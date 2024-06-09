package Obj_Project;

import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {
    public void displayMenu(List<Student> students, List<Course> courses) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Enroll Students for the Course");
            System.out.println("2. View the Enrollments details of the Students");
            System.out.println("3. Explore Course details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    enrollStudentInCourse(scanner, students, courses);
                    break;
                case 2:
                    viewStudentEnrollmentDetails(scanner, students);
                    break;
                case 3:
                    viewEnrolledStudentsInCourse(scanner, courses);
                    break;
                case 4:
                    System.out.println("Exiting the system.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void enrollStudentInCourse(Scanner scanner, List<Student> students, List<Course> courses) {
        System.out.println("Available Students:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getName());
        }
        System.out.print("Enter student number: ");
        int studentNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (studentNumber < 1 || studentNumber > students.size()) {
            System.out.println("Invalid student number.");
            return;
        }

        Student selectedStudent = students.get(studentNumber - 1);

        System.out.println("Available Courses:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).getCourseName());
        }
        System.out.print("Enter course number: ");
        int courseNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (courseNumber < 1 || courseNumber > courses.size()) {
            System.out.println("Invalid course number.");
            return;
        }

        Course selectedCourse = courses.get(courseNumber - 1);
        selectedStudent.enrollInCourse(selectedCourse);
    }

    private void viewStudentEnrollmentDetails(Scanner scanner, List<Student> students) {
        System.out.println("Available Students:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getName());
        }
        System.out.print("Enter student number: ");
        int studentNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (studentNumber < 1 || studentNumber > students.size()) {
            System.out.println("Invalid student number.");
            return;
        }

        Student selectedStudent = students.get(studentNumber - 1);
        List<Course> enrolledCourses = selectedStudent.getEnrolledCourses();

        if (enrolledCourses.isEmpty()) {
            System.out.println(selectedStudent.getName() + " is not enrolled in any courses.");
        } else {
            System.out.println("Enrollment Details for " + selectedStudent.getName() + ":");
            for (Course course : enrolledCourses) {
                course.getCourseDetails();
            }
        }
    }

    private void viewEnrolledStudentsInCourse(Scanner scanner, List<Course> courses) {
        System.out.println("Available Courses:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).getCourseName());
        }
        System.out.print("Enter course number: ");
        int courseNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (courseNumber < 1 || courseNumber > courses.size()) {
            System.out.println("Invalid course number.");
            return;
        }

        Course selectedCourse = courses.get(courseNumber - 1);
        selectedCourse.viewEnrolledStudents();
    }
}
