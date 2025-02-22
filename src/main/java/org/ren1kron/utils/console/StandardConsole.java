package org.ren1kron.utils.console;

import java.util.Scanner;

public class StandardConsole implements Console{
    private static final String RESET = "\u001B[0m";
    private static final String RED   = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void print(Object obj) {
        System.out.print(obj);
    }

    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }

    @Override
    public void printerr(Object obj) {
        System.out.println(RED + obj + RESET);
    }

    @Override
    public void printGritting(Object obj) {
        System.out.println(GREEN + obj + RESET + "\n");
    }

    @Override
    public String readln() {
        return scanner.nextLine();
    }

    @Override
    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }
}
