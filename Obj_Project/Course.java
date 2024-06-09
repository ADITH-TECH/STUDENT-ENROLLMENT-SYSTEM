package Obj_Project;

import java.util.ArrayList;
import java.util.List;

abstract class Course {
    private String courseID;
    private String name;
    private List<Student> enrolledStudents;
    private int maxStudents;

    public Course(String courseID, String name, int maxStudents) {
        this.courseID = courseID;
        this.name = name;
        this.enrolledStudents = new ArrayList<>();
        this.maxStudents = maxStudents;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return name;
    }

    public void addStudent(Student student) {
        if (enrolledStudents.size() < maxStudents) {
            enrolledStudents.add(student);
            System.out.println(student.getName() + " added to the course " + name + ".");
        } else {
            System.out.println("The course " + name + " is full.");
        }
    }

    public void viewEnrolledStudents() {
        System.out.println("Enrolled students in " + name + ":");
        for (Student student : enrolledStudents) {
            System.out.println(student.getName());
        }
    }

    public abstract void getCourseDetails();
}
