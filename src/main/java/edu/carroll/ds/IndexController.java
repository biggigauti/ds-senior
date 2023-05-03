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
@Controller
public class IndexController {

    String data = null;

    @GetMapping("/")
    public String index() {
        System.out.println("Data string from get method " + data);
        return "index";
    }

    @PostMapping(path="/", consumes="application/json")
    public String post(@RequestBody DataModel dataModel) throws IOException, InterruptedException {
        data = dataModel.getData();
        System.out.println("Data string from post method " + data);
        runPython(data);

        return "index";
    }

    private void runPython(String data) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("python", "src/main/resources/static/python.py", data);
        pb.redirectErrorStream(true);

        Process p = pb.start();

        List<String> results = readProcessOutput(p.getInputStream());

        int exitCode = p.waitFor();

        System.out.println("Exit code = " + exitCode);
        System.out.println("Results = " + results);
    }

    private List<String> readProcessOutput(InputStream input) {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader((new InputStreamReader(input)))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {}

        return list;
    }
}
