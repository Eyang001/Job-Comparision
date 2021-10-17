package edu.gatech.seclass.jobcompare6300.Database.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.gatech.seclass.jobcompare6300.Database.Entities.LocationEntity;

@Dao
public interface LocationDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insert(LocationEntity... locationEntities);

    @Update
    public void update(LocationEntity... locationEntities);

    @Delete
    public void delete(LocationEntity locationEntities);

    @Query("SELECT * FROM LocationEntity")
    List<LocationEntity> getAll();
}
