package org.example;
import java.util.List;
import java.util.UUID;

public class Student {

    private String studentId;
    private String name;
    private String address;
    private String email;
    private Course course;
    private List<Course> coursesEnrolled;



    // Parameterized constructor
    public Student(String studentId, String name, String address, String email) {
        this.studentId = generateStudentId();
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public String generateStudentId() {
        return UUID.randomUUID().toString();

    }

    // Getter for studentId
    public String getStudentId() {
        return studentId;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

     //Getter and Setter for course
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    @Override
    public String toString() {
        StringBuilder details = new StringBuilder();
        details.append("Student Name: ").append(name).append("\n")
                .append("Student ID: ").append(studentId).append("\n")
                .append("Address: ").append(address).append("\n")
                .append("Email: ").append(email).append("\n");
        details.append("Enrolled Courses: ").append(coursesEnrolled.size() > 0 ? "\n" : "None\n");

        for (Course course : coursesEnrolled) {
            details.append(course.getName()).append("\n");
        }
        return details.toString();
    }


}

