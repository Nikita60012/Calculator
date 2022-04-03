package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
public class SecondActivity extends AppCompatActivity{

    int firstnumber;
    int secondnumber;
    int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Intent intent = getIntent();
        firstnumber = intent.getIntExtra("first",firstnumber);
        secondnumber = intent.getIntExtra("second",secondnumber);
        result = intent.getIntExtra("result",result);
        TextView textView = findViewById(R.id.textView);
        if (secondnumber < 0){
            textView.setText(firstnumber + " + " +"("+secondnumber + ")"+ " = " + result);
        }
        else {
            textView.setText(firstnumber + " + " + secondnumber + " = " + result);
        }
    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView mainView = findViewById(R.id.textView);
        outState.putString("***", String.valueOf(mainView.getText()));
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("***")) {
            firstnumber = savedInstanceState.getInt("firstn");
            secondnumber = savedInstanceState.getInt("secondn");
        }
    }
}
