public class TheBiggestNumber {

    /**
     * The max variable is initialised with the first parameter value (a).
     * If the second parameter value (b) is bigger than max then the method assigns its value to max.
     * If the third parameter value (c) is bigger than max then the method assigns its value to max.
     * The print statement prints the biggest number to the console.
     *
     * @param a first whole number given by the user.
     * @param b second whole number given by the user.
     * @param c third whole number given by the user.
     */
    public void theBiggestNumber (int a, int b, int c) {
        int max = a;

        if (b > a) {
            max = b;
        }

        if (c > max) {
            max = c;
        }

        System.out.println("The biggest number is: " + max);
    }
}
