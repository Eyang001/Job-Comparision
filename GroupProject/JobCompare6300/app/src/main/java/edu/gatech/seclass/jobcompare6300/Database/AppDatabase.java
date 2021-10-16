package edu.gatech.seclass.jobcompare6300.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import edu.gatech.seclass.jobcompare6300.Job;

public class AppDatabase {

    @Database(entities = {Job.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase {
        public abstract JobDao userDao();
    }

}
