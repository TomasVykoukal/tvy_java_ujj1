package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Kap_19_Sy2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fout = new FileOutputStream("19_vypisy.txt");
        PrintStream pout = new PrintStream(fout);
        FileOutputStream ferr = new FileOutputStream("19_chyby.log");
        PrintStream perr = new PrintStream(ferr);

        System.out.println((new Date()) + " Out pøed pøesmìrováním");
        System.err.println((new Date()) + " Err pøed pøesmìrováním");

        System.setOut(pout);
        System.setErr(perr);
        System.out.println((new Date()) + " Out po pøesmìrování");
        System.err.println((new Date()) + " Err po pøesmìrování");
        fout.flush();
        ferr.flush();

        //throw new IOException(); //vyhození výjimky, která se zapí¹e do souboru chyby.log
                                   //není-li vykomentována => C:\Doku\Know-How\git\tvy_spielwiese\src\main\java\org\example\Kap_19_Sy2.java:28:9 java: unreachable statement

        System.setOut(new PrintStream(new FileOutputStream(java.io.FileDescriptor.out))); //zpìtné pøesmìrování na standardní výstupní proud (zdroj: Stackoverflow)
        System.setErr(new PrintStream(new FileOutputStream(java.io.FileDescriptor.err))); //dtto

        System.out.println((new Date()) + " Out po zpìtném pøesmìrování");
        System.out.println();
        System.getProperties().list(System.out);
        System.out.println();
        System.err.println((new Date()) + " Err po zpìtném pøesmìrování");
    }
}
