package com.teamrevelador.hack40_android;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by anubhavmalik on 20/03/18.
 */

public class MyOpenHelper extends SQLiteOpenHelper {

    public MyOpenHelper(Context context, String name) {
        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

//        String statement= "create table mytable ( id integer primary key autoincrement,

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
