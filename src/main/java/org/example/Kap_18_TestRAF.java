package org.example;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Kap_18_TestRAF {
    public static void main(String[] args) throws IOException {
        //18.7 soubory s náhodným pøístupem (RAF = RandomAccessFile)
        System.out.println("18.7 soubory s náhodným pøístupem (RAF = RandomAccessFile)");
        RandomAccessFile frw = new RandomAccessFile("18_7_a.bin", "rw");
        int k13, pocet13 = 5;
        long posun13;
        /*argument "r" ->
          Exception in thread "main" java.io.IOException: Zugriff verweigert
	          at java.base/java.io.RandomAccessFile.write0(Native Method)
	          at java.base/java.io.RandomAccessFile.write(RandomAccessFile.java:522)
	          at java.base/java.io.RandomAccessFile.writeInt(RandomAccessFile.java:1070)
	          at org.example.Kap_18_IoZnaky.main(Kap_18_IoZnaky.java:399)
          argument "wr" ->
          Exception in thread "main" java.lang.IllegalArgumentException: Illegal mode "wr" must be one of "r", "rw", "rws", or "rwd"
  	          at java.base/java.io.RandomAccessFile.<init>(RandomAccessFile.java:238)
	          at java.base/java.io.RandomAccessFile.<init>(RandomAccessFile.java:213)
	          at java.base/java.io.RandomAccessFile.<init>(RandomAccessFile.java:127)
	          at org.example.Kap_18_IoZnaky.main(Kap_18_IoZnaky.java:386)*/

        //zápis do souboru
        System.out.println("- fáze zápis do souboru");
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer());
        System.out.println("Velikost souboru (frw.length()):         " + frw.length());

        System.out.println("\npoèet (stanoven): " + pocet13);
        frw.writeInt(pocet13);
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer());
        System.out.println("Velikost souboru (frw.length()):         " + frw.length() + "\n");

        for (int i = 0; i < pocet13; i++) {
            k13 = (int) (1000.0 * Math.random());
            System.out.print(i + "/" + k13 + " ");
            frw.writeInt(k13);
            System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer());
        }
        System.out.println("Velikost souboru (frw.length()):         " + frw.length());

        System.out.println("\n" + Math.PI);
        frw.writeDouble(Math.PI);
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer());
        System.out.println(Math.E);
        frw.writeDouble(Math.E);
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer());
        System.out.println("Velikost souboru (frw.length()):         " + frw.length());

        //pøeskakovaný výpis obsahu souboru
        System.out.println("\n- fáze pøeskakovaný výpis obsahu souboru");
        frw.seek(0L); //návrat na zaèátek
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer());

        pocet13 = frw.readInt();
        System.out.println("poèet (frw.readInt()): " + pocet13);
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer() + "\n");

        posun13 = 4 * pocet13; //posun pøed posl. int ze smyèky (poèet + øada int dle poètu); velikost int = 4 B;
        frw.seek(posun13);
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer() + "\n");

        frw.writeInt(1234); //pøepsání posledního int v souboru
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer());
        frw.seek(posun13); //pozice mìøena od zaè. souboru
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer() + "\n");

        k13 = frw.readInt();
        System.out.println(k13);
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer() + "\n");

        frw.skipBytes(8); //double je velký 8 B (pøeskok PI)
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer() + "\n");

        double e13 = frw.readDouble();
        System.out.println(e13);
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer());

        //systematický výpis obsahu souboru
        System.out.println("\n- fáze systematický výpis obsahu souboru");
        frw.seek(0);
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer());

        pocet13 = frw.readInt();
        System.out.println("frw.readInt(): " + pocet13);
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer());

        for (int i = 0; i < pocet13; i++) {
            k13 = frw.readInt();
            System.out.print(i + "/" + k13 + " ");
            System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer());
        }

        e13 = frw.readDouble();
        System.out.println("pi: " + e13 + " ");
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer());
        e13 = frw.readDouble();
        System.out.println("e: " + e13 + " ");
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer());
        System.out.println("Velikost souboru (frw.length()):         " + frw.length());

        //sní¾ení délky souboru + test
        System.out.println("\n- sní¾ení délky souboru + test");
        frw.setLength(20);
        frw.seek(0);
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer());
        System.out.println("Velikost souboru (frw.length()):         " + frw.length());

        pocet13 = frw.readInt();
        System.out.println("frw.readInt(): " + pocet13);
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer());

        for (int i = 0; i < 4; i++) {
            k13 = frw.readInt();
            System.out.print(i + "/" + k13 + " ");
            System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer());
        } //=> dosa¾eno konce souboru!

        //k13 = frw.readInt();
        /*Exception in thread "main" java.io.EOFException
            at java.base/java.io.RandomAccessFile.readInt(RandomAccessFile.java:843)
            at org.example.Kap_18_IoZnaky.main(Kap_18_IoZnaky.java:496)*/
        //posun13 = frw.readLong();
        /*Exception in thread "main" java.io.EOFException
            at java.base/java.io.RandomAccessFile.readInt(RandomAccessFile.java:843)
            at java.base/java.io.RandomAccessFile.readLong(RandomAccessFile.java:876)
            at org.example.Kap_18_IoZnaky.main(Kap_18_IoZnaky.java:501)*/
        //e13 = frw.readDouble();
        /*Exception in thread "main" java.io.EOFException
            at java.base/java.io.RandomAccessFile.readInt(RandomAccessFile.java:843)
            at java.base/java.io.RandomAccessFile.readLong(RandomAccessFile.java:876)
            at java.base/java.io.RandomAccessFile.readDouble(RandomAccessFile.java:922)
            at org.example.Kap_18_IoZnaky.main(Kap_18_IoZnaky.java:496)*/

        frw.close();


        //18.7 soubory s náhodným pøístupem (varianta "index øádek")
        System.out.println("\n18.7 soubory s náhodným pøístupem (varianta \"index øádek\")");
        RandomAccessFile fr = new RandomAccessFile("a.txt", "r");
        String radka;
        int pocet = 0;
        long[] ofsety = new long[10];
        ofsety[pocet] = 0;

        System.out.println("- fáze výpis popøedu");
        System.out.println("Pozice v souboru (fr.getFilePointer()): " + fr.getFilePointer());
        while ((radka = fr.readLine()) != null) {
            pocet++;
            ofsety[pocet] = fr.getFilePointer();
            System.out.print(radka);
            System.out.println(" Pozice v souboru (fr.getFilePointer()): " + ofsety[pocet] + " / radka.length(): " + radka.length());
            if (radka.endsWith("\r")) { //opatøení kvùli chybì v JDK 1.1; nyní nadbyteèné
                System.out.println("\r");
            }
        }

        System.out.println("\n- výpis obsahu promìnných vè. pole ofsety");
        System.out.println("pocet: " + pocet);
        for (int i = 0; i < ofsety.length; i++) {
            System.out.println(i + ": " + ofsety[i]);
        }

        System.out.println("\n- fáze výpis pozpátku");
        fr.seek(0);
        System.out.println("Pozice v souboru (fr.getFilePointer()): " + fr.getFilePointer());
        for (int i = pocet - 1; i >= 0; i--) {
            fr.seek(ofsety[i]);
            radka = fr.readLine();
            System.out.print(radka);
            System.out.println(" Pozice v souboru (fr.getFilePointer()): " + ofsety[i] + " / radka.length(): " + radka.length());
        }
        fr.close();


        //18.7 soubory s náhodným pøístupem (varianta s writeChars())
        System.out.println("\n18.7 soubory s náhodným pøístupem (varianta s writeChars())");
        RandomAccessFile frw2 = new RandomAccessFile("18_7_g.txt", "rw");
        frw2.writeChars("Ahoj"); //A h o j
        frw2.writeBytes("Ahoj"); //Ahoj

        frw2.writeChar((int)'A');
        frw2.writeChar((int)'h');
        frw2.writeChar((int)'o');
        frw2.writeChar((int)'j');

        frw2.seek(0);
        radka = frw2.readLine();
        System.out.println(radka);
        frw2.close();
    }
}
