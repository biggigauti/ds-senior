package edu.carroll.ds;

import edu.carroll.ds.json.model.DataModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Spring controller that routes traffic hitting "/(root)" to the index HTML template.
 */
@Controller
public class IndexController {

    String data = null;

    //Get Mapping. This returns the index page to the user.
    @GetMapping("/")
    public String index() {
        System.out.println("Data string from get method " + data);
        return "index";
    }
    
    //Post Mapping. This function listens for any posts directed at the root extension "/".
    //Once received, the JSON string is transformed into a "dataModel" so Java can interpret the data.
    //We then run the "runPython" script which grabs the data from the model and passes it as a parameter.
    @PostMapping(path="/", consumes="application/json")
    public String post(@RequestBody DataModel dataModel) throws IOException, InterruptedException {
        data = dataModel.getData();
        System.out.println("Data string from post method " + data);
        runPython(data);

        return "index";
    }

    private void runPython(String data) throws IOException, InterruptedException {
        //The process builder allows us to run the Python script within Java. This uses your machine's
        //local Python interpreter.
        ProcessBuilder pb = new ProcessBuilder("python", "src/main/resources/static/python.py", data);
        pb.redirectErrorStream(true);

        Process p = pb.start();

        //Read the output of the python file
        List<String> results = readProcessOutput(p.getInputStream());

        int exitCode = p.waitFor();

        //Print exit code and results to console.
        System.out.println("Prediction: Symbol " + results.get(results.size()-1));
    }

    //Helper function that reads the process output.
    private List<String> readProcessOutput(InputStream input) {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader((new InputStreamReader(input)))) {
            String line;
            //While there are lines, continue reading.
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {}

        return list;
    }
}
