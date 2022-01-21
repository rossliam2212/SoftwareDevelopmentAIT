package com.company;

public class Box {
    private String name;
    private double length, width, height;
    private boolean full;

    /**
     * The constructor initializes the instance variable to the values passed in.
     * @param name The type of box.
     * @param length The length of the box.
     * @param width The width of the box.
     * @param height The height of the box.
     * @param full 
     */
    public Box(String name, double length, double width, double height, boolean full) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.height = height;
        this.full = full;
    }

    /**
     * This method returns the value of the name instance variable name.
     * @return The value of name.
     */
    public String getName() {
        return name;
    }

    /**
     * This method is used to set the value of the name instance variable.
     * @param name The value name is to be set to.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns the value of the length instance variable.
     * @return The value of length.
     */
    public double getLength() {
        return length;
    }

    /**
     * This method is used to set to value of the length instance variable.
     * @param length The value length is to be set to.
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * The method returns the value of the width instance variable.
     * @return The value of width.
     */
    public double getWidth() {
        return width;
    }

    /**
     * This method is used to set the value of the width instance variable.
     * @param width The value width is to be set to.
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * This method returns the value of the height instance variable.
     * @return The value of height.
     */
    public double getHeight() {
        return height;
    }

    /**
     * This method is used to set the value of the height instance variable.
     * @param height The value height is to be set to.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * This method returns the value of the full instance variable.
     * @return The value of full.
     */
    public boolean isFull() {
        return full;
    }

    /**
     * This method is used to set the value of the full instance variable.
     * @param full The value full is to be set to.
     */
    public void setStatus(boolean full) {
        this.full = full;
    }

    /**
     * This method returns the name and values of all the instance variable.
     * @return All the instances variables formatted.
     */
    public String toString() {
        return "Name: " + name +
                "\nLength: " + length +
                "\nWidth: " + width +
                "\nHeight: " + height +
                "\nFull: " + full;
    }
}
