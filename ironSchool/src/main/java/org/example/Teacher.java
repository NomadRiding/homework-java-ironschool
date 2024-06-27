package org.example;
import java.util.List;
import java.util.UUID;

    public class Teacher {
        private String teacherId;
        private String name;
        private double salary;
        private List<Course> coursesEnrolled;

        public Teacher(String name, double salary) {
            this.teacherId = generateId();
            this.name = name;
            this.salary = salary;
        }

        private String generateId() {
            return UUID.randomUUID().toString();
        }

        public String getTeacherId() {
            return teacherId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            StringBuilder details = new StringBuilder();
            details.append("teacher Name: ").append(name).append("\n")
                    .append("teacher ID: ").append(teacherId).append("\n")
                    .append("Salary: ").append(salary).append("\n");
            details.append("Enrolled Courses: ").append(coursesEnrolled.size() > 0 ? "\n" : "None\n");

            for (Course course : coursesEnrolled) {
                details.append(course.getName()).append("\n");
            }
            return details.toString();
        }
    }



