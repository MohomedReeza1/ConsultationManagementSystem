package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    static ArrayList<Doctor> doctorLists = new ArrayList<>(10);
    static ArrayList<Patient> patientLists = new ArrayList<>();
    static ArrayList<Consultation> consultations = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();
        BookDoctor bookDoctor = new BookDoctor();
        manager.openFile();
        bookDoctor.openConsultationFile();
        bookDoctor.openPatientFile();

        try {
            boolean system = true;
            while (system) {
                System.out.println(""" 
                            ----------------------------Welcome to Westminster Skin Consultation----------------------------------\n
                            Select an option from below\n
                            1: Doctor Menu
                            2: Book a doctor
                            ------------------------------------------------------------------------------------------------------
                            """);
                int choice1 = input.nextInt();

                boolean systemManager = true;

                if (choice1 == 1) {
                    while (systemManager) {
                        System.out.println("""
                               \n-----------------------------------Welcome to Doctor Menu--------------------------------------------\n
                               Select an option from below\n
                               A: Add a new doctor
                               D: Delete a doctor
                               P: Print the list of doctors
                               S: Save data to a file
                                
                               B: Go back
                               Q: Quit
                               ----------------------------------------------------------------------------------------------------
                                """);
                        String choice2 = input.next().toUpperCase();

                        switch (choice2) {
                            case "A" -> manager.addDoctor();
                            case "D" -> manager.deleteDoctor();
                            case "P" -> manager.printDoctorList();
                            case "S" -> manager.saveFile();
                            case "B" -> systemManager = false;
                            case "Q" -> exit(0);
                            default -> System.out.println("Please enter a valid input");
                        }

                    }
                } else if (choice1 == 2) {
                    WelcomeForm.main(args);
                    system = false;
                }
                else System.out.println("Please enter a valid option\n");

            }
        }
        catch (InputMismatchException e) {
            System.out.println("Wrong Input");
        }
    }
}
