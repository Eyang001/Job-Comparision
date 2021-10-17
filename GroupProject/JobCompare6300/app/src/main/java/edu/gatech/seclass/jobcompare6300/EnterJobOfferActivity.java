package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
            Toast.makeText(getApplicationContext(),"Updating current job...", Toast.LENGTH_LONG).show();
            controller.editCurrentJob(title, company, city, state, colIndex, salary, bonus, teleworkDays, leaveDays, gymAllowance);
        }
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

    public boolean validateFields(View view){
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
