/**
 * OOPSBannerApp
 * Demonstrates rendering of "OOPS" using multiple OOPS concepts
 *
 * UC1  : Print OOPS
 * UC2  : Banner using String arrays
 * UC3  : Refactor logic into methods
 * UC4  : Store character pattern in inner class
 * UC5  : Use Map to render banner dynamically
 *
 * @author Krishna
 * @version 1.0
 */
package com.bridgelabz.oopsapp;

import java.util.HashMap;
import java.util.Map;

public class OOPSBannerApp {

    /* =========================
       UC1: Print OOPS
       ========================= */
    public static void printOOPS() {
        System.out.println("OOPS");
    }

    /* =========================
       UC2: Banner using arrays
       ========================= */
    public static void renderBannerUsingArrays() {

        String[] O = {
                "   ***   ",
                " **   ** ",
                "**     **",
                "**     **",
                "**     **",
                " **   ** ",
                "   ***   "
        };

        String[] P = {
                "******* ",
                "**     **",
                "**     **",
                "******* ",
                "**       ",
                "**       ",
                "**       "
        };

        String[] S = {
                " ****** ",
                "**      ",
                "**      ",
                " *****  ",
                "      **",
                "      **",
                " ****** "
        };

        for (int i = 0; i < O.length; i++) {
            System.out.println(String.join("  ", O[i], O[i], P[i], S[i]));
        }
    }

    /* =========================
       UC3: Refactor into methods
       ========================= */
    public static String[] getOPattern() {
        return new String[]{
                "   ***   ",
                " **   ** ",
                "**     **",
                "**     **",
                "**     **",
                " **   ** ",
                "   ***   "
        };
    }

    public static String[] getPPattern() {
        return new String[]{
                "******* ",
                "**     **",
                "**     **",
                "******* ",
                "**       ",
                "**       ",
                "**       "
        };
    }

    public static String[] getSPattern() {
        return new String[]{
                " ****** ",
                "**      ",
                "**      ",
                " *****  ",
                "      **",
                "      **",
                " ****** "
        };
    }

    public static void printBanner(String[]... patterns) {
        for (int i = 0; i < patterns[0].length; i++) {
            for (String[] pattern : patterns) {
                System.out.print(pattern[i] + "  ");
            }
            System.out.println();
        }
    }

    /* =========================
       UC4: Inner Class
       ========================= */
    static class BannerCharacter {
        private final char character;
        private final String[] pattern;

        public BannerCharacter(char character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        public char getCharacter() {
            return character;
        }

        public String[] getPattern() {
            return pattern;
        }
    }

    /* =========================
       UC5: HashMap + StringBuilder
       ========================= */
    public static Map<Character, BannerCharacter> buildCharacterMap() {
        Map<Character, BannerCharacter> map = new HashMap<>();
        map.put('O', new BannerCharacter('O', getOPattern()));
        map.put('P', new BannerCharacter('P', getPPattern()));
        map.put('S', new BannerCharacter('S', getSPattern()));
        return map;
    }

    public static void renderBannerUsingMap(String word) {
        Map<Character, BannerCharacter> map = buildCharacterMap();
        int height = map.get(word.charAt(0)).getPattern().length;

        for (int row = 0; row < height; row++) {
            StringBuilder line = new StringBuilder();
            for (char ch : word.toCharArray()) {
                line.append(map.get(ch).getPattern()[row]).append("  ");
            }
            System.out.println(line);
        }
    }

    /* =========================
       Main Method
       ========================= */
    public static void main(String[] args) {

        // UC1
        printOOPS();
        System.out.println();

//        // UC2
//        renderBannerUsingArrays();
//        System.out.println();
//
//        // UC3
//        printBanner(getOPattern(), getOPattern(), getPPattern(), getSPattern());
//        System.out.println();
//
//        // UC5 (UC4 implicitly used)
//        renderBannerUsingMap("OOPS");
    }
}
