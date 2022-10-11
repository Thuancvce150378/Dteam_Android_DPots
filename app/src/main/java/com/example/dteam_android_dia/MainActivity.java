package com.example.dteam_android_dia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(true)//check user have been value for income
        {
            setContentView(R.layout.activity_home);
        }
        else
        {
            setContentView(R.layout.activity_main);
        }
    }
}