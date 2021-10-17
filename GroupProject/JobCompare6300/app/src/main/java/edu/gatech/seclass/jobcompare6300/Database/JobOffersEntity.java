package edu.gatech.seclass.jobcompare6300.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class JobOffersEntity {

    @PrimaryKey
    public int jobOfferID;

    @ColumnInfo(name = "score")
    public String score;

}
