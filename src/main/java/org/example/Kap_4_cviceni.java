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
        System.out.print("(Kap. 4, cvič. 4) Zadejte reálné číslo: ");
        float f4_in = Kap_4_VstupFloat.ctiFloat();
        long l4_out = (long) f4_in;
        System.out.println("... jeho celá část: " + l4_out);


    }
}
