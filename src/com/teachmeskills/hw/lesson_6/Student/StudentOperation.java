package com.teachmeskills.hw.lesson_6.Student;

import java.util.Scanner;

public class StudentOperation {

    private Student[] students;

    public void createStudents(int numberOfStudents) {
        students = new Student[numberOfStudents];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter information for a student №" + (i + 1) + ":");

            System.out.print("First Name: ");
            String studentName = scanner.nextLine();

            System.out.print("Last Name: ");
            String studentLastName = scanner.nextLine();

            System.out.print("Passport Number: ");
            String passportNumber = scanner.nextLine();

            System.out.print("Group Name: ");
            String groupName = scanner.nextLine();

            System.out.print("Age: ");
            String age = scanner.nextLine();

            students[i] = new Student(studentName, studentLastName, passportNumber, groupName, age);
        }
    }
    public void showStudentInfo() {
        if (students != null) {
            for (int i = 0; i < students.length; i++) {
                Student student = students[i];
                System.out.println("Student №" + (i + 1) + ": " + student.studentName +
                        " " + student.studentLastName + " " + student.passportNumber + " " +
                        student.groupName + " " + student.age);
            }
        } else {
            System.out.println("There are no any data about students.");
        }
    }
}

