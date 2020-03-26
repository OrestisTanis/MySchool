/*
 * This class provides useful utilities for the development of console programs.
 */
package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {
    private static Scanner scanner;
    
    public static void createScanner(){
        if (scanner == null){
            scanner = new Scanner(System.in);
        }
    }
    public Scanner getScanner(){
        return scanner;
    }
    public static void closeScanner(){
        scanner.close();
    }

    /**
     * Outputs the specified <tt>string<tt> to the console
     *
     * @param message The message to output
     */
    public static void printMessage(String message) {
        System.out.println(message);

    }

    /**
     * Outputs each string contained in the <tt>List</tt> in the following
     * format:
     * <p>
     * 1. Item 1
     * <p>
     * 2. Item 2
     * <p>
     * 3. Item 3
     * <p>
     * ...
     *
     * @param list an <tt>List</tt> object
     */
    public static void printOptions(List list) {
        for (int i = 0; i < list.size(); i++) {
            printMessage(i + 1 + ". " + list.get(i));
        }
    }

    /**
     * Outputs the specified string parameters to the console in the following format:
     * <p>
     * 1. Parameter 1
     * <p>
     * 2. Parameter 2
     * <p>
     * 3. Parameter 3
     * <p>
     * ...
     *
     * @param args Any number of string parameters
     * @return An ArrayList of strings containing the passed parameters
     */
    public static ArrayList<String> printOptions(String... args) {
        byte i = 0;
        ArrayList<String> list = new ArrayList();

        for (String arg : args) {
            i++;
            printMessage(i + ". " + arg);
            list.add(arg);
        }
        return list;
    }

    /**
     * Reads input from the user and returns the <tt>string</tt> located in the
     * <tt>ArrayList</tt>
     * at index - 1, which matches user's selection while enforcing input
     * validation
     *
     * @param scanner A Scanner object
     * @param arrayList An ArrayList of strings
     * @return The string representing the option chosen by the user
     */
    public static String getOption(List<String> list) {
        int optionsListSize = list.size();
        int input = getIntFromTo(1, optionsListSize);
        return list.get(input - 1);
    }

    /**
     * Reads input from the user and returns an <tt>integer</tt>
     * between 1 and the specified arrayList size, while enforcing input
     * validation
     *
     * @param scanner A Scanner object
     * @param arrayList An ArrayList of strings
     * @return The string representing the option chosen by the user
     */
    public static int getOptionInt(List list) {
        int optionsListSize = list.size();
        int input = getIntFromTo(1, optionsListSize);
        return input;
    }

    /**
     * Ensures that an integer between <tt>lowerBound</tt> and
     * <tt>upperBound</tt> will be returned by the user. Displays a message on
     * invalid input and forces the user to give new input.
     *
     * @param scanner A Scanner object
     * @param int lowerBound The lower bound of the accepted input range.
     * @param int upperBound The upper bound of the accepted input range.
     * @return An integer number between the specified range.
     */
    public static int getIntFromTo(int lowerBound, int upperBound) {
        int input = lowerBound - 1;
        boolean onlyOneOption = lowerBound - upperBound == 0;
        while (input < lowerBound || input > upperBound){
            try {
                input = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                scanner.nextLine();
                input = lowerBound - 1;
            }
            if ((input < lowerBound || input > upperBound) && onlyOneOption) {
                System.out.printf("The only option is (%d): \n", lowerBound);
            }
            else if (input < lowerBound || input > upperBound){
                System.out.printf("Please enter a valid number (%d-%d): \n", lowerBound, upperBound);
            }
            
        }
        System.out.println(input);
        return input;
    }
    
    /**
    * Ensures that a positive integer will be returned by the user. 
    * Displays a message on invalid input and forces the user to give new input.
    *
    * @param scanner A Scanner object
    * @return A positive integer number.
    */
    public static int getPositiveInt() {
        int input = 0;

        do {
            if (input < 0) {
                System.out.println("Only positive integer numbers are allowed. Please enter a new value: ");
            }

            try {
                input = scanner.nextInt();
                scanner.nextLine();
                /* It's because when you enter a number then press Enter, input.nextInt() consumes only the number,
                *  not the "end of line". When input.nextLine() executes, it consumes the "end of line" still in 
                *  the buffer from the first input.
                *  So when you continue reading with input.nextLine() you receive the "\n" Enter key.
                * https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo
                 */
            } catch (Exception e) {
                scanner.nextLine();
                input =  -1;
            }

        } while (input < 0);

        return input;
    }
    
    /**
    * Ensures that a positive double will be returned by the user. 
    * Displays a message on invalid input and forces the user to give new input.
    *
    * @param scanner A Scanner object
    * @return A positive double number.
    */
    public static double getPositiveDouble() {
        double input = 0;

        do {
            if (input < 0) {
                System.out.println("Only positive numbers are allowed. Please enter a new value: ");
            }

            try {
                input = scanner.nextDouble();
                scanner.nextLine();
                /* It's because when you enter a number then press Enter, input.nextInt() consumes only the number,
                *  not the "end of line". When input.nextLine() executes, it consumes the "end of line" still in 
                *  the buffer from the first input.
                *  So when you continue reading with input.nextLine() you receive the "\n" Enter key.
                * https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo
                 */
            } catch (Exception e) {
                scanner.nextLine();
                input =  -1;
            }

        } while (input < 0);

        return input;
    }

    /**
     * Ensures that a string that matches the specified regular expression will
     * be returned by the user. Displays a message on invalid input and forces
     * the user to give new input.
     *
     * @param scanner A Scanner object
     * @param allowedRegex The regular expression that matches the desired user
     * input.
     * @return A string that matches the specified regular expression
     */
    public static String getString(String allowedRegex, String invalidInputMessage) {
        String userInput = "";
        Pattern pattern = Pattern.compile(allowedRegex);
        while (!pattern.matcher(userInput).matches()) {
            userInput = scanner.nextLine().trim();

            if (!pattern.matcher(userInput).matches()) {
                System.out.println(invalidInputMessage);
            }
        }
        return userInput;
    }
    
    public static LocalDate getLocalDateAfter(LocalDate minDate, String pattern, String invalidInputMessage){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        boolean dateValid = false;
        LocalDate resultDate = null;
        while(!dateValid){
            String inputStr = scanner.nextLine().trim();
            if (isDateValid(formatter, inputStr)){
                resultDate = LocalDate.parse(inputStr, formatter);
                dateValid = minDate.isBefore(resultDate);
            }
            if (!dateValid){
                System.out.println(invalidInputMessage);
            }
        }
        return resultDate;
    }
    
    public static boolean isDateValid(DateTimeFormatter f,String dateStr){
        try {
            LocalDate.parse(dateStr, f);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public static LocalDate getLocalDateFromTo(LocalDate minDate, LocalDate maxDate, String allowedPattern, String invalidInputMessage){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(allowedPattern); //"dd/MM/yyyy"
        boolean dateValid = false;
        LocalDate resultDate = LocalDate.parse("1001-01-01");
        while(!dateValid){
            String inputStr = scanner.nextLine().trim();
            if (isDateValid(formatter, inputStr)){
                resultDate = LocalDate.parse(inputStr, formatter);
                dateValid = minDate.isBefore(resultDate) && maxDate.isAfter(resultDate);
            }
            if (!dateValid){
                System.out.println(invalidInputMessage);
            }
        }
        return resultDate;
    }

//    static List<String> getMultipleStringInput(Scanner scanner) {
//        String userInput = "";
//        int userInputStrLength = 0;
//        while (userInputStrLength < 1) {
//            userInput = scanner.nextLine().trim();
//
//            // Does not allow input to be zero o more whitespaces
//            if (userInput.matches("\\s*")) {
//                userInput = "";
//                System.out.println("A course title must be at least 1 character");
//            }
//        }
//
//        // Will always be greater than zero
//        String[] wordArr = userInput.split(" ");
//        List<String> wordList = Arrays.asList(wordArr);
//
//        return wordList;
//    }

}
