package com.company.Softuni_Projects_Java;

import java.util.Locale;
import java.util.Scanner;

public class StringGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine();
        String inputt = scan.nextLine();
        while (!inputt.equals("Done")) {
            String[] tokens = inputt.split("\\s+");
            String command = tokens[0];
            if (command.equals("Change")) {
                char c = tokens[1].charAt(0);
                char d = tokens[2].charAt(0);
                userInput.replace(c, d);
                String replaced = userInput.replace(c, d);
                System.out.println(replaced);
                userInput = replaced;

            } else if (command.equals("Includes")) {
                String container = tokens[1];
                boolean isFound = userInput.contains(container);
                if (isFound) {
                    System.out.println("True");

                } else {
                    System.out.println("False");
                }


            } else if (command.equals("End")) {
                String container = tokens[1];
                boolean isEnding = userInput.endsWith(container);
                if (isEnding) {
                    System.out.println("True");

                } else {
                    System.out.println("False");
                }


            } else if (command.equals("Uppercase")) {
                userInput = userInput.toUpperCase(Locale.ROOT);
                System.out.println(userInput);

            } else if (command.equals("FindIndex")) {
                char c = tokens[1].charAt(0);
                System.out.println(userInput.indexOf(c));
            } else if (command.equals("Cut")) {
                int startIndex = Integer.parseInt(tokens[1]);
                int endIndex = Integer.parseInt(tokens[2]);
                String finall = userInput.substring(startIndex, endIndex + startIndex);
                userInput = finall;
                System.out.println(finall);


            } else if (command.equals("Done")) {

                System.out.println(userInput);



            }
            inputt = scan.nextLine();

        }

    }
}