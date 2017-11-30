package com.example.locatsu.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.locatsu.R;

/**
 * Created by TO_MANG on 30/11/2560.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_name = "location.db";
    private static final int DATABASE_version = 1;

    public static final String TABLE_name = "location";
    public static final String COL_id = "_id";
    public static final String COL_name = "name";
    public static final String COL_picture = "picture";

    public static final String COL_detail = "detail";
    public static final String SQL_DATABASE_table = "create table "+ TABLE_name +"(" +
            COL_id +" integer primary key autoincrement, " +
            COL_name + " text," +
            COL_picture + " text," +
            COL_detail + " text" +
            ")";
    private Context mContext;

    public DatabaseHelper(Context context) {
        super(context,DATABASE_name,null,DATABASE_version);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_DATABASE_table);

    }

    private void insertInitialData(SQLiteDatabase db){
        ContentValues cv = new ContentValues();
        cv.put(COL_name, "Faculty of Science");
        cv.put(COL_picture, "faculty_sc_3.jpg");
        cv.put(COL_detail, R.string.app_name);
        db.insert(TABLE_name,null,cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
