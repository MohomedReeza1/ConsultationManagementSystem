package com.company;

import java.io.*;
import java.util.*;

interface SkinConsultationManager {
    public void addDoctor();
    public void deleteDoctor();
    public void printDoctorList();
    public void saveFile() throws ClassNotFoundException;
}

public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    public Scanner input = new Scanner(System.in);

    public void addDoctor() {
        boolean system = true;
        while (system) {
            try {
                if (Main.doctorLists.size() != 10) {

                    System.out.println("\n---------------------------------Enter Doctor Details-----------------------------------------------\n");

                    System.out.println("First Name: ");
                    String firstName = input.next();

                    System.out.println("\nSurname: ");
                    String lastName = input.next();

                    System.out.println("\nDate of Birth: (DD/MM/YYYY) ");
                    String dob = input.next();

                    System.out.println("\nMobile Number: ");
                    int mobileNo = input.nextInt();

                    System.out.println("\nMedical ID: ");
                    String medicalId = input.next();

                    for (int i=0; i< Main.doctorLists.size(); i++) {
                        if (Main.doctorLists.get(i).getMedicalId().equals(medicalId)) {
                            System.out.println("Medical ID already exists. Please enter details correctly.");
                            addDoctor();
                        }
                    }

                    System.out.println("\nDoctor's Specialization: (C, M, P, S)");
                    System.out.println("""
                            C: Cosmetic dermatology\s
                            M: Medical dermatology\s
                            P: Pediatric Dermatology\s
                            S: Surgical Dermatology
                            """);

                    char selection = input.next().toUpperCase().charAt(0);
                    String specialization = null;

                    switch (selection) {
                        case 'C' -> specialization = "Cosmetic dermatology";
                        case 'M' -> specialization = "Medical dermatology";
                        case 'P' -> specialization = "Pediatric dermatology";
                        case 'S' -> specialization = "Surgical dermatology";
                        default -> System.out.println("Please enter a valid specialization");
                    }

                    Doctor doctorDetails = new Doctor(firstName, lastName, dob, mobileNo, medicalId, specialization);
                    Main.doctorLists.add(doctorDetails);


                    System.out.println("----------------------------------------------------------------------------------------------------");
                    System.out.println("Data added successfully!");
                    System.out.println("Do you want to add another doctor? (Y/N)");
                    char choice = input.next().toUpperCase().charAt(0);

                    if (choice == 'N')
                        system=false;
                    else if (choice == 'Y')
                        continue;
                }
                else
                    System.out.println("Maximum number of doctors are already added!!");
                system = false;
                }
            catch (InputMismatchException e) {
                System.out.println("Wrong input. Please enter details again");
            }
        }
    }

    public void deleteDoctor() {
            try {
                boolean choice = true;
                while(choice) {
                    System.out.println("Enter the medical ID of the doctor you want to delete: ");
                    String medicalId = input.next();

                    for (int i = 0; i < Main.doctorLists.size(); i++) {
                        if (medicalId.equals(Main.doctorLists.get(i).getMedicalId())) {
                            System.out.println("\tName: " + Main.doctorLists.get(i).getFirstName() + " " + Main.doctorLists.get(i).getLastName());
                            System.out.println("\tDate of birth : " + Main.doctorLists.get(i).getDob());
                            System.out.println("\tMobile Number : " + Main.doctorLists.get(i).getMobileNo());
                            System.out.println("\tMedical ID: " + Main.doctorLists.get(i).getMedicalId());
                            System.out.println("\tSpecialization: " + Main.doctorLists.get(i).getSpecialization() );

                            Main.doctorLists.remove(i);
                            System.out.println("\nDoctor's data removed successfully!");
                            System.out.println("\nDoctor count: " + Main.doctorLists.size() );
                            System.out.println("----------------------------------------------------------------------------------------------------");

                            choice = false;
                            break;
                        }
                    }
                    if (choice) System.out.println("No record was found for medical ID : "  + medicalId );
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Wrong input");
            }
    }

    public void printDoctorList() {
        Main.doctorLists.sort(Comparator.comparing(Person::getLastName));
        for (int i=0; i<Main.doctorLists.size(); i++) {
            System.out.println("\nDoctor " + (i+1));
            System.out.println("\tName: " + Main.doctorLists.get(i).getFirstName() + " " + Main.doctorLists.get(i).getLastName());
            System.out.println("\tDate of birth : " + Main.doctorLists.get(i).getDob());
            System.out.println("\tMobile Number : " + Main.doctorLists.get(i).getMobileNo());
            System.out.println("\tMedical ID: " + Main.doctorLists.get(i).getMedicalId());
            System.out.println("\tSpecialization: " + Main.doctorLists.get(i).getSpecialization() );
        }
        System.out.println("\nDoctor count: " + Main.doctorLists.size());
    }

    public void saveFile()   {
        try {
            FileOutputStream fileOut = new FileOutputStream("Doctor Information.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Main.doctorLists);
            out.close();
            fileOut.close();
            System.out.println("Data saved successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void openFile() {
        try {
            FileInputStream fileIn = new FileInputStream("Doctor Information.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Main.doctorLists = (ArrayList<Doctor>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}




