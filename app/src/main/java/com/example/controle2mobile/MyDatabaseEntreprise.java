package com.example.controle2mobile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseEntreprise extends SQLiteOpenHelper {

    public static String DBNAME="enterprises.db ";
    public static String TABLENAME="CONTACT ";
    public static String C1="ID";
    public static String C2=" Raison_Sociale";
    public static String C3="adresse";
    public static String C4="Capitale";


    public MyDatabaseEntreprise(Context con) {
        super(con, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql ="create table "+TABLENAME+"("+C1+" integer primary key autoincrement,"+C2+" TEXT,"+C3+" TEXT,"+C4+" double)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String sql ="drop table "+TABLENAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
}
