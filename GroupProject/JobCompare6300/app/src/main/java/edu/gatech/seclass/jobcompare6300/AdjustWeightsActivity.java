package edu.gatech.seclass.jobcompare6300;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdjustWeightsActivity extends AppCompatActivity {
    private Controller controller;
    private Button saveButton;
    private Button cancelButton;
    private EditText salaryField;
    private EditText bonusField;
    private EditText teleworkField;
    private EditText leaveField;
    private EditText gymField;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adjust_comparison_weights);

        saveButton = (Button) findViewById(R.id.saveButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);

        salaryField = (EditText) findViewById(R.id.salaryField);
        bonusField = (EditText) findViewById(R.id.bonusField);
        teleworkField = (EditText) findViewById(R.id.teleworkField);
        leaveField = (EditText) findViewById(R.id.leaveField);
        gymField = (EditText) findViewById(R.id.gymField);
    }

    public void save(View view){
        int salaryWeight = Integer.parseInt(salaryField.getText().toString());
        int bonusWeight = Integer.parseInt(bonusField.getText().toString());
        int teleWeight = Integer.parseInt(teleworkField.getText().toString());
        int leaveWeight = Integer.parseInt(leaveField.getText().toString());
        int gymWeight = Integer.parseInt(gymField.getText().toString());
        controller.adjustWeights(salaryWeight, bonusWeight, teleWeight, leaveWeight, gymWeight);
        Toast.makeText(this.getApplicationContext(), "Saving new weights", Toast.LENGTH_LONG).show();
        this.finish();
    }

    public void cancel(View view){
        this.finish();
    }
}
