package com.company.Softuni_Projects_Java;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PhoneShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List < String > phoneList = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());

        String command = scan.nextLine();

        while (!command.equals("End")) {

            String[] tokens = command.split(" - ");
            String token1 = tokens[0];
            switch (token1) {
                case "Add":
                    if (!phoneList.contains(tokens[1])) {
                        String add = tokens[1];
                        phoneList.add(add);

                    }
                    break;

                case "Remove":
                    phoneList.remove(tokens[1]);
                    break;

                case "Bonus phone":
                    String[] splitted = tokens[1].split(":");
                    if (phoneList.contains(splitted[0])) {
                        int index = phoneList.indexOf(splitted[0]);
                        phoneList.add(index + 1, splitted[1]);
                    }
                    break;
                case "Last":

                    if (phoneList.contains(tokens[1])) {
                        int index = phoneList.indexOf(tokens[1]);
                        String phone = phoneList.get(index);
                        phoneList.remove(tokens[1]);
                        phoneList.add(tokens[1]);

                    }
                    break;
                default:
                    break;
            }

            command = scan.nextLine();
        }
        System.out.println(String.join(", ", phoneList));

    }
}