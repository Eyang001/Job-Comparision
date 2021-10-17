package edu.gatech.seclass.jobcompare6300;

public class Job {
    private String title;
    private String company;
    private Location location;
    private int salary;
    private int bonus;
    private int teleworkDays;
    private int leaveDays;
    private int gymAllowance;

    public Job(String title, String company, Location location, int salary, int bonus, int teleworkDays, int leaveDays, int gymAllowance){
        this.title=title;
        this.company=company;
        this.location=location;
        this.salary=salary;
        this.bonus=bonus;
        this.teleworkDays=teleworkDays;
        this.leaveDays=leaveDays;
        this.gymAllowance=gymAllowance;
    }

    public String getTitle() {return title;}
    public String getCompany() {return company;}
    public String getLocationCity(){return location.getCity();}
    public String getLocationState(){return location.getState();}
    public int getLocationCostOfLivingIndex(){return location.getCostOfLivingIndex();}
    public int getSalary(){return salary;}
    public int getBonus(){return bonus;}
    public int getTeleworkDays(){return teleworkDays;}
    public int getLeaveDays(){return leaveDays;}
    public int getGymAllowance(){return gymAllowance;}

    public void setTitle(String title){this.title=title;}
    public void setCompany(String company){this.company=company;}
    public void setLocation(Location location){this.location=location;}
    public void setSalary(int salary){this.salary=salary;}
    public void setBonus(int bonus){this.bonus=bonus;}
    public void setTeleworkDays(int teleworkDays){this.teleworkDays=teleworkDays;}
    public void setLeaveDays(int leaveDays){this.leaveDays=leaveDays;}
    public void setGymAllowance(int gymAllowance){this.gymAllowance=gymAllowance;}

    public float getJobScore(ComparisonWeights weights){
        /* function computes a Job's score*/
        float score=0;

        // from Emily job offer class

        int sumWeights = weights.getYearlySalary() + weights.getYearlyBonus() + weights.getTeleDays()
                + weights.getLeaveDays() + weights.getGymAllowance();
        float yearlySalaryWeight = (float) weights.getYearlySalary()/sumWeights;
        float yearlyBonusWeight = (float) weights.getYearlyBonus()/sumWeights;
        float teleDaysWeight = (float) weights.getTeleDays()/sumWeights;
        float leaveWeight = (float) weights.getLeaveDays()/sumWeights;
        float gymWeight = (float) weights.getGymAllowance()/sumWeights;

        float AYS = this.getSalary() * this.getLocationCostOfLivingIndex();
        float AYB = this.getBonus() * this.getLocationCostOfLivingIndex();
        score =  AYS * yearlySalaryWeight + AYB * yearlyBonusWeight
                + this.getGymAllowance() * gymWeight + (this.getLeaveDays() * AYS / 260) * leaveWeight
                + ((260 - 52 * this.getTeleworkDays()) * (AYS / 260) / 8) * teleDaysWeight;

        return score;
    }
}
