package com.edu.calarea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class convert_page extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ImageView btnBack;
    Spinner spinner_metric;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_page);

        //Bind with id
        btnBack = findViewById(R.id.btn_back);
        spinner_metric = findViewById(R.id.spinnerMetric);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //Set Items to Spinner(Drop down)
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.metric, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_metric.setAdapter(adapter);

        //Get the selected item from the spinner
        spinner_metric.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String choice = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(this, "Item: " + choice, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}