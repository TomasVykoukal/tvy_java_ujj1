package org.example;
import java.io.*;

//pøedání výjimky vý¹e - deklarace výjimky
public class Kap_16_Vyjimka_1 {
    public static int ctiInt() throws IOException, NumberFormatException {
        byte[] pole = new byte[20];
        String nacteno;
        int i;

        System.in.read(pole);
        nacteno = new String(pole).trim();
        i = Integer.valueOf(nacteno).intValue();
        return i;
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        System.out.print("Zadej poèet cihel: ");
        int i = ctiInt();
        System.out.println("Cihel je: " + i);
    }
}
