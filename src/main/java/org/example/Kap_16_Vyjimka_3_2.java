package org.example;
import java.io.*;

//podmno�ina �. 3 (o�et�en� v�jimky a n�sledn� p�ed�n� v��e) - seskupov�n� v�jimek
public class Kap_16_Vyjimka_3_2 {
    public static int ctiInt() throws IOException {

        while (true) {
            try {
                byte[] pole = new byte[20];
                System.in.read(pole);
                String nacteno = new String(pole).trim();
                int i = Integer.valueOf(nacteno).intValue();
                if (i <= 0) {
                    throw new IOException(); //vyvol�n� v�jimky
                }
                return i;
            }
            catch (NumberFormatException e) {
                System.out.print("��slo " + e.getMessage());
                System.out.println(" nebylo zad�no dob�e.");
                System.out.print("Zkuste to znovu: ");
            }
            catch (IOException e) {
                System.out.println("Chyba �ten�");
                throw e;
            }
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
    }
}
