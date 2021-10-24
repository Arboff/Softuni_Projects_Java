package com.company.Softuni_Projects_Java;

import java.util.*;

public class Numbers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        double asd = averag(numbers);
        List < Integer > biggest = new ArrayList < > ();


        for (int i: numbers) {
            if (i > asd) {
                biggest.add(i);
            }



        }
        Collections.sort(biggest, Collections.reverseOrder());

        if (biggest.size() == 0) {
            System.out.println("No");
        } else {
            printing(biggest);

        }




    }




    public static void printing(List < Integer > biggest) {
        if (biggest.size() > 5) {
            for (int i = 0; i < 5; i++) {
                System.out.printf("%d ", biggest.get(i));

            }

        } else {
            for (int a: biggest) {
                System.out.printf("%d ", a);

            }
        }
    }





    public static double averag(int[] average) {
        double total = 0;
        for (double a: average) {
            total += a;
        }
        double av = total / average.length;
        double rounded = Math.round(av * 100.0) / 100.0;

        return rounded;
    }
}
