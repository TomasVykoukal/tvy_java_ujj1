package org.example;
import java.util.Locale;
import java.util.Scanner;  // Import the Scanner class

public class Kap_9_cviceni {
    //cvièení 4
    static void tiskPI(int desetMist) {
        String pi_txt = String.valueOf(Math.PI);
        String pi_txt_output = pi_txt.substring(0, 2 + desetMist);
        System.out.println(pi_txt_output);
    }

    public static void main(String[] args) {
        //cvièení 1
        /*Scanner sc1 = new Scanner(System.in);  // Create a Scanner object

        System.out.print("Zadej první èást palindromu: ");
        String ret1 = sc1.nextLine();  // Read user input

        System.out.print("Zadej volitelnou støední èást palindromu: ");
        String ret2 = sc1.nextLine();
        sc1.close();
        StringBuffer retb1 = new StringBuffer(ret1);

        System.out.println("Palindrom je: " + ret1 + ret2 + retb1.reverse());  // Output user input*/

        //cvièení 2
        /*Scanner sc2 = new Scanner(System.in);

        System.out.print("Zadej èíslo (0..., 0{x|X}..., des.): ");
        String cislo2 = sc2.nextLine();
        sc2.close();

        if (cislo2.charAt(0) == '0' && cislo2.length() > 1) {
            if (cislo2.toUpperCase().charAt(1) == 'X') {
                if (cislo2.length() > 2) {
                    //¹estnáctkové èíslo
                    int i2_16 = Integer.valueOf(cislo2.substring(2, cislo2.length()), 16).intValue();
                    //int i2_16 = Integer.valueOf(cislo2, 16).intValue(); Todo: plný formát nefung, proè?
                    String s2_16_2 = Integer.toBinaryString(i2_16);
                    System.out.println("¹estnáctkové èíslo " + cislo2 + ": " + i2_16 + ": " + s2_16_2);
                }
                else {
                    System.out.println("Chyba zadání: \"" + cislo2 + "\" je neplatný formát.");
                }
            }
            else {
                //osmièkové èíslo
                int i2_8 = Integer.valueOf(cislo2.substring(1, cislo2.length()), 8).intValue();
                String s2_8_2 = Integer.toBinaryString(i2_8);
                System.out.println("osmièkové èíslo " + cislo2 + ": " + i2_8 + ": " + s2_8_2);
            }
        }
        else {
            //desítkové èíslo
            int i2_10 = Integer.valueOf(cislo2, 10).intValue();
            String s2_10_2 = Integer.toBinaryString(i2_10);
            System.out.println("desítkové èíslo: " + i2_10 + ": " + s2_10_2);
        }*/

        //cvièení 3
        /*Scanner sc3 = new Scanner(System.in);

        System.out.print("Zadej øetìzec s instrukcí v posl. znaku (l/L - lower, u/U - upper, x/X - exch.): ");
        String ret_output, ret_input = sc3.nextLine();
        sc3.close();

        char instr_znak = ret_input.toUpperCase().charAt(ret_input.length() - 1);
        ret_input = ret_input.substring(0, ret_input.length() - 1); //oøíznutí instrukèního znaku

        switch (instr_znak) {
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
                StringBuffer ret_output_buff = new StringBuffer(ret_input.length());
                char znak;

                for (int i = 0; i < ret_input.length(); i++) {
                    znak = ret_input.charAt(i);
                    if (Character.isLowerCase(znak)) {
                        znak = Character.toUpperCase(znak);
                    } else {
                        znak = Character.toLowerCase(znak);
                    }
                    ret_output_buff.append(znak);
                }
                System.out.println("X: " + ret_output_buff);
            }
            break;
            default: System.out.println("Zadána ¹patná koncovka øetìzce.");
            break;
        }*/

        //cvièení 4
        tiskPI(15);
        //System.out.println(Math.PI);
    }
}
