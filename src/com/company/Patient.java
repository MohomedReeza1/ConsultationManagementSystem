package com.company;

public class Patient extends Person {
    private String patientId;

    public Patient(String firstName, String lastName, String dob, int mobileNo, String patientId) {
        super(firstName, lastName, dob, mobileNo);
        this.patientId = patientId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}
