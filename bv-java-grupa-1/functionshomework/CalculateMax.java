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
    public int getMax(int a, int b) {
        if (a > b) {
            return a;
        } else if (b > a) {
            return b;
        }
        return a;
    }


    /**
     * First, the main method instantiates the CalculateMax class.
     * With a while loop, it asks the user to enter 3 numbers which are stored in 3 int variables.
     * The biggest number between the first two is assigned to the variable biggestOfFirstTwoNumbers
     * with the help of the getMax() method. After that, it is compared with the third number
     * and the biggest is assigned to the biggestNum variable.
     * Then, the biggest number is printed to the console and the loop starts again.
     */
    public static void main(String[] args) {
        CalculateMax result = new CalculateMax();
        while (true) {
            System.out.println("Enter three numbers: ");
            int firstNum = result.getUserInput();
            int secondNum = result.getUserInput();
            int thirdNum = result.getUserInput();

            int biggestOfFirstTwoNumbers = result.getMax(firstNum, secondNum);
            int biggestNum = result.getMax(biggestOfFirstTwoNumbers, thirdNum);

            System.out.println("The biggest number is: " + biggestNum);
        }
    }
}

