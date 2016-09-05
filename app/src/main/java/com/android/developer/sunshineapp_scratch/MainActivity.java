package com.android.developer.sunshineapp_scratch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ForecastFragment fragment = new ForecastFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment).commit();


    }

}
