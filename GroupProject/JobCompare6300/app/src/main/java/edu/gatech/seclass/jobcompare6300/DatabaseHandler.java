package edu.gatech.seclass.jobcompare6300;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {
    // https://www.androidhive.info/2013/09/android-sqlite-database-with-multiple-tables/

    private static SQLiteDatabase db;
    private static SQLiteOpenHelper helper;
    private static ContentValues values;

    // DB Name
    public static final int DB_VERSION = 1;
    public static final String DATABASE_NAME = "jobsManager.db";

    // Tables
    public static final String TABLE_JOB = "job";
    public static final String TABLE_COMPARISON_WEIGHTS = "comparison_weights";

    // Job Table Columns
    public static final String JOB_ID = "id";
    public static final String JOB_COL_TITLE = "title";
    public static final String JOB_COL_COMPANY = "company";

    // Job Table create statement
    private static final String CREATE_JOB_TABLE = "CREATE TABLE " + TABLE_JOB + "("
            + JOB_ID + " INTEGER PRIMARY KEY," + JOB_COL_TITLE + " TEXT,"
            + JOB_COL_COMPANY + " TEXT" + ")";

    // TODO ComparisonWeights Table create statement
    /* ADD HERE */

    public DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_JOB_TABLE);
        //TODO add statment for comparisonweights table
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JOB);
        //TODO add statment for comparisonweights table

        // Build new table
        onCreate(db);
    }

    public void enterJob(Job job){
        db = this.getWritableDatabase();
        values = new ContentValues();
        values.put(JOB_COL_TITLE, job.getTitle());
        values.put(JOB_COL_COMPANY, job.getTitle());
        db.insert(TABLE_JOB, null, values);
        helper.close();
    }



//    public ArrayList<Job> getAllJobs() {
//        ArrayList<Job> arrayJobs = new ArrayList<>();
//        db = this.getReadableDatabase();
//        String query = "SELECT * FROM " + TABLE_JOB;
//        Cursor cursor =  db.rawQuery( query, null );
//        cursor.moveToFirst();
//
//        while(cursor.isAfterLast()){ //while there are tuples remaining to check
//            Job job = cursor.getString(cursor.getColumnIndex(job));
//            arrayJobs.add(job);
//            cursor.moveToNext();
//        }
//        return arrayJobs;
//    }

    }


//}
