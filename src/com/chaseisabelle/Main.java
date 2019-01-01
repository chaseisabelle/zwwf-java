package com.chaseisabelle;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            String input = args[1].toLowerCase();
            Map<Character, Integer> letters = new HashMap<>();

            for (int i = 0; i < input.length(); i++) {
                char letter = input.charAt(i);

                if (!letters.containsKey(letter)) {
                    letters.put(letter, count(letter, input));
                }
            }

            BufferedReader reader = Files.newBufferedReader(Paths.get(args[2]), StandardCharsets.UTF_8);
            ArrayList<String> output = new ArrayList<>();

            while (true) {
                String line = reader.readLine();

                if (line == null) {
                    break;
                }

                line = line.toLowerCase();
                boolean skip = false;
                int i = 0;

                for (i = 0; i < line.length(); i++) {
                    char letter = line.charAt(i);

                    skip = !letters.containsKey(letter) || count(letter, line) > letters.get(letter);

                    if (skip) {
                        break;
                    }
                }

                if (skip || i >= line.length()) {
                    continue;
                }

                output.add(line);
            }

            output.forEach((word) -> System.out.println(word));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            System.exit(1);
        }
    }

    private static int count(char c, String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
        }

        return count;
    }
}
