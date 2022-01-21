import java.io.*;
import java.util.Scanner;

public class Question3 {

    public static void main(String[] args) {
        File fileDirectory = new File("Files");
        File[] fileArray = fileDirectory.listFiles();

        if (fileArray.length != 0) {
            for (int i = 0; i < fileArray.length; i++) {
                int randomNum = (int)(Math.random() * (fileArray.length) - 1);
                swap(fileArray, i, randomNum);
            }
            printFileStatistics(fileArray);
        } else {
            System.out.println("Error! The files have not yet been created.");
        }
    }

    /**
     * This method is used to swap the contents of one file with the contents of another file.
     * @param fileArray The array of files.
     * @param index The index of the first file to be swapped in the file array.
     * @param randomNum The index of the second file to be swapped in the file array.
     */
    public static void swap(File[] fileArray, int index, int randomNum) {
        try {
            String file1 = "";
            String file2 = "";

            Scanner scanner = new Scanner(fileArray[index]);
            while (scanner.hasNextLine()) {
                file1 += scanner.nextLine();
            }

            scanner = new Scanner(fileArray[randomNum]);
            while (scanner.hasNextLine()) {
                file2 += scanner.nextLine();
            }

            FileWriter writer = new FileWriter(fileArray[index]);
            writer.write(file2);
            writer.close();

            writer = new FileWriter(fileArray[randomNum]);
            writer.write(file1);
            writer.close();

            System.out.println("Successfully swapped files " + index + " & " + randomNum);

        } catch (IOException e) {
            System.out.println("An error has occurred!");
            e.printStackTrace();
        }
    }

    /**
     * This method is used to print out all the statistics of all the files of the inputted array of files.
     * @param fileArray The array of files.
     */
    public static void printFileStatistics(File[] fileArray) {
        System.out.println("\nFile Statistics:");
        if (fileArray.length != 0) {
            for (File file : fileArray) {
                System.out.println("\n===== " + file.getName() + " =====");
                System.out.println("Word Count: " + wordCounter(file));
                System.out.println("Vowel Count: " + vowelCounter(file));
                System.out.println("Average Number of Vowels: " + averageNumberOfVowels(vowelCounter(file), wordCounter(file)));
            }
            System.out.println("\n");
        } else {
            System.out.println("Error! The files have not yet been created.");

        }
    }

    /**
     * This method is used to count all the words in an inputted file.
     * @param file The file to find the word count of.
     * @return The number of words in the file.
     */
    private static int wordCounter(File file) {
        int counter = 0;
        String line;

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                line = scanner.next();
                String[] words = line.split(" ");
                counter += words.length;
            }
        } catch (IOException e) {
            System.out.println("An error has occurred!");
            e.printStackTrace();
        }
        return counter;
    }

    /**
     * This method is used to count all the vowels in an inputted file.
     * @param file The file to find the vowel count of.
     * @return The number of vowels in the file.
     */
    private static int vowelCounter(File file) {
        int counter = 0;
        String line;

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                line = scanner.next();
                line = line.toLowerCase();
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == 'a' || line.charAt(i) == 'e' || line.charAt(i) == 'i' || line.charAt(i) == 'o' || line.charAt(i) == 'u') {
                        counter++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error has occurred!");
            e.printStackTrace();
        }
        return counter;
    }

    /**
     * This method is used to calculate the average number of vowels per word.
     * @param numberOfVowels The number of vowels in the file.
     * @param numberOfWords The number of words in the file.
     * @return The average number of vowels per word.
     */
    private static double averageNumberOfVowels(int numberOfVowels, int numberOfWords) {
        return (double)numberOfVowels / numberOfWords;
    }
}
