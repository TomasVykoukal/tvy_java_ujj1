package org.example;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Kap_18_TestRAF {
    public static void main(String[] args) throws IOException {
        //18.7 soubory s n�hodn�m p��stupem (RAF = RandomAccessFile)
        System.out.println("18.7 soubory s n�hodn�m p��stupem (RAF = RandomAccessFile)");
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

        //z�pis do souboru
        System.out.println("- f�ze z�pis do souboru");
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer());
        System.out.println("Velikost souboru (frw.length()):         " + frw.length());

        System.out.println("\npo�et (stanoven): " + pocet13);
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

        //p�eskakovan� v�pis obsahu souboru
        System.out.println("\n- f�ze p�eskakovan� v�pis obsahu souboru");
        frw.seek(0L); //n�vrat na za��tek
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer());

        pocet13 = frw.readInt();
        System.out.println("po�et (frw.readInt()): " + pocet13);
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer() + "\n");

        posun13 = 4 * pocet13; //posun p�ed posl. int ze smy�ky (po�et + �ada int dle po�tu); velikost int = 4 B;
        frw.seek(posun13);
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer() + "\n");

        frw.writeInt(1234); //p�eps�n� posledn�ho int v souboru
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer());
        frw.seek(posun13); //pozice m��ena od za�. souboru
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer() + "\n");

        k13 = frw.readInt();
        System.out.println(k13);
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer() + "\n");

        frw.skipBytes(8); //double je velk� 8 B (p�eskok PI)
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer() + "\n");

        double e13 = frw.readDouble();
        System.out.println(e13);
        System.out.println("Pozice v souboru (frw.getFilePointer()): " + frw.getFilePointer());

        //systematick� v�pis obsahu souboru
        System.out.println("\n- f�ze systematick� v�pis obsahu souboru");
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

        //sn�en� d�lky souboru + test
        System.out.println("\n- sn�en� d�lky souboru + test");
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
        } //=> dosa�eno konce souboru!

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


        //18.7 soubory s n�hodn�m p��stupem (varianta "index ��dek")
        System.out.println("\n18.7 soubory s n�hodn�m p��stupem (varianta \"index ��dek\")");
        RandomAccessFile fr = new RandomAccessFile("a.txt", "r");
        String radka;
        int pocet = 0;
        long[] ofsety = new long[10];
        ofsety[pocet] = 0;

        System.out.println("- f�ze v�pis pop�edu");
        System.out.println("Pozice v souboru (fr.getFilePointer()): " + fr.getFilePointer());
        while ((radka = fr.readLine()) != null) {
            pocet++;
            ofsety[pocet] = fr.getFilePointer();
            System.out.print(radka);
            System.out.println(" Pozice v souboru (fr.getFilePointer()): " + ofsety[pocet] + " / radka.length(): " + radka.length());
            if (radka.endsWith("\r")) { //opat�en� kv�li chyb� v JDK 1.1; nyn� nadbyte�n�
                System.out.println("\r");
            }
        }

        System.out.println("\n- v�pis obsahu prom�nn�ch v�. pole ofsety");
        System.out.println("pocet: " + pocet);
        for (int i = 0; i < ofsety.length; i++) {
            System.out.println(i + ": " + ofsety[i]);
        }

        System.out.println("\n- f�ze v�pis pozp�tku");
        fr.seek(0);
        System.out.println("Pozice v souboru (fr.getFilePointer()): " + fr.getFilePointer());
        for (int i = pocet - 1; i >= 0; i--) {
            fr.seek(ofsety[i]);
            radka = fr.readLine();
            System.out.print(radka);
            System.out.println(" Pozice v souboru (fr.getFilePointer()): " + ofsety[i] + " / radka.length(): " + radka.length());
        }
        fr.close();


        //18.7 soubory s n�hodn�m p��stupem (varianta s writeChars())
        System.out.println("\n18.7 soubory s n�hodn�m p��stupem (varianta s writeChars())");
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
