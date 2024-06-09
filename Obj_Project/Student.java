package Obj_Project;

import java.util.ArrayList;
import java.util.List;

class Student {
    private String studentID;
    private String name;
    private List<Course> enrolledCourses;
    private final int maxCourses = 5;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollInCourse(Course course) {
        if (enrolledCourses.contains(course)) {
            System.out.println(name + " is already enrolled in " + course.getCourseName() + ".");
        } else if (enrolledCourses.size() >= maxCourses) {
            System.out.println(name + " cannot enroll in more than " + maxCourses + " courses.");
        } else {
            enrolledCourses.add(course);
            course.addStudent(this);
            System.out.println(name + " enrolled in " + course.getCourseName() + ".");
        }
    }

    public boolean isEnrolled(Course course) {
        return enrolledCourses.contains(course);
    }
}

