package edu.gatech.seclass.jobcompare6300.Database.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.gatech.seclass.jobcompare6300.Database.Entities.JobOffersEntity;

@Dao
public interface JobOffersDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insertJobOffer(JobOffersEntity... jobOffers);

    @Update
    public void updateJobOffer(JobOffersEntity... jobOffers);

    @Delete
    public void deleteJobOffer(JobOffersEntity... jobOffers);

    // fetch all settings as a list
    @Query("SELECT * FROM jobOffers")
    List<JobOffersEntity> getAll();
}
