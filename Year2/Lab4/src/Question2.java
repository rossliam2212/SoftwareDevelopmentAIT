import java.io.*;
import java.util.Scanner;

public class Question2 {

    public static void main(String[] args) {
        int numberOfFiles = 5;
        File myFile = new File("Lab 3 text file.txt");

        try {
            Scanner scanner = new Scanner(myFile);
            String words = "";

            while (scanner.hasNextLine()) {
                words += scanner.nextLine();
            }

            processWords(words, numberOfFiles);

        } catch (IOException e) {
            System.out.println("An error has occurred!");
            e.printStackTrace();
        }
    }

    /**
     * This method takes in all of the words from a file as a String and puts a fraction of those words into new files.
     * The fraction of words that are to be put into new files depends on the number of files that are to be created.
     * @param input All of the words in the file.
     * @param numberOfFiles The number of files to be created.
     */
    public static void processWords(String input, int numberOfFiles) {
        String[] words = input.split(" "); // Converts all the words in the input String into an array.
        File[] files = new File[numberOfFiles]; // Holds all the files.
        String[] fileContent = new String[numberOfFiles]; // Holds the content to be placed into each file.

        /*
        Creating all the new files.
        All the file names are checked to see if they already exist. If they do, they are not created again.
         */
        try {
            for (int i = 0; i < files.length; i++) {
                files[i] = new File("Files\\file" + i + ".txt");
                if (files[i].createNewFile()) {
                    System.out.println("File created: " + files[i].getName());
                } else {
                    System.out.println(files[i].getName() + " already exists!");
                    if (i == files.length - 1) {
                        return;
                    }
                }
                fileContent[i] = "";
            }
        } catch (IOException e) {
            System.out.println("An error occurred!");
            e.printStackTrace();
        }

        for (int i = 0; i < words.length; i++) {
            int mod = i % numberOfFiles;
            fileContent[mod] += " " + words[i];
        }

        /*
        Writes all of the content from the fileContent array to each file in the files array.
         */
        try {
            for (int i = 0; i < files.length; i++) {
                FileWriter writer = new FileWriter(files[i]);
                writer.write(fileContent[i]);
                writer.close();
            }
            System.out.println("\nSuccessfully wrote to all " + files.length + " files!");
        } catch (IOException e) {
            System.out.println("An error has occurred writing to one or more of the files!");
            e.printStackTrace();
        }
    }
}
