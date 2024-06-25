package org.example;
import java.util.UUID;

    public class Teacher {
        private String teacherId;
        private String name;
        private double salary;

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
    }



