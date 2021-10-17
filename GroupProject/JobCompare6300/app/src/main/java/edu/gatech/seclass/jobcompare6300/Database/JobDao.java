package edu.gatech.seclass.jobcompare6300.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface JobDao {

    //TODO below

    //TODO below

    @Query("SELECT * FROM Job")
    List<Job> getAll();

    @Query("SELECT * FROM Job WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);

    //for 1-1 relationship
    @Transaction
    @Query("SELECT * FROM Job")
    public List<JobAndJobOffers> getJobAndJobOffers();

    //for 1-M relationship
    @Transaction
    @Query("SELECT * FROM Location")
    public List<JobWithLocation> getJobWithLocation();


    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}