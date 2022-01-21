import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runPart1();
        runPart2();
        runPart3();
    }

    /**
     * ===== Part 1 =====
     * This method runs part 1.
     * A character array is created and outputted to the console. The user is then asked to enter the character they would
     * like to find the index of.
     * Using the inputted character, the indexFinder(char[], char) method is called to find the index of the character in the array.
     * If the index of the character was found, the index is outputted to the console, otherwise an error message is displayed.
     */
    public static void runPart1() {
        System.out.println("===== Part 1 =====");
        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f'};

        System.out.println("Array of Characters: ");
        System.out.println(Arrays.toString(arr));

        System.out.println("Which character would you like to find the index of?");
        char input = scanner.next().charAt(0);

        int characterIndex = indexFinder(arr, input);

        if (characterIndex != -1) {
            System.out.println("Character Index of " + input + ": " + characterIndex);
        } else {
            System.out.println("The inputted character index was not found.");
        }
    }

    /**
     * This method takes in an array of characters and a single character.
     * The method checks whether the character is in the character array by looping through the array and checking all the elements and
     * returns the index if it is found.
     * @param arr The array of characters.
     * @param characterToFind The character the user wants to find the index of.
     * @return The index of the character if it is found, otherwise -1.
     */
    private static int indexFinder(char[] arr, char characterToFind) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == characterToFind) {
                index = i;
                break;
            } else if (i == arr.length-1 && arr[i] != characterToFind) {
                index = -1;
            }
        }
        return index;
    }

    /**
     * ===== Part 2 =====
     * This method runs part 2.
     * A 2D array of characters is created and outputted to the console. The user is then asked to enter the character they would
     * like to find the index of.
     * Using the inputted character, the overloaded findIndex(char[][], char) method is called to find the index of the character in the array.
     * If the character is found, the index is outputted to the console, otherwise an error message is displayed.
     */
    public static void runPart2() {
        System.out.println("\n===== Part 2 =====");
        char[][] arr2D = {{'a', 'b', 'c'}, {'d', 'e', 'f'}};

        System.out.println(Arrays.deepToString(arr2D));
        System.out.println("What character would you like to find the index of?");
        char input = scanner.next().charAt(0);

        String characterIndex = indexFinder(arr2D, input);
        if (characterIndex != null) {
            System.out.println("Character index of " + input + ": " + characterIndex);
        } else {
            System.out.println("The inputted character index was not found!");
        }
    }

    /**
     * This overloaded method takes in a 2D array of characters and a single character.
     * The method checks whether the character is in the 2D character array by looping through the array and checking all the elements and
     * returns the index as a String if it is found.
     * @param arr The 2D array of characters.
     * @param characterToFind The character the user wants to find the index of.
     * @return The index of the character as a String if it is found, otherwise null.
     */
    private static String indexFinder(char[][] arr, char characterToFind) {
        String index = "";
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == characterToFind) {
                    index = "[" + i + "][" + j + "]";
                    break;
                }
            }
        }
        return index.isEmpty() ? null : index;
    }

    /**
     * ===== Part 3 =====
     * This method runs part 3.
     * The user is asked to enter two words (Strings).
     * The getOffset(char[], char[]) method is called and the two Strings are passed into this method as character arrays.
     * The row and column that the two Strings match on (offset) is then outputted to the console.
     * Lastly, the printCharacterMatch(int[], String, String) is called. The offset and the two Strings are passed into this method.
     */
    public static void runPart3() {
        System.out.println("\n===== Part 3 =====");
        System.out.print("Enter a word: ");
        String word1 = scanner.next();
        System.out.print("Enter another word: ");
        String word2 = scanner.next();

        int[] offSet = getOffset(word1.toCharArray(), word2.toCharArray());
        if (offSet[0] != -1 & offSet[1] != -1) {
            System.out.println("Characters match on offset: " + Arrays.toString(offSet));
            printCharacterMatch(offSet, word1, word2);
        } else {
            System.out.println("The words have no matching characters.");
        }
    }

    /**
     * This method takes in two character arrays.
     * A loop is used to call the indexFinder(char[], char) method to find the offset of the column.
     * Once this has been found, the first element in returnValue is assigned the iteration number, which represents the row and
     * the second element is assigned the offset of the column.
     * @param first The first word converted to a character array.
     * @param second The second word converted to a character array.
     * @return The offset which the two words match on as an integer array, otherwise -1, -1.
     */
    private static int[] getOffset(char[] first, char[] second) {
        int[] returnValue = {-1, -1};

        for (int i = 0; i < first.length; i++) {
            int index = indexFinder(second, first[i]);

            if (index != -1) {
                returnValue[0] = i;
                returnValue[1] = index;
                return returnValue;
            }
        }
        return returnValue;
    }

    /**
     * This method takes in two Strings and an integer array, which contains the offset that the two Strings match on.
     * The method loops through the first String and using the second offset, prints the first word vertically.
     * Once the loop iteration equals the first offset, the second word is printed out horizontally where the same characters
     * in both words match.
     * @param offset The offset the two Strings match on.
     * @param word1 The first word entered by the user.
     * @param word2 The second word entered by the user.
     */
    private static void printCharacterMatch(int[] offset, String word1, String word2) {
        int offSet1 = offset[0];
        int offSet2 = offset[1];

        for (int i = 0; i < word1.length(); i++) {
            if (i != offSet2) {
                System.out.print(" ");
            } else {
                for (int j = 0; j < word1.length(); j++) {
                    if (j > 0) {
                        if (j != offSet1) {
                            for (int k = 0; k < offSet2; k++) {
                                System.out.print(" ");
                            }
                        }
                    }
                    if (j == offSet1) {
                        System.out.println(word2);
                    } else {
                        System.out.println(word1.charAt(j));
                    }
                }
            }
        }
    }
}
