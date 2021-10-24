package com.company.Softuni_Projects_Java;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List< String > initialItems = Arrays.stream(scan.nextLine().split("!")).collect(Collectors.toList());

        String command = scan.nextLine();
        while(!command.equals("Go Shopping!")){
            String[] commands = command.split(" ");
            String instruction = commands[0];
            String firstItem = commands[1];

            switch(instruction){
                case "Urgent":
                    if(!initialItems.contains(firstItem)){
                        initialItems.add(0, firstItem);
                    }
                    break;
                case "Unnecessary":
                    if(initialItems.contains(firstItem)){
                        initialItems.remove(firstItem);

                    }
                    break;
                case "Correct":
                    if(initialItems.contains(firstItem)) {
                        String secondItem = commands[2];
                        int index = initialItems.indexOf(firstItem);
                        initialItems.set(index, secondItem);
                    }
                    break;
                case "Rearrange":
                    if(initialItems.contains(firstItem)){
                        initialItems.remove(firstItem);
                        initialItems.add(firstItem);
                    }
                    break;



            }



            command = scan.nextLine();
        }
        System.out.printf(String.join(", ", initialItems));
    }
}
