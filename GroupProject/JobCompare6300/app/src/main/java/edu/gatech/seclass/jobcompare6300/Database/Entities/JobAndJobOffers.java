package edu.gatech.seclass.jobcompare6300.Database.Entities;

import androidx.room.Embedded;
import androidx.room.Relation;

import edu.gatech.seclass.jobcompare6300.Database.Entities.JobEntity;
import edu.gatech.seclass.jobcompare6300.Database.Entities.JobOffersEntity;

public class JobAndJobOffers {

    @Embedded
    public JobEntity job;
    @Relation(
            parentColumn = "jobId",
            entityColumn = "jobOfferID"
    )
    public JobOffersEntity jobOffers;

    public JobAndJobOffers(JobEntity job, JobOffersEntity jobOffers){
        this.job = job;
        this.jobOffers = jobOffers;
    }

}
