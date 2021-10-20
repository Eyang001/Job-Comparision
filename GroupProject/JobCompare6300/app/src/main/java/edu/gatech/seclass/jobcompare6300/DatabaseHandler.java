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
    // https://www.tutlane.com/tutorial/android/android-sqlite-database-with-examples

    private static SQLiteDatabase db;
    private static SQLiteOpenHelper helper;
    private static ContentValues values;

    // DB Name
    public static final int DB_VERSION = 1;
    public static final String DATABASE_NAME = "jobsManager.db";

    // Tables
    public static final String TABLE_JOB = "job";
    public static final String TABLE_COMPARISON_WEIGHTS = "comparison_weights";
    public static final String TABLE_LOCATION = "location";

    // Job Table Columns
    private static final String JOB_ID = "id";
    private static final String JOB_COL_TITLE = "title";
    private static final String JOB_COL_COMPANY = "company";
    private static final String JOB_COL_LOCATION_CITY = "location_city";
    private static final String JOB_COL_LOCATION_STATE = "location_state";
    private static final String JOB_COL_SALARY = "salary";
    private static final String JOB_COL_BONUS = "bonus";
    private static final String JOB_COL_TELEWORK = "teleworkDays";
    private static final String JOB_COL_LEAVE =  "leaveDays";
    private static final String JOB_COL_GYM = "gymAllowance";

    // WeightsComparison Table Columns

    private static final String WEIGHTS_ID = "id";
    private static final String WEIGHTS_COL_SALARY = "yearlySalary";
    private static final String WEIGHTS_COL_BONUS = "yearlyBonus";
    private static final String WEIGHTS_COL_TELEWORK = "teleDays";
    private static final String WEIGHTS_COL_LEAVE  = "leaveDays";
    private static final String WEIGHTS_COL_GYM = "gymAllowance";

    // TODO Create LOCATION table columns

    // Job Table create statement
    private static final String CREATE_JOB_TABLE = "CREATE TABLE " + TABLE_JOB + "("
            + JOB_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + JOB_COL_TITLE + " TEXT," + JOB_COL_COMPANY + " TEXT,"
            + JOB_COL_LOCATION_CITY + " TEXT," + JOB_COL_LOCATION_STATE
            + " TEXT," + JOB_COL_SALARY + " INTEGER," + JOB_COL_BONUS
            + " INTEGER," + JOB_COL_TELEWORK + " INTEGER," +  JOB_COL_LEAVE
            + " INTEGER," + JOB_COL_GYM + " INTEGER" + ")";

    // ComparisonWeights Table create statement
    private static final String CREATE_COMPARISON_WEIGHTS_TABLE = "CREATE TABLE " + TABLE_COMPARISON_WEIGHTS + "("
            + WEIGHTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + WEIGHTS_COL_SALARY + " INTEGER," + WEIGHTS_COL_BONUS + " INTEGER,"
            + WEIGHTS_COL_TELEWORK + " INTEGER," + WEIGHTS_COL_LEAVE + " INTEGER,"
            + WEIGHTS_COL_GYM +" INTEGER" + ")";

    // TODO create statement for LOCATION table

    public DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_JOB_TABLE);
        db.execSQL(CREATE_COMPARISON_WEIGHTS_TABLE);
        //TODO add statment for LOCATION table
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JOB);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPARISON_WEIGHTS);
        //TODO add statment for LOCATION table
        onCreate(db);
    }

    public void enterJob(Job job){
        db = this.getWritableDatabase();
        values = new ContentValues();
        values.put(JOB_COL_TITLE, job.getTitle());
        values.put(JOB_COL_COMPANY, job.getCompany());
        values.put(JOB_COL_LOCATION_CITY, job.getLocationCity());
        values.put(JOB_COL_LOCATION_STATE, job.getLocationState());
        values.put(JOB_COL_SALARY, job.getSalary());
        values.put(JOB_COL_BONUS, job.getBonus());
        values.put(JOB_COL_TELEWORK, job.getTeleworkDays());
        values.put(JOB_COL_LEAVE, job.getLeaveDays());
        values.put(JOB_COL_GYM, job.getGymAllowance());
        db.insert(TABLE_JOB, null, values);
        db.close();
    }

    public void setWeights(int salaryWeight, int bonusWeight, int teleWeight, int leaveWeight, int gymWeight){
        db = this.getWritableDatabase();
        values = new ContentValues();
        values.put(WEIGHTS_COL_SALARY, salaryWeight);
        values.put(WEIGHTS_COL_BONUS, bonusWeight);
        values.put(WEIGHTS_COL_TELEWORK, teleWeight);
        values.put(WEIGHTS_COL_LEAVE, leaveWeight);
        values.put(WEIGHTS_COL_GYM, gymWeight);
        int id = 1;
        db.insert(TABLE_COMPARISON_WEIGHTS, null,values);
        //        db.update(TABLE_COMPARISON_WEIGHTS, values, WEIGHTS_ID+" = ?",new String[]{String.valueOf(id)});
//        db.close();
    }

    public ArrayList<String> getAllJobs() {

        ArrayList<String> arrayJobs = new ArrayList<>();
        db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_JOB;
        Cursor cursor =  db.rawQuery( query, null );
        while(cursor.moveToNext()){ //while there are tuples remaining to check
//            Job job = new Job();
            arrayJobs.add(cursor.getString(cursor.getColumnIndex(JOB_COL_TITLE)));
            arrayJobs.add(cursor.getString(cursor.getColumnIndex(JOB_COL_COMPANY)));
        }
        return arrayJobs;
    }




}
