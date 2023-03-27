package com.company;

public class Doctor extends Person {
    private String medicalId;
    private String specialization;

    public  Doctor (){
        super();
    }

    public Doctor(String firstName, String lastName, String dob, int mobileNo, String medicalId, String specialization) {
        super(firstName, lastName, dob, mobileNo);
        this.medicalId = medicalId;
        this.specialization = specialization;
    }

    public String getMedicalId() {
        return medicalId;
    }

    public String getSpecialization() {
        return specialization;
    }

}
