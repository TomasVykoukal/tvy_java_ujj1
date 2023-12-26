package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Kap_5_cviceni {
    public static void main(String[] args) {
        //cvièení 1
        /*System.out.print("Zadej první celé èislo: ");
        int c1_1 = Kap_4_VstupInt.ctiInt();
        System.out.print("Zadej druhé celé èislo (odli¹né od prvního): ");
        int c1_2 = Kap_4_VstupInt.ctiInt();
        System.out.println();
        System.out.println("Men¹í èíslo: " + (c1_1 > c1_2 ? c1_2 : c1_1));
        System.out.println("Vìt¹í èíslo: " + (c1_1 > c1_2 ? c1_1 : c1_2));*/

        //cvièení 2
        /*byte[] pole2 = new byte[2];
        String nacteno2;
        int c2;
        System.out.print("Zadej ¹estnáctkové èislo ({0..9|a..f|A..F}^2: ");
        try {
            System.in.read(pole2);
            nacteno2 = new String(pole2).trim();
            c2 = Integer.parseInt(nacteno2, 16);
        }
        catch (NumberFormatException e) {
            System.out.print("Èíslo " + e.getMessage());
            System.out.println(" nebylo zadáno dobøe.");
            return;
        }
        catch (IOException e) {
            System.out.println("Chyba ètení");
            return;
        }
        System.out.println("Zadáno bylo: " + nacteno2);
        System.out.println("Zadané èíslo dekadicky: " + c2);*/

        //Test SCANNER
        /*Scanner sc2 = new Scanner(System.in);
        System.out.print("Zadejte najednou dva znaky: ");
        String s2 = sc2.nextLine();
        char c2_1 = s2.charAt(0);
        char c2_2 = s2.charAt(1);
        System.out.println("s2: " + s2 + "; c2_1: " + c2_1 + ", c2_2: " + c2_2);*/

        //cvièení 3
        char c3;
        //Varianta s WHILE, kdy se ukonèovací znak ji¾ nevyhodnotí
        /*System.out.print("Zadejte znak: ");
        while ((c3 = Kap_4_VstupZnaku.ctiZnak()) != '?') {
            if (c3 != '\n') {
                if (c3 < '0' || (c3 > '9' & c3 < 'A') || (c3 > 'Z' & c3 < 'a') || c3 > 'z')
                    System.out.println("Interpunkèní znak");
                else System.out.println("Alfanumerický znak");
                System.out.print("Zadejte znak: ");
            }
        };*/
        //Varianta s DO-WHILE, kdy se ukonèovací znak je¹tì vyhodnotí
        /*System.out.print("Zadejte znak: ");
        do {
            c3 = Kap_4_VstupZnaku.ctiZnak();
            if (c3 != '\n') {
                if (c3 < '0' || (c3 > '9' & c3 < 'A') || (c3 > 'Z' & c3 < 'a') || c3 > 'z')
                    System.out.println("Interpunkèní znak");
                else System.out.println("Alfanumerický znak");
                if (c3 != '?') {
                    System.out.print("Zadejte znak: ");
                }
            }
        } while (c3 != '?');*/

        //cvièení 4
        /*System.out.print("Zadejte délku obdélníka: ");
        int del4 = Kap_4_VstupInt.ctiInt();
        System.out.print("Zadejte ¹íøku obdélníka: ");
        int sir4 = Kap_4_VstupInt.ctiInt();
        System.out.println("Zadána délka a ¹íøka " + del4 + " a " + sir4);

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
        }*/

        //cvièení 5
        /*int i5;
        int i5_pocet = 0;
        int i5_max = Integer.MIN_VALUE;
        System.out.println("Zadejte øadu celých èísel ukonèenou nulou.");
        System.out.print((i5_pocet + 1) + ". èíslo: ");
        while ((i5 = Kap_4_VstupInt.ctiInt()) != 0) {
            i5_pocet++;
            if (i5 > i5_max)
                i5_max = i5;
            System.out.print((i5_pocet + 1) + ". èíslo: ");
        }
        System.out.println("Maximum ze zadaných " + i5_pocet + " èísel: " + i5_max);*/

        //cvièení 6
        /*int cislo6;
        int i6_pocet_int = 0;
        System.out.print("Zadejte poèet zadávaných celých èísel: ");
        int i6_pocet = Kap_4_VstupInt.ctiInt();
        for (int i6 = 1; i6 <= i6_pocet; i6++) {
            System.out.print("Zadejte èíslo " + i6 + " / " + i6_pocet + ": ");
            cislo6 = Kap_4_VstupInt.ctiInt();
            if (cislo6 >= 18 & cislo6 <= 32) i6_pocet_int++;
        }
        System.out.println("V intervalu <18; 32> le¾í " + i6_pocet_int + " èísel ze zadaných " + i6_pocet + " èísel.");*/

        //cvièení 7
        /*System.out.print("Zadejte celé èíslo INT: ");
        int cislo7 = Kap_4_VstupInt.ctiInt();
        String str7 = Integer.toString(cislo7);
        System.out.println("Bylo zadáno èíslo " + cislo7 + " o délce " + str7.length() + ".");
        for (int i7 = 0; i7 < str7.length(); i7++)
            System.out.print(str7.charAt(i7) + "  ");
        System.out.println();*/

        //cvièení 8
        //dle autorského øe¹ení:
        /*double e1 = 1.0, stareE = 0.0;
        int f = 1, i1 = 1;

        while (Math.abs(e1 - stareE) > 1e-7) {
            stareE = e1;
            f *= i1;
            e1 += 1.0 / (double) f;
            i1++;
        }
        System.out.println("Vypoètené e: " + e1 + " (aut. øe¹ení)");*/

        //vlastní øe¹ení:
        /*Double e = 0., inkrE = 1.; //iniciaèní hodnota inkr.: 1/0! tj. 1
        int i = 0;
        while (inkrE > 1e-15) { //exponent oproti zadání -7 zmìnìn na -15 pro vìt¹í pøesnost
            e = e + inkrE;
            inkrE = inkrE/++i; //první iterace: inkr. = 1/1! tj. 1 (kum. 2), dal¹í iterace: 1/i! (algoritmicky: pøedch. inkr. * 1/i)
        }
        System.out.println("Vypoètené e: " + e);
        System.out.println("Knihovní  e: " + Math.E);*/

        //cvièení 9
        for (int i9 = 1; i9 <= 11; i9++) {
            switch (i9) {
                //DEFAULT mù¾e být i zde a funguje stále správnì
                case  1: System.out.println("i9: " + i9 + " / Case  1"); break;
                case  2: System.out.println("i9: " + i9 + " / Case  2"); break;
                case  3: System.out.println("i9: " + i9 + " / Case  3"); break;
                case  4: System.out.println("i9: " + i9 + " / Case  4"); break;
                case  5: System.out.println("i9: " + i9 + " / Case  5"); break;
                case  6: System.out.println("i9: " + i9 + " / Case  6"); break;
                case  7: System.out.println("i9: " + i9 + " / Case  7"); break;
                case  8: System.out.println("i9: " + i9 + " / Case  8"); break;
                case  9: System.out.println("i9: " + i9 + " / Case  9"); break;
                case 10: System.out.println("i9: " + i9 + " / Case 10"); break;
                default: System.out.println("i9: " + i9 + " tj. jiná ne¾ 1-10 / Default"); break;
            }
        }
    }
}
