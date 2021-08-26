package model;

import java.sql.Timestamp;

public class Result {
    private int id;
    private Timestamp dateOfTest;
    private double value;

    // Foreign key
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDateOfTest() {
        return dateOfTest;
    }

    public void setDateOfTest(Timestamp dateOfTest) {
        this.dateOfTest = dateOfTest;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
