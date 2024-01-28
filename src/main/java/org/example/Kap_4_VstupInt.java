package org.example;
import java.io.*;

public class Kap_4_VstupInt {
    public static int ctiInt() {
        byte[] pole = new byte[20];
        //byte pole[] = new byte[20]; //jde také
        String nacteno;
        int i;

        try { //je-li vynecháno => java: unreported exception java.io.IOException; must be caught or declared to be thrown
            System.in.read(pole);
            nacteno = new String(pole).trim();
            i = Integer.valueOf(nacteno).intValue(); //{Boolean|Byte|Short|...}.valueOf("...") - stat. met.; vrací øetìzec zkonvertovaný na objekt tøídy pøísl. datového typu
            return i;                                //.{booleanValue|byteValue|shortValue|...}() - tuto tøídu pøevádí na odpovídající základní datový typ
        }
        catch (NumberFormatException e) {
            System.out.print("Èíslo " + e.getMessage());
            System.out.println(" nebylo zadáno dobøe.");
            //e.printStackTrace(); //-->výpis viz Kap_16_PocetCihel
            return 0;
        }
        catch (IOException e) {
            System.out.println("Chyba ètení");
            return 0;
        }
    }
    public static void main(String[] args) {
        System.out.print("Zadej celé èíslo INT: ");
        int i = ctiInt();
        System.out.println("i = " + i);
    }
}
