package com.company.Softuni_Projects_Java;


import java.util.Scanner;

public class printV {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int input = Integer.parseInt(scan.nextLine());
        String five = "*****";
        String indent = "";
        String between = "*   *";
        String end = "********";
        String start = "";
        for (int i = 0; i < (input - 2) * 2; i++) {
            indent += " ";
        }
        System.out.println(five + indent + five);
        System.out.println();

        for (int i = 0; i < input - 2; i++) {
            indent = indent.replaceFirst(String.valueOf(indent.charAt(0)), "");
            indent = indent.replaceFirst(String.valueOf(indent.charAt(0)), "");
            start += " ";
            System.out.println(start + between + indent + between);
            System.out.println();
        }
        start += " ";
        System.out.println(start + end);





    }
}