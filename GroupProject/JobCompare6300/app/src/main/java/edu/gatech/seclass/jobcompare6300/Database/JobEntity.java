package edu.gatech.seclass.jobcompare6300.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;

@Entity
public class JobEntity {
    @PrimaryKey
    public int jobID;

    @ForeignKey("locationID")
    public String locationID;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "company")
    public String company;

    @ColumnInfo(name = "salary")
    public String salary;

    @ColumnInfo(name = "bonus")
    public String bonus;

    @ColumnInfo(name = "teleworkDays")
    public String teleworkDays;

    @ColumnInfo(name = "leaveDays")
    public String leaveDays;

    @ColumnInfo(name = "gymAllowance")
    public String gymAllowance;

}