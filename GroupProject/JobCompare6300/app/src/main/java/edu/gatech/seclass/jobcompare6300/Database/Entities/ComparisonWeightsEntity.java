package edu.gatech.seclass.jobcompare6300.Database.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "comparisonWeights")
public class ComparisonWeightsEntity {

    @PrimaryKey(autoGenerate = true)
    public int weightID;

    @ColumnInfo(name = "yearlySalary")
    public int yearlySalary;

    @ColumnInfo(name = "yearlyBonus")
    public int yearlyBonus;

    @ColumnInfo(name = "teleDays")
    public int teleDays;

    @ColumnInfo(name = "leave")
    public int leave;

    @ColumnInfo(name = "gym")
    public int gym;

    public ComparisonWeightsEntity(int yearlySalary,int yearlyBonus, int teleDays, int  leave, int gym){
        this.yearlySalary = yearlySalary;
        this.yearlyBonus = yearlyBonus;
        this.teleDays = teleDays;
        this.leave = leave;
        this.gym = gym;
    }

}
