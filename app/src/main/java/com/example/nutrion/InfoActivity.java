package com.example.dietnutritionreminder.dietandnutritionreminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class InfoActivity extends AppCompatActivity {

    TextView textViewBMIValue;
    EditText editTextAge, editTextGender, editTextHeight, editTextWeight;
    RadioButton radioButtonMale, radioButtonFemale;
    Button buttonEnd,buttonCalculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        textViewBMIValue=(TextView) findViewById(R.id.textViewBMIValue);
        editTextAge=(EditText) findViewById(R.id.editTextAge);
        editTextGender=(EditText) findViewById(R.id.editTextGender);
        editTextHeight=(EditText) findViewById(R.id.editTextHeight);
        editTextWeight=(EditText) findViewById(R.id.editTextWeight);
        radioButtonMale=(RadioButton) findViewById(R.id.radioButtonMale);
        radioButtonFemale=(RadioButton) findViewById(R.id.radioButtonFemale);
        buttonEnd=(Button)findViewById(R.id.buttonEnd);
        buttonCalculate=(Button)findViewById(R.id.buttonCalculate);
    }

    public void onClickCalculateBMI(View v) {
        boolean male,female;
        float bmi;
        String bmiValue;
        male=radioButtonMale.isChecked();
        female=radioButtonFemale.isChecked();
//        Toast.makeText(InfoActivity.this, "radioButtonMale="+male+"\nradioButtonFemale="+female,Toast.LENGTH_LONG).show();
        if(isEmptyAny()) {
            Toast.makeText(InfoActivity.this, "Fill up remaining empty forms", Toast.LENGTH_LONG).show();
            return;
        }
        bmi=calculateBMI();
        bmiValue=String.format(Locale.getDefault(),"%.2f",bmi);
        textViewBMIValue.setText("Your BMI Value = "+bmiValue);
    }

    private float calculateBMI() {
        float weight,height,bmi = 0;
        weight= Float.parseFloat(editTextWeight.getText().toString());
        height= Float.parseFloat(editTextHeight.getText().toString());
        height/=1000;
        if(!(weight==0||height==0))
            bmi=weight/(height*height);
        else
            Toast.makeText(InfoActivity.this, "Weight or height can not be 0(zero)", Toast.LENGTH_LONG).show();
        return bmi;
    }

    private boolean isEmptyAny() {
        boolean isEmpty;
        if((editTextAge.getText().toString().isEmpty()||
                (editTextHeight.getText().toString().isEmpty()||
                        (editTextWeight.getText().toString().isEmpty()
                        )
                )
        )
        )
            isEmpty=(radioButtonMale.isChecked()||radioButtonFemale.isChecked());
        else
            isEmpty=false;
        return isEmpty;
    }

    public void onClickNext(View v) {
        Intent intentSecond=new Intent(this,SecondActivity.class);
        startActivity(intentSecond);
    }
}
