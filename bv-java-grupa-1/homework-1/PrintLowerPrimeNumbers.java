public class PrintLowerPrimeNumbers {

    /**
     * The variable divisors is initialised with the value 0. It is used to check if a number is prime or not.
     * The first for loop takes each number from 2 to until the given user number.
     * The second for loop takes each number from the first for loop and divides it with every number
     * lower than it, starting with 2.
     * If one of the divisions doesn't have any remainders it means that the number isn't prime
     * (and the divisors variable increments).
     * If the divisors variable is equal with 0, it means that the number is prime and it prints the number.
     * At the end, the divisors variable is set to 0 again (in case it incremented) so the loop can continue correctly.
     *
     * @param userInput is a whole number given by the user as the limit.
     */
    public void printLowerPrimeNumbers(int userInput) {
        int divisors = 0;

        for (int i = 2; i < userInput; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    divisors++;
                }
            }
            if (divisors == 0) {
                System.out.println(i);
            }
            divisors = 0;
        }
    }
}
