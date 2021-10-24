package edu.gatech.seclass.jobcompare6300;

public class Location {
    private final String city;
    private final String state;
    private int costOfLivingIndex;

    public Location(String city, String state, int colIndex){
        this.city=city;
        this.state=state;
        this.costOfLivingIndex=colIndex;
    }

    public String getCity(){
        return city;
    }

    public String getState(){
        return state;
    }

    public int getCostOfLivingIndex(){
        return costOfLivingIndex;
    }

    public void setCostOfLivingIndex(int colIndex){
        this.costOfLivingIndex=colIndex;
    }
}
