package edu.gatech.seclass.jobcompare6300;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

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
    private static final String JOB_COL_CITY = "city";
    private static final String JOB_COL_STATE = "state";
    private static final String JOB_COL_COST_LIVING = "cost_of_living";
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

    // Location Table Columns
    private static final String CITY_ID = "id";
    private static final String CITY_COL_CITY = "city";
    private static final String CITY_COL_STATE = "state";
    private static final String CITY_COL_COST_LIVING = "cost_of_living";

    // Job Table create statement
    private static final String CREATE_JOB_TABLE = "CREATE TABLE " + TABLE_JOB + "("
            + JOB_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + JOB_COL_TITLE + " TEXT," + JOB_COL_COMPANY + " TEXT,"
            + JOB_COL_CITY + " TEXT," + JOB_COL_STATE + " TEXT,"
            + JOB_COL_COST_LIVING + " INTEGER," + JOB_COL_SALARY + " INTEGER," + JOB_COL_BONUS
            + " INTEGER," + JOB_COL_TELEWORK + " INTEGER," +  JOB_COL_LEAVE
            + " INTEGER," + JOB_COL_GYM + " INTEGER" + ")";

    // ComparisonWeights Table create statement
    private static final String CREATE_COMPARISON_WEIGHTS_TABLE = "CREATE TABLE " + TABLE_COMPARISON_WEIGHTS + "("
            + WEIGHTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + WEIGHTS_COL_SALARY + " INTEGER," + WEIGHTS_COL_BONUS + " INTEGER,"
            + WEIGHTS_COL_TELEWORK + " INTEGER," + WEIGHTS_COL_LEAVE + " INTEGER,"
            + WEIGHTS_COL_GYM +" INTEGER" + ")";

    // Location Table create statement
    private static final String CREATE_LOCATION_TABLE = "CREATE TABLE " + TABLE_LOCATION + "("
            + CITY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + CITY_COL_CITY + " TEXT," + CITY_COL_STATE + " TEXT,"
            + CITY_COL_COST_LIVING + " INTEGER" + ")";


    public DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_JOB_TABLE);
        db.execSQL(CREATE_COMPARISON_WEIGHTS_TABLE);
        db.execSQL(TABLE_LOCATION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JOB);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPARISON_WEIGHTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCATION);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.setVersion(oldVersion);
    }

    public void enterJob(Job job, boolean currentJob){
        db = this.getWritableDatabase();
        values = new ContentValues();
        values.put(JOB_COL_TITLE, job.getTitle());
        values.put(JOB_COL_COMPANY, job.getCompany());
        values.put(JOB_COL_CITY, job.getLocationCity());
        values.put(JOB_COL_STATE, job.getLocationState());
        values.put(JOB_COL_COST_LIVING, job.getLocationCostOfLivingIndex());
        values.put(JOB_COL_CITY, job.getLocationCity());
        values.put(JOB_COL_SALARY, job.getSalary());
        values.put(JOB_COL_BONUS, job.getBonus());
        values.put(JOB_COL_TELEWORK, job.getTeleworkDays());
        values.put(JOB_COL_LEAVE, job.getLeaveDays());
        values.put(JOB_COL_GYM, job.getGymAllowance());

        // check if this job is a current job (update row 1) or an offer (insert after row 1)
        if (currentJob){
            db.update(TABLE_JOB, values, JOB_ID+" = 1",null);
        }
        else {
            db.insert(TABLE_JOB, null, values);}
        }
//        db.close();


    public ArrayList<Job> getAllJobs() {
        ArrayList<Job> arrayJobs = new ArrayList<>();
        db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_JOB;
        Cursor cursor =  db.rawQuery( query, null );

        while(cursor.moveToNext()){ //while there are tuples remaining to check
            String title = cursor.getString(cursor.getColumnIndex(JOB_COL_TITLE));
            String company = cursor.getString(cursor.getColumnIndex(JOB_COL_COMPANY));
//            Location location = new Location();
            String city = cursor.getString(cursor.getColumnIndex(JOB_COL_CITY));
            String state = cursor.getString(cursor.getColumnIndex(JOB_COL_STATE));
            int cost_living = cursor.getInt(cursor.getColumnIndex(JOB_COL_COST_LIVING));
            int salary = cursor.getInt(cursor.getColumnIndex(JOB_COL_SALARY));
            int bonus = cursor.getInt(cursor.getColumnIndex(JOB_COL_BONUS));
            int telework = cursor.getInt(cursor.getColumnIndex(JOB_COL_TELEWORK));
            int leave = cursor.getInt(cursor.getColumnIndex(JOB_COL_LEAVE));
            int gym = cursor.getInt(cursor.getColumnIndex(JOB_COL_GYM));
//            Job job = new Job(title,company,location,salary,bonus,telework,leave,gym);
        }
        return arrayJobs;
    }


    public void setWeights(ComparisonWeights weights){
        db = this.getWritableDatabase();
        values = new ContentValues();
        values.put(WEIGHTS_COL_SALARY, weights.getYearlySalary());
        values.put(WEIGHTS_COL_BONUS, weights.getYearlyBonus());
        values.put(WEIGHTS_COL_TELEWORK, weights.getTeleDays());
        values.put(WEIGHTS_COL_LEAVE, weights.getLeaveDays());
        values.put(WEIGHTS_COL_GYM, weights.getGymAllowance());
        db.update(TABLE_COMPARISON_WEIGHTS, values, WEIGHTS_ID+" = 1",null);
//        db.close();  //UNCOMMENT after done testing!!!!
    }

    public ComparisonWeights getWeights() {
        ComparisonWeights weights = new ComparisonWeights();
        db = this.getWritableDatabase();
        String weightsQuery = "SELECT * FROM " + TABLE_COMPARISON_WEIGHTS;
        Cursor weightsCursor = db.rawQuery(weightsQuery, null);
        while (weightsCursor.moveToNext()) { //while there are tuples remaining to check
            weights.setYearlySalary(weightsCursor.getInt(weightsCursor.getColumnIndex(WEIGHTS_COL_SALARY)));
            weights.setYearlyBonus(weightsCursor.getInt(weightsCursor.getColumnIndex(WEIGHTS_COL_BONUS)));
            weights.setTeleDays(weightsCursor.getInt(weightsCursor.getColumnIndex(WEIGHTS_COL_TELEWORK)));
            weights.setLeaveDays(weightsCursor.getInt(weightsCursor.getColumnIndex(WEIGHTS_COL_LEAVE)));
            weights.setGymAllowance(weightsCursor.getInt(weightsCursor.getColumnIndex(WEIGHTS_COL_GYM)));
            //  db.close();  //UNCOMMENT after done testing!!!!
        }
        return weights;
    }







}
