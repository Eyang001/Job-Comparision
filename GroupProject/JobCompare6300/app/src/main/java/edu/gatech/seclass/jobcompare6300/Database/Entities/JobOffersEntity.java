package edu.gatech.seclass.jobcompare6300.Database.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class JobOffersEntity {


    @PrimaryKey(autoGenerate = true)
    public int jobOfferID;

    @ColumnInfo(name = "score")
    public int score;

    public JobOffersEntity(int score){
        this.score = score;

    }

}
