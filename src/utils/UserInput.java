package utils;

import java.util.Scanner;

public class UserInput {
    private final static Scanner scanner = new Scanner(System.in);

    public static Scanner getScanner() {
        return scanner;
    }

    public static void waitForEnter() {
        try {
            System.in.read();
        } catch (Exception ignored) {
        }
    }
}
