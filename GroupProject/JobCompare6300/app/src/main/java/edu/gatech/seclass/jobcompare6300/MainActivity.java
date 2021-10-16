package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Controller controller;
    private Button enterCurrentJobButton;
    private Button enterJobOfferButton;
    private Button adjustWeigthsButton;
    private Button compareOffersButton;
    private Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        controller = new Controller();

        enterCurrentJobButton = (Button) findViewById(R.id.enterCurrentJobButton);
        enterJobOfferButton = (Button) findViewById(R.id.enterJobOfferButton);
        adjustWeigthsButton = (Button) findViewById(R.id.adjustWeightsButton);
        compareOffersButton = (Button) findViewById(R.id.compareJobOffersButton);
        exitButton = (Button) findViewById(R.id.exitButton);
    }

    //https://developer.android.com/training/basics/firstapp/starting-activity
    public void editCurrentJob(View view){
        Intent intent = new Intent(this, EnterJobActivity.class); //start enter current job activity, pass it controller
        //intent.putExtra(controller);
        startActivity(intent);
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