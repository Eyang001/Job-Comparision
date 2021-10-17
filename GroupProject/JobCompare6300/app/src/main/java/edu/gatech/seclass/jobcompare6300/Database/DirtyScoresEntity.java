package edu.gatech.seclass.jobcompare6300.Database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity
public class DirtyScoresEntity {

    @ColumnInfo(name = "dirtyScores")
    public int dirtyScores;

    public DirtyScoresEntity(int dirtyScores){
        this.dirtyScores = dirtyScores;
    }

}
