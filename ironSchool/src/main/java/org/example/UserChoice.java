package org.example;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserChoice {
    private static Scanner scanner = new Scanner(System.in);
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
            schoolName();
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
        String[] teacherNames = new String[teacherQuantity];

        for (int i = 0; i < teacherQuantity; ++i) {
            teacherNames[i] = getFilteredName("teacher", i);
        }

        System.out.println("Teacher names:");
        for (String name : teacherNames) {
            System.out.println(name);
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
        String[] courseNames = new String[courseQuantity];

        for (int i = 0; i < courseQuantity; ++i) {
            courseNames[i] = getFilteredName("course", i);
        }

        System.out.println("Course names:");
        for (String name : courseNames) {
            System.out.println(name);
        }
    }

    public static void commandMenu() {
        while (true) {
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
                        // Show courses logic here
                        break;
                    case 4:
                        // Lookup course logic here
                        break;
                    case 5:
                        // Show students logic here
                        break;
                    case 6:
                        // Lookup student logic here
                        break;
                    case 7:
                        // Show teachers logic here
                        break;
                    case 8:
                        // Lookup teacher logic here
                        break;
                    case 9:
                        // Show profit logic here
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
