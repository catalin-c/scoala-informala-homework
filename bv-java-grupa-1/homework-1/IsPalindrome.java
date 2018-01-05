public class IsPalindrome {

    /**
     * The copyOfUserInput variable is initialised with userInput value (as a copy).
     * The reverse variable is initialised with the value 0.
     * The while loop statement builds the reverse variable with the reversed value of userInput.
     * If the copyOfUserInput is the same as the reversed number then the given number is a palindrome(@userInput).
     * Otherwise, the given number isn't a palindrome.
     *
     *  @param userInput is the whole number given by the user.
     */
    public void isPalindrome(int userInput) {
        int copyOfUserInput = userInput;
        int reverse = 0;

        while (userInput != 0) {
            reverse = reverse * 10 + userInput % 10;
            userInput /= 10;
        }

        if (copyOfUserInput == reverse) {
            System.out.println(copyOfUserInput + " is a palindrome.");
        } else {
            System.out.println(copyOfUserInput + " is not a palindrome.");
        }
    }
}
