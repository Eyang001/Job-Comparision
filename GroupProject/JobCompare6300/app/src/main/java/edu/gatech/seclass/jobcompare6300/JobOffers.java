package edu.gatech.seclass.jobcompare6300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class JobOffers {
    private ArrayList<Job> jobOffers;
    private HashMap<Job, Float> rankedJobOffers;
    private LinkedList<Job> sortedJobOffers;
    private boolean dirtyScores; //used to indicate that the weights have been updated but not the scores

    public JobOffers(){
        this.jobOffers=new ArrayList<Job>();
        this.rankedJobOffers=new HashMap<Job, Float>();
        this.sortedJobOffers=new LinkedList<Job>();
        dirtyScores = false;
    }

    public float getJobScore(Job job){
        return rankedJobOffers.get(job);
    }

    public void updateJobScores(ComparisonWeights weights){
        /* for every job in jobOffers, recompute the job score
        update the value in ranked offers accordingly
        call sortJobOffers
         */
    }

    private void sortJobOffers(){
        /* purge sortedJobOffers
        sort rankedJobOffers
        add sorted results back to sortedJobOffers
         */
    }

    public void markScoresDirty(){
        this.dirtyScores=true;
    }
    private void markScoresClean(){
        this.dirtyScores=false;
    }

    public Job getCurrentJob(Job job){
        return this.jobOffers.get(0);
    }

    public void addOffer(Job job, ComparisonWeights weights){

    }
}
