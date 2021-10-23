package edu.gatech.seclass.jobcompare6300;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LocationUnitTest {
    private Location location;

    @Before
    public void setUp() throws Exception {
        location = new Location("Starbase", "Texas", 100);
    }

    @Test
    public void getCity() {
        assertEquals("Starbase", location.getCity());
    }

    @Test
    public void getState() {
        assertEquals("Texas", location.getState());
    }

    @Test
    public void getCostOfLivingIndex() {
        assertEquals(100, location.getCostOfLivingIndex());
    }

    @Test
    public void setCostOfLivingIndex() {
        location.setCostOfLivingIndex(150);
        assertEquals(150, location.getCostOfLivingIndex());
    }
}