package edu.carroll.ds;

/*
import org.tensorflow.SavedModelBundle;
import org.tensorflow.Tensor;
import org.tensorflow.ndarray.FloatNdArray;
import org.tensorflow.ndarray.NdArrays;
import org.tensorflow.ndarray.Shape;
import org.tensorflow.types.TFloat32;
import org.tensorflow.proto.framework.SignatureDef;

 */

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class EvaluateSymbol {

    public static void loadModel() {
        System.out.println("nothing");
    }

    public static void main(String[] args) {
        loadModel();

        /*
        try {
            SavedModelBundle model = SavedModelBundle.load("/Users/birgirgauti/Desktop/skóli/spring2023/ds405/modelSave", "serve");
            SignatureDef sig = model.metaGraphDef().getSignatureDefMap().get("predict");

            FloatNdArray input_matrix = NdArrays.ofFloats(Shape.of(1, 256));
            input_matrix.set(NdArrays.vectorOf(1f        , 1f        , 1f        , 1f        , 1f        ,
                    1f        , 1f        , 1f        , 1f        , 1f        ,
                    1f        , 1f        , 1f        , 1f        , 1f        ,
                    1f        , 1f        , 1f        , 0.99215686f, 1f        ,
                    1f        , 1f        , 1f        , 1f        , 1f        ,
                    1f        , 1f        , 1f        , 1f        , 1f        ,
                    1f        , 1f        , 1f        , 1f        , 0.94901961f,
                    0.98431373f, 1f        , 1f        , 1f        , 1f        ,
                    1f        , 1f        , 1f        , 1f        , 0.99215686f,
                    0.96078431f, 1f        , 1f        , 1f        , 0.99607843f,
                    0.96470588f, 0.97647059f, 0.98431373f, 1f        , 1f        ,
                    1f        , 1f        , 1f        , 1f        , 0.99215686f,
                    0.97254902f, 0.96078431f, 1f        , 1f        , 1f        ,
                    0.99607843f, 0.96470588f, 1f        , 0.97254902f, 0.98823529f,
                    1f        , 1f        , 1f        , 1f        , 0.99215686f,
                    0.97254902f, 0.99607843f, 0.96470588f, 0.99607843f, 1f        ,
                    1f        , 0.99607843f, 0.96470588f, 1f        , 1f        ,
                    0.97254902f, 0.99215686f, 1f        , 1f        , 0.99215686f,
                    0.97254902f, 0.99607843f, 1f        , 0.96470588f, 0.99607843f,
                    1f        , 1f        , 0.99607843f, 0.96470588f, 1f        ,
                    1f        , 0.99607843f, 0.97254902f, 0.99215686f, 0.99215686f,
                    0.97254902f, 0.99607843f, 1f        , 1f        , 0.96470588f,
                    0.99607843f, 1f        , 1f        , 0.99607843f, 0.96470588f,
                    1f        , 1f        , 1f        , 0.99607843f, 0.96470588f,
                    0.96862745f, 0.99607843f, 1f        , 1f        , 1f        ,
                    0.96470588f, 0.99607843f, 1f        , 1f        , 0.99607843f,
                    0.96470588f, 1f        , 1f        , 1f        , 0.99215686f,
                    0.96470588f, 0.96862745f, 0.99607843f, 1f        , 1f        ,
                    1f        , 0.96862745f, 0.99215686f, 1f        , 1f        ,
                    0.99607843f, 0.96470588f, 1f        , 1f        , 0.99215686f,
                    0.97254902f, 0.99607843f, 0.99215686f, 0.97254902f, 0.99607843f,
                    1f        , 1f        , 0.96862745f, 0.99215686f, 1f        ,
                    1f        , 0.99607843f, 0.96470588f, 1f        , 0.99215686f,
                    0.97254902f, 0.99607843f, 1f        , 1f        , 0.98823529f,
                    0.97254902f, 1f        , 1f        , 0.96862745f, 0.99215686f,
                    1f        , 1f        , 0.99607843f, 0.96862745f, 0.99215686f,
                    0.97254902f, 0.99607843f, 1f        , 1f        , 1f        ,
                    1f        , 0.98823529f, 0.97254902f, 1f        , 0.97254902f,
                    0.98823529f, 1f        , 1f        , 0.99607843f, 0.96078431f,
                    0.97254902f, 0.99607843f, 1f        , 1f        , 1f        ,
                    1f        , 1f        , 1f        , 0.98431373f, 0.98039216f,
                    0.97647059f, 0.98823529f, 1f        , 1f        , 0.99607843f,
                    0.96078431f, 0.99607843f, 1f        , 1f        , 1f        ,
                    1f        , 1f        , 1f        , 1f        , 1f        ,
                    0.98431373f, 0.95294118f, 0.98823529f, 1f        , 1f        ,
                    1f        , 1f        , 1f        , 1f        , 1f        ,
                    1f        , 1f        , 1f        , 1f        , 1f        ,
                    1f        , 1f        , 0.97254902f, 0.99215686f, 1f        ,
                    1f        , 1f        , 1f        , 1f        , 1f        ,
                    1f        , 1f        , 1f        , 1f        , 1f        ,
                    1f        , 1f        , 1f        , 1f        , 1f        ,
                    1f), 0);
            Tensor input_tensor = TFloat32.tensorOf(input_matrix);
            System.out.println(input_tensor.shape());

            Map<String, Tensor> feed_dict = new HashMap<>();
            feed_dict.put("context", input_tensor);

            System.out.println(model.function("predict").call(feed_dict));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

         */
    }
}
