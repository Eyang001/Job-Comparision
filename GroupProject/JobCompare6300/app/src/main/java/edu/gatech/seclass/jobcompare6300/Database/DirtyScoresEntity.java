package edu.gatech.seclass.jobcompare6300.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity
public class DirtyScoresEntity {

    @ColumnInfo(name = "dirtyScores")
    public String dirtyScores;

}
