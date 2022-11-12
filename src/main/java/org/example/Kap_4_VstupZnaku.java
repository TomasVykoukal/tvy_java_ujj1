package org.example;
import javax.lang.model.type.NullType;
import java.io.*;

public class Kap_4_VstupZnaku {
    //varianta s. 72
    /*public static void main(String[] args) throws IOException {
        System.out.print("Zadej znak: ");
        char c = (char) System.in.read();
        System.out.println("c = " + c);
    }*/

    //varianta s. 73
    public static char ctiZnak() {
        try {
            return (char) System.in.read();
        }
        catch (IOException e) {
            return '\uFFFF'; //?
        }
    }

    //vlastní varianta s očištěním nového řádku
    public static char ctiZnakOcist() {
        byte[] pole = new byte[1];
        String nacteno;
        try {
            System.in.read(pole);
            nacteno = new String(pole).trim();
            if (nacteno.length() == 1)
                return nacteno.charAt(0);
            else
                return '\uFFFF'; //nouzové řešení, ptz. se nepodařilo vrátit NULL apod.
        }
        catch (IOException e) {
            System.out.println("Chyba čtení");
            return '\uFFFF';
        }
    }

    public static void main(String[] args) {
        /*System.out.println("Odřádkování: " + System.getProperty("line.separator"));
        System.out.print("ctiZnak: Zadej znak: ");
        char c = ctiZnak();
        System.out.println("c = " + c);
        c = ctiZnak();*/ //neutralizace nového řádku
        System.out.print("ctiZnakOcist: Zadej znak: ");
        char c = ctiZnakOcist();
        System.out.println("c = " + c);
    }
}
