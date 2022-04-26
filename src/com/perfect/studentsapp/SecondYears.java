package com.perfect.studentsapp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SecondYears {
    private final Student[] myStudents = new Student[3];

    public void enterStudentValues() {
        Scanner input = new Scanner(System.in);
        int studentCount = 1;
        int index = 0;
        for (Student student : myStudents) {
            student = new Student();

            System.out.println("---------------------- Student "+ studentCount +" ----------------------");
            final int NUMBER_OF_SUBJECTS = 5;
            int studentNumber;
            String firstName;
            String lastName;
            String[] subjectCodes = new String[NUMBER_OF_SUBJECTS];
            double[] finalMarks = new double[NUMBER_OF_SUBJECTS];

            try {
                System.out.print("Enter the student number: ");
                studentNumber = input.nextInt();
                System.out.print("Enter the student first name: ");
                firstName = input.next();
                System.out.print("Enter the student last name: ");
                lastName = input.next();
            }
            catch (InputMismatchException e) {
                System.out.println("\nInvalid Input. Please Restart the application");
                break;
            }


            // Recording the subject codes for the student
            System.out.println("-----Subjects for " + firstName + " " + lastName + "-----");
            for (int j = 0; j < NUMBER_OF_SUBJECTS; j++) {
                System.out.print("Enter subject code: ");
                String code = input.next();
                subjectCodes[j] = code;
            }

            // Recording the final marks for each of the subjects
            System.out.println("-----Final Marks for " + firstName + " " + lastName+"-----");
            try {
                for (int i = 0; i < NUMBER_OF_SUBJECTS; i++) {
                    System.out.print("Enter final mark for " + subjectCodes[i] + ": ");
                    double marks = input.nextDouble();
                    finalMarks[i] = marks;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("\nInput Error. Marks can only be numbers.");
                break;
            }

            student.setStudent(studentNumber, firstName, lastName, subjectCodes, finalMarks);

            student.determineOverallAverage();

            myStudents[index] = student; //adding the student to the students array
            index++; // Incrementing the index to process next student object

            studentCount++;
            System.out.println("-------------------------------------------------------");
        }
        input.close();
    }

    /**
     * This method sorts an array of Student objects based on their averages
     * @return Student with the highest average
     */
    public Student sortStudents() {
        Student tempStudent; //
        for (int i = 0; i < myStudents.length - 1; i++) {
            for (int j =0; j < myStudents.length - 1 - i; j++) {
                if (myStudents[j].determineOverallAverage() < myStudents[j + 1].determineOverallAverage()) {
                    tempStudent  = myStudents[j];
                    myStudents[j] = myStudents[j + 1];
                    myStudents[j + 1] = tempStudent;
                }
            }
        }
        return myStudents[0];
    }

    public void display() {
        System.out.println("-------------------------------------------------------");
        System.out.println("                  SECOND YEAR STUDENTS");
        System.out.println("Student Number     First Name     Last Name     Average");
        System.out.println("-------------------------------------------------------");
        try {
            for (Student student : this.myStudents) {
                student.displayStudent();
            }
        }
        catch (NullPointerException e) {
            System.out.println("Ensure all students are processed [Null Error]");
        }
    }
}
