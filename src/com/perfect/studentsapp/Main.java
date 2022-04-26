package com.perfect.studentsapp;

public class Main {

    public static void main(String[] args){
        SecondYears students = new SecondYears();

        try {
            students.enterStudentValues();
            students.display();
            Student topStudent = students.sortStudents();

            System.out.println("\n--------- SORTED STUDENTS  (DESCENDING ORDER) ---------");
            students.display();

            System.out.println("\n-------------------- Best  Student --------------------");
            topStudent.displayStudent();
        }
        catch(NullPointerException e) {
            System.out.println("Some students were not processed");
        }
    }
}
