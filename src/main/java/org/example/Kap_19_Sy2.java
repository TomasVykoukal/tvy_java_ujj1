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

        System.out.println((new Date()) + " Out p�ed p�esm�rov�n�m");
        System.err.println((new Date()) + " Err p�ed p�esm�rov�n�m");

        System.setOut(pout);
        System.setErr(perr);
        System.out.println((new Date()) + " Out po p�esm�rov�n�");
        System.err.println((new Date()) + " Err po p�esm�rov�n�");
        fout.flush();
        ferr.flush();

        //throw new IOException(); //vyhozen� v�jimky, kter� se zap�e do souboru chyby.log
                                   //nen�-li vykomentov�na => C:\Doku\Know-How\git\tvy_spielwiese\src\main\java\org\example\Kap_19_Sy2.java:28:9 java: unreachable statement

        System.setOut(new PrintStream(new FileOutputStream(java.io.FileDescriptor.out))); //zp�tn� p�esm�rov�n� na standardn� v�stupn� proud (zdroj: Stackoverflow)
        System.setErr(new PrintStream(new FileOutputStream(java.io.FileDescriptor.err))); //dtto

        System.out.println((new Date()) + " Out po zp�tn�m p�esm�rov�n�");
        System.out.println();
        System.getProperties().list(System.out);
        System.out.println();
        System.err.println((new Date()) + " Err po zp�tn�m p�esm�rov�n�");
    }
}
