package mchehab.com.androidlinearregression;

import android.content.Context;

import org.tensorflow.contrib.android.TensorFlowInferenceInterface;


public class Classifier {
    static {
        System.loadLibrary("tensorflow_inference");
    }

    private TensorFlowInferenceInterface inferenceInterface;
    private static final String MODEL_FILE = "file:///android_asset/frozen.pb";
    private static final String INPUT_NODE = "input";
    private static final String[] OUTPUT_NODES = {"prediction"};
    private static final String OUTPUT_NODE = "prediction";
    private static final long[] INPUT_SIZE = {1};
    private static final int OUTPUT_SIZE = 1;

    public Classifier(final Context context) {
        inferenceInterface = new TensorFlowInferenceInterface(context.getAssets(), MODEL_FILE);
    }

    public float[] predictProbabilities(float[] data) {
        float[] result = new float[OUTPUT_SIZE];
        inferenceInterface.feed(INPUT_NODE, data, INPUT_SIZE);
        inferenceInterface.run(OUTPUT_NODES);
        inferenceInterface.fetch(OUTPUT_NODE, result);

        //Downstairs	Jogging	  Sitting	Standing	Upstairs	Walking
        return result;
    }
}

