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



    public static Boolean containsProfanity(String input){
        List<String> profanities = Arrays.asList("fuck", "bitch", "asshole", "cunt", "whore");
        Iterator var2 = profanities.iterator();

        String profanity;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            profanity = (String)var2.next();
        } while(!input.toLowerCase().contains(profanity));

        return true;
    }

    public static Boolean containsNumbers(String input){
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
