package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //define views
    private EditText nameEditText;
    private EditText heightEditText;
    private EditText weightEditText;
    private Spinner genderSpinner;
    //define preferences
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    public static final String namePre = "name";
    public static final String heightPre = "height";
    public static final String weightPre = "weight";
    public static final String genderPre = "gender";
    public static final String flag = "flag";
    private boolean running = true;
    private int counter;
    private TextView time;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        setupSharedPref();
        checkPref();
    }

    public void setupViews() {
        nameEditText = (EditText) findViewById(R.id.name);
        heightEditText = (EditText) findViewById(R.id.height);
        weightEditText = (EditText) findViewById(R.id.weight);
        genderSpinner = (Spinner) findViewById(R.id.gender);
    }

    public void setupSharedPref() {
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
    }

    public void checkPref() {
        boolean f = pref.getBoolean(flag, false);
        if (f) {
            String name = pref.getString(namePre, "");
            nameEditText.setText(name);
            String height = pref.getString(heightPre, "");
            heightEditText.setText(height);
            String weight = pref.getString(weightPre, "");
            weightEditText.setText(weight);
            String gender = pref.getString(genderPre, "");
            if (gender.equals("male"))
                genderSpinner.setSelection(0);
            else
                genderSpinner.setSelection(1);
        }
    }

    public void runTimer() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (running)
                    counter++;
                time.setText(Integer.toString(counter));
                handler.postDelayed(this, 1000);
            }
        });
        {
        }
    }

    public void saveBTNClickON(View view) {

        String name = nameEditText.getText().toString();
        String height = heightEditText.getText().toString();
        String weight = weightEditText.getText().toString();
        String gender = genderSpinner.getSelectedItem().toString();

        editor.putString(namePre, name);
        editor.putString(heightPre, height);
        editor.putString(weightPre, weight);
        editor.putString(genderPre, gender);
        editor.putBoolean(flag, true);
        editor.commit();
    }

    public void calculateBMIBTNCLickON(View view) {
        double w = Double.parseDouble(weightEditText.getText().toString());
        double h = Double.parseDouble(heightEditText.getText().toString());
        double BMI = w / (h * h);
        Toast.makeText(getApplicationContext(), Double.toString(BMI), Toast.LENGTH_SHORT).show();
    }

    public void timerBTNClickON(View view) {
        openActivity2();
    }
    public void openActivity2() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}
