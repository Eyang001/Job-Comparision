package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.LinkedList;

public class Controller {
    private static JobOffers jobOffers;
    private static ComparisonWeights weights;
    private static ArrayList<Location> locations;
    private static DatabaseHandler databaseHandler;

    public Controller(Context context){
        jobOffers = new JobOffers();
        weights = new ComparisonWeights();
        locations = new ArrayList<Location>();
        databaseHandler = DatabaseHandler.getInstance(context);

        // RESET for entire database below **** do NOT uncomment, only for testing
        // context.deleteDatabase("jobsManager.db");

        // Try to load the DB if it already exists locally
        try {
            updateWeightsFromDb();
            updateJobsFromDb();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateWeightsFromDb() {
        weights = databaseHandler.getWeights();
    }

    public void updateJobsFromDb() {
        jobOffers = databaseHandler.getAllJobs();
    }

    public static int getNumJobs(){
        return jobOffers.getNumJobs();
    }
    public static float getJobScore(Job job){
        return jobOffers.getJobScore(job);
    }

    public static LinkedList<Job> getSortedJobs(){
        jobOffers.updateJobScores(weights);
        return jobOffers.getSortedJobOffers();
    }
    public static Job getCurrentJob(){return jobOffers.getCurrentJob();}

    public static Job getLatestOffer(){return jobOffers.getLastSavedJobOffer();}
  
    public static Location getLocationByCityState(String city, String state){
        for (Location l: locations){
            if(l.getCity() == city && l.getState()==state) return l;
        }
        return null;
    }

    public static void editCurrentJob(String title, String company, String city, String state, int colIndex,
                        int salary, int bonus, int teleworkDays, int leaveDays, int gymAllowance){
        Job job = jobOffers.getCurrentJob();
        addLocation(city, state, colIndex);
        Location location = getLocationByCityState(city, state);
        if(job==null){
            job = new Job(title, company, location, salary, bonus, teleworkDays, leaveDays, gymAllowance);
        }
        else{
            job.setTitle(title);
            job.setCompany(company);
            job.setLocation(location);
            job.setSalary(salary);
            job.setBonus(bonus);
            job.setTeleworkDays(teleworkDays);
            job.setLeaveDays(leaveDays);
            job.setGymAllowance(gymAllowance);
        }
        // DB entry for Current Job
        databaseHandler.enterJob(job, true);

        jobOffers.addOffer(job, weights, true);

    }

    public static void enterJobOffer(String title, String company, String city, String state, int colIndex,
                      int salary, int bonus, int teleworkDays, int leaveDays, int gymAllowance){
        addLocation(city, state, colIndex);
        Location location=getLocationByCityState(city,state);

        // DB entries for Offers
        Job job = new Job(title, company, location, salary, bonus, teleworkDays, leaveDays, gymAllowance);
        boolean currentJob = false;
        databaseHandler.enterJob(job, currentJob);

        jobOffers.addOffer(new Job(title, company, location, salary, bonus, teleworkDays, leaveDays,
                gymAllowance), weights, false);
    }

    public static void adjustWeights(int salaryWeight, int bonusWeight, int teleWeight, int leaveWeight, int gymWeight) {
        weights.setYearlySalary(salaryWeight);
        weights.setYearlyBonus(bonusWeight);
        weights.setTeleDays(teleWeight);
        weights.setLeaveDays(leaveWeight);
        weights.setGymAllowance(gymWeight);
        // add weights to DB
        databaseHandler.setWeights(weights); // enter weights into DB
    }

    public static ComparisonWeights getWeights(){
        return weights;
    }

    //adds location if it does not exist, updates the cost of living index if the location does exist.
    public static void addLocation(String city, String state, int colIndex){
        //O(2n)
        if(!locationIsStored(city,state)){
            locations.add(new Location(city, state, colIndex));
        }
        else{
            for (Location l: locations) {
                if(l.getCity().equals(city) && l.getState().equals(state)){
                    l.setCostOfLivingIndex(colIndex);
                    break;
                }
            }
        }
    }
    
    private static boolean locationIsStored(String city, String state){
        boolean isStored=false;
        for (Location l: locations) {
            if(l.getCity().equals(city) && l.getState().equals(state)){
                isStored=true;
                break;
            }
        }
        return isStored;
    }
}
