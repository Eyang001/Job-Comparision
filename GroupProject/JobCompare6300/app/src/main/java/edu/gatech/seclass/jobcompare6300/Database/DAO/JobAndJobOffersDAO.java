package edu.gatech.seclass.jobcompare6300.Database.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import edu.gatech.seclass.jobcompare6300.Database.Entities.JobAndJobOffers;

@Dao
public interface JobAndJobOffersDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insertSettings(JobAndJobOffers... jobAndJobOffers);

    @Update
    public void updateSettings(JobAndJobOffers... jobAndJobOffers);

    @Delete
    public void delete(JobAndJobOffers jobAndJobOffers);

    @Transaction
    @Query("SELECT * FROM JobEntity")
    public List<JobAndJobOffers> getJobAndJobOffers();
}
