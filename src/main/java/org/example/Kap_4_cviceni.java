package org.example;

import java.io.IOException;

public class Kap_4_cviceni {
    public static void main(String[] args) {
        //cvičení 1
        /*try {
            System.out.print("(Kap. 4, cvič. 1) Zadej znak: ");
            char c1_in = (char) System.in.read();
            byte b1 = (byte) c1_in;
            char c1_out = (char) (b1 + 1);
            System.out.println("Výsledný znak (vstup + 1): " + c1_out);
        }
        catch (IOException e) {
            System.out.println("Chyba I/O");
        }*/

        //cvičení 2
        /*try {
            System.out.print("(Kap. 4, cvič. 2) Zadej znak: ");
            char c2_in = (char) System.in.read();
            byte b2 = (byte) c2_in;
            System.out.println("Zadaný znak " + c2_in + " (Unicode hodn. v des. soust.): " + b2);
        }
            catch (IOException e) {
            System.out.println("Chyba I/O");
        }*/

        //cvičení 3
        /*float f3_dan = (float) .25; //n. %čís.%f jinak "java: incompatible types: possible lossy conversion from double to float"
        System.out.print("(Kap. 4, cvič. 3) Zadejte cenu bez daně: ");
        float f3_in = Kap_4_VstupFloat.ctiFloat();
        float f3_out = f3_in * (1 + f3_dan);
        System.out.println("Prodejní cena s daní (" + (f3_dan * 100) + " %): " + f3_out);*/

        //cvičení 4
        /*System.out.print("(Kap. 4, cvič. 4) Zadejte reálné číslo: ");
        float f4_in = Kap_4_VstupFloat.ctiFloat();
        long l4_out = (long) f4_in;
        System.out.println("... jeho celá část: " + l4_out);*/

        //cvičení 5
        /*char c5_in;
        byte b5_in;
        char c5_out;
        System.out.print("(Kap. 4, cvič. 5) Zadejte tři malá písmena: ");
        for (int i = 1; i <= 3; i++) {
            try {
                c5_in = Kap_4_VstupZnaku.ctiZnak();
                System.out.println("*** " + i + ". znak: ***");
                b5_in = (byte) c5_in;
                System.out.println("  Zadáno: " + c5_in + " (" + b5_in + ")");
                if (b5_in < 97 || b5_in > 122){
                    throw new Kap_4_MalePism_Exception();
                }
                b5_in -= 32;
                c5_out = (char) b5_in;
                System.out.println("  Výstup: " + c5_out);
            }
            catch (Kap_4_MalePism_Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Výtisk trasování zásobníku:");
                e.printStackTrace();
            }
        }*/

        //cvičení 6
        int[] poleInt = new int[5];
        int soucet = 0, soucin = 1, maxcis = Integer.MIN_VALUE, mincis = Integer.MAX_VALUE;
        float prumer = 0;
        for (int i = 0; i < poleInt.length; i++) {
            System.out.print("Zadejte " + (i+1) + "/" + poleInt.length + " celé číslo: ");
            poleInt[i] = Kap_4_VstupInt.ctiInt();
        }
        System.out.println("Zadávání čísel ukončeno.");

        for (int i = 0; i < poleInt.length; i++) {
            soucet += poleInt[i];
        }
        System.out.println("Součet zadaných čísel: " + soucet);

        for (int i = 0; i < poleInt.length; i++) {
            soucin *= poleInt[i];
        }
        System.out.println("Součin zadaných čísel: " + soucin);

        prumer = soucet/poleInt.length;
        System.out.println("Průměr zadaných čísel: " + prumer);

        for (int i = 0; i < poleInt.length; i++) {
            if (poleInt[i] > maxcis) maxcis = poleInt[i];
        }
        System.out.println("Nejvyšší ze zadaných čísel: " + maxcis);

        for (int i = 0; i < poleInt.length; i++) {
            if (poleInt[i] < mincis) mincis = poleInt[i];
        }
        System.out.println("Nejnižší ze zadaných čísel: " + mincis);
    }
}