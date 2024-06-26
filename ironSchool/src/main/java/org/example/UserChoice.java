package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserChoice {
    private static Scanner scanner;
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
                return;
            }
            System.out.println("Not allowed to use numbers or profanity");
            schoolName();
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
