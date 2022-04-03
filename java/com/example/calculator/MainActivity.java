package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Integer firstnumber = 0;
    private Integer secondnumber = 0;
    private Integer result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickButton(View view){

        EditText editTextFirst  = findViewById(R.id.editTextTextNumberOne);
        EditText editTextSecond  = findViewById(R.id.editTextTextNumberTwo);

        try {
            firstnumber = Integer.parseInt(String.valueOf(editTextFirst.getText()));
            secondnumber = Integer.parseInt(String.valueOf(editTextSecond.getText()));
            result = firstnumber + secondnumber;
            startSecondActivity();
        }catch (Exception e){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Введены некорректные данные, введите ещё раз", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    public void startSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("first", firstnumber);
        intent.putExtra("second", secondnumber);
        intent.putExtra("result", result);
        startActivity(intent);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("firstn", firstnumber);
        outState.putInt("secondn", secondnumber);
        outState.putInt("resultn", result);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null && savedInstanceState.containsKey("firstn")) {
            firstnumber = savedInstanceState.getInt("firstn");
        }
        if(savedInstanceState != null && savedInstanceState.containsKey("secondn")) {
            secondnumber = savedInstanceState.getInt("secondn");
        }
            if(savedInstanceState != null && savedInstanceState.containsKey("result")) {
                result = savedInstanceState.getInt("resultn");
            }
    }
    public void resetUI() {
        ((TextView) findViewById(R.id.editTextTextNumberOne)).setText(firstnumber.toString());
        ((TextView) findViewById(R.id.editTextTextNumberTwo)).setText(secondnumber.toString());
    }
    public void onResume() {
        super.onResume();
        resetUI();
    }
}