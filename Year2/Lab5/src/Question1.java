import java.io.*;
import java.util.Scanner;

public class Question1 {

    public static void main(String[] args) {
        File textFile = new File("Lab 3 text file.txt");

        try {
            Scanner scanner = new Scanner(textFile);
            String words = "";

            while (scanner.hasNext()) {
                words += scanner.next() + " ";
            }
            words = words.replaceAll("[^a-zA-Z0-9 ]", ""); // Removes all special characters.
            words = words.toLowerCase();

            String[] wordsArray = words.split(" ");

            sortWords(wordsArray);

        } catch (IOException e) {
            System.out.println("An error has occurred!");
            e.printStackTrace();
        }
    }

    /**
     * This method sorts an array of Strings in alphabetical order and prints out the results.
     * @param wordsArray The array of Strings to be sorted.
     */
    private static void sortWords(String[] wordsArray) {
        for (int i = 0; i < wordsArray.length; i++) {
            for (int j = 0; j < wordsArray.length; j++) {
                if (wordsArray[i].charAt(0) < wordsArray[j].charAt(0)) {
                    swap(wordsArray, i, j);
                }
            }
        }

        for (int i = 0; i < wordsArray.length; i++) {
            System.out.println(wordsArray[i]);
        }
    }

    /**
     * This method is used to swap two indexes in an array.
     * @param wordsArray The array.
     * @param firstIndex The first index to be swapped.
     * @param secondIndex The second index to be swapped.
     */
    private static void swap(String[] wordsArray, int firstIndex, int secondIndex) {
        String temp = wordsArray[firstIndex];
        wordsArray[firstIndex] = wordsArray[secondIndex];
        wordsArray[secondIndex] = temp;
    }
}
