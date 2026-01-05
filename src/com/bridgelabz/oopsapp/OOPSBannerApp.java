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
    public static void main(String[] args) {

        // UC1
        printOOPS();
        System.out.println();

        // UC2
        renderBannerUsingArrays();
        System.out.println();
//
//        // UC3
//        printBanner(getOPattern(), getOPattern(), getPPattern(), getSPattern());
//        System.out.println();
//
//        // UC5 (UC4 implicitly used)
//        renderBannerUsingMap("OOPS");
    }
}
