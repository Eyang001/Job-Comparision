package edu.gatech.seclass.jobcompare6300;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ComparisonWeightsUnitTest {
    private ComparisonWeights comparisonWeights;

    @Before
    public void setUp() {
        comparisonWeights = new ComparisonWeights();
    }


    @Test
    public void getYearlySalary() {
        assertEquals(1, comparisonWeights.getYearlySalary());
        comparisonWeights = new ComparisonWeights(2,1,1,1,1);
        assertEquals(2, comparisonWeights.getYearlySalary());
        comparisonWeights.setYearlySalary(3);
        assertEquals(3, comparisonWeights.getYearlySalary());
    }

    @Test
    public void setYearlySalary() {
        comparisonWeights.setYearlySalary(4);
        assertEquals(4, comparisonWeights.getYearlySalary());
        comparisonWeights.setYearlySalary(42);
        assertEquals(42, comparisonWeights.getYearlySalary());
    }

    @Test
    public void getYearlyBonus() {
        assertEquals(1, comparisonWeights.getYearlyBonus());
        comparisonWeights = new ComparisonWeights(1,4,1,1,1);
        assertEquals(4, comparisonWeights.getYearlyBonus());
        comparisonWeights.setYearlyBonus(3);
        assertEquals(3, comparisonWeights.getYearlyBonus());
    }

    @Test
    public void setYearlyBonus() {
        comparisonWeights.setYearlyBonus(4);
        assertEquals(4, comparisonWeights.getYearlyBonus());
        comparisonWeights.setYearlyBonus(42);
        assertEquals(42, comparisonWeights.getYearlyBonus());
    }

    @Test
    public void getTeleDays() {
        assertEquals(1, comparisonWeights.getTeleDays());
        comparisonWeights = new ComparisonWeights(1,1,6,1,1);
        assertEquals(6, comparisonWeights.getTeleDays());
        comparisonWeights.setTeleDays(3);
        assertEquals(3, comparisonWeights.getTeleDays());
    }

    @Test
    public void setTeleDays() {
        comparisonWeights.setTeleDays(4);
        assertEquals(4, comparisonWeights.getTeleDays());
        comparisonWeights.setTeleDays(42);
        assertEquals(42, comparisonWeights.getTeleDays());
    }

    @Test
    public void getLeaveDays() {
        assertEquals(1, comparisonWeights.getLeaveDays());
        comparisonWeights = new ComparisonWeights(1,1,1,3,1);
        assertEquals(3, comparisonWeights.getLeaveDays());
        comparisonWeights.setLeaveDays(4);
        assertEquals(4, comparisonWeights.getLeaveDays());
    }

    @Test
    public void setLeaveDays() {
        comparisonWeights.setLeaveDays(6);
        assertEquals(6, comparisonWeights.getLeaveDays());
        comparisonWeights.setLeaveDays(42);
        assertEquals(42, comparisonWeights.getLeaveDays());
    }

    @Test
    public void getGymAllowance() {
        assertEquals(1, comparisonWeights.getGymAllowance());
        comparisonWeights = new ComparisonWeights(1,2,3,4,5);
        assertEquals(5, comparisonWeights.getGymAllowance());
        comparisonWeights.setGymAllowance(7);
        assertEquals(7, comparisonWeights.getGymAllowance());
    }

    @Test
    public void setGymAllowance() {
        comparisonWeights.setGymAllowance(8);
        assertEquals(8, comparisonWeights.getGymAllowance());
        comparisonWeights.setGymAllowance(10);
        assertEquals(10, comparisonWeights.getGymAllowance());
    }
}