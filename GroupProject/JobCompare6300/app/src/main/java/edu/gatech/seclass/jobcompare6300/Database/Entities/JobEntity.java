package edu.gatech.seclass.jobcompare6300.Database.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity (tableName = "jobs")
public class JobEntity {

    @PrimaryKey(autoGenerate = true)
    public int jobID;

//    @ForeignKey("locationID")
//    public String locationID;

    @NonNull
    @ColumnInfo(name = "title")
    public String title;

    @NonNull
    @ColumnInfo(name = "company")
    public String company;

    @ColumnInfo(name = "salary")
    public int salary;

    @ColumnInfo(name = "bonus")
    public int bonus;

    @ColumnInfo(name = "teleworkDays")
    public int teleworkDays;

    @ColumnInfo(name = "leaveDays")
    public int leaveDays;

    @ColumnInfo(name = "gymAllowance")
    public int gymAllowance;

    public JobEntity(@NonNull String title, @NonNull String company, int salary, int bonus, int teleworkDays,
                     int leaveDays, int gymAllowance) {
        this.title = title;
        this.company = company;
        this.salary = salary;
        this.bonus = bonus;
        this.teleworkDays = teleworkDays;
        this.leaveDays = leaveDays;
        this.gymAllowance = gymAllowance;

    }

}