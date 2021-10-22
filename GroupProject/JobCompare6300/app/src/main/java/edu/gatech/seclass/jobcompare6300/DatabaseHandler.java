package edu.gatech.seclass.jobcompare6300;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

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
//    public static final String TABLE_LOCATION = "location";

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
//    private static final String LOCATION_ID = "loc_id";
//    private static final String LOCATION_COL_CITY = "city";
//    private static final String LOCATION_COL_STATE = "state";
//    private static final String LOCATION_COL_COST_LIVING = "cost_of_living";

    // Job Table create statement
    private static final String CREATE_JOB_TABLE = "CREATE TABLE " + TABLE_JOB + "("
            + JOB_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + JOB_COL_TITLE + " TEXT," + JOB_COL_COMPANY + " TEXT,"
            + JOB_COL_CITY + " TEXT," + JOB_COL_STATE + " TEXT,"
            + JOB_COL_COST_LIVING + " INTEGER," + JOB_COL_SALARY + " INTEGER," + JOB_COL_BONUS
            + " INTEGER," + JOB_COL_TELEWORK + " INTEGER," +  JOB_COL_LEAVE
            + " INTEGER," + JOB_COL_GYM + " INTEGER)";

            // TODO I tried to add foreign key references to db but it keeps breaking, I recommend we revisit location class
            // + JOB_LOCATION_ID + "INTEGER, "
            //+ "FOREIGN KEY (" + JOB_LOCATION_ID + ") REFERENCES " + TABLE_LOCATION + "(LOCATION_ID))";

    // ComparisonWeights Table create statement
    private static final String CREATE_COMPARISON_WEIGHTS_TABLE = "CREATE TABLE " + TABLE_COMPARISON_WEIGHTS + "("
            + WEIGHTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + WEIGHTS_COL_SALARY + " INTEGER," + WEIGHTS_COL_BONUS + " INTEGER,"
            + WEIGHTS_COL_TELEWORK + " INTEGER," + WEIGHTS_COL_LEAVE + " INTEGER,"
            + WEIGHTS_COL_GYM +" INTEGER" + ")";

    // Location Table create statement
//    private static final String CREATE_LOCATION_TABLE = "CREATE TABLE " + TABLE_LOCATION + "("
//            + LOCATION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
//            + LOCATION_COL_CITY + " TEXT," + LOCATION_COL_STATE + " TEXT,"
//            + LOCATION_COL_COST_LIVING + " INTEGER" + ")";

    private static DatabaseHandler instance;

    // Using singleton pattern to get instance of dbhandler
    public static synchronized DatabaseHandler getInstance(Context context) {
        if (instance == null)
            instance = new DatabaseHandler(context);
        return instance;
    }

    private DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

//     Enforce foreign key constraints
//    @Override
//    public void onOpen(SQLiteDatabase db) {
//        super.onOpen(db);
//        // Enable foreign key constraints
//        db.execSQL("PRAGMA foreign_keys=ON;");
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_JOB_TABLE);
        db.execSQL(CREATE_COMPARISON_WEIGHTS_TABLE);
//        db.execSQL(CREATE_LOCATION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JOB);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPARISON_WEIGHTS);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCATION);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.setVersion(oldVersion);
    }

    public void enterJob(Job job, boolean currentJob){
        // Query db first to determibe if it is empty and provide Cursor object
        String query = "SELECT * FROM " + TABLE_JOB;
        Cursor cursor =  db.rawQuery( query, null );

        db = this.getWritableDatabase();
        values = new ContentValues();
        values.put(JOB_COL_TITLE, job.getTitle());
        values.put(JOB_COL_COMPANY, job.getCompany());
        values.put(JOB_COL_CITY, job.getLocationCity());
        values.put(JOB_COL_STATE, job.getLocationState());
        values.put(JOB_COL_COST_LIVING, job.getLocationCostOfLivingIndex());
        values.put(JOB_COL_SALARY, job.getSalary());
        values.put(JOB_COL_BONUS, job.getBonus());
        values.put(JOB_COL_TELEWORK, job.getTeleworkDays());
        values.put(JOB_COL_LEAVE, job.getLeaveDays());
        values.put(JOB_COL_GYM, job.getGymAllowance());

        // case: enter current job and there are at least 1 jobs in table
        if (currentJob && cursor.getCount() > 0){
            db.update(TABLE_JOB, values, JOB_ID+" = 1",null);}
        // case: enter current job first and there are no jobs in table
        else if (currentJob && cursor.getCount() == 0){
            db.insert(TABLE_JOB, null, values);}
        // case: enter job offer first and there are no jobs in table before entering current job
        else if (!currentJob && cursor.getCount() == 0){ // enter nulls for first row if we don't have a current job
            db.execSQL("INSERT INTO " + TABLE_JOB + " ("+ JOB_COL_TITLE+","+JOB_COL_COMPANY+","
                    +JOB_COL_CITY+","+JOB_COL_STATE+","+JOB_COL_COST_LIVING+","+JOB_COL_SALARY+","
                    +JOB_COL_BONUS+","+JOB_COL_TELEWORK+","+JOB_COL_LEAVE+","+JOB_COL_GYM
                    +") VALUES ("+"NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);");
            db.insert(TABLE_JOB, null, values);}
        else {
            db.insert(TABLE_JOB, null, values);}
        }
        // TODO        db.close(); uncomment after testing

//    public void enterLocation(Job job) {
//        // Query db first to determibe if it is empty and provide Cursor object
//        String city = job.getLocationCity();
//        String state = job.getLocationState();
//        String query = "SELECT city, state FROM " + TABLE_LOCATION + " WHERE "
//                + " city = " + city +" AND state = " + state;
//
//        Cursor cursor = db.rawQuery(query, null);
//        int index = 0;
//        try {
//            index = cursor.getInt(cursor.getColumnIndex(LOCATION_ID));
//        } catch(Exception e){};
//
//        db = this.getWritableDatabase();
//        values = new ContentValues();
//        values.put(LOCATION_COL_CITY, job.getLocationCity());
//        values.put(LOCATION_COL_STATE, job.getLocationState());
//        values.put(LOCATION_COL_COST_LIVING, job.getLocationCostOfLivingIndex());
//
//        // case: proposed location in table that don't exist
//        if (cursor.getCount() > 0){
//            db.update(TABLE_JOB, values, LOCATION_ID+" = "+ index,null);}
//        // case: proposed location does not exist in Location table
//        else if (cursor.getCount() == 0){
//            db.insert(TABLE_JOB, null, values);}
//
//    }


        public JobOffers getAllJobs() {
        JobOffers jobOffers = new JobOffers();
        db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_JOB;
        Cursor cursor =  db.rawQuery( query, null );
        ComparisonWeights weights = this.getWeights();
        boolean isCurrentJob = true;
        while(cursor.moveToNext()){ //while there are tuples remaining to check
            String title = cursor.getString(cursor.getColumnIndex(JOB_COL_TITLE));
            if (isCurrentJob && title == "null"){ // check if 1st row is null i.e., no current job
                isCurrentJob = false; // flag that there is no current job
                continue;}
            String company = cursor.getString(cursor.getColumnIndex(JOB_COL_COMPANY));
            String city = cursor.getString(cursor.getColumnIndex(JOB_COL_CITY));
            String state = cursor.getString(cursor.getColumnIndex(JOB_COL_STATE));
            int cost_living = cursor.getInt(cursor.getColumnIndex(JOB_COL_COST_LIVING));
            Location location = new Location(city,state,cost_living);
            int salary = cursor.getInt(cursor.getColumnIndex(JOB_COL_SALARY));
            int bonus = cursor.getInt(cursor.getColumnIndex(JOB_COL_BONUS));
            int telework = cursor.getInt(cursor.getColumnIndex(JOB_COL_TELEWORK));
            int leave = cursor.getInt(cursor.getColumnIndex(JOB_COL_LEAVE));
            int gym = cursor.getInt(cursor.getColumnIndex(JOB_COL_GYM));

            Job job = new Job(title,company,location,salary,bonus,telework,leave,gym);
            jobOffers.addOffer(job,weights,isCurrentJob);
            isCurrentJob = false;
        }
        return jobOffers;
    }

    public void setWeights(ComparisonWeights weights){
        // Query db first to determibe if it is empty and provide Cursor object
        String query = "SELECT * FROM " + TABLE_COMPARISON_WEIGHTS;
        Cursor cursor =  db.rawQuery( query, null );
        db = this.getWritableDatabase();
        values = new ContentValues();
        values.put(WEIGHTS_COL_SALARY, weights.getYearlySalary());
        values.put(WEIGHTS_COL_BONUS, weights.getYearlyBonus());
        values.put(WEIGHTS_COL_TELEWORK, weights.getTeleDays());
        values.put(WEIGHTS_COL_LEAVE, weights.getLeaveDays());
        values.put(WEIGHTS_COL_GYM, weights.getGymAllowance());
        if (cursor.getCount() == 0) {
            db.insert(TABLE_COMPARISON_WEIGHTS, null, values);
        } else {
            db.update(TABLE_COMPARISON_WEIGHTS, values, WEIGHTS_ID + " = 1", null);
        }
        // TODO       db.close();  //UNCOMMENT after done testing!!!!
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
            // TODO  db.close();  //UNCOMMENT after done testing!!!!
        }
        return weights;
    }

    public void deleteDatabase(String Table) {
        String clearDBQuery = "DELETE FROM "+Table;
        this.db.execSQL(clearDBQuery);

        String clearAutoIncrement = "DELETE FROM SQLITE_SEQUENCE WHERE NAME = '" + Table + "'";
        this.db.execSQL(clearAutoIncrement);
    }





}
