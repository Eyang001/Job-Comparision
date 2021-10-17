package edu.gatech.seclass.jobcompare6300;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class JobOffersUnitTest {
    private JobOffers jobOffers;
    @Before
    public void setup(){
        jobOffers=new JobOffers();
    }

    @Test
    public void testGetCurrentJob(){
        jobOffers=new JobOffers();
        //should return null if there is no current job
        assertNull(jobOffers.getCurrentJob());

        //insert a job that is not current job
        Location location = new Location("Test City", "Testland", 100);
        ComparisonWeights weights= new ComparisonWeights();
        Job job = new Job("Test Engineer", "GT", location, 100000, 50000,0,20,500);
        jobOffers.addOffer(job, weights, false);
        assertNull(jobOffers.getCurrentJob());

        //add another job
        job = new Job("Test Engineer", "GT", location, 100000, 50000,0,20,500);
        jobOffers.addOffer(job, weights, false);
        ArrayList<Job> allOffers = jobOffers.getJobOffers();
        System.out.println(allOffers.toString());
        assertEquals(3,allOffers.size()); //0 index null
        assertNull(jobOffers.getCurrentJob());

        //add current job
        job = new Job("Test Engineer", "GT", location, 100000, 50000,0,20,500);
        jobOffers.addOffer(job, weights, true);
        assertNotNull(jobOffers.getCurrentJob());
        allOffers=jobOffers.getJobOffers();
        assertEquals(3, allOffers.size());
    }
}
