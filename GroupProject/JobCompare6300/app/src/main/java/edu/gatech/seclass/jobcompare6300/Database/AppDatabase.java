package edu.gatech.seclass.jobcompare6300.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import edu.gatech.seclass.jobcompare6300.ComparisonWeights;
import edu.gatech.seclass.jobcompare6300.Database.DAO.ComparisonWeightsDAO;
import edu.gatech.seclass.jobcompare6300.Database.DAO.DirtyScoresDAO;
import edu.gatech.seclass.jobcompare6300.Database.DAO.JobAndJobOffersDAO;
import edu.gatech.seclass.jobcompare6300.Database.DAO.JobDAO;
import edu.gatech.seclass.jobcompare6300.Database.DAO.JobWithLocationDAO;
import edu.gatech.seclass.jobcompare6300.Database.DAO.LocationDAO;
import edu.gatech.seclass.jobcompare6300.Database.Entities.ComparisonWeightsEntity;
import edu.gatech.seclass.jobcompare6300.Database.Entities.JobEntity;
import edu.gatech.seclass.jobcompare6300.Database.Entities.JobOffersEntity;
import edu.gatech.seclass.jobcompare6300.Database.Entities.JobWithLocation;
import edu.gatech.seclass.jobcompare6300.Database.Entities.LocationEntity;

@Database(entities = {
        JobEntity.class, ComparisonWeightsEntity.class,
        JobOffersEntity.class, JobWithLocation.class,
        LocationEntity.class
        },
        version = 1, exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {

    public abstract JobDAO userDao();
    public abstract JobAndJobOffersDAO jobAndJobOffersDAO();
    public abstract JobWithLocationDAO jobWithLocationDAO();
    public abstract LocationDAO locationDAO();
    public abstract ComparisonWeightsDAO comparisonWeightsDAO();
    public abstract DirtyScoresDAO dirtyScoresDAO();

    private static final String DB_NAME = "Job_db";
    private static AppDatabase INSTANCE;

    // Need singleton pattern and call on databasebuilder class b/c we can't instantiate an object of DB
    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
                INSTANCE = buildInstance(context);
        }
        return INSTANCE;
    }

    private static AppDatabase buildInstance(Context context){
        INSTANCE = Room.databaseBuilder(context,
                AppDatabase.class, DB_NAME)
                .allowMainThreadQueries() // ****remove this line when using the APP!!!!!
                .fallbackToDestructiveMigration()
                .build();
        return INSTANCE;
    }

    public void cleanUp(){
        INSTANCE = null;
    }

}


