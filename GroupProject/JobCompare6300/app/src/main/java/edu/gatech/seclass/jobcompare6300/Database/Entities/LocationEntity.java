package edu.gatech.seclass.jobcompare6300.Database.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "locations")
public class LocationEntity {

    @PrimaryKey(autoGenerate = true)
    public int locationID;

    @NonNull
    @ColumnInfo(name = "city")
    public String city;

    @NonNull
    @ColumnInfo(name = "state")
    public String state;

    @NonNull
    @ColumnInfo(name = "costOfLivingIndex")
    public int costOfLivingIndex;

    public LocationEntity(String city, String state, int costOfLivingIndex){
        this.city=city;
        this.state=state;
        this.costOfLivingIndex=costOfLivingIndex;
    }

}
