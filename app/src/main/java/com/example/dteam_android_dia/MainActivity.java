package com.example.dteam_android_dia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(true)
        {
//            setContentView(R.layout.activity_home);
             Intent intent = new Intent(MainActivity.this, AddTransaction.class);
             startActivity(intent);
        }
        else
        {
            setContentView(R.layout.activity_main);
        }
    }
}