package edu.gatech.seclass.jobcompare6300;

import java.util.ArrayList;

public class Controller {
    private JobOffers jobOffers;
    private ComparisonWeights weights;
    private ArrayList<Location> locations;

    public Controller(){
        jobOffers = new JobOffers();
        weights = new ComparisonWeights();
        locations = new ArrayList<Location>();
    }

    public void run(){
        /* listen for menu selection
        handle selection accordingly
        loop
         */
    }

    public void editCurrentJob(){
        /* display activity_enter_current_job
        save current job's details in jobOffers if save button is selected, otherwise cancel
        return to main menu
         */
    }

    public void enterJobOffer(){
        /* display activity_enter_job_offer
        save/cancel
        handle appropriate follow-on action
         */
    }

    public void adjustWeights(){
        /* display activity_adjust_comparison_weights
        save/cancel then return to main menu
         */
    }

    public void compareOffers(){
        /* display activity_compare_jobs

         */
    }

    private void addLocation(String city, String state, int colIndex){
        
    }
    
    private boolean locationIsStored(String city, String state){
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
