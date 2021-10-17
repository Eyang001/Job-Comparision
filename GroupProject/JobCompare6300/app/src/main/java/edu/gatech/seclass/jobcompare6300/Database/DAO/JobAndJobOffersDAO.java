package edu.gatech.seclass.jobcompare6300.Database.DAO;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import edu.gatech.seclass.jobcompare6300.Database.Entities.JobAndJobOffers;

@Dao
public interface JobAndJobOffersDAO {

    @Transaction
    @Query("SELECT * FROM jobs")
    public List<JobAndJobOffers> getJobAndJobOffers();
}
