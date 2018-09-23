package mchehab.com.kotlin

import android.content.Context
import org.tensorflow.contrib.android.TensorFlowInferenceInterface

class TFSimpleRegression internal constructor(context: Context) {

    companion object {
        init {
            System.loadLibrary("tensorflow_inference")
        }
    }

    private val MODEL_FILE = "file:///android_asset/frozen.pb"
    private val INPUT_NODE = "input"
    private val OUTPUT_NODES = arrayOf("prediction")
    private val OUTPUT_NODE = "prediction"
    private val INPUT_SIZE = longArrayOf(1)
    private val OUTPUT_SIZE = 1

    private val inferenceInterface: TensorFlowInferenceInterface

    init {
        inferenceInterface = TensorFlowInferenceInterface(context.assets, MODEL_FILE)
    }

    fun predict(data: FloatArray): FloatArray {
        val result = FloatArray(OUTPUT_SIZE)
        inferenceInterface.feed(INPUT_NODE, data, *INPUT_SIZE)
        inferenceInterface.run(OUTPUT_NODES)
        inferenceInterface.fetch(OUTPUT_NODE, result)

        return result
    }
}