package com.edu.calarea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class triangle_page extends AppCompatActivity {

    EditText length, width;
    Button btn_calc_triangle;
    TextView displayResult;
    Calculation calc;
    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle_page);

        //Bind views with ids
        length = findViewById(R.id.et_height_triangle);
        width = findViewById(R.id.et_width_triangle);
        btn_calc_triangle = findViewById(R.id.btn_calc_triangle);
        displayResult = findViewById(R.id.tv_result_triangle);
        btnBack = findViewById(R.id.btn_back);

        btn_calc_triangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!length.getText().toString().isEmpty() && !width.getText().toString().isEmpty()){

                    calc = new Calculation();
                    double result = calc.areaTriangle(length, width);

                    //Display result
                    displayResult.setText(String.format("%.2f sqmm", result));

                    //Close Keyboard
                    closeKeyboard();
                }
                else{
                    if(length.getText().toString().isEmpty()){
                        length.setError("Length cannot leave empty");
                    }
                    else if(width.getText().toString().isEmpty()){
                        width.setError("Width cannot leave empty");
                    }
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

    //Close soft keyboard
    private void closeKeyboard(){
        View view = this.getCurrentFocus();
        if(view != null){
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}