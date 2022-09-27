package com.example.dteam_android_dia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.UUID;

public class IncomeSetup extends AppCompatActivity {
    EditText amount;
    Spinner incomeWith;
    ImageButton btnNext;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_setup);
        btnNext = findViewById(R.id.btnNext);
        amount = findViewById(R.id.editTextNumberDecimal);
        incomeWith = findViewById(R.id.spinIncomeRange);
        DB = new DBHelper(this);

        Log.d("IncomeSetup", "IncomeSetup");
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("IncomeSetup", "Next page");
                Intent intent = new Intent(IncomeSetup.this, ProgramIntro.class);
                startActivity(intent);

                //create id
                String InComeRangeID = UUID.randomUUID().toString().replace("-","");
                String InComeID = UUID.randomUUID().toString().replace("-","");


                //get input
                String amountText = amount.getText().toString();
                String incomeWithText = incomeWith.getSelectedItem().toString();

                //create data
                Boolean checkSetupData = DB.insertInComeRange(InComeRangeID,incomeWithText)
                        && DB.insertInCome(InComeID,InComeRangeID, amountText);
                if(checkSetupData==true)
                    Toast.makeText(IncomeSetup.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(IncomeSetup.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }
        });
    }


}