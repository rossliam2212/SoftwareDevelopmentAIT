package com.company;

import java.util.Scanner;

public class LightSwitchMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LightSwitch lightSwitch = new LightSwitch();
        boolean quit = false;
        String input;

        System.out.println("Light Switch is turned off.");

        while (!quit) {
            printInstructions();
            input = scanner.next();

            if (input.equals("+")) {
                lightSwitch.setStatus(1);
            } else if (input.equals("-")) {
                lightSwitch.setStatus(0);
            } else {
                System.out.println("\nInvalid input. Try again.");
            }

            if (lightSwitch.isLightBlown()) {
                quit = true;
            }
        }
    }

    /**
     * This method prints out the instructions on how to turn on and turn off the light switch for the user.
     */
    public static void printInstructions() {
        System.out.println("\nWhat would you light to do? ");
        System.out.println("\t+ to turn the light on");
        System.out.println("\t- to turn the light off");
    }
}
