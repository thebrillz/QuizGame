package com.example.quizgame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String dbname="scores.db";
    public static final String tablename="scores_table";
    public static final String col1="Name";
    public static final String col2="Fandom";
    public static final String col3="Score";


    public DataBaseHelper(Context context) {
        super(context, dbname, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
           db.execSQL("create table "+ tablename + "(NAME VARCHAR(50), FANDOM VARCHAR(25), SCORE INT )" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
           db.execSQL("DROP TABLE IF EXISTS "+tablename);
           onCreate(db);
    }

    public boolean insert(String name, String fd, int score)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("NAME",name);
        cv.put("FANDOM",fd);
        cv.put("SCORE", score);
        long result= db.insert(tablename,null,cv);
        if(result==-1)
            return false;
        else
            return true;
    }

    public Cursor getLeaderboard(String fd)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String query="SELECT NAME, SCORE FROM scores_table WHERE FANDOM = ? order by SCORE desc, NAME asc limit 5";
        String[] selectionArgs = {fd};
        Cursor res=db.rawQuery(query,selectionArgs);
        return res;
    }


}
