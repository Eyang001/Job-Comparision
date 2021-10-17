package edu.gatech.seclass.jobcompare6300.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import edu.gatech.seclass.jobcompare6300.Job;

@Dao
public interface JobDAO {

    // fetch all jobs as a list
    @Query("SELECT * FROM JobEntity")
    List<Job> getAll();

    // fetch title and company
    @Query("SELECT title, company FROM JobEntity WHERE title IN (:title) AND company IN (:company)")
    List<Job> getTitleCompany(String title, String company);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(JobEntity... jobEntities);

    @Update
    void update(JobEntity... jobEntities);

    @Delete
    void delete(JobEntity jobEntity);


    // What are the below queries for???

    //for 1-1 relationship
    @Transaction
    @Query("SELECT * FROM Job")
    public List<JobAndJobOffers> getJobAndJobOffers();

    //for 1-M relationship
    @Transaction
    @Query("SELECT * FROM Location")
    public List<JobWithLocation> getJobWithLocation();


}