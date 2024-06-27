package org.example;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserChoice {
    private static Scanner scanner = new Scanner(System.in);
    public static double totalCourseCost = 0.0;
    public static double totalTeacherSalary = 0.0;
    public static double totalProfit = 0.0;
    public static double totalStudentEnrollment = 0.0;
    private static List<Course> courses = new ArrayList<>();
    private static List<Teacher> teachers = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        welcome();
    }
    public static void welcome(){
        System.out.println("Welcome to Advance Learning \n");
        System.out.println("Choose a name for this school: ");
        schoolName();
    }

    public static void schoolName(){
        while(true) {
            String school = scanner.nextLine();
            if(!containsProfanity(school) && !containsNumbers(school)) {
                teacherQuantity();
                return;
            }
            System.out.println("Not allowed to use numbers or profanity");
        }
    }

    public static void teacherQuantity(){
        System.out.println("How many teachers should work in this school?");
        int teacherQuantity;
        while(true){
            try{
                teacherQuantity = scanner.nextInt();
                scanner.nextLine();
                if(teacherQuantity > 0){
                    break;
                }
                System.out.println("Enter a number above ZERO");
            } catch (InputMismatchException e){
                System.out.println("Uh oh! please enter a number. ");
                scanner.next();
            }
        }
        collectTeacherNames(teacherQuantity);
        courseQuantity();
    }

    private static String getFilteredName(String type, int i) {
        while (true) {
            System.out.println("What should this " + type + " be called?");
            String name = scanner.nextLine();
            if (!containsProfanity(name) && !containsNumbers(name)) {
                return name;
            }
            System.out.println("Uh oh, that is not allowed. Try again");
        }
    }

    private static void collectTeacherNames(int teacherQuantity) {
        for (int i = 0; i < teacherQuantity; i++) {
            String name = getFilteredName("teacher", i);
            Teacher teacher = new Teacher(name, 700);
            totalTeacherSalary += teacher.getSalary();
        }

        System.out.println("Teacher names:");
        for (Teacher teacher : teachers) {
            System.out.println(teacher.getName());
        }
    }

    private static void courseQuantity() {
        System.out.println("How many courses should this school have?");
        int courseQuantity;

        while (true) {
            try {
                courseQuantity = scanner.nextInt();
                scanner.nextLine();
                if (courseQuantity > 0) {
                    break;
                }
                System.out.println("Enter a number above ZERO");
            } catch (InputMismatchException e) {
                System.out.println("Uh oh, please enter a number. Try again");
                scanner.next();  // Clear invalid input
            }
        }
        collectCourseNames(courseQuantity);
    }


    private static void collectCourseNames(int courseQuantity) {
        for (int i = 0; i < courseQuantity; i++){
            String name = getFilteredName("Course", i);
            Course course = new Course(name, 1000);
            courses.add(course);
            totalCourseCost += course.getPrice();
        }
        System.out.println("Course names and prices: ");
        for(Course course : courses) {
            System.out.println(course.getName() + " : $" + course.getPrice());
        }
        System.out.println("Total course cost: $" + totalCourseCost);
        studentQuantity();
    }

    public static void studentQuantity(){
        System.out.println("How many students will attend this school?");
        int studentQuantity;
        while(true){
            try{
                studentQuantity = scanner.nextInt();
                scanner.nextLine();
                if(studentQuantity > 0){
                    break;
                }
                System.out.println("Enter a number above ZERO");
            } catch (InputMismatchException e){
                System.out.println("Uh oh! please enter a number. ");
                scanner.next();
            }
        }
        collectStudentNames(studentQuantity);
        commandMenu();
    }


    private static void collectStudentNames(int studentQuantity) {
        for (int i = 0; i < studentQuantity; i++) {
            String name = getFilteredName("student", i);
            System.out.println("Enter the address for student " + name + ": ");
            String address = scanner.nextLine();
            System.out.println("Enter the email for student " + name + ": ");
            String email = scanner.nextLine();

            Student student = new Student(name, address, email);
            students.add(student);
            totalStudentEnrollment += 3000;
        }

        System.out.println("Student names:");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }

    public static void commandMenu() {
        while (true) {
            System.out.println("\n");
            System.out.println("Please select from the following options:");
            System.out.println("1. ENROLL");
            System.out.println("2. ASSIGN");
            System.out.println("3. SHOW COURSES");
            System.out.println("4. LOOKUP COURSE");
            System.out.println("5. SHOW STUDENTS");
            System.out.println("6. LOOKUP STUDENT");
            System.out.println("7. SHOW TEACHERS");
            System.out.println("8. LOOKUP TEACHER");
            System.out.println("9. SHOW PROFIT");
            System.out.println("0. EXIT");
            System.out.println("SELECT THE NUMBER:");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();  // Clear the buffer

                switch (choice) {
                    case 1:
                        // Enroll logic here
                        break;
                    case 2:
                        // Assign logic here
                        break;
                    case 3:
                        showCourses();
                        break;
                    case 4:
                        lookupCourse();
                        break;
                    case 5:
                        showStudentNames();
                        break;
                    case 6:
                        lookupStudent();
                        break;
                    case 7:
                        showTeacherNames();
                        break;
                    case 8:
                        // Lookup teacher logic here
                        break;
                    case 9:
                        showProfit();
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Uh oh, please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    public static void showCourses(){
        System.out.println("Courses: ");
        for(Course course : courses){
            System.out.println(course.getName());
        }
    }

    public static void showTeacherNames(){
        System.out.println("Teachers: ");
        for(Teacher teacher : teachers){
            System.out.println(teacher.getName());
        }
    }

    public static void showStudentNames(){
        System.out.println("Students: ");
        for(Student student : students){
            System.out.println(student.getName());
        }
    }

    public static void lookupStudent() {
        System.out.println("Enter the student ID to lookup:");
        try {
            String studentId = scanner.nextLine();
            scanner.nextLine();  // Clear the buffer

            Student student = findStudentById(studentId);

            if (student != null) {
                System.out.println(student); // Print full details using Student's toString() method
            } else {
                System.out.println("Student with ID " + studentId + " not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid student ID.");
            scanner.next();  // Clear invalid input
        }
    }

    private static Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;  // Return null if student not found
    }

    public static void lookupCourse() {
        System.out.println("Enter the course ID to lookup:");
        try {
            String courseId = scanner.nextLine();
            scanner.nextLine();

            Course course = findCourseById(courseId);

            if (course != null) {
                System.out.println(course);
            } else {
                System.out.println("Course with ID " + courseId + " not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid course ID.");
            scanner.next();
        }
    }

    private static Course findCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }



    public static void showProfit(){
        totalProfit = totalStudentEnrollment - (totalCourseCost - totalTeacherSalary);
        System.out.println(totalProfit);
    }


    public static Boolean containsProfanity(String input){
        List<String> profanities = Arrays.asList("fuck", "bitch", "asshole", "cunt");
        for (String profanity : profanities) {
            if (input.toLowerCase().contains(profanity)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean containsNumbers(String input){
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
