package edu.gatech.seclass.jobcompare6300.Database.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.gatech.seclass.jobcompare6300.Database.Entities.JobEntity;
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
    public void insert(JobEntity... jobEntities);

    @Update
    public void update(JobEntity... jobEntities);

    @Delete
    public void delete(JobEntity jobEntity);

}