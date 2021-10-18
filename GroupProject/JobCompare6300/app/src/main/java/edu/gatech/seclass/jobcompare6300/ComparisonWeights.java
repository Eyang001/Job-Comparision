package edu.gatech.seclass.jobcompare6300;

public class ComparisonWeights {
    private int yearlySalary;
    private int yearlyBonus;
    private int teleDays;
    private int leaveDays;
    private int gymAllowance;

    public ComparisonWeights() {
        this.yearlySalary = 1;
        this.yearlyBonus = 1;
        this.teleDays = 1;
        this.leaveDays = 1;
        this.gymAllowance = 1;
    }

    public ComparisonWeights(int yearlySalary, int yearlyBonus, int teleDays, int leaveDays, int gymAllowance) {
        this.yearlySalary = yearlySalary;
        this.yearlyBonus = yearlyBonus;
        this.teleDays = teleDays;
        this.leaveDays = leaveDays;
        this.gymAllowance = gymAllowance;
    }

    public int getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(int yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public int getYearlyBonus() {
        return yearlyBonus;
    }

    public void setYearlyBonus(int yearlyBonus) {
        this.yearlyBonus = yearlyBonus;
    }

    public int getTeleDays() {
        return teleDays;
    }

    public void setTeleDays(int teleDays) {
        this.teleDays = teleDays;
    }

    public int getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
    }

    public int getGymAllowance() {
        return gymAllowance;
    }

    public void setGymAllowance(int gymAllowance) {
        this.gymAllowance = gymAllowance;
    }
}
