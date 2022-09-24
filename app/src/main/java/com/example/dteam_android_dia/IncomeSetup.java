package com.example.dteam_android_dia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;

public class IncomeSetup extends AppCompatActivity {

    ImageButton btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_setup);
        btnNext = findViewById(R.id.btnNextpage);
        Log.d("IncomeSetup", "IncomeSetup");
        btnNext.setOnClickListener(v -> {
            Log.d("IncomeSetup", "Next page");
            Intent intent = new Intent(IncomeSetup.this, ProgramIntro.class);
            startActivity(intent);
        });
    }
}