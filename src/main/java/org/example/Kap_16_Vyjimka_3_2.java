package org.example;
import java.io.*;

//podmno¾ina è. 3 (o¹etøení výjimky a následné pøedání vý¹e) - seskupování výjimek
public class Kap_16_Vyjimka_3_2 {
    public static int ctiInt() throws IOException {

        while (true) {
            try {
                byte[] pole = new byte[20];
                System.in.read(pole);
                String nacteno = new String(pole).trim();
                int i = Integer.valueOf(nacteno).intValue();
                if (i <= 0) {
                    throw new IOException(); //vyvolání výjimky
                }
                return i;
            }
            catch (NumberFormatException e) {
                System.out.print("Èíslo " + e.getMessage());
                System.out.println(" nebylo zadáno dobøe.");
                System.out.print("Zkuste to znovu: ");
            }
            catch (IOException e) {
                System.out.println("Chyba ètení");
                throw e;
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("Zadej poèet cihel: ");
        try {
            int i = ctiInt();
            System.out.println("Cihel je " + i);
        }
        catch (IOException e) {
            System.out.println("Program neprobìhl správnì (I/O problém).");
        }
    }
}
