package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EnterJobActivity extends AppCompatActivity {
    private Controller controller;
    private Job job;
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
        setContentView(R.layout.activity_enter_current_job);

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

        if(Controller.getCurrentJob() != null){
            job=Controller.getCurrentJob();
            titleField.setText(job.getTitle());
            companyField.setText(job.getCompany());
            cityField.setText(job.getLocationCity());
            stateField.setText(job.getLocationState());
            colField.setText(String.valueOf(job.getLocationCostOfLivingIndex()));
            salaryField.setText(String.valueOf(job.getSalary()));
            bonusField.setText(String.valueOf(job.getBonus()));
            teleworkField.setText(String.valueOf(job.getTeleworkDays()));
            leaveField.setText(String.valueOf(job.getLeaveDays()));
            gymField.setText(String.valueOf(job.getGymAllowance()));
        }
    }

    public void saveJob(View view){
        if(validateFields(view)) {
            String title = titleField.getText().toString();
            String company = companyField.getText().toString();
            String city = cityField.getText().toString();
            String state = stateField.getText().toString();
            int colIndex = Integer.parseInt(colField.getText().toString());
            int salary = Integer.parseInt(salaryField.getText().toString());
            int bonus = Integer.parseInt(bonusField.getText().toString());
            int teleworkDays = Integer.parseInt(teleworkField.getText().toString());
            int leaveDays = Integer.parseInt(leaveField.getText().toString());
            int gymAllowance = Integer.parseInt(gymField.getText().toString());
            Controller.editCurrentJob(title, company, city, state, colIndex, salary, bonus, teleworkDays, leaveDays, gymAllowance);
            Toast.makeText(getApplicationContext(),"Updating current job...", Toast.LENGTH_LONG).show();
            this.finish();
        }
    }

    public void cancel(View view){
        this.finish();
    }

    private boolean validateFields(View view){
        boolean allFieldsValid=true;
        String title = titleField.getText().toString();
        String company = companyField.getText().toString();
        String city = cityField.getText().toString();
        String state = stateField.getText().toString();
        if(title.length() == 0){
            allFieldsValid=false;
            titleField.setError("Please enter a job title before saving");
        }
        if(title.length() > 128){
            allFieldsValid=false;
            titleField.setError("Please enter a Job Title under 128 characters");
        }
        if(company.length() == 0){
            allFieldsValid=false;
            companyField.setError("Please enter a company before saving");
        }
        if(company.length() > 128){
            allFieldsValid=false;
            companyField.setError("Please enter a company name under 128 characters");
        }
        if(city.length() == 0){
            allFieldsValid=false;
            cityField.setError("Please enter a city before saving");
        }
        if(city.length() > 128){
            allFieldsValid=false;
            cityField.setError("Please enter a city name under 128 characters");
        }
        if(state.length()==0){
            allFieldsValid=false;
            stateField.setError("Please enter a state before saving");
        }
        if(state.length() > 128){
            allFieldsValid=false;
            stateField.setError("Please enter a state name under 128 characters");
        }
        try{
            int colIndex = Integer.parseInt(colField.getText().toString());
            if(colIndex<=0){
                allFieldsValid=false;
                colField.setError("Please enter a positive integer before saving");
            }
        }
        catch(NumberFormatException e){
            allFieldsValid=false;
            colField.setError("Please enter a positive integer before saving");
        }

        try{
            int salary = Integer.parseInt(salaryField.getText().toString());
            if(salary<0){
                allFieldsValid=false;
                salaryField.setError("Please enter a positive integer before saving");
            }
        }
        catch(NumberFormatException e){
            allFieldsValid=false;
            salaryField.setError("Please enter a positive integer before saving");
        }

        try{
            int bonus = Integer.parseInt(bonusField.getText().toString());
            if(bonus<0){
                allFieldsValid=false;
                bonusField.setError("Please enter a positive integer before saving");
            }
        }
        catch(NumberFormatException e){
            allFieldsValid=false;
            bonusField.setError("Please enter a positive integer before saving");
        }

        try{
            int teleworkDays = Integer.parseInt(teleworkField.getText().toString());
            if(teleworkDays<0 || teleworkDays>5){
                allFieldsValid=false;
                teleworkField.setError("Please enter a value in [0,5] before saving");
            }
        }
        catch(NumberFormatException e){
            allFieldsValid=false;
            teleworkField.setError("Please enter a value in [0,5] before saving");
        }

        try{
            int leaveDays = Integer.parseInt(leaveField.getText().toString());
            if(leaveDays<0 || leaveDays>365){
                allFieldsValid=false;
                leaveField.setError("Please enter a value in [0, 365] before saving");
            }
        }
        catch(NumberFormatException e){
            allFieldsValid=false;
            leaveField.setError("Please enter a value in [0, 365] before saving");
        }

        try{
            int gymAllowance = Integer.parseInt(gymField.getText().toString());
            if(gymAllowance<0 || gymAllowance>500){
                allFieldsValid=false;
                gymField.setError("Please enter a value in [0, 500] before saving");
            }
        }
        catch(NumberFormatException e){
            allFieldsValid=false;
            gymField.setError("Please enter a value in [0, 500] before saving");
        }

        return allFieldsValid;
    }
}
