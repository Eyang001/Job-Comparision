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
    public void insertDirtyScore(DirtyScoresEntity... dirtyScore);

    @Update
    public void updateDirtyScore(DirtyScoresEntity... dirtyScore);

    @Delete
    public void deleteDirtyScore(DirtyScoresEntity... dirtyScore);

    // fetch all settings as a list
    @Query("SELECT * FROM dirtyScore")
    List<DirtyScoresEntity> getAll();
}
