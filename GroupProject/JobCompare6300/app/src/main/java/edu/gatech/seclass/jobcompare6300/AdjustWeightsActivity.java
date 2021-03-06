package edu.gatech.seclass.jobcompare6300;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdjustWeightsActivity extends AppCompatActivity {
    private EditText salaryField;
    private EditText bonusField;
    private EditText teleworkField;
    private EditText leaveField;
    private EditText gymField;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adjust_comparison_weights);

        salaryField = (EditText) findViewById(R.id.salaryField);
        bonusField = (EditText) findViewById(R.id.bonusField);
        teleworkField = (EditText) findViewById(R.id.teleworkField);
        leaveField = (EditText) findViewById(R.id.leaveField);
        gymField = (EditText) findViewById(R.id.gymField);

        ComparisonWeights weights = Controller.getWeights();

        salaryField.setText(String.valueOf(weights.getYearlySalary()));
        bonusField.setText(String.valueOf(weights.getYearlyBonus()));
        teleworkField.setText(String.valueOf(weights.getTeleDays()));
        leaveField.setText(String.valueOf(weights.getLeaveDays()));
        gymField.setText(String.valueOf(weights.getGymAllowance()));
    }

    public void save(View view){
        if(validateFields(view)){
            int salaryWeight = Integer.parseInt(salaryField.getText().toString());
            int bonusWeight = Integer.parseInt(bonusField.getText().toString());
            int teleWeight = Integer.parseInt(teleworkField.getText().toString());
            int leaveWeight = Integer.parseInt(leaveField.getText().toString());
            int gymWeight = Integer.parseInt(gymField.getText().toString());
            Controller.adjustWeights(salaryWeight, bonusWeight, teleWeight, leaveWeight, gymWeight);
            Toast.makeText(this.getApplicationContext(), "Saving new weights", Toast.LENGTH_LONG).show();
            this.finish();
        }
    }

    public void cancel(View view){
        this.finish();
    }

    private boolean validateFields(View view){
        boolean isValid=true;
        try{
            int salaryWeight = Integer.parseInt(salaryField.getText().toString());
            if(salaryWeight<0){
                salaryField.setError("Please enter a positive integer");
                isValid=false;
            }
        }
        catch(NumberFormatException e){
            salaryField.setError("Please enter a positive integer");
            isValid=false;
        }

        try{
            int bonusWeight = Integer.parseInt(bonusField.getText().toString());
            if(bonusWeight<0){
                bonusField.setError("Please enter a positive integer");
                isValid=false;
            }
        }
        catch(NumberFormatException e){
            bonusField.setError("Please enter a positive integer");
            isValid=false;
        }

        try{
            int teleWeight = Integer.parseInt(teleworkField.getText().toString());
            if(teleWeight<0){
                teleworkField.setError("Please enter a positive integer");
                isValid=false;
            }
        }
        catch(NumberFormatException e){
            teleworkField.setError("Please enter a positive integer");
            isValid=false;
        }

        try{
            int leaveWeight = Integer.parseInt(leaveField.getText().toString());
            if(leaveWeight<0){
                leaveField.setError("Please enter a positive integer");
                isValid=false;
            }
        }
        catch(NumberFormatException e){
            leaveField.setError("Please enter a positive integer");
            isValid=false;
        }

        try{
            int gymWeight = Integer.parseInt(gymField.getText().toString());
            if(gymWeight<0){
                gymField.setError("Please enter a positive integer");
                isValid=false;
            }
        }
        catch(NumberFormatException e){
            gymField.setError("Please enter a positive integer");
            isValid=false;
        }

        return isValid;
    }
}
