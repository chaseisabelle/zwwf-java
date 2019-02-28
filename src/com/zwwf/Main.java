package com.zwwf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            zwwf(args[0].toLowerCase());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            System.out.println(exception.getStackTrace().toString());
        }
    }

    public static void zwwf(String input) throws Exception {System.out.println(input);
        Map<Character, Integer> letters = new HashMap<>();
        Integer length = input.length();

        for (char letter : input.toCharArray()) {
            letters.put(letter, letters.getOrDefault(letter, 0) + 1);
        }

        ArrayList<String> strings = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String word = scanner.nextLine();

            if (word.length() > length) {
                continue;
            }

            Map<Character, Integer> chars = new HashMap<>();
            boolean skip = false;

            for (char letter : word.toCharArray()) {
                skip = !letters.containsKey(letter);

                if (skip) {
                    break;
                }

                chars.put(letter, chars.getOrDefault(letter, 0) + 1);
            }

            if (skip) {
                continue;
            }

            for (Map.Entry<Character, Integer> entry : letters.entrySet()) {
                skip = entry.getValue() > chars.getOrDefault(entry.getKey(), 100);

                if (skip) {
                    break;
                }
            }

            if (skip) {
                continue;
            }

            strings.add(word);
        }

        strings.forEach((string) -> {
            System.out.println(string + "\n");
        });
    }
}
