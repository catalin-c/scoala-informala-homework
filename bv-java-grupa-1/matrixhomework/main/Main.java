package main;

import exceptions.InvalidDiagonalException;
import exceptions.InvalidLineException;
import exceptions.InvalidRowColumnException;
import exceptions.InvalidSizeException;
import logic.Matrix;

import java.util.InputMismatchException;

import static utils.PrintMessages.printInputMismatchExceptionMessage;
import static utils.PrintMessages.printNullMatrixMessage;
import static utils.UserInput.getIntegerUserInput;

public class Main {
    public static void main(String[] args) {
        Matrix<Integer> matrix = null;

        while (true) {
            System.out.println();
            System.out.println("Please enter a command(0/1/2/3/4/5/6):");
            System.out.println("1. Create a Matrix");
            System.out.println("2. Print the current Matrix");
            System.out.println("3. Print the sum of a line");
            System.out.println("4. Print the sum of a diagonal");
            System.out.println("5. Print the sum of all the numbers");
            System.out.println("6. Change a value");
            System.out.println("0. Exit");
            System.out.println();

            int command = 0;

            try {
                command = getIntegerUserInput();
            } catch (InputMismatchException e) {
                printInputMismatchExceptionMessage();
                continue;
            }

            if(command == 0) {
                System.out.println("Have a great day!");
                break;
            } else if (command == 1) {
                System.out.println("Enter the size of the Matrix:");
                int size = 0;
                try {
                    size = getIntegerUserInput();
                } catch (InputMismatchException e) {
                    printInputMismatchExceptionMessage();
                    continue;
                }

                System.out.println("Enter a value for the Matrix:");
                int value = 0;
                try {
                    value = getIntegerUserInput();
                } catch (InputMismatchException e) {
                    printInputMismatchExceptionMessage();
                    continue;
                }

                try {
                    matrix = new Matrix<>(size, value);
                } catch (InvalidSizeException e) {
                    System.out.println("-------------------------------------------");
                    System.out.println(e.getMessage());
                    System.out.println("-------------------------------------------");
                    continue;
                }
            } else if(command == 2) {
                if(matrix == null) {
                    printNullMatrixMessage();
                    continue;
                }
                System.out.println(matrix);
            } else if (command == 3) {
                if(matrix == null) {
                    printNullMatrixMessage();
                    continue;
                }

                System.out.println("Enter the line:");
                int line = 0;
                try {
                    line = getIntegerUserInput();
                } catch (InputMismatchException e) {
                    printInputMismatchExceptionMessage();
                    continue;
                }
                try {
                    System.out.println("The line sum is: " + matrix.getLineSum(line));
                } catch (InvalidLineException e) {
                    System.out.println("-------------------------------------------");
                    System.out.println(e.getMessage());
                    System.out.println("-------------------------------------------");
                }
            } else if (command == 4) {
                if(matrix == null) {
                    printNullMatrixMessage();
                    continue;
                }

                System.out.println("Enter a diagonal mod of calculus (1 or 2):");
                int diagValue = 0;

                try {
                    diagValue = getIntegerUserInput();
                } catch (InputMismatchException e) {
                    printInputMismatchExceptionMessage();
                    continue;
                }

                try {
                    System.out.println("The diagonal sum is: " + matrix.getDiagSum(diagValue));
                } catch (InvalidDiagonalException e) {
                    System.out.println("-------------------------------------------");
                    System.out.println(e.getMessage());
                    System.out.println("-------------------------------------------");
                }
            } else if (command == 5) {
                if (matrix == null) {
                    printNullMatrixMessage();
                    continue;
                }

                System.out.println("The sum is: " + matrix.getSum());
            } else if (command == 6) {
                if (matrix == null) {
                    printNullMatrixMessage();
                    continue;
                }

                System.out.println("Enter the row:");
                int row = 0;

                try {
                    row = getIntegerUserInput();
                } catch (InputMismatchException e) {
                    printInputMismatchExceptionMessage();
                    continue;
                }

                System.out.println("Enter the column:");
                int column = 0;

                try {
                    column = getIntegerUserInput();
                } catch (InputMismatchException e) {
                    printInputMismatchExceptionMessage();
                    continue;
                }

                System.out.println("Enter the value:");
                int value = 0;

                try {
                    value = getIntegerUserInput();
                } catch (InputMismatchException e) {
                    printInputMismatchExceptionMessage();
                    continue;
                }

                try {
                    matrix.addValue(row, column, value);
                } catch (InvalidRowColumnException e) {
                    System.out.println("-------------------------------------------");
                    System.out.println(e.getMessage());
                    System.out.println("-------------------------------------------");
                }
            } else {
                System.out.println("-------------------------------------------");
                System.out.println("Please enter a valid command!");
                System.out.println("-------------------------------------------");
            }
        }
    }
}
