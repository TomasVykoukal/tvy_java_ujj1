package org.example;
import java.io.*;

public class Kap_4_VstupInt {
    public static int ctiInt() {
        byte[] pole = new byte[20];
        //byte pole[] = new byte[20]; //jde také
        String nacteno;
        int i;

        try {
            System.in.read(pole);
            nacteno = new String(pole).trim();
            i = Integer.valueOf(nacteno).intValue(); //{Boolean|Byte|Short|...}.valueOf("...") - stat. met.; vrací řetězec zkonvertovaný na objekt třídy přísl. datového typu
            return i;                                //.{booleanValue|byteValue|shortValue|...}() - tuto třídu převádí na odpovídající základní datový typ
        }
        catch (NumberFormatException e) {
            System.out.print("Číslo " + e.getMessage());
            System.out.println(" nebylo zadáno dobře.");
            return 0;
        }
        catch (IOException e) {
            System.out.println("Chyba čtení");
            return 0;
        }
    }
    public static void main(String[] args) {
        System.out.print("Zadej celé číslo INT: ");
        int i = ctiInt();
        System.out.println("i = " + i);
    }
}
