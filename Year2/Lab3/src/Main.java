import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

//        File myFile = new File("D:\\AIT - College Work\\Year 2\\Software Development 2\\Semester 1\\Lab 3\\Lab 3.txt");
        File myFile = new File("Lab 3.txt");

        System.out.println("===== Part 1 =====");
        System.out.println("Number of words: " + wordCounter(myFile));

        System.out.println("\n===== Part 2 =====");
        System.out.println("Number of vowels: " + vowelCounter(myFile));
        System.out.println("Average number of vowels per word: " + averageNumberOfVowels(vowelCounter(myFile), wordCounter(myFile)));

        System.out.println("\n===== Part 3 =====");
        wordJumbler(myFile);
    }

    /**
     * ===== Part 1 =====
     * This method is used to count up all the words in a file.
     * A while loop is used with the scanner to scan through the entire file. The variable String line is set to the scanner.next().
     * The variable line is then split at all spaces (" ") and placed into the words String array.
     * The wordCount variable is then updated by adding the length of the words String array.
     * If there is an error with the file, an IOException is caught and error message is displayed.
     * @param file The file that we want to find the word count of.
     * @return The number of words in the file
     */
    public static int wordCounter(File file) {
        String line;
        int wordCount = 0;

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                line = scanner.next();
                String[] words = line.split(" ");
                wordCount += words.length;
            }
        } catch (IOException e) {
            System.out.println("An error has occurred!");
        }
        return wordCount;
    }

    /**
     * ===== Part 2 =====
     * This method is used to count all the vowels in a file.
     * A while loop is used with the scanner to scan through the entire file. The variable String line is set to scanner.next().
     * The variable line is the converted to lower case to keep all the characters in the word case consistent.
     * The word is then looped though and each character is checked to see if it is a vowel, if a vowel is found, the vowelCounter
     * variable is incremented to keep track of the number of vowels.
     * If there is an error with the file, an IOException is caught and error message is displayed.
     * @param file The file that we want to find the vowel count of.
     * @return The number of vowels in the file.
     */
    public static int vowelCounter(File file) {
        int vowelCount = 0;
        String line;

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                line = scanner.next();
                line = line.toLowerCase();
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == 'a' || line.charAt(i) == 'e' || line.charAt(i) == 'i' || line.charAt(i) == 'o' || line.charAt(i) == 'u') {
//                        System.out.println("char: " + line.charAt(i));
                        vowelCount++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error has occurred!");
        }
        return vowelCount;
    }

    /**
     * This method is used to calculate the average number of vowels per word.
     * @param numberOfVowels The number of words in the file.
     * @param numberOfWords The number of vowels in the file.
     * @return The average number of vowels per word.
     */
    public static double averageNumberOfVowels(int numberOfVowels, int numberOfWords) {
        return (double)numberOfVowels / (double)numberOfWords;
    }

    /**
     * ===== Part 3 =====
     * This method is used to jumble all the words in a file.
     * A while loop is used with the scanner to scan through the entire file. The variable String line is set to the scanner.next()
     * which represents the next word in the file. All special characters are then removed from the word, if there are any.
     * The word is then checked to see if it is longer than three characters. If it is, it is converted to a character array.
     * The character array is then looped through, Each iteration a random integer id generated and the swap(char[], int, int) method is
     * called to randomly swap two characters in the array.
     * The character array is looped through again and each character is appended to the word variable. The word variable is the printed
     * to the console and then is reset for the next iteration of the while loop.
     * @param file The file that we want to jumble the words in.
     */
    public static void wordJumbler(File file) {
        String line;
        StringBuilder word = new StringBuilder();
        int outputFormatCounter = 0;

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                line = scanner.next();
                line = line.replaceAll("[^a-zA-Z0-9 ]", "");
                if (line.length() > 3) {
                    char[] characterArray = line.toCharArray();

                    for (int i = 1; i < characterArray.length - 1; i++) {
                        int randomNum = (int)((Math.random() * (characterArray.length - 2)) + 1);
                        swap(characterArray, i, randomNum);
                    }

                    for (char c : characterArray) {
                        word.append(c);
                    }
                    System.out.print(word + " ");
                    outputFormatCounter++;

                    if (outputFormatCounter % 20 == 0) {
                        System.out.print("\n");
                    }
                    word = new StringBuilder();
                }
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("An error has occurred trying to read the file.");
        }
    }

    
    public static void swap(char[] c, int index, int randomNum) {
        char temp = c[index];
        c[index] = c[randomNum];
        c[randomNum] = temp;
    }
}
