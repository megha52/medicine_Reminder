package com.example.myapp2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG="DatabaseHelper";
    private static final String TABLE_NAME="medicine";
    private static final String col1="id";
    private static final String col2="name";
    private static final String col3="hrs";
    private static final String col4="min";
    public DatabaseHelper(Context context)
    {
        super(context,TABLE_NAME,null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createtable= "CREATE TABLE medicine (ID INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, hrs INTEGER, min INTEGER)";
        db.execSQL(createtable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //db.execSQL("DROP IF TABLE EXISTS "+TABLE_NAME);
        //onCreate(db);

    }

    public boolean addData(String name,int hrs,int min)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col2,name);
        contentValues.put(col3,hrs);
        contentValues.put(col4,min);
        Log.d(TAG,"addData: Adding "+name+" to "+TABLE_NAME);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if (result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
    public Cursor getData(){
        SQLiteDatabase db1=this.getWritableDatabase();
        String quary="SELECT * FROM "+TABLE_NAME;
        Cursor data=db1.rawQuery(quary,null );
        return data;

    }
    public void deleteName(String n){
        SQLiteDatabase db1=this.getWritableDatabase();
        String quary1="DELETE FROM "+ TABLE_NAME +" WHERE "+col2+" = '" +n+ "'";
        db1.execSQL(quary1);
    }
}
