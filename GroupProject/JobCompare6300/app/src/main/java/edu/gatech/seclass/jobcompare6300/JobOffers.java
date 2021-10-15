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
        if !dirtyScores {return};
        for(Map.Entry<Job, Float> pair : jobOffers.entrySet()){
            float newScore = calculateScore(pair.getKey(),weights);
            jobOffers.put(pair.getKey(),newScore);
        }
        markScoresClean();
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

    //how to differentiate currentJobOffer vs jobOffer?
    public void addOffer(Job job, ComparisonWeights weights){
        jobOffers[0] != null ? jobOffers[jobOffers.size()] = job : jobOffers[jobOffers.size()-1] = job;
        float score = calculateScore(job, weights);
        rankedJobOffers.put(job, score);
    }

    public float calculateScore(Job job, ComparisonWeights weights){
        int yearlySalary = weights.getyearlySalary();
        int yearlyBonus = weights.getyearlyBonus();
        int teleDays = weights.getteleDays();
        int leave = weights.getleaveDays();
        int gym = weights.getGymAllowance();
        int sumWeights = yearlySalary + yearlyBonus + teleDays + leave + gym;
        return job.getSalary() * yearlySalary / sumWeights + job.getBonus() * yearlyBonus / sumWeights
                + job.getGymAllowance() * gym / sumWeights + (job.getLeaveDays() * job.getSalary() / 260) * leave / sumWeights
                + ((260 - 52 * job.getTeleworkDays()) * (job.getSalary() / 260) / 8) * teleDays / sumWeights;
    }

}
