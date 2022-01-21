import java.io.*;
import java.util.Scanner;

public class Question1 {

    public static void main(String[] args) {
        File file = new File("Lab 3 text file.txt");

        try {
            Scanner scanner = new Scanner(file);
            int counter = 0;

            while (scanner.hasNext()) {
                /*
                Checking the counter variable to see if it is divisible by 5 to get every fifth word in the file.
                If counter is divisible by five, then print out the word.
                Else move onto the next word in the file.
                 */
                if (counter % 5 == 0) {
                    System.out.print(scanner.next() + " ");
                } else {
                    scanner.next();
                }
                counter++;
            }
        } catch (IOException e) {
            System.out.println("An error has occurred!");
            e.printStackTrace();
        }
    }
}
