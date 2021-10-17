package edu.gatech.seclass.jobcompare6300.Database;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class JobWithLocation {

    @Embedded
    public LocationEntity location;
    @Relation(
            parentColumn = "locationId",
            entityColumn = "jobId"
    )
    public List<JobEntity> jobs;

}
