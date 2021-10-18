package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CompareOffersActivity extends AppCompatActivity {

    private TextView job1Salary;
    private TextView job2Salary;
    private TextView job1Bonus;
    private TextView job2Bonus;
    private TextView job1Title;
    private TextView job2Title;
    private TextView job1Company;
    private TextView job2Company;
    private TextView job1Location;
    private TextView job2Location;
    private TextView job1Telework;
    private TextView job2Telework;
    private TextView job1Leave;
    private TextView job2Leave;
    private TextView job1Gym;
    private TextView job2Gym;
    private Spinner job1Spinner;
    private Spinner job2Spinner;
    private Button compareButton;
    private Button anotherComparisonButton;
    private Button mainMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_jobs);
        job1Salary = (TextView) findViewById(R.id.salaryJob1);
        job2Salary = (TextView) findViewById(R.id.salaryJob2);
        job1Bonus = (TextView) findViewById(R.id.bonusJob1);
        job2Bonus = (TextView) findViewById(R.id.bonusJob2);
        job1Title = (TextView) findViewById(R.id.titleJob1);
        job2Title = (TextView) findViewById(R.id.titleJob2);
        job1Company = (TextView) findViewById(R.id.companyJob1);
        job2Company = (TextView) findViewById(R.id.companyJob2);
        job1Location = (TextView) findViewById(R.id.locationJob1);
        job2Location = (TextView) findViewById(R.id.locationJob2);
        job1Telework = (TextView) findViewById(R.id.teleworkJob1);
        job2Telework = (TextView) findViewById(R.id.teleworkJob2);
        job1Leave = (TextView) findViewById(R.id.leaveJob1);
        job2Leave = (TextView) findViewById(R.id.leaveJob2);
        job1Gym = (TextView) findViewById(R.id.gymJob1);
        job2Gym = (TextView) findViewById(R.id.gymJob2);
        job1Spinner = (Spinner) findViewById(R.id.spinner);
        job2Spinner = (Spinner) findViewById(R.id.spinner2);
        compareButton = (Button) findViewById(R.id.compareButton);
        anotherComparisonButton = (Button) findViewById(R.id.resetButton);
        mainMenuButton = (Button) findViewById(R.id.mainMenuButton);

        try{
            boolean compareToCurrentJob = getIntent().getBooleanExtra("compareToCurrentJob",false);
            if(compareToCurrentJob){
                Job currentJob=Controller.getCurrentJob();
                Job latestJob=Controller.getLatestOffer();
                //populate fields
                updateJob1Fields(currentJob);
                updateJob2Fields(latestJob);
            }
        }
        catch(Exception ignored){

        }
    }


    public void compareJobs(View view){
        //get job1, job2 select the job objects
        //job1Spinner.getSelectedItemPosition();
        //job2Spinner.getSelectedItemPosition();
    }

    public void anotherComparison(View view){
        Intent intent = new Intent(this, CompareOffersActivity.class);
        startActivity(intent);
        this.finish();
    }

    public void mainMenu(View view){
        this.finish();
    }

    private void updateJob1Fields(Job job){
        job1Salary.setText(String.valueOf(job.getSalary()));
        job1Bonus.setText(String.valueOf(job.getBonus()));
        String loc = job.getLocationCity()+", "+job.getLocationState()+": "+job.getLocationCostOfLivingIndex();
        job1Location.setText(loc);
        job1Title.setText(job.getTitle());
        job1Company.setText(job.getCompany());
        job1Telework.setText(String.valueOf(job.getTeleworkDays()));
        job1Leave.setText(String.valueOf(job.getLeaveDays()));
        job1Gym.setText(String.valueOf(job.getGymAllowance()));
    }
    private void updateJob2Fields(Job job){
        job2Salary.setText(String.valueOf(job.getSalary()));
        job2Bonus.setText(String.valueOf(job.getBonus()));
        String loc = job.getLocationCity()+", "+job.getLocationState()+": "+job.getLocationCostOfLivingIndex();
        job2Location.setText(loc);
        job2Title.setText(job.getTitle());
        job2Company.setText(job.getCompany());
        job2Telework.setText(String.valueOf(job.getTeleworkDays()));
        job2Leave.setText(String.valueOf(job.getLeaveDays()));
        job2Gym.setText(String.valueOf(job.getGymAllowance()));
    }
}
