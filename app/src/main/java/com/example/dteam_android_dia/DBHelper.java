package com.example.dteam_android_dia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context ) {
        super(context, "DB4.db", null, 1);
    }

//    @Override
//    public void onCreate(SQLiteDatabase DB) {
//        DB.execSQL("create Table Userdetails(name TEXT primary key, contact TEXT, dob TEXT)");
//    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table tpPlanBill( " +
                "ID TEXT PRIMARY KEY NOT NULL," +
                "ID_PotItem  TEXT  NOT NULL," +
                "estiminate REAL  NOT NULL," +
                "isCheck INTERGER  NOT NULL," +
                "description TEXT NOT NULL," +
                "FOREIGN KEY (ID_PotItem) REFERENCES tbPotItem(ID)" +
                ")");

        DB.execSQL("create Table tpPot( " +
                "ID TEXT PRIMARY KEY NOT NULL," +
                "percent INTEGER  NOT NULL," +
                "ID_Income TEXT NOT NULL," +
                "FOREIGN KEY (ID_Income) REFERENCES tbIncome(ID)" +
                ")");

        DB.execSQL("create Table tbInCome( " +
                "ID TEXT PRIMARY KEY NOT NULL," +
                "ID_IncomeRange TEXT NOT NULL," +
                "amount INTEGER NOT NULL," +
                "FOREIGN KEY (ID_IncomeRange) REFERENCES tbIncomeRange(ID)" +
                ")");

        DB.execSQL("create Table tpPotItem( " +
                "ID TEXT PRIMARY KEY NOT NULL," +
                "picture TEXT NOT NULL," +
                "text TEXT NOT NULL" +
                ")");

        DB.execSQL("create Table tbBill( " +
                "ID TEXT PRIMARY KEY NOT NULL," +
                "ID_PotItem TEXT  NOT NULL," +
                "date TEXT  NOT NULL," +
                "currency REAL NOT NULL," +
                "description TEXT NOT NULL," +
                "FOREIGN KEY (ID_PotItem) REFERENCES tpPotItem(ID)" +
                ")");

        DB.execSQL("create Table tbIncomeRange( " +
                "ID TEXT PRIMARY KEY NOT NULL," +
                "name TEXT NOT NULL" +
                ")");
    }
    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists tpPlanBill");
        DB.execSQL("drop Table if exists tpPot");
        DB.execSQL("drop Table if exists tbInCome");
        DB.execSQL("drop Table if exists tpPotItem");
        DB.execSQL("drop Table if exists tbBill");
        DB.execSQL("drop Table if exists tbIncomeRange");

    }
    public Boolean insertInComeRange(String ID, String name)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("ID", ID);
        long result=DB.insert("tbIncomeRange", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean insertInCome(String ID,String ID_IncomeRange, String amount)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", ID);
        contentValues.put("ID_IncomeRange", ID_IncomeRange);
        contentValues.put("amount", amount);

        long result=DB.insert("tbInCome", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
}