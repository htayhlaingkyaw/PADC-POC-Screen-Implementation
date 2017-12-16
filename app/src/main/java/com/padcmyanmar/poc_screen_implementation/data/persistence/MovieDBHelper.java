package com.padcmyanmar.poc_screen_implementation.data.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import retrofit2.http.PUT;

/**
 * Created by Aspire on 12/16/2017.
 */

public class MovieDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "movies.db";

    private static final String SQL_CREATE_POPULAR_MOVIE_TABLE = "CREATE TABLE " + MovieContract.PopularMovieEntry.TABLE_NAME + " ( " +
            MovieContract.PopularMovieEntry._ID + " INTERGER PRIMARY ID KEY AUTOINCREMENT, " +
            MovieContract.PopularMovieEntry.COLUMN_VOTE_COUNT + " INTEGER NOT NULL, " +
            MovieContract.PopularMovieEntry.COLUMN_ID + " INTEGER NOT NULL, " +
            MovieContract.PopularMovieEntry.COLUMN_VOTE_AVERAGE  + " REAL NOT NULL " +
            MovieContract.PopularMovieEntry.COLUMN_VOTE_AVERAGE + "INTEGER DEFAULT 0, " +
            MovieContract.PopularMovieEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
            MovieContract.PopularMovieEntry.COLUMN_POPULARITY + " REAL NOT NULL, " +
            MovieContract.PopularMovieEntry.COLUMN_POSTER_PATH + " TEXT, " +
            MovieContract.PopularMovieEntry.COLUMN_ORIGINAL_LANGUAGE + " TEXT NOT NULL, " +
            MovieContract.PopularMovieEntry.COLUMN_ORIGINAL_TITLE + " TEXT NOT NULL, " +
            MovieContract.PopularMovieEntry.COLUMN_BACKDROP_PATH + " TEXT, " +
            MovieContract.PopularMovieEntry.COLUMN_ADULT + " INTEGER DEFAULT 0, " +
            MovieContract.PopularMovieEntry.COLUMN_OVERVIEW + " TEXT NOT NULL, " +
            MovieContract.PopularMovieEntry.COLUMN_RELEASE_DATE + " TEXT NOT NULL " +

            " UNIQUE (" + MovieContract.PopularMovieEntry.COLUMN_TITLE + ") ON CONFLICT IGNORE" +
            " );";

    public static final String SQL_CREATE_GENRE_IDS_TABLE = "CREATE TABLE " + MovieContract.GenreIdsEntry.TABLE_NAME + " (" +
            MovieContract.GenreIdsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            MovieContract.GenreIdsEntry.COLUMN_MOVIE_TITLE + " TEXT NOT NULL, " +
            MovieContract.GenreIdsEntry.COLUMN_GENRE_ID + " INTEGER, " +

            " UNIQUE (" + MovieContract.GenreIdsEntry.COLUMN_MOVIE_TITLE + ", " +
            MovieContract.GenreIdsEntry.COLUMN_GENRE_ID + ") ON CONFLICT IGNORE" +
            ");";

    public MovieDBHelper(Context context) {
        super(context,DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_POPULAR_MOVIE_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_GENRE_IDS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MovieContract.PopularMovieEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MovieContract.GenreIdsEntry.TABLE_NAME);

        onCreate(sqLiteDatabase);
    }
}
