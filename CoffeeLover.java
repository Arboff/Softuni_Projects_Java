package com.company.Softuni_Projects_Java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CoffeeLover {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List < String > coffeeList = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());

        int commandCound = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= commandCound; i++) {
            String[] tokens = scan.nextLine().split(" ");
            String command = tokens[0];
            switch (command) {
                case "Include":
                    String item = tokens[1];
                    coffeeList.add(item);
                    break;
                case "Remove":
                    int number = Integer.parseInt(tokens[2]);
                    String position = tokens[1];
                    if (coffeeList.size() >= number) {
                        switch (position) {
                            case "first":
                                for (int j = 1; j <= number; j++) {
                                    coffeeList.remove(0);
                                }
                                break;
                            case "last":
                                for (int j = 1; j <= number; j++) {
                                    int last = coffeeList.size() - 1;
                                    coffeeList.remove(last);
                                }

                                break;
                        }
                    }
                    break;
                case "Prefer":
                    int index1 = Integer.parseInt(tokens[1]);
                    int index2 = Integer.parseInt(tokens[2]);
                    if (index1 < coffeeList.size() && index2 < coffeeList.size()) {
                        Collections.swap(coffeeList, index1, index2);
                    }

                    break;
                case "Reverse":
                    Collections.reverse(coffeeList);
                    break;

            }

        }

        System.out.println("Coffees:");
        System.out.println(String.join(" ", coffeeList));

    }
}