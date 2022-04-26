package com.perfect.studentsapp;

public class Student {
    private int number;
    private String firstName;
    private String lastName;
    private String[] subjectCodes = new String[5];
    private double[] finalMarks = new double[5];
    private double overallAverage;

    public Student() {
        this.number = 0;
        this.firstName = "";
        this.lastName = "";
        this.overallAverage = 0.0d;
    }

    public void setStudent(int number, String firstName, String lastName, String[] subjectCodes, double[] finalMarks)
    {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjectCodes = subjectCodes;
        this.finalMarks = finalMarks;
    }

    public double determineOverallAverage() {
        int numberOfSubjects = this.subjectCodes.length;
        double totalMarks = 0.0d;

        for (double mark : this.finalMarks) {
            totalMarks += mark;
        }
        this.overallAverage = totalMarks / numberOfSubjects;
        return this.overallAverage;
    }

    public void displayStudent() {
        System.out.printf("%14d%15s%14s%12s%n",
                this.number, this.firstName, this.lastName, determineOverallAverage());
    }
}