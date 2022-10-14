package com.johannes2002895.notesgw.helper;

import android.database.Cursor;

import com.johannes2002895.notesgw.db.DatabaseContract;
import com.johannes2002895.notesgw.entity.MyNotes;

import java.util.ArrayList;

public class MappingHelper {
    //menggubah cursor menjadi arrayList
    public static ArrayList<MyNotes> mapCursorToArrayList(Cursor notesCursor){
        ArrayList<MyNotes> notesList = new ArrayList<>();

        while(notesCursor.moveToNext()){
            int id = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID));
            String title = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.TITLE));
            String description = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESCRIPTION));
            String date = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DATE));
            notesList.add(new MyNotes(id, title, description, date));
        }
        return notesList;
    }

}
