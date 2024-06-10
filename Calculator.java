//Tanay Agarwal
//6/09/2024
//CS 401
//Homework 1 

//Calculator

import java.util.Scanner; // For getting input from user

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Setting up Scanner
        boolean checker = false; // For while loop
        String input = "";
        int switchNumber = 0; // for inputting values for the switch statement later in the code
        float firstNumber = 0; // Setting up the first number to be inputted
        float secondNumber = 0; // Setting up the second number to be inputted

        System.out.println("Welcome to The Simple Calculator \n"); // Welcome message
        while (!checker) { // while loop to constantly run calculator unless user inputs 5

            // Loop for valid first number input
            while (true) {
                System.out.println("Please input the first number:"); // print statement for inputting the first number
                try {
                    firstNumber = scanner.nextFloat();
                    break; // exit loop if input is valid
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a float value.");
                    scanner.next(); // clear invalid input
                }
            }

            // Loop for valid second number input
            while (true) {
                System.out.println("Please input the second number:"); // print statement for inputting the second number
                try {
                    secondNumber = scanner.nextFloat();
                    break; // exit loop if input is valid
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a float value.");
                    scanner.next(); // clear invalid input
                }
            }

            // Print statements for all the options.
            System.out.println("Please input the number for which operation you want to perform");
            System.out.println("1: Addition");
            System.out.println("2: Subtraction");
            System.out.println("3: Multiplication");
            System.out.println("4: Division");

            // Loop for valid operation input
            while (true) {
                try {
                    switchNumber = scanner.nextInt();
                    	if ((switchNumber >= 1) && (switchNumber <= 4)) {
                    			break;} // exit loop if input is valid
                    	else {
                    		System.out.println("Invalid input. Please enter an integer value between 1 and 4.");
                    	}
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter an integer value between 1 and 4.");
                    scanner.next(); // clear invalid input
                }
            }

            switch (switchNumber) { // switch statement for each operation
                case 1: // addition case
                    System.out.printf("Result: %.2f + %.2f = %.2f\n", firstNumber, secondNumber, addNumbers(firstNumber, secondNumber));
                    break;
                case 2: // subtraction case
                    System.out.printf("Result: %.2f - %.2f = %.2f\n", firstNumber, secondNumber, subtractNumbers(firstNumber, secondNumber));
                    break;
                case 3: // multiplication case
                    System.out.printf("Result: %.2f * %.2f = %.2f\n", firstNumber, secondNumber, multiplyNumbers(firstNumber, secondNumber));
                    break;
                case 4: // division case
                    if (secondNumber == 0) {
                        System.out.println("Cannot divide by zero.");
                    } else {
                        System.out.printf("Result: %.2f / %.2f = %.2f\n", firstNumber, secondNumber, divideNumbers(firstNumber, secondNumber));
                    }
                    break;
                default: // invalid choice case in case user inputs wrong input
                    System.out.println("Invalid choice. Please select a valid operation.");
            }

            // Asking if the user wants to perform another calculation
            System.out.println("Do you want to perform another calculation? (yes/no): ");
            scanner.nextLine(); // consume newline
            while (true) {
                input = scanner.nextLine();
                if (input.equals("yes")) {
                    break; // continue the loop
                } else if (input.equals("no")) {
                    checker = true; // exit the loop
                    System.out.println("Goodbye");
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
            }
        }

        scanner.close(); // closes the scanner
    }

    static float addNumbers(float a, float b) { // function for addition
        return a + b;
    }

    static float subtractNumbers(float a, float b) { // function for subtraction
        return a - b;
    }

    static float multiplyNumbers(float a, float b) { // function for multiplication
        return a * b;
    }

    static float divideNumbers(float a, float b) { // function for division
        return a / b;
    }
}
