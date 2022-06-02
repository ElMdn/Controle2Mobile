package com.example.controle2mobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

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

    public static long Add_Entreprise(SQLiteDatabase sqLiteDatabase ,Entreprise et){
        ContentValues cv = new ContentValues();
        cv.put(C2,et.getRaisonSociale());
        cv.put(C3,et.getAdresse());
        cv.put(C4,et.getCapitale());
        return sqLiteDatabase.insert(TABLENAME,null,cv);
    }

    public static long Update_Entreprise(SQLiteDatabase sqLiteDatabase ,Entreprise et){
        ContentValues cv = new ContentValues();
        cv.put(C2,et.getRaisonSociale());
        cv.put(C3,et.getAdresse());
        cv.put(C4,et.getCapitale());
        return sqLiteDatabase.update(TABLENAME,cv,"id="+et.getId(),null);
    }

    public static long delete_Entreprise(SQLiteDatabase sqLiteDatabase, int id){
        return sqLiteDatabase.delete(TABLENAME,"id="+id,null);
    }

    public static ArrayList<Entreprise> getAllEntreprise(SQLiteDatabase sqLiteDatabase){
        ArrayList<Entreprise> etrp = new ArrayList<>();

        Cursor crs = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLENAME,null);

        while(crs.moveToNext()){
            Entreprise e = new Entreprise();
            e.setId(crs.getInt(0));
            e.setRaisonSociale(crs.getString(1));
            e.setAdresse(crs.getString(2));
            e.setCapitale(crs.getDouble(3));
            etrp.add(e);
        }

        return etrp;
    }

    public static Entreprise getOneEntreprise(SQLiteDatabase sqLiteDatabase, int id){
        Entreprise e = null;

        Cursor crs = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLENAME + " WHERE id = " + id,null);

        if(crs.moveToNext()){
            e = new Entreprise();
            e.setId(crs.getInt(0));
            e.setRaisonSociale(crs.getString(1));
            e.setAdresse(crs.getString(2));
            e.setCapitale(crs.getDouble(3));
        }

        return e;
    }
}
