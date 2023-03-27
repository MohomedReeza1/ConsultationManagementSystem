package com.company;
import java.io.Serial;
import java.io.Serializable;

public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String dob;
    private int mobileNo;

    public Person(String firstName, String lastName, String dob, int mobileNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.mobileNo = mobileNo;
    }

    public Person() {

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDob() {
        return dob;
    }

    public int getMobileNo() {
        return mobileNo;
    }

}
