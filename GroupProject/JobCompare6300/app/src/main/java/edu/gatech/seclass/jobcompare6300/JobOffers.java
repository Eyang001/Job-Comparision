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

    public void updateJobScores(ComparisonWeights weights){
        /* for every job in jobOffers, recompute the job score
        update the value in ranked offers accordingly
        call sortJobOffers
         */

        //if (!dirtyScores) {return};

        /* update score for each job offer */
        for(Map.Entry<Job, Float> pair : rankedJobOffers.entrySet()){
            float newScore = pair.getKey().getJobScore(weights);
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

    public void addOffer(Job job, ComparisonWeights weights, boolean isCurrentJob){
        /* if currentJob does not exist, add to index 0 */
        if (isCurrentJob && getCurrentJob() == null) {jobOffers.add(0,job); }
        else if (!isCurrentJob){
            if (getCurrentJob() != null) {
                jobOffers.add(jobOffers.size(), job);
            } else {
                jobOffers.add(jobOffers.size() + 1, job);
            }

            //calculate score and add to rankedJobOffers
            float score = job.getJobScore(weights);
            rankedJobOffers.put(job, score);
        }
    }


    public Job getCurrentJob(){
        return this.jobOffers.get(0);
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

}
