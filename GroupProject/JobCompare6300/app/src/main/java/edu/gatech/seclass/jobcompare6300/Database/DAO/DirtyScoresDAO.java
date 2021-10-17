package edu.gatech.seclass.jobcompare6300.Database.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.gatech.seclass.jobcompare6300.Database.Entities.DirtyScoresEntity;

@Dao
public interface DirtyScoresDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insertSettings(DirtyScoresEntity... dirtyScoresEntities);

    @Update
    public void updateSettings(DirtyScoresEntity... dirtyScoresEntities);

    @Delete
    public void delete(DirtyScoresEntity dirtyScoresEntities);

    // fetch all settings as a list
    @Query("SELECT * FROM DirtyScoresEntity")
    List<DirtyScoresEntity> getAll();
}
