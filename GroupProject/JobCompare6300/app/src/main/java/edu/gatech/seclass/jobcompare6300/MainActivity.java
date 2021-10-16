package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        controller = new Controller();
    }

    //https://developer.android.com/training/basics/firstapp/starting-activity
    public void editCurrentJob(View view){
        Intent intent = new Intent(); //start enter current job activity, pass it controller

    }

    public void enterJobOffer(View view){
        //controller.enterJobOffer(view);
    }

    public void adjustComparisonWeights(View view){
        //controller.adjustWeights(view);
    }

    public void compareJobOffers(View view){
        //controller.compareOffers(view);
    }

    public void exit(View view){
        this.finishAffinity();
    }
}