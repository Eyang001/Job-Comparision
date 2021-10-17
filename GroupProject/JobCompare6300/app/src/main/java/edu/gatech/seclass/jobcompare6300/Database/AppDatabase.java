package edu.gatech.seclass.jobcompare6300.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {
        JobEntity.class, ComparisonWeightsEntity.class,
        JobOffersEntity.class, JobWithLocation.class,
        LocationEntity.class
        },
        version = 1, exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "Job_db";
    private static volatile AppDatabase INSTANCE;

    // Need singleton pattern and call on databasebuilder class b/c we can't instantiate an object of DB
    static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, DB_NAME)
                        .fallbackToDestructiveMigration()
                        .build();

            }
        }
        return INSTANCE;
    }


    public abstract JobDAO userDao();
    public abstract ComparisonWeightsDAO comparisonWeightsDAO();

}


