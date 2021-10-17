package edu.gatech.seclass.jobcompare6300.Database.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.gatech.seclass.jobcompare6300.ComparisonWeights;
import edu.gatech.seclass.jobcompare6300.Database.Entities.ComparisonWeightsEntity;

@Dao
public interface ComparisonWeightsDAO {

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        public void insertComparisonWeights(ComparisonWeights... comparisonWeights);

        @Update
        public void updateComparisonWeights(ComparisonWeights... comparisonWeights);

        @Delete
        public void deleteComparisonWeights(ComparisonWeights... comparisonWeights);

        // fetch all settings as a list
        @Query("SELECT * FROM comparisonWeights")
        List<ComparisonWeightsEntity> getAll();
}
