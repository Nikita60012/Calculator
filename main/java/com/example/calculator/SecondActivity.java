package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
public class SecondActivity extends AppCompatActivity{

    private Integer firstnumber = (Integer) getIntent().getSerializableExtra("firstnumber");
    private Integer secondnumber = (Integer) getIntent().getSerializableExtra("secondnumber");
    private Integer result = (Integer) getIntent().getSerializableExtra("result");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        TextView textViewFirst = findViewById(R.id.textViewFirst);
        TextView textViewSecond = findViewById(R.id.textViewSecond);
        TextView textViewResult = findViewById(R.id.textViewResult);
        textViewFirst.setText(firstnumber.toString());
        textViewSecond.setText(secondnumber.toString());
        textViewResult.setText(result.toString());
    }

}
