package model;

import java.sql.Timestamp;

public class Management {
    private int id;
    private int amountOfPills;
    private Timestamp dateOfNextTest;

    // Foreign keys
    private int resultId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmountOfPills() {
        return amountOfPills;
    }

    public void setAmountOfPills(int amountOfPills) {
        this.amountOfPills = amountOfPills;
    }

    public Timestamp getDateOfNextTest() {
        return dateOfNextTest;
    }

    public void setDateOfNextTest(Timestamp dateOfNextTest) {
        this.dateOfNextTest = dateOfNextTest;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }
}
