package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EnterJobOfferActivity extends AppCompatActivity {
    private Controller controller;
    private Button saveButton;
    private Button cancelButton;
    private Button additionalOfferButton;
    private Button compareToCurrentJobButton;
    private Button mainMenuButton;
    private EditText titleField;
    private EditText companyField;
    private EditText cityField;
    private EditText stateField;
    private EditText colField;
    private EditText salaryField;
    private EditText bonusField;
    private EditText teleworkField;
    private EditText leaveField;
    private EditText gymField;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_job_offer);

        EditText titleField = (EditText) findViewById(R.id.titleField);
        EditText companyField = (EditText) findViewById(R.id.companyField);
        EditText cityField = (EditText) findViewById(R.id.cityField);
        EditText stateField = (EditText) findViewById(R.id.stateField);
        EditText colField = (EditText) findViewById(R.id.colField);
        EditText salaryField = (EditText) findViewById(R.id.salaryField);
        EditText bonusField = (EditText) findViewById(R.id.bonusField);
        EditText teleworkField = (EditText) findViewById(R.id.teleworkField);
        EditText leaveField = (EditText) findViewById(R.id.leaveField);
        EditText gymField = (EditText) findViewById(R.id.gymField);
        Button saveButton = (Button) findViewById(R.id.saveButton);
        Button cancelButton = (Button) findViewById(R.id.cancelButton);
        Button additionalOfferButton = (Button) findViewById(R.id.additionalOfferButton);
        Button compareToCurrentJobButton = (Button) findViewById(R.id.compareToCurrentJobButton);
    }

    public void save(View view){

    }

    public void cancel(View view){

    }
    public void enterAnotherOffer(View view){
        Intent intent = new Intent(this.getApplicationContext(), EnterJobOfferActivity.class);
        startActivity(intent);
    }

    public void compareToCurrentJob(View view){

    }

    public void mainMenu(View view){
        this.finish();
    }


}
