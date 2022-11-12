package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Kap_5_cviceni {
    public static void main(String[] args) {
        //cvičení 1
        /*System.out.print("Zadej první celé čislo: ");
        int c1_1 = Kap_4_VstupInt.ctiInt();
        System.out.println();
        System.out.print("Zadej druhé celé čislo (odlišné od prvního): ");
        int c1_2 = Kap_4_VstupInt.ctiInt();
        System.out.println();
        System.out.println("Menší číslo: " + (c1_1 > c1_2 ? c1_2 : c1_1));
        System.out.println("Větší číslo: " + (c1_1 > c1_2 ? c1_1 : c1_2));*/

        //cvičení 2
        /*byte[] pole2 = new byte[2];
        String nacteno2;
        int c2;
        System.out.print("Zadej šestnáctkové čislo ({0..9|a..f|A..F}^2: ");
        try {
            System.in.read(pole2);
            nacteno2 = new String(pole2).trim();
            c2 = Integer.parseInt(nacteno2, 16);
        }
        catch (NumberFormatException e) {
            System.out.print("Číslo " + e.getMessage());
            System.out.println(" nebylo zadáno dobře.");
            return;
        }
        catch (IOException e) {
            System.out.println("Chyba čtení");
            return;
        }
        System.out.println("Zadáno bylo: " + nacteno2);
        System.out.println("Zadané číslo dekadicky: " + c2);*/

        //Test SCANNER
        /*Scanner sc2 = new Scanner(System.in);
        System.out.print("Zadejte najednou dva znaky: ");
        String s2 = sc2.nextLine();
        sc2.
        char c2_1 = s2.charAt(0);
        char c2_2 = s2.charAt(1);
        System.out.println("s2: " + s2 + "; c2_1: " + c2_1 + ", c2_2: " + c2_2);*/

        //cvičení 3
        char c3;
        //Varianta s WHILE, kdy se ukončovací znak již nevyhodnotí
        /*System.out.print("Zadejte znak: ");
        while ((c3 = Kap_4_VstupZnaku.ctiZnak()) != '?') {
            if (c3 != '\n') {
                if (c3 < '0' || (c3 > '9' & c3 < 'A') || (c3 > 'Z' & c3 < 'a') || c3 > 'z')
                    System.out.println("Interpunkční znak");
                else System.out.println("Alfanumerický znak");
                System.out.print("Zadejte znak: ");
            }
        };*/
        //Varianta s DO-WHILE, kdy se ukončovací znak ještě vyhodnotí
        /*System.out.print("Zadejte znak: ");
        do {
            c3 = Kap_4_VstupZnaku.ctiZnak();
            if (c3 != '\n') {
                if (c3 < '0' || (c3 > '9' & c3 < 'A') || (c3 > 'Z' & c3 < 'a') || c3 > 'z')
                    System.out.println("Interpunkční znak");
                else System.out.println("Alfanumerický znak");
                if (c3 != '?') {
                    System.out.print("Zadejte znak: ");
                }
            }
        } while (c3 != '?');*/

        //cvičení 4
        System.out.print("Zadejte délku obdélníka: ");
        int del4 = Kap_4_VstupInt.ctiInt();
        System.out.print("Zadejte šířku obdélníka: ");
        int sir4 = Kap_4_VstupInt.ctiInt();
        System.out.println("Zadána délka a šířka " + del4 + " a " + sir4);

        for (int del_idx = 1; del_idx <= del4; del_idx++) {
            System.out.print('*');
            for (int sir_idx = 1; sir_idx <= (sir4 - 2); sir_idx++) {
                if (del_idx > 1 & del_idx < del4 & sir_idx >= 1 & sir_idx < sir4)
                    System.out.print("  ");
                else
                    System.out.print(" *");
            }
            if (sir4 >= 2)
                System.out.println(" *");
            else
                System.out.println();
        }




    }
}
