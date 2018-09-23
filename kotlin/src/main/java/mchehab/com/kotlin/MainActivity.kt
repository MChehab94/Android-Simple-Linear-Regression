package mchehab.com.kotlin

import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private var tfSimpleRegression: TFSimpleRegression? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tfSimpleRegression = TFSimpleRegression(applicationContext)

        setButtonPredictListener()
    }

    private fun setButtonPredictListener() {
        buttonPredict!!.setOnClickListener { e ->
            val number = java.lang.Float.parseFloat(editTextNumber!!.text.toString())
            val result = tfSimpleRegression!!.predict(floatArrayOf(number))
            textView.text = result[0].toString() + ""
        }
    }
}
