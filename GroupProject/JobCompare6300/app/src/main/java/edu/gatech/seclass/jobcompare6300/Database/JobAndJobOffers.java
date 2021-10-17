package edu.gatech.seclass.jobcompare6300.Database;

import androidx.room.Embedded;
import androidx.room.Relation;

public class JobAndJobOffers {

    @Embedded
    public JobEntity job;
    @Relation(
            parentColumn = "jobId",
            entityColumn = "jobOfferID"
    )
    public JobOffersEntity jobOffers;

}
