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

        titleField = (EditText) findViewById(R.id.titleField);
        companyField = (EditText) findViewById(R.id.companyField);
        cityField = (EditText) findViewById(R.id.cityField);
        stateField = (EditText) findViewById(R.id.stateField);
        colField = (EditText) findViewById(R.id.colField);
        salaryField = (EditText) findViewById(R.id.salaryField);
        bonusField = (EditText) findViewById(R.id.bonusField);
        teleworkField = (EditText) findViewById(R.id.teleworkField);
        leaveField = (EditText) findViewById(R.id.leaveField);
        gymField = (EditText) findViewById(R.id.gymField);
        saveButton = (Button) findViewById(R.id.saveButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);
        additionalOfferButton = (Button) findViewById(R.id.additionalOfferButton);
        compareToCurrentJobButton = (Button) findViewById(R.id.compareToCurrentJobButton);
    }

    public void save(View view){

    }

    public void cancel(View view){
        titleField.setText("");
        companyField.setText("");
        cityField.setText("");
        stateField.setText("");
        colField.setText("");
        salaryField.setText("");
        bonusField.setText("");
        teleworkField.setText("");
        leaveField.setText("");
        gymField.setText("");
    }
    public void enterAnotherOffer(View view){
        Intent intent = new Intent(this, EnterJobOfferActivity.class);
        startActivity(intent);
        this.finish();
    }

    public void compareToCurrentJob(View view){
        Intent intent = new Intent(this, CompareOffersActivity.class);
        startActivity(intent);
        this.finish();
    }

    public void mainMenu(View view){
        this.finish();
    }


}
