package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;
import java.util.Scanner;

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
        String school = scanner.nextLine();
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

}
