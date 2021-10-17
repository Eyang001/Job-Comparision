package edu.gatech.seclass.jobcompare6300.Database.Entities;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

import edu.gatech.seclass.jobcompare6300.Database.Entities.JobEntity;
import edu.gatech.seclass.jobcompare6300.Database.Entities.LocationEntity;

public class JobWithLocation {

    @Embedded
    public LocationEntity location;
    @Relation(
            parentColumn = "locationId",
            entityColumn = "jobId"
    )
    public List<JobEntity> jobs;

    public JobWithLocation(LocationEntity location, List jobs){
        this.location = location;
        this.jobs = jobs;
    }

}
