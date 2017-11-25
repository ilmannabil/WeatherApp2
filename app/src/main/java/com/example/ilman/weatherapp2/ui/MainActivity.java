package com.example.ilman.weatherapp2.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ilman.weatherapp2.R;
import com.example.ilman.weatherapp2.ui.fragment.WeatherFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.framelayout_mainactivity, new WeatherFragment()).commit();
    }
}
