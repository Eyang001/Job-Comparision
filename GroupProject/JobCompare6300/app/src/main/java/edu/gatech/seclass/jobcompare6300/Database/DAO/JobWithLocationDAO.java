package edu.gatech.seclass.jobcompare6300.Database.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import edu.gatech.seclass.jobcompare6300.Database.Entities.JobWithLocation;

@Dao
public interface JobWithLocationDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insertSettings(JobWithLocation... jobWithLocations);

    @Update
    public void updateSettings(JobWithLocation... jobWithLocations);

    @Delete
    public void delete(JobWithLocation jobWithLocations);


    @Transaction
    @Query("SELECT * FROM LocationEntity")
    public List<JobWithLocation> getJobWithLocation();
}
