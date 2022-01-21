package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String input = scanner.next();

        printResults(input);

    }

    /**
     * This method prints out all the details of the word that the user inputted.
     * The details included are: length, number of vowels, first letter and last letter.
     * @param input The word that the user has inputted.
     */
    public static void printResults(String input) {
        System.out.println("\nYou Entered: " + input);
        System.out.println("-----------------------------------");
        System.out.println("Length: " + input.length());
        System.out.println("Vowels: " + numberOfVowels(input));
        System.out.println("First Letter: " + input.charAt(0));
        System.out.println("Last Letter: " + input.charAt(input.length() - 1));
    }

    /**
     * This method is used to find count the number of vowels in a String.
     * The String passed in is converted to lowercase and looped through to check whether any vowels are found.
     * If a vowel is found, the counter is incremented to keep track of the number of vowels.
     * @param input The word the user has inputted;
     * @return The number of vowels in the String.
     */
    public static int numberOfVowels(String input) {
        int vowels = 0;
        input = input.toLowerCase();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' || input.charAt(i) == 'o' || input.charAt(i) == 'u') {
                vowels++;
            }
        }
        return vowels;
    }
}
