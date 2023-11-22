package org.example;
import java.util.Locale;
import java.util.Scanner;  // Import the Scanner class

public class Kap_9_cviceni {
    public static void main(String[] args) {
        //cvičení 1
        /*Scanner sc1 = new Scanner(System.in);  // Create a Scanner object

        System.out.print("Zadej první část palindromu: ");
        String ret1 = sc1.nextLine();  // Read user input

        System.out.print("Zadej volitelnou střední část palindromu: ");
        String ret2 = sc1.nextLine();
        sc1.close();
        StringBuffer retb1 = new StringBuffer(ret1);

        System.out.println("Palindrom je: " + ret1 + ret2 + retb1.reverse());  // Output user input
         */


        //cvičení 2
        Scanner sc2 = new Scanner(System.in);

        System.out.print("Zadej číslo (0..., 0{x|X}..., des.): ");
        String cislo2 = sc2.nextLine();
        sc2.close();

        if (cislo2.charAt(0) == '0' && cislo2.length() > 1) {
            if (cislo2.toUpperCase().charAt(1) == 'X') {
                if (cislo2.length() > 2) {
                    //šestnáctkové číslo
                    int i2_16 = Integer.valueOf(cislo2.substring(2, cislo2.length()), 16).intValue();
                    //int i2_16 = Integer.valueOf(cislo2, 16).intValue(); Todo: plný formát nefung, proč?
                    String s2_16_2 = Integer.toBinaryString(i2_16);
                    System.out.println("šestnáctkové číslo " + cislo2 + ": " + i2_16 + ": " + s2_16_2);
                }
                else {
                    System.out.println("Chyba zadání: \"" + cislo2 + "\" je neplatný formát.");
                }
            }
            else {
                //osmičkové číslo
                int i2_8 = Integer.valueOf(cislo2.substring(1, cislo2.length()), 8).intValue();
                String s2_8_2 = Integer.toBinaryString(i2_8);
                System.out.println("osmičkové číslo " + cislo2 + ": " + i2_8 + ": " + s2_8_2);
            }
        }
        else {
            //desítkové číslo
            int i2_10 = Integer.valueOf(cislo2, 10).intValue();
            String s2_10_2 = Integer.toBinaryString(i2_10);
            System.out.println("desítkové číslo: " + i2_10 + ": " + s2_10_2);
        }


        //cvičení 3
        Scanner sc3 = new Scanner(System.in);

        System.out.print("Zadej řetězec s instrukcí v posl. znaku (l/L - lower, u/U - upper, x/X - exch.): ");
        String ret_output, ret_input = sc3.nextLine();
        sc3.close();

        switch (ret_input.toUpperCase().charAt(ret_input.length() - 1)) {
            case 'L': {
                ret_output = ret_input.toLowerCase();
                System.out.println("L: " + ret_output);
            }
            break;
            case 'U': {
                ret_output = ret_input.toUpperCase();
                System.out.println("U: " + ret_output);
            }
            break;
            case 'X': {
                ret_output = ret_input.
            }
            break;
            default: System.out.println("Zadána špatná koncovka řetězce.");
                break;
        }



        //cvičení 4

    }
}
