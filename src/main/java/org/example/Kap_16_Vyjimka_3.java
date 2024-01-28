package org.example;
import java.io.*;

//o¹etøení výjimky a následné pøedání vý¹e
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
            System.out.println("Chyba pøi ètení");
            throw e;
        }
        catch (NumberFormatException e) {
            System.out.println("Chyba formátu");
            throw e;
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
        catch (NumberFormatException e) {
            System.out.println("Program neprobìhl správnì (formátovací problém).");
        }
    }
}
