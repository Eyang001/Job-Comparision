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
        float score=0;
        /*compute the score*/
        return score;
    }
}
