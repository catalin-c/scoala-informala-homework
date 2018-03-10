import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculateMax {
    //The reader class member is declared and instantiated
    private Scanner reader = new Scanner(System.in);

    /**
     * @return returns the int given by the user in the console
     */
    public int getUserInput() {
        return this.reader.nextInt();
    }

    /**
     * The method gets two numbers as input (a and b).
     * It checks which one is bigger and returns it.
     * If they are equal then the first one is returned.
     *
     * @param a is the first number (int) given as input
     * @param b is the second number (int) given as input
     * @return returns the biggest number or the first one if they are equal
     */
    public int getMax(int a, int b) throws IllegalArgumentException {
        if (a == b) {
            throw new IllegalArgumentException("The numbers shouldn't be equal.");
        }

        if (a > b) {
            return a;
        }
        return b;

    }


    /**
     * First, within a while loop, the main method instantiates the CalculateMax class.
     * Then it asks the user to enter 3 numbers.
     * The 3 variables that will store the user input are declared and then they are assigned in the try/catch block
     * the values given by the user only if they are integers. If the user gives the wrong input,
     * a message is printed on the console and the loop starts again.
     * The biggest between the three numbers is assigned to the variable biggestNum
     * with the help of the getMax() method.
     * Then, the biggest number is printed to the console and the loop starts again.
     */
    public static void main(String[] args) {
        while (true) {
            CalculateMax result = new CalculateMax();
            System.out.println("Enter three numbers: ");
            int firstNum, secondNum, thirdNum;
            try {
                firstNum = result.getUserInput();
                secondNum = result.getUserInput();
                thirdNum = result.getUserInput();

                int biggestNum = result.getMax(result.getMax(firstNum, secondNum), thirdNum);
                System.out.println("The biggest number is: " + biggestNum);
            } catch (InputMismatchException e) {
                System.err.println("You entered an invalid number!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

