package edu.gatech.seclass.jobcompare6300.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity
public class ComparisonWeightsEntity {

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
