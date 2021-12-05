package com.company.Softuni_Projects_Java;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dictionary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String words = scan.nextLine();
        String inputt = scan.nextLine();
        Map < String, ArrayList < String >> map = new HashMap < String, ArrayList < String >> ();
        String regex = "(?<word>[A-Za-z]+): (?<deff>[A-Za-z0-9_ ,]+)";
        Pattern p = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher m = p.matcher(words);
        String[] examWords = inputt.split("\\s[|]\\s");
        int n = 0;

        while (m.find()) {
            if (map.containsKey(m.group("word"))) {
                map.get(m.group("word")).add(m.group("deff"));
            } else {
                map.put(m.group("word"), new ArrayList < String > ());
                map.get(m.group("word")).add(m.group("deff"));

            }
        }
        String command = scan.nextLine();
        if (command.equals("Test")) {

            for (int i = 0; i < examWords.length; i++) {
                List < String > definitions = new ArrayList < > ();
                if (map.containsKey(examWords[i])) {
                    System.out.printf("%s:%n", examWords[i]);
                    for (String definition: map.get(examWords[i])) {
                        definitions.add(definition);
                    }
                    definitions.sort(Comparator.comparingInt(String::length).reversed());

                    for (String def: definitions) {
                        System.out.printf(" -%s%n", def);
                    }





                }

            }


        } else if (command.equals("Hand Over")) {
            List < String > exWords = new ArrayList < > ();
            for (String key: map.keySet()) {
                exWords.add(key);

            }
            Collections.sort(exWords);

            for (String word: exWords) {
                System.out.printf("%s ", word);
            }
        }









    }
}