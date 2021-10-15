package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.view.View;

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
        //start DB handler

        /*loop
        switch(user button selection){
            case enter current job:
            case enter job offer:
            case adjust comparison weights:
            case compare job offers:
            case exit:
                //spin down DB handler
                //
            case default:
                continue
        */


        /* listen for menu selection
        handle selection accordingly
        loop
         */


    }

    public void editCurrentJob(View view){
        //Intent intent = new Intent(this, enterCurrentJobActivity.class);
        //startActivity(intent);

        /* display activity_enter_current_job
        save current job's details in jobOffers if save button is selected, otherwise cancel
        return to main menu
         */
    }

    public void enterJobOffer(View view){
        /* display activity_enter_job_offer
        save/cancel
        handle appropriate follow-on action
         */
    }

    public void adjustWeights(View view){
        /* display activity_adjust_comparison_weights
        save/cancel then return to main menu
         */
    }

    public void compareOffers(View view){
        /* display activity_compare_jobs

         */
    }

    //adds location if it does not exist, updates the cost of living index if the location does exist.
    private void addLocation(String city, String state, int colIndex){
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
