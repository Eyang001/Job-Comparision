package edu.gatech.seclass.jobcompare6300.Database.DAO;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import edu.gatech.seclass.jobcompare6300.Database.Entities.JobWithLocation;

@Dao
public interface JobWithLocationDAO {

    @Transaction
    @Query("SELECT * FROM locations")
    public List<JobWithLocation> getJobWithLocation();
}
