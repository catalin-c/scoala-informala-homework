package utils;

import java.util.Scanner;

public class UserInput {
    public static int getIntegerUserInput() {
        Scanner reader = new Scanner(System.in);
        return reader.nextInt();
    }
}
