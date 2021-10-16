package edu.gatech.seclass.jobcompare6300.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity
public class ComparisonWeightsEntity {

    @ColumnInfo(name = "yearlySalary")
    public String yearlySalary;

    @ColumnInfo(name = "yearlyBonus")
    public String yearlyBonus;

    @ColumnInfo(name = "teleDays")
    public String teleDays;

    @ColumnInfo(name = "leave")
    public String leave;

    @ColumnInfo(name = "gym")
    public String gym;

}
