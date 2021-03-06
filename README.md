# Software Development AIT - Java

All of the Java lab work I've completed as part of my Software Development module in AIT.

## Quick Links
- [Year 2](#year-2)
  - [Lab 1](#lab-1)
  - [Lab 2](#lab-2)
  - [Lab 3](#lab-3)
  - [Lab 4](#lab-4)
  - [Lab 5](#lab-5)
  - [Lab 6](#lab-6)
  - [Lab 7](#lab-7)
  - [Lab 8](#lab-8)
  - [Lab 9](#lab-9)
- [Year 3](#year-3)
- [Year 4](#year-4)

## Year 2

### Lab 1 
[src](https://github.com/rossliam2212/SoftwareDevelopmentAIT/tree/master/Year2/Lab1/src)

1. Create an application which will read a word from the command line, using a method(s) will analyse the string and state its length, number of vowels, first letter and last letter. 

2. A class Box complete with getter,setter and constructor  methods, it should have dimensions, name, status(full/empty).

3. A class LightSwitch which has a status of on/off, it also has a random chance to blow while it is being switched on. Use the input of plus to turn on the light and minus to turn off the light. You must constantly poll the keyboard for user input. The application ends when the light blows.

### Lab 2
[src](https://github.com/rossliam2212/SoftwareDevelopmentAIT/tree/master/Year2/Lab2/src)

1. Create a method which reads in an array of chars and finds the index of a certain letter.

2. Create a method similar to that in part 1 which finds the index in a 2D array.

3. Using the methods above, create an application which takes in two words and joins them on a matching char. Example:
```
    T
   ROAD
    L
    L
```

### Lab 3
[src](https://github.com/rossliam2212/SoftwareDevelopmentAIT/tree/master/Year2/Lab3/src)

1. Count the number of words in the text file.

2. Using previously developed methods count the number of vowels in the file and the average number of vowels per word.

3. Print out the words in the file so that words longer than 3 chars will have the first and last letter stay the same but the middle letters jumbled. For example please jumble these letters becomes:
```
pealse jmulbe tehse ltetres 
```

### Lab 4
[src](https://github.com/rossliam2212/SoftwareDevelopmentAIT/tree/master/Year2/Lab4/src)
1. Read in from Lab 3's text file and print out every 5th word.

2. Create an array of 5 files (do not hard code), put one fifth of the words from the text file in each file.

3. Randomly swap the contents of all files,( eg file1 now contains the contents of file3 ....), finally printing the statistics for each of the files.

### Lab 5
[src](https://github.com/rossliam2212/SoftwareDevelopmentAIT/tree/master/Year2/Lab5/src)
1. Read into an array the values from the lab3.txt file. and print out each value in sorted order. Create a method for sorting and reuse the method for swapping.

2. Create a class Book which validates the arguments to be non null, book should have a title, publisher, author, price.

3. Using the Comparable interface sort an array of Books. Allow change the sort method.

### Lab 6
[src](https://github.com/rossliam2212/SoftwareDevelopmentAIT/tree/master/Year2/Lab6/src)
1. Create a base class Building which implements interfaces for Walls, Roof.

2. Extend Building into House, ApartmentBlock and OfficeBlock, each will have a new interface such as Rooms for House, Units for ApartmentBlock and Cubicles for OfficeBlock

3. Create a GUI for Creating a new Building that changes based on the type selected.

### Lab 7
[src](https://github.com/rossliam2212/SoftwareDevelopmentAIT/tree/master/Year2/Lab7/src)
1. Create a class CurrencyConverter which implements an Interface BaseCurrency(USD), write a test class to convert to this base currency from Euro.

2. Extend the CurrencyConverter class to become MultipleCurrencyConverter modify the interface for the currencies Euro, Yuan, and GBP, create a test class for this.

3. Create a GUI which can update a display for all currencies based on the input of an amount in any currency field

<img width="798" alt="Screenshot 2022-01-21 at 23 25 13" src="https://user-images.githubusercontent.com/73957889/150612816-10ef9089-0046-4339-94d4-654e8d4db2de.png">
<img width="798" alt="Screenshot 2022-01-21 at 23 26 07" src="https://user-images.githubusercontent.com/73957889/150612824-0174bd9a-a421-4e07-92ff-3f1fed23e4f6.png">

### Lab 8
[src](https://github.com/rossliam2212/SoftwareDevelopmentAIT/tree/master/Year2/Lab8/src)
1. Create a GUI with a canvas, this canvas implements a mouseactionlistener to gather points on the screen. Create a draw button to connect these points.

2. Create a GUI with a canvas, click to drop a random shape. If you click the shape it changes colour, if you click the canvas it draws a new random shape and removes the old one.

3.  Create a GUI with a canvas, multiple shapes can be dropped using buttons to select colour and shape, each dropped shape must be movable around the canvas.
<img width="747" alt="Screenshot 2022-01-26 at 01 24 59" src="https://user-images.githubusercontent.com/73957889/151281059-b262e20e-228b-4847-9ed6-a11cc5ffbee1.png">
<img width="749" alt="Screenshot 2022-01-27 at 02 27 21" src="https://user-images.githubusercontent.com/73957889/151281068-97cdaed7-c553-49f1-9d33-4626376719e0.png">

### Lab 9
[src](https://github.com/rossliam2212/SoftwareDevelopmentAIT/tree/master/Year2/Lab9/src)
1. Create or extend the currency converter GUI to use the Jsoup library to convert between the four currencies

2. Create a circle(player) on a canvas, allow the player to move with wasd keys.

3. Extend the functionality of part 2, create an Arraylist of random shapes, once the player is above the shape pressing space will eliminate the shape, the application ends when all shapes are consumed.
<img width="799" alt="Screenshot 2022-02-08 at 21 25 01" src="https://user-images.githubusercontent.com/73957889/153078614-89c60827-3529-4580-9d99-574c47a4249b.png">
<img width="498" alt="Screenshot 2022-02-08 at 21 26 08" src="https://user-images.githubusercontent.com/73957889/153078620-5d3f1e8a-8bcd-4015-81e1-8f2cd3443702.png">

## Year 3
--

## Year 4
--
