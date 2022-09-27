package com.example.dteam_android_dia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(true)//check user have been value for income
        {
            Intent intent = new Intent(MainActivity.this, IncomeSetup.class);
            startActivity(intent);
        }
        else
        {
            setContentView(R.layout.activity_main);


        }


    }



}