package model;

import java.sql.Time;
import java.sql.Timestamp;

public class ResultData {
    private int id;
    private Timestamp testDate;
    private String firstName;
    private double value;
    private int amountOfPills;
    private String sideEffects;
    private Timestamp nextTestDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTestDate() {
        return testDate;
    }

    public void setTestDate(Timestamp testDate) {
        this.testDate = testDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getAmountOfPills() {
        return amountOfPills;
    }

    public void setAmountOfPills(int amountOfPills) {
        this.amountOfPills = amountOfPills;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public Timestamp getNextTestDate() {
        return nextTestDate;
    }

    public void setNextTestDate(Timestamp nextTestDate) {
        this.nextTestDate = nextTestDate;
    }

    @Override
    public String toString() {
        String result = "Result Data: ResutlId:  " + id + ", " +
                "TestDate: " + testDate.toString() + ", " +
                "Name: " + firstName + ", " +
                "Value: " + value + ", " +
                "AmountOfPills: " + amountOfPills + ", " +
                "SideEffects: " + sideEffects + ", " +
                "NextTestDate: " + nextTestDate.toString();

        return result;

    }
}
