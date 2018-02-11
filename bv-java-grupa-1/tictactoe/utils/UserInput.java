package utils;

import java.util.Scanner;

public class UserInput {
    private Scanner reader = new Scanner(System.in);

    /**
     * @return the user input.
     */
    public int getInput() {
        return reader.nextInt();
    }
}
