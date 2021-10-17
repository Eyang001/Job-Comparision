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
    public void insertSettings(JobOffersEntity... jobOffersEntities);

    @Update
    public void updateSettings(JobOffersEntity... jobOffersEntities);

    @Delete
    public void delete(JobOffersEntity jobOffersEntities);

    // fetch all settings as a list
    @Query("SELECT * FROM JobOffersEntity")
    List<JobOffersEntity> getAll();
}
