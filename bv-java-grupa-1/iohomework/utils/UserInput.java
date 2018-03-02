package utils;

import java.util.Scanner;

public class UserInput {
    public static String getUserInput() {
        Scanner reader = new Scanner(System.in);
        return reader.nextLine().toLowerCase();
    }
}
