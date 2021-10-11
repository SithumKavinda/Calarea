package com.edu.calarea;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class circle_page extends AppCompatActivity {

    RadioButton rad, dia;
    EditText userVar;
    Button calc_area_circle;
    TextView result;
    Calculation calc;
    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_page);

        //Bind views with ids
        rad = findViewById(R.id.radio_radius);
        dia = findViewById(R.id.radio_diameter);
        userVar = findViewById(R.id.editTextNumberDecimal);
        calc_area_circle = findViewById(R.id.btn_calc_circle);
        result = findViewById(R.id.tv_result);
        btnBack = findViewById(R.id.btn_back);

        rad.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(rad.isChecked()){
                    userVar.setHint("Enter Radius");
                }
            }
        });

        dia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(dia.isChecked()){
                    userVar.setHint("Enter Diameter");
                }
            }
        });

        calc_area_circle.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {

                if(!userVar.getText().toString().isEmpty()){

                    calc = new Calculation();
                    double answer = calc.areaCircle(userVar, rad, dia);

                    //Display answer
                    result.setText(String.format("%.2f sqmm", answer));

                    //Close keyboard
                    closeKeyboard();

                }
                else{
                    String type = "";

                    if(rad.isChecked()){
                        type = "Radius";
                    }
                    else if(dia.isChecked()){
                        type = "Diameter";
                    }

                    userVar.setError(type + " Cannot be empty");
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    //Close Keyboard
    private void closeKeyboard(){
        View view = this.getCurrentFocus();
        if(view != null){
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}