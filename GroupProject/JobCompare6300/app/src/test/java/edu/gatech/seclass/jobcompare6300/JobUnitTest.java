package edu.gatech.seclass.jobcompare6300;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JobUnitTest {
    private Job job;

    @Before
    public void setUp() throws Exception {
        Location location = new Location("Test City", "Testland", 100);
        job = new Job("Test Engineer", "GT", location, 100000, 50000,0,20,500);
    }

    @Test
    public void getTitle() {
        assertEquals("Test Engineer", job.getTitle());
    }

    @Test
    public void getCompany() {
        assertEquals("GT", job.getCompany());
    }

    @Test
    public void getLocationCity() {
        assertEquals("Test City", job.getLocationCity());
    }

    @Test
    public void getLocationState() {
        assertEquals("Testland", job.getLocationState());
    }

    @Test
    public void getLocationCostOfLivingIndex() {
        assertEquals(100, job.getLocationCostOfLivingIndex());
    }

    @Test
    public void getSalary() {
        assertEquals(100000, job.getSalary());
    }

    @Test
    public void getBonus() {
        assertEquals(50000, job.getBonus());
    }

    @Test
    public void getTeleworkDays() {
        assertEquals(0, job.getTeleworkDays());
    }

    @Test
    public void getLeaveDays() {
        assertEquals(20, job.getLeaveDays());
    }

    @Test
    public void getGymAllowance() {
        assertEquals(500, job.getGymAllowance());
    }

    @Test
    public void setTitle() {
        job.setTitle("Tech Lead");
        assertEquals("Tech Lead", job.getTitle());
    }

    @Test
    public void setCompany() {
        job.setCompany("Home Depot");
        assertEquals("Home Depot", job.getCompany());
    }

    @Test
    public void setLocation() {
        Location location1 = new Location("Starbase", "Texas", 1);
        job.setLocation(location1);
        assertEquals("Starbase", job.getLocationCity());
        assertEquals("Texas", job.getLocationState());
        assertEquals(1, job.getLocationCostOfLivingIndex());
    }

    @Test
    public void setSalary() {
        job.setSalary(90000);
        assertEquals(90000, job.getSalary());
    }

    @Test
    public void setBonus() {
        job.setBonus(10000);
        assertEquals(10000, job.getBonus());
    }

    @Test
    public void setTeleworkDays() {
        job.setTeleworkDays(5);
        assertEquals(5, job.getTeleworkDays());
    }

    @Test
    public void setLeaveDays() {
        job.setLeaveDays(42);
        assertEquals(42, job.getLeaveDays());
    }

    @Test
    public void setGymAllowance() {
        job.setGymAllowance(100);
        assertEquals(100, job.getGymAllowance());
    }

    @Test
    public void getJobScore() {
        ComparisonWeights comparisonWeights = new ComparisonWeights();
        assertEquals(29138.4615, job.getJobScore(comparisonWeights),1); // (100000+ 50000+ 500+ (20* 100000/ 260) - ((260 - 52 * 0) * (100000/ 260) / 8))/5

        Location location = new Location("Test City", "Testland", 200);
        job = new Job("Test Engineer", "GT", location, 100000, 50000,0,20,500);
        assertEquals(14619.2308, job.getJobScore(comparisonWeights),1); // (100000/2+ 50000/2+ 500+ (20* (100000/2)/ 260) - ((260 - 52 * 0) * ((100000/2)/ 260) / 8))/5

        job = new Job("Test Engineer", "GT", location, 100000, 50000,1,20,500);
        assertEquals(14869.2308, job.getJobScore(comparisonWeights),1); // (100000/2+ 50000/2+ 500+ (20* (100000/2)/ 260) - ((260 - 52 * 1) * ((100000/2)/ 260) / 8))/5

        ComparisonWeights comparisonWeights2 = new ComparisonWeights(2,3,4,5,6);
        assertEquals(8861.53846, job.getJobScore(comparisonWeights2),1); // (2/20)(100000/2) + (3/20)(50000/2) + (6/20)500 + (5/20)(20* (100000/2)/ 260) - (4/20)((260 - 52 * 1) * ((100000/2)/ 260)/8)
                                                                                        //      5000 + 3750 + 150 + 961.538462 - 1000
    }
}