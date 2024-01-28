package org.example;
import java.io.*;

public class Kap_4_VstupInt {
    public static int ctiInt() {
        byte[] pole = new byte[20];
        //byte pole[] = new byte[20]; //jde tak�
        String nacteno;
        int i;

        try { //je-li vynech�no => java: unreported exception java.io.IOException; must be caught or declared to be thrown
            System.in.read(pole);
            nacteno = new String(pole).trim();
            i = Integer.valueOf(nacteno).intValue(); //{Boolean|Byte|Short|...}.valueOf("...") - stat. met.; vrac� �et�zec zkonvertovan� na objekt t��dy p��sl. datov�ho typu
            return i;                                //.{booleanValue|byteValue|shortValue|...}() - tuto t��du p�ev�d� na odpov�daj�c� z�kladn� datov� typ
        }
        catch (NumberFormatException e) {
            System.out.print("��slo " + e.getMessage());
            System.out.println(" nebylo zad�no dob�e.");
            //e.printStackTrace(); //-->v�pis viz Kap_16_PocetCihel
            return 0;
        }
        catch (IOException e) {
            System.out.println("Chyba �ten�");
            return 0;
        }
    }
    public static void main(String[] args) {
        System.out.print("Zadej cel� ��slo INT: ");
        int i = ctiInt();
        System.out.println("i = " + i);
    }
}
