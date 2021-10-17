package edu.gatech.seclass.jobcompare6300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
        //if (!dirtyScores) {return};

        /* update score for each job offer */
        for(Map.Entry<Job, Float> pair : rankedJobOffers.entrySet()){
            float newScore = calculateScore(pair.getKey(),weights);
            rankedJobOffers.put(pair.getKey(),newScore);
        }

        /* sort jobOffers */


        //markScoresClean();
    }

    private void sortJobOffers(){
        /* purge sortedJobOffers
        sort rankedJobOffers
        add sorted results back to sortedJobOffers
         */
        for(Map.Entry<Job, Float> pair : rankedJobOffers.entrySet()){
            pair.getKey();
            pair.getValue();
            
        }
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

    public void addOffer(Job job, ComparisonWeights weights, boolean isCurrentJob){
        if (isCurrentJob && jobOffers.get(0) == null) {jobOffers.add(0,job); }
        else if (!isCurrentJob){
            if (jobOffers.get(0) != null) {
                jobOffers.add(jobOffers.size(), job);
            } else {
                jobOffers.add(jobOffers.size() - 1, job);
            }
            float score = calculateScore(job, weights);
            rankedJobOffers.put(job, score);
        }
    }

    public float calculateScore(Job job, ComparisonWeights weights){
        int sumWeights = yearlySalary + yearlyBonus + teleDays + leave + gym;
        float yearlySalaryWeight = weights.getyearlySalary()/sumWeights;
        float yearlyBonusWeight = weights.getyearlyBonus()/sumWeights;
        float teleDaysWeight = weights.getteleDays()/sumWeights;
        float leaveWeight = weights.getleaveDays()/sumWeights;
        float gymWeight = weights.getGymAllowance()/sumWeights;

        float AYS = job.getSalary() * job.getLocationCostOfLivingIndex();
        float AYB = job.getBonus() * job.getLocationCostOfLivingIndex();
        return  AYS * yearlySalaryWeight + AYB * yearlyBonusWeight
                + job.getGymAllowance() * gymWeight + (job.getLeaveDays() * AYS / 260) * leaveWeight
                + ((260 - 52 * job.getTeleworkDays()) * (AYS / 260) / 8) * teleDaysWeight;
    }

}
