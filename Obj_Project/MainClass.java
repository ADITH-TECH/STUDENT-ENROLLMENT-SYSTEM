package Obj_Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        List<Student> students = getStudents();
        List<Course> courses = getCourses();

        StudentManagementSystem sms = new StudentManagementSystem();
        sms.displayMenu(students, courses);
    }

    public static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("101", "John"));
        students.add(new Student("102", "Bob"));
        students.add(new Student("103", "Jenny"));
        students.add(new Student("104", "Harry"));
        students.add(new Student("105", "James"));
        return students;
    }

    public static List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();
        courses.add(new MathCourse("201", "Calculus 101", 30, true));
        courses.add(new ProgrammingCourse("301", "Java Programming", 30, "Java"));
        return courses;
    }
}
