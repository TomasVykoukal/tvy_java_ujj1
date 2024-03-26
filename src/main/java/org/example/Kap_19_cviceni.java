package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Kap_19_cviceni {

    public static void main(String[] args) throws IOException {
        //cvi�en� 1
        System.out.println("cvi�en� 1");
        Kap_19_cviceni ja = new Kap_19_cviceni();
        System.out.println("Program: " + ja.getClass().getName());
        System.out.println("Po�et parametr�: " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println("1. param.: " + args[i]);
        }
        /*PS C:\Doku\Know-How\git\tvy_spielwiese\src\main\java\org\example> java .\Kap_19_cviceni.java soubor.ext
          Program: org.example.Kap_19_cviceni
          Po?et parametr?: 1
          1. param.: soubor.ext
          PS C:\Doku\Know-How\git\tvy_spielwiese\src\main\java\org\example> */

        //cvi�en� 2
        System.out.println("\ncvi�en� 2 (text. generovat cel� ��sla --> text. soubor bez/s buff) 18.4.1");
        System.out.println("- varianta bez vyrovn�vac� pam�ti");
        File fwJm3 = new File("19_cvic_pole.txt");
        FileWriter fw3 = new FileWriter(fwJm3);
        long tzac = System.currentTimeMillis();
        for (int i = 1; i <= 10_000; i++) {
            if (i % 10 != 0) {
                //System.out.print(i + ", ");
                fw3.write(Integer.toString(i) + ", ");
            }
            else {
                //System.out.println(i);
                fw3.write(Integer.toString(i) + "\n"); //alternativa k BufferedWriter.newLine
            }
        }
        long tkon = System.currentTimeMillis();
        System.out.println("doba trv�n� nebuf. v�stupu: " + (tkon - tzac) + " ms");
        fw3.close();

        System.out.println("- varianta s vyrovn�vac� pam�t� (18.4.10)");
        File fwJm3buff = new File("19_cvic_pole_buff.txt");
        FileWriter fw3buff = new FileWriter(fwJm3buff);
        BufferedWriter bw3buff = new BufferedWriter(fw3buff);
        tzac = System.currentTimeMillis();
        for (int i = 1; i <= 10_000; i++) {
            if (i % 10 != 0) {
                //System.out.print(i + ", ");
                bw3buff.write(Integer.toString(i) + ", ");
            }
            else {
                //System.out.println(i);
                bw3buff.write(Integer.toString(i) + "\n");
            }
        }
        tkon = System.currentTimeMillis();
        System.out.println("doba trv�n� buf. v�stupu: " + (tkon - tzac) + " ms");
        bw3buff.close();

        //cvi�en� 3
        System.out.println("\ncvi�en� 3");
        System.out.println("verze p�eklada�e Java: " + System.getProperty("java.version"));
    }
}
