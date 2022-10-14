package com.johannes2002895.notesgw.db;

import android.provider.BaseColumns;

public class DatabaseContract {

    public static final class NoteColumns implements BaseColumns{
        //menaruh Atribut2
        public static final String TABLE_NAME = "notes";
        public static final String TITLE = "title";
        public static final String DESCRIPTION = "description";
        public static final String DATE = "date";
    }

}
