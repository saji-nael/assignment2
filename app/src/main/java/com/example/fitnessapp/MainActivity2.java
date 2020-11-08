package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity2 extends AppCompatActivity {
    //define views
    private EditText hour;
    private EditText min;
    private EditText sec;
    private boolean running = true;
    private int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setupViews();
    }
    public void setupViews() {
        hour = (EditText) findViewById(R.id.hour);
        min = (EditText) findViewById(R.id.min);
        sec = (EditText) findViewById(R.id.sec);

    }
}