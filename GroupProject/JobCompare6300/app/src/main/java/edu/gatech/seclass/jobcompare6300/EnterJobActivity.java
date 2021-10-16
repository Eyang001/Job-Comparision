package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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

        Intent intent=this.getIntent();
        controller = (Controller) intent.getExtras().get("Controller");

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

        //fill in fields if current job is saved
        if(controller.getCurrentJob() != null){
            job=controller.getCurrentJob();
            titleField.setText(job.getTitle());
            companyField.setText(job.getCompany());
            cityField.setText(job.getLocationCity());
            stateField.setText(job.getLocationState());
            colField.setText(job.getLocationCostOfLivingIndex());
            salaryField.setText(job.getSalary());
            bonusField.setText(job.getBonus());
            teleworkField.setText(job.getTeleworkDays());
            leaveField.setText(job.getLeaveDays());
            gymField.setText(job.getGymAllowance());
        }
    }

    public void saveJob(View view){
        //get the info from the fields
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

        if(validateFields(view)) {
            controller.editCurrentJob(title, company, city, state, colIndex, salary, bonus, teleworkDays, leaveDays, gymAllowance);
            this.finish();
        }
        else{
            return;
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
        int colIndex = Integer.parseInt(colField.getText().toString());
        int salary = Integer.parseInt(salaryField.getText().toString());
        int bonus = Integer.parseInt(bonusField.getText().toString());
        int teleworkDays = Integer.parseInt(teleworkField.getText().toString());
        int leaveDays = Integer.parseInt(leaveField.getText().toString());
        int gymAllowance = Integer.parseInt(gymField.getText().toString());

        if(title.length() == 0){
            allFieldsValid=false;
            titleField.setError("Please enter a job title before saving");
        }
        if(company.length() == 0){
            allFieldsValid=false;
            companyField.setError("Please enter a company before saving");
        }
        if(city.length() == 0){
            allFieldsValid=false;
            cityField.setError("Please enter a city before saving");
        }
        if(state.length()==0){
            allFieldsValid=false;
            stateField.setError("Please enter a state before saving");
        }
        if(colIndex<=0){
            allFieldsValid=false;
            colField.setError("Please enter a positive integer before saving");
        }
        if(salary<=0){
            allFieldsValid=false;
            salaryField.setError("Please enter a positive integer before saving");
        }
        if(bonus<=0){
            allFieldsValid=false;
            bonusField.setError("Please enter a positive integer before saving");
        }
        if(teleworkDays<0 || teleworkDays>5){
            allFieldsValid=false;
            teleworkField.setError("Please enter a value in [0,5] before saving");
        }
        if(leaveDays<0 || leaveDays>365){
            allFieldsValid=false;
            leaveField.setError("Please enter a value in [0, 365] before saving");
        }
        if(gymAllowance<0 || gymAllowance>500){
            allFieldsValid=false;
            gymField.setError("Please enter a value in [0, 500] before saving");
        }
        return allFieldsValid;
    }
}
