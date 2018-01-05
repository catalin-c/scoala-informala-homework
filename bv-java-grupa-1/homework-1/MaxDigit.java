public class MaxDigit {

    /**
     * The maxDigit variable is initialised with the value 0.
     * The while loop statement iterates through the given number.
     * If the maxDigit variable is smaller than the last digit from the userInput,
     * the maxDigit is assigned the last digit value.
     * The userInput number is divided by 10 so the while loop can get the next digit
     * and end if the userInput is 0.
     * The print statement prints the biggest digit.
     *
     * @param userInput is the whole number given by the user.
     */
    public void maxDigit(int userInput) {
        int maxDigit = 0;
        while (userInput > 0) {
            if (maxDigit < userInput % 10) {
                maxDigit = userInput % 10;
            }
            userInput /= 10;
        }
        System.out.println("The max digit is: " + maxDigit);
    }
}
