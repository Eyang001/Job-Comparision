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
    public void insertLocation(LocationEntity... locations);

    @Update
    public void updateLocation(LocationEntity... locations);

    @Delete
    public void deleteLocation(LocationEntity locations);

    @Query("SELECT * FROM locations")
    List<LocationEntity> getAll();
}
