package com.company;

public class LightSwitch {
    private int status; // 0 - off, 1 - on
    private boolean lightBlown;

    /**
     * The constructor initializes the status and lightBlown instance variables;
     */
    public LightSwitch() {
        this.status = 0; // off by default
        this.lightBlown = false;
    }

    /**
     * This method is used to set the status of the light switch.
     * An integer status is taken in and is checked to see if it is a 0 or 1 to represent off or on.
     * If it is, the status instance variable is then checked to see if the lightSwitch is currently off or on.
     * A message is then printed to indicate whether is turned off or is already turned off or is turned on or is already turned on.
     * Otherwise, an error message is printed.
     * If the light switch is turned on, then the randomChanceToBlow() method is called. If this returns true, a message
     * indicating the light switch has blown is outputted to the console.
     * @param status The status of the light, 0 - off, 1 - on.
     */
    public void setStatus(int status) {
        if (status == 0) {
            if (this.status != 0) {
                this.status = status;
                System.out.println("\nLight Switch turned off.");
            } else {
                System.out.println("\nLight Switch is already turned off.");
            }
        } else if (status == 1){
            if (this.status != 1) {
                this.status = status;
                System.out.println("\nLight Switch turned on.");
                if (randomChanceToBlow()) {
                    System.out.println("Light Switch has blown.");
                }
            } else {
                System.out.println("\nLight Switch is already turned on.");
            }
        } else {
            System.out.println("Error. Invalid status choice.");
        }
    }

    /**
     * This method returns the value of the lightBlown instance variable.
     * @return true if the light is blown, false otherwise.
     */
    public boolean isLightBlown() {
        return this.lightBlown;
    }

    /**
     * This method is used to randomly blow the light switch.
     * A random number between 1 and 100 is generated. If this number is greater than 75, the lightBlown instance variable
     * is updated to true.
     * @return true is the light switch blows, false otherwise.
     */
    private boolean randomChanceToBlow() {
        int randomNum = ((int) (Math.random() * (100 - 1)) + 1);

        if (randomNum > 75) {
            this.lightBlown = true;
            return true;
        }

        return false;
    }
}
