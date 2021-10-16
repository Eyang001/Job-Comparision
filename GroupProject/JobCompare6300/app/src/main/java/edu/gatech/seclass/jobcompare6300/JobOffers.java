package edu.gatech.seclass.jobcompare6300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
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

        /* sort and update rankedJobOffers and rankedJobOffers */
        sortJobOffers();
        //markScoresClean();
    }

    private void sortJobOffers(){
        /* purge sortedJobOffers */
        sortedJobOffers.clear();

        /* sort rankedJobOffers */
        List<Map.Entry<Job, Float>> list = new LinkedList<>(rankedJobOffers.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Job, Float>>()
            {
            public int compare(Map.Entry<Job, Float> o1, Map.Entry<Job, Float> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        /* add sorted results back to sortedJobOffers */
        for(Map.Entry<Job, Float> pair : rankedJobOffers.entrySet()){
            sortedJobOffers.add(pair.getKey());
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
        /* if currentJob does not exist, add to index 0 */
        if (isCurrentJob && jobOffers.get(0) == null) {jobOffers.add(0,job); }
        else if (!isCurrentJob){
            if (jobOffers.get(0) != null) {
                jobOffers.add(jobOffers.size(), job);
            } else {
                jobOffers.add(jobOffers.size() - 1, job);
            }

            //calculate score and add to rankedJobOffers
            float score = calculateScore(job, weights);
            rankedJobOffers.put(job, score);
        }
    }

    public float calculateScore(Job job, ComparisonWeights weights){
        int sumWeights = weights.getyearlySalary() + weights.getyearlyBonus() + weights.getteleDays()
                + weights.getleaveDays() + weights.getGymAllowance();
        float yearlySalaryWeight = (float) weights.getyearlySalary()/sumWeights;
        float yearlyBonusWeight = (float) weights.getyearlyBonus()/sumWeights;
        float teleDaysWeight = (float) weights.getteleDays()/sumWeights;
        float leaveWeight = (float) weights.getleaveDays()/sumWeights;
        float gymWeight = (float) weights.getGymAllowance()/sumWeights;

        float AYS = job.getSalary() * job.getLocationCostOfLivingIndex();
        float AYB = job.getBonus() * job.getLocationCostOfLivingIndex();
        return  AYS * yearlySalaryWeight + AYB * yearlyBonusWeight
                + job.getGymAllowance() * gymWeight + (job.getLeaveDays() * AYS / 260) * leaveWeight
                + ((260 - 52 * job.getTeleworkDays()) * (AYS / 260) / 8) * teleDaysWeight;
    }

}
