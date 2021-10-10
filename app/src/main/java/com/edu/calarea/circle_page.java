package com.edu.calarea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class circle_page extends AppCompatActivity {

    RadioButton rad, dia;
    EditText userVar;
    Button calc_area_circle;
    String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_page);

        //Bind views with ids
        rad = findViewById(R.id.radio_radius);
        dia = findViewById(R.id.radio_diameter);
        userVar = findViewById(R.id.editTextNumberDecimal);
        calc_area_circle = findViewById(R.id.btn_calc_circle);

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
            @Override
            public void onClick(View view) {

                if(userVar.getHint() == "Enter Radius"){
                    answer = calcArea_circleRad(userVar);
                }
                else if(userVar.getHint() == "Enter Diameter"){
                    answer = calcArea_circleDia(userVar);
                }
                Toast.makeText(circle_page.this, "Value:" + answer, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String calcArea_circleRad(EditText x){
        double val = Double.parseDouble(x.getText().toString());

        String ans = Double.toString((22.0/7.0) * val * val);

        return ans;
    }

    public String calcArea_circleDia(EditText x){
        double val = Double.parseDouble(x.getText().toString());

        String ans = Double.toString((22.0/7.0) * (val/2) * (val/2));

        return ans;
    }
}