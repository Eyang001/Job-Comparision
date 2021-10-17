package edu.gatech.seclass.jobcompare6300.Database.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.gatech.seclass.jobcompare6300.ComparisonWeights;
import edu.gatech.seclass.jobcompare6300.Job;

@Dao
public interface ComparisonWeightsDAO {

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        public void insertSettings(ComparisonWeights... comparisonWeights);

        @Update
        public void updateSettings(ComparisonWeights... comparisonWeights);

        @Delete
        public void delete(ComparisonWeights comparisonWeights);

        // fetch all settings as a list
        @Query("SELECT * FROM ComparisonWeightsEntity")
        List<Job> getAll();
}
