package Sample_Day5_Programs;

import java.util.Scanner;
import java.util.ArrayList;

abstract class AttendanceSystem {
    ArrayList<String> presentStudents = new ArrayList<>();

    abstract void markAttendance(String name);

    public void showAttendance() {
        System.out.println("Students Present Today:");
        for (String student : presentStudents) {
            System.out.println("- " + student);
        }
    }
}

class StudentAttendance extends AttendanceSystem {

    @Override
    void markAttendance(String name) {
        presentStudents.add(name);
        System.out.println(name + " marked as present.");
    }
}

public class Attendence_Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentAttendance attendance = new StudentAttendance();

        System.out.print("Enter number of students to mark: ");
        int n = scanner.nextInt();
        scanner.nextLine();  

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            attendance.markAttendance(name);
        }

        attendance.showAttendance();
        System.out.println("\nRemaining students are marked as not present.");
    }
}

