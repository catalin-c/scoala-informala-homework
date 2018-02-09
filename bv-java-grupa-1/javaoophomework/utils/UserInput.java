package utils;

import java.util.Scanner;

public class UserInput {
    private Scanner reader = new Scanner(System.in);

    public int getIntInput() {
        return reader.nextInt();
    }

    public String getStringInput() {
        return reader.next();
    }

    public double getDoubleInput() {
        return reader.nextDouble();
    }
}
