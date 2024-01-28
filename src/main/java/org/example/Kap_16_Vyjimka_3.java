package org.example;
import java.io.*;

//o�et�en� v�jimky a n�sledn� p�ed�n� v��e
public class Kap_16_Vyjimka_3 {
    public static int ctiInt() throws IOException, NumberFormatException {
        byte[] pole = new byte[20];
        String nacteno;
        int i;

        try {
            System.in.read(pole);
            nacteno = new String(pole).trim();
            i = Integer.valueOf(nacteno).intValue();
            return i;
        }
        catch (IOException e) {
            System.out.println("Chyba p�i �ten�");
            throw e;
        }
        catch (NumberFormatException e) {
            System.out.println("Chyba form�tu");
            throw e;
        }
    }

    public static void main(String[] args) {
        System.out.print("Zadej po�et cihel: ");
        try {
            int i = ctiInt();
            System.out.println("Cihel je " + i);
        }
        catch (IOException e) {
            System.out.println("Program neprob�hl spr�vn� (I/O probl�m).");
        }
        catch (NumberFormatException e) {
            System.out.println("Program neprob�hl spr�vn� (form�tovac� probl�m).");
        }
    }
}
