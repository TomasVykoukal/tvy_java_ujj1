package org.example;
import java.io.*;

//podmno¾ina è. 2 (kompletní o¹etøení výjimky) - specifika viz ní¾e
public class Kap_16_Vyjimka_2_2 {
    public static int ctiInt() {
        byte[] pole = new byte[20];
        String nacteno;
        int i = 0;

        try {
            System.in.read(pole);
            nacteno = new String(pole).trim();
            i = Integer.valueOf(nacteno).intValue();
        }
        catch (IOException e) {
            //¾ádný kód //naprosto nejhor¹í reakce na výjimku
            e.printStackTrace(); //rozumná reakce na výjimku
        }
        catch (NumberFormatException e) {
            //¾ádný kód //naprosto nejhor¹í reakce na výjimku
            e.printStackTrace(); //rozumná reakce na výjimku

            //dal¹í metody
            String msg = e.getMessage();
            System.out.println("getMessage: " + msg);
            msg = e.getLocalizedMessage();
            System.out.println("getLocalizedMessage: " + msg);
            msg = e.toString();
            System.out.println("e.toString: " + msg);
            msg = e.getClass().toString();
            System.out.println("getClass().toString(): " + msg);
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.print("Zadej poèet cihel: ");
        int i = ctiInt();
        System.out.println("Cihel je: " + i);
    }
}
