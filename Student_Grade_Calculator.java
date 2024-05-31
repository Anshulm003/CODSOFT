// TASK 2 (STUDENT GRADE CALCULATOR)

import java.util.Scanner;

public class Student_Grade_Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] marks = new int[5];
        int totalMarks = 0;

        // Taking Marks from the User (out of 100) in 5 Subjects
        System.out.println("Enter Marks of your all subject out of 100 : ");
        for (int i = 0; i < 5; i++){
            System.out.println("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
            totalMarks += marks[i];
        }

        // Determine Average Percentage
        double avg = (double) totalMarks / 6;

        // Determine Grade
        char grade;
        if (avg >= 90){
            grade = 'A';
        } else if (avg >= 80) {
            grade = 'B';
        } else if (avg >= 70) {
            grade = 'C';
        } else if (avg >= 60) {
            grade = 'D';
        } else if (avg >= 50) {
            grade = 'E';
        }else {
            grade = 'F';
        }

        // RESULT of Student Grade Calculator
        System.out.println("Total Marks : " + totalMarks);
        System.out.println("Average Percentage : " + avg + " %");
        System.out.println("Grade : "+ grade);
    }
}
