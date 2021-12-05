package com.company.Softuni_Projects_Java;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.*;
public class MessageDecryptor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputs = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= inputs; i++) {
            String userInput = scan.nextLine();
            String regexpattern = "(?<as>[%|$])(?<tag>[A-Z][a-z]+)(?<bs>[$|%])[:] [\\[](?<first>[0-9]+)[\\]][|][\\[](?<second>[0-9]+)[\\]][|][\\[](?<third>[0-9]+)[\\]][|]";
            Pattern p = Pattern.compile(regexpattern);
            Matcher b = p.matcher(userInput);
            boolean matches = b.matches();
            String finall = "";



            if (matches) {
                String firs = b.group("as");
                String secon = b.group("bs");
                if (firs.equals(secon)) {
                    int first = Integer.parseInt(b.group("first"));
                    int second = Integer.parseInt(b.group("second"));
                    int third = Integer.parseInt(b.group("third"));

                    finall += (char) first;
                    finall += (char) second;
                    finall += (char) third;
                    System.out.printf("%s: %s %n", b.group("tag"), finall);
                } else {
                    System.out.println("Valid message not found!");
                }
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}