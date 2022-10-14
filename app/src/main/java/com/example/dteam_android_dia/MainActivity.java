package com.example.dteam_android_dia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(true)//check user have been value for income
        {
//            setContentView(R.layout.activity_home);
             Intent intent = new Intent(MainActivity.this, total_history.class);
             startActivity(intent);
        }
        else
        {
            setContentView(R.layout.activity_main);
        }
    }
}