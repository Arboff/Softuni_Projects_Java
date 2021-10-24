package com.company.Softuni_Projects_Java;

import java.util.Scanner;

public class BurgerBus {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double totalEarnings = 0;
        double totalOwnerExpenses = 0;

        int cities = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= cities; i++) {
            String cityName = scan.nextLine();
            double earnings = Double.parseDouble(scan.nextLine());
            double ownerExpenses = Double.parseDouble(scan.nextLine());
            if (i % 15 == 0 || i % 5 == 0) {
                earnings *= 0.90;
            } else if (i % 3 == 0) {
                ownerExpenses *= 1.50;

            }

            double profit = earnings - ownerExpenses;
            totalEarnings += earnings;
            totalOwnerExpenses += ownerExpenses;

            System.out.printf("In %s Burger Bus earned %.2f leva.%n", cityName, profit);
        }

        double totalProfit = totalEarnings - totalOwnerExpenses;

        System.out.printf("Burger Bus total profit: %.2f leva.", totalProfit);

    }
}