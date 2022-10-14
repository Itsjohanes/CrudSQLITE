package com.johannes2002895.notesgw.db;


import com.johannes2002895.notesgw.db.DatabaseContract.NoteColumns;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static com.johannes2002895.notesgw.db.DatabaseContract.NoteColumns.TABLE_NAME;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "notes";
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_TABLE_NOT = String.format("CREATE TABLE %s"
                    + " (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL)",
            TABLE_NAME,
            NoteColumns._ID,
            NoteColumns.TITLE,
            NoteColumns.DESCRIPTION,
            NoteColumns.DATE
    );
    //constructornya
    DatabaseHelper(Context context){super(context,DATABASE_NAME,null, DATABASE_VERSION);}

    @Override
    //perintah eksekusi
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_NOT);

    }

    @Override
    //ketika upgrade selalu drop table
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
