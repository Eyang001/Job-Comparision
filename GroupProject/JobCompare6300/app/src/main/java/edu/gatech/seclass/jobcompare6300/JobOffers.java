package edu.gatech.seclass.jobcompare6300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class JobOffers {
    private ArrayList<Job> jobOffers;
    private HashMap<Job, Float> rankedJobOffers;
    private LinkedList<Job> sortedJobOffers;

    public JobOffers(){
        this.jobOffers=new ArrayList<Job>(10);
        this.rankedJobOffers=new HashMap<Job, Float>();
        this.sortedJobOffers=new LinkedList<Job>();
    }

    public void updateJobScores(ComparisonWeights weights){
        /* for every job in jobOffers, recompute the job score
        update the value in ranked offers accordingly
        call sortJobOffers
         */
        /* update score for each job offer */
        for(Map.Entry<Job, Float> pair : rankedJobOffers.entrySet()){
            float newScore = pair.getKey().getJobScore(weights);
            rankedJobOffers.put(pair.getKey(),newScore);
        }
        /* sort and update rankedJobOffers and rankedJobOffers */
        sortJobOffers();
    }

    private void sortJobOffers(){
        /* purge sortedJobOffers */
        sortedJobOffers.clear();

        /* sort rankedJobOffers */
        List<Map.Entry<Job, Float>> list = new LinkedList<>(rankedJobOffers.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Job, Float>>()
            {
            public int compare(Map.Entry<Job, Float> o1, Map.Entry<Job, Float> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        /* add sorted results back to sortedJobOffers */
        for(Map.Entry<Job, Float> pair : rankedJobOffers.entrySet()){
            sortedJobOffers.add(pair.getKey());
        }
    }

    public void addOffer(Job job, ComparisonWeights weights, boolean isCurrentJob){
        /* if currentJob does not exist, add to index 0 */
        if (isCurrentJob && getCurrentJob() == null) {
            if(jobOffers.size() == 0) {jobOffers.add(job);}
            else{jobOffers.set(0,job);}
        }
        else if (!isCurrentJob){
            if (getCurrentJob() != null) {
                jobOffers.add(jobOffers.size(), job);
            } else {
                if(jobOffers.size() == 0) {
                    jobOffers.add(0, null);
                }
                jobOffers.add(jobOffers.size(), job);
            }

            //calculate score and add to rankedJobOffers
            float score = job.getJobScore(weights);
            rankedJobOffers.put(job, score);
        }
    }

    public int getNumJobs(){
        if(jobOffers.size()>=1 && getCurrentJob()==null){
            return jobOffers.size()-1;
        }
        else return jobOffers.size();
    }

    public Job getCurrentJob(){
        if(this.jobOffers.size()>0){
            return this.jobOffers.get(0);
        }
        else return null;
    }

    public Job getLastSavedJobOffer(){
        if(getCurrentJob() == null){
            return this.jobOffers.get(this.jobOffers.size());
        } else {
            return this.jobOffers.get(this.jobOffers.size()-1);
        }
    }

    public ArrayList<Job> getJobOffers(){
        return this.jobOffers;
    }

    public float getJobScore(Job job){
        return this.rankedJobOffers.get(job);
    }

    public LinkedList<Job> getSortedJobOffers(){return sortedJobOffers;}
}
