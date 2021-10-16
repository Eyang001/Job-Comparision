package edu.gatech.seclass.jobcompare6300.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;

@Entity
public class JobOffersEntity {

    @ForeignKey("jobID")
    public String jobID;

    @ColumnInfo(name = "score")
    public String score;

}
