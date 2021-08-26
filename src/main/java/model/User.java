package model;

import java.util.List;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String nationalEmergencyNumber;
    private String careProviderNumber;
    private String nextOfKinNumber;
    private String password;

    public String getNationalEmergencyNumber() {
        return nationalEmergencyNumber;
    }

    public void setNationalEmergencyNumber(String nationalEmergencyNumber) {
        this.nationalEmergencyNumber = nationalEmergencyNumber;
    }

    public String getCareProviderNumber() {
        return careProviderNumber;
    }

    public void setCareProviderNumber(String careProviderNumber) {
        this.careProviderNumber = careProviderNumber;
    }

    public String getNextOfKinNumber() {
        return nextOfKinNumber;
    }

    public void setNextOfKinNumber(String nextOfKinNumber) {
        this.nextOfKinNumber = nextOfKinNumber;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User: " + firstName + " " + lastName;
    }
}
