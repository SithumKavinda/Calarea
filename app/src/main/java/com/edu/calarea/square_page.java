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

public class square_page extends AppCompatActivity {

    EditText length, width;
    Button btn_calc;
    TextView result;
    Calculation calc;
    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_page);

        //Bind with ids
        length = findViewById(R.id.et_length_square);
        width = findViewById(R.id.et_width_square);
        btn_calc = findViewById(R.id.btn_calc_square);
        result = findViewById(R.id.tv_result_square);
        btnBack = findViewById(R.id.btn_back);

        //Object of Calculation class
        calc = new Calculation();

        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Validation
                if(!length.getText().toString().isEmpty() && !width.getText().toString().isEmpty()){

                    //Calculation
                    double answer = calc.areaSquare(length, width);
                    result.setText(String.format("%.2f sqmm", answer));

                    //Close keyboard
                    closeKeyboard();
                }
                else{
                    //Set errors
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