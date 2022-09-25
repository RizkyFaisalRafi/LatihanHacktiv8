package com.rifara.siklushidup.crud_sqlite.db;

import android.provider.BaseColumns;

public class DatabaseContract {


    public static final String TABLE_NOTE = "table_note";
    static String TABLE_NAME = "note";

    public static final class NoteColumns implements BaseColumns {
        public static String TITLE = "title";
        public static String DESCRIPTION = "description";
        public static String DATE = "date";
    }

}
