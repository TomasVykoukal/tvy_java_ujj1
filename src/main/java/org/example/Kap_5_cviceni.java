package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Kap_5_cviceni {
    public static void main(String[] args) {
        //cvi�en� 1
        /*System.out.print("Zadej prvn� cel� �islo: ");
        int c1_1 = Kap_4_VstupInt.ctiInt();
        System.out.print("Zadej druh� cel� �islo (odli�n� od prvn�ho): ");
        int c1_2 = Kap_4_VstupInt.ctiInt();
        System.out.println();
        System.out.println("Men�� ��slo: " + (c1_1 > c1_2 ? c1_2 : c1_1));
        System.out.println("V�t�� ��slo: " + (c1_1 > c1_2 ? c1_1 : c1_2));*/

        //cvi�en� 2
        /*byte[] pole2 = new byte[2];
        String nacteno2;
        int c2;
        System.out.print("Zadej �estn�ctkov� �islo ({0..9|a..f|A..F}^2: ");
        try {
            System.in.read(pole2);
            nacteno2 = new String(pole2).trim();
            c2 = Integer.parseInt(nacteno2, 16);
        }
        catch (NumberFormatException e) {
            System.out.print("��slo " + e.getMessage());
            System.out.println(" nebylo zad�no dob�e.");
            return;
        }
        catch (IOException e) {
            System.out.println("Chyba �ten�");
            return;
        }
        System.out.println("Zad�no bylo: " + nacteno2);
        System.out.println("Zadan� ��slo dekadicky: " + c2);*/

        //Test SCANNER
        /*Scanner sc2 = new Scanner(System.in);
        System.out.print("Zadejte najednou dva znaky: ");
        String s2 = sc2.nextLine();
        char c2_1 = s2.charAt(0);
        char c2_2 = s2.charAt(1);
        System.out.println("s2: " + s2 + "; c2_1: " + c2_1 + ", c2_2: " + c2_2);*/

        //cvi�en� 3
        char c3;
        //Varianta s WHILE, kdy se ukon�ovac� znak ji� nevyhodnot�
        /*System.out.print("Zadejte znak: ");
        while ((c3 = Kap_4_VstupZnaku.ctiZnak()) != '?') {
            if (c3 != '\n') {
                if (c3 < '0' || (c3 > '9' & c3 < 'A') || (c3 > 'Z' & c3 < 'a') || c3 > 'z')
                    System.out.println("Interpunk�n� znak");
                else System.out.println("Alfanumerick� znak");
                System.out.print("Zadejte znak: ");
            }
        };*/
        //Varianta s DO-WHILE, kdy se ukon�ovac� znak je�t� vyhodnot�
        /*System.out.print("Zadejte znak: ");
        do {
            c3 = Kap_4_VstupZnaku.ctiZnak();
            if (c3 != '\n') {
                if (c3 < '0' || (c3 > '9' & c3 < 'A') || (c3 > 'Z' & c3 < 'a') || c3 > 'z')
                    System.out.println("Interpunk�n� znak");
                else System.out.println("Alfanumerick� znak");
                if (c3 != '?') {
                    System.out.print("Zadejte znak: ");
                }
            }
        } while (c3 != '?');*/

        //cvi�en� 4
        /*System.out.print("Zadejte d�lku obd�ln�ka: ");
        int del4 = Kap_4_VstupInt.ctiInt();
        System.out.print("Zadejte ���ku obd�ln�ka: ");
        int sir4 = Kap_4_VstupInt.ctiInt();
        System.out.println("Zad�na d�lka a ���ka " + del4 + " a " + sir4);

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

        //cvi�en� 5
        /*int i5;
        int i5_pocet = 0;
        int i5_max = Integer.MIN_VALUE;
        System.out.println("Zadejte �adu cel�ch ��sel ukon�enou nulou.");
        System.out.print((i5_pocet + 1) + ". ��slo: ");
        while ((i5 = Kap_4_VstupInt.ctiInt()) != 0) {
            i5_pocet++;
            if (i5 > i5_max)
                i5_max = i5;
            System.out.print((i5_pocet + 1) + ". ��slo: ");
        }
        System.out.println("Maximum ze zadan�ch " + i5_pocet + " ��sel: " + i5_max);*/

        //cvi�en� 6
        /*int cislo6;
        int i6_pocet_int = 0;
        System.out.print("Zadejte po�et zad�van�ch cel�ch ��sel: ");
        int i6_pocet = Kap_4_VstupInt.ctiInt();
        for (int i6 = 1; i6 <= i6_pocet; i6++) {
            System.out.print("Zadejte ��slo " + i6 + " / " + i6_pocet + ": ");
            cislo6 = Kap_4_VstupInt.ctiInt();
            if (cislo6 >= 18 & cislo6 <= 32) i6_pocet_int++;
        }
        System.out.println("V intervalu <18; 32> le�� " + i6_pocet_int + " ��sel ze zadan�ch " + i6_pocet + " ��sel.");*/

        //cvi�en� 7
        /*System.out.print("Zadejte cel� ��slo INT: ");
        int cislo7 = Kap_4_VstupInt.ctiInt();
        String str7 = Integer.toString(cislo7);
        System.out.println("Bylo zad�no ��slo " + cislo7 + " o d�lce " + str7.length() + ".");
        for (int i7 = 0; i7 < str7.length(); i7++)
            System.out.print(str7.charAt(i7) + "  ");
        System.out.println();*/

        //cvi�en� 8
        //dle autorsk�ho �e�en�:
        /*double e1 = 1.0, stareE = 0.0;
        int f = 1, i1 = 1;

        while (Math.abs(e1 - stareE) > 1e-7) {
            stareE = e1;
            f *= i1;
            e1 += 1.0 / (double) f;
            i1++;
        }
        System.out.println("Vypo�ten� e: " + e1 + " (aut. �e�en�)");*/

        //vlastn� �e�en�:
        /*Double e = 0., inkrE = 1.; //inicia�n� hodnota inkr.: 1/0! tj. 1
        int i = 0;
        while (inkrE > 1e-15) { //exponent oproti zad�n� -7 zm�n�n na -15 pro v�t�� p�esnost
            e = e + inkrE;
            inkrE = inkrE/++i; //prvn� iterace: inkr. = 1/1! tj. 1 (kum. 2), dal�� iterace: 1/i! (algoritmicky: p�edch. inkr. * 1/i)
        }
        System.out.println("Vypo�ten� e: " + e);
        System.out.println("Knihovn�  e: " + Math.E);*/

        //cvi�en� 9
        for (int i9 = 1; i9 <= 11; i9++) {
            switch (i9) {
                //DEFAULT m��e b�t i zde a funguje st�le spr�vn�
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
                default: System.out.println("i9: " + i9 + " tj. jin� ne� 1-10 / Default"); break;
            }
        }
    }
}
