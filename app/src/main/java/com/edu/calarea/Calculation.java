package com.edu.calarea;

import android.widget.EditText;
import android.widget.RadioButton;

public class Calculation {

    private double pi = 22.0 / 7.0;

    //Defaul constructor
    public Calculation() {}

    //Calculate area of circle
    public double areaCircle(EditText x, RadioButton r, RadioButton d){

        if(r.isChecked()){
            double val = Double.parseDouble(x.getText().toString());
            double ans = pi * val * val;
            return ans;
        }
        else if(d.isChecked()){
            double val = Double.parseDouble(x.getText().toString());
            double ans = pi * (val / 2) * (val / 2);
            return ans;
        }

        return 0.0;
    }

    //Calculate area of triangle
    public double areaTriangle(EditText x, EditText y){
        double length = Double.parseDouble(x.getText().toString());
        double width = Double.parseDouble(y.getText().toString());
        double ans = 0.5 * length * width;

        return ans;
    }

    //Calculate area of Rombus
    public double areaSquare(EditText x, EditText y){
        double length = Double.parseDouble(x.getText().toString());
        double width = Double.parseDouble(y.getText().toString());
        double ans = length * width;

        return ans;
    }
}
