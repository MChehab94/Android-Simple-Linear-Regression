package mchehab.com.androidlinearregression;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber;
    private TextView textViewResult;
    private Button buttonPredict;

    private TFSimpleRegression tfSimpleRegression;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber = findViewById(R.id.editTextNumber);
        textViewResult = findViewById(R.id.textView);
        buttonPredict = findViewById(R.id.buttonPredict);

        tfSimpleRegression = new TFSimpleRegression(getApplicationContext());

        setButtonPredictListener();
    }

    private void setButtonPredictListener(){
        buttonPredict.setOnClickListener(e -> {
            float number = Float.parseFloat(editTextNumber.getText().toString());
            float result[] = tfSimpleRegression.predict(new float[]{number});
            textViewResult.setText(result[0] + "");
        });
    }
}