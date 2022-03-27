package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Integer firsnumber = 0;
    private Integer secondnumber = 0;
    private Integer result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void editTextFirst(View view){
        EditText editText  = findViewById(R.id.editTextTextNumberOne);
        firsnumber= Integer.parseInt(String.valueOf(editText.getText()));
    }
    public void editTextSecond(View view){
        EditText editText  = findViewById(R.id.editTextTextNumberTwo);
        secondnumber= Integer.parseInt(String.valueOf(editText.getText()));
    }
    public void onClickButton(View view){

        result = firsnumber + secondnumber;
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("first",firsnumber);
        intent.putExtra("second",secondnumber);
        intent.putExtra("result",result);
        startActivity(intent);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("firstn", firsnumber);
        outState.putInt("secondn", secondnumber);
        outState.putInt("resultn", result);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        firsnumber = savedInstanceState.getInt("firstn");
        secondnumber = savedInstanceState.getInt("secondn");
        result= savedInstanceState.getInt("resultn");
    }
    public void resetUI() {
        ((TextView) findViewById(R.id.editTextTextNumberOne)).setText(firsnumber.toString());
        ((TextView) findViewById(R.id.editTextTextNumberTwo)).setText(secondnumber.toString());
    }
    public void onResume() {
        super.onResume();
        resetUI();
    }
}