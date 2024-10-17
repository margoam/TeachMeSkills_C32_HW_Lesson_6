package com.teachmeskills.hw.lesson_6.Student;

import java.util.Scanner;

/**
 * Задача 1
 * Создать класс для описания студента нашей группы.
 * Поля класса: имя, фамилия, номер паспорта, название группы (можно добавить свои поля по желанию - например, возраст).
 * Создать объекты этого класса для каждого из студента нашей группы.
 * Поместить все эти объекты в массив.
 * Пройти по массиву циклом for и вывести информацию на консоль.
 */

public class StudentMain {

    public static void Main(String[] args) {

        StudentOperation studentOperation = new StudentOperation();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();

        studentOperation.createStudents(numberOfStudents);
        studentOperation.showStudentInfo();
    }
}
