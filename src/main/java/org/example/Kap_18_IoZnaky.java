package org.example;

import java.io.*;
import java.util.StringTokenizer;

public class Kap_18_IoZnaky {
    public static void main(String[] args) throws IOException {
        //18.3.1 vstupy a v�stupy znak�
        //a. vytvo�en� instance t��d FileReader a FileWriter pomoc� existuj�c� instance t��dy File
        System.out.println("18.3.1 vstupy a v�stupy znak�");
        System.out.println("- vytvo�en� instance FileReader a FileWriter pomoc� File");
        File frJm1 = new File("a.txt");
        File fwJm1 = new File("18_3_1_b1.txt");

        if (frJm1.exists()) {
            FileReader fr1 = new FileReader(frJm1);
            FileWriter fw1 = new FileWriter(fwJm1, true);
            int c1;
            while ((c1 = fr1.read()) != -1) {
                //fw1.write(c1);
                fw1.append((char)c1);
            }
            fr1.close();
            fw1.close();
        }

        //b. vytvo�en� instance FileWriter p��mo se jm�nem souboru (FileWriter m� jako parametr p��mo jm�no souboru; bez mezistupn� File)
        System.out.println("- vytvo�en� instance FileWriter p��mo se jm�nem souboru (bez mezistupn� File)");
        File frJm2 = new File("a.txt");
        FileReader fr2 = new FileReader(frJm2);
        FileWriter fw2 = new FileWriter("18_3_1_b2.txt", true);

        long delka2 = frJm2.length();
        System.out.println("frJm2.length(): " + delka2);
        int c2;

        for (long i = 0; i < delka2; i++) {
            //prost� smy�ka FOR nastaven� na frJm.length() vyp�e nav�c n�kolik netisknuteln�ch znak�
            c2 = fr2.read();
            fw2.write(c2);
            System.out.println(i + ": " + (c2 == 13 || c2 == 10 ? "NL" : (char)c2) + " " + c2);

            //... �e�en� pomoc� vno�en� podm�nky IF
            /*if ((c2 = fr2.read()) != -1) {
                fw2.write(c2);
            }*/
        }
        //proudy p�ek�dov�vaj� znaky podle nastaven�ho k�dovac�ho schematu
        System.out.println("System.getProperty(\"file.encoding\"): " + System.getProperty("file.encoding"));
        System.out.println("fr2.getEncoding(): " + fr2.getEncoding());
        System.out.println("fw2.getEncoding(): " + fw2.getEncoding());

        fr2.close();
        fw2.close();

        //18.3.3 dal�� dovednosti se soubory
        System.out.println("\n18.3.3 dal�� dovednosti se soubory");
        File frJm3 = new File("a.txt");
        FileReader fr3 = new FileReader(frJm3);
        FileWriter fw3 = new FileWriter("18_3_3_b.txt");

        long delka3 = frJm3.length();
        int c3;

        //prvn� kop�rov�n� od za��tku
        for (long i = 0; i < delka3; i++) {
            c3 = fr3.read();
            fw3.write(c3);
        }
        fr3.close(); //pon�kud nep�ehledn� forma p�esunu na za�. souboru
        fw3.close(); //obsah 1. kola �ten� je zaps�n

        //druh� kop�rov�n� z poloviny
        fr3 = new FileReader(frJm3);
        //fr3.reset(); //Exception in thread "main" java.io.IOException: reset() not supported
                       //   at java.base/java.io.Reader.reset(Reader.java:370)
                       //   at org.example.Kap_18_IoZnaky.main(Kap_18_IoZnaky.java:68)
        fw3 = new FileWriter("18_3_3_b.txt", true);

        fr3.skip(delka3 / 2);
        while ((c3 = fr3.read()) != -1) {
            fw3.write(c3);
        }
        fr3.close();
        fw3.close();

        //18.4.1 vlastnost: bufferov�n�
        System.out.println("18.4.1 vlastnost: bufferov�n�");
        System.out.println("- �ten� souboru nebufferovan�");
        File frJm31 = new File("18_4_1_a.txt");
        FileReader fr31 = new FileReader(frJm31);

        System.out.println("d�lka 18_4_1_a.txt: " + frJm31.length());
        int c31;
        long z31 = System.currentTimeMillis();
        while((c31 = fr31.read()) != -1) ;
        long k31 = System.currentTimeMillis();
        System.out.println("ms: " + (k31 - z31));

        fr31.close();

        System.out.println("- �ten� souboru bufferovan�");
        File frJm32 = new File("18_4_1_a.txt");
        FileReader fr32 = new FileReader(frJm32);
        BufferedReader in32 = new BufferedReader(fr32);

        System.out.println("d�lka 18_4_1_a.txt: " + frJm32.length());
        int c32;
        long z32 = System.currentTimeMillis();
        while((c32 = in32.read()) != -1) ;
        long k32 = System.currentTimeMillis();
        System.out.println("ms: " + (k32 - z32));

        fr32.close();

        //18.4.2 vlastnost: �ten� po ��dc�ch (pomoc� met. readLine() t��dy BufferedReader)
        System.out.println("\n18.4.2 vlastnost: �ten� po ��dc�ch");
        FileReader fr4 = new FileReader("a.txt");
        BufferedReader in4 = new BufferedReader(fr4);
        FileWriter fw4 = new FileWriter("18_4_2_b.txt");
        BufferedWriter out4 = new BufferedWriter(fw4);

        String radka4;
        while ((radka4 = in4.readLine()) != null) { //readLine() p�e�te ��dku bez ukon�ovac�ch znak� ...
            System.out.println(radka4);
            out4.write(radka4);
            out4.newLine(); //... proto ukon�en� ��dky na v�stupu
        }
        fr4.close();
        //fw4.close(); //v�stupn� soubor by se uzav�el, ani� by se do n�j zapsala data ulo�en� v bufferu => pr�zdn� v�stupn� soubor
                       //Exception in thread "main" java.io.IOException: Stream closed
	                   //    at java.base/sun.nio.cs.StreamEncoder.ensureOpen(StreamEncoder.java:51)
	                   //    at java.base/sun.nio.cs.StreamEncoder.write(StreamEncoder.java:125)
	                   //    at java.base/java.io.OutputStreamWriter.write(OutputStreamWriter.java:207)
	                   //    at java.base/java.io.BufferedWriter.flushBuffer(BufferedWriter.java:120)
	                   //    at java.base/java.io.BufferedWriter.close(BufferedWriter.java:268)
	                   //    at org.example.Kap_18_IoZnaky.main(Kap_18_IoZnaky.java:130)
        out4.close();

        System.out.println("\n18.4.2 vlastnost: �ten� po ��dc�ch (bajtov� orientovan� varianta)");
        FileInputStream fr41 = new FileInputStream("a.txt");
        BufferedInputStream in41 = new BufferedInputStream(fr41); //Use try-with-resources or close this "BufferedInputStream" in a "finally" clause. => in41.close();
        FileOutputStream fw41 = new FileOutputStream("18_4_2_b1.bin");
        BufferedOutputStream out41 = new BufferedOutputStream(fw41);

        int radka41;
        while ((radka41 = in41.read()) != -1) { //readLine() zde nen� - ta �te znaky, ne bajty
            //System.out.println(radka4); //nem� v�znam, Value 'radka4' is always 'null'
            //System.out.println((String)radka4); //dtto
            out41.write(radka41);
        }
        fr41.close();
        in41.close(); //viz pozn. v��e
        //fw41.close(); //dtto jako v��e
        out41.close();

        //18.4.3 vlastnost: v�b�rov� �ten� po ��dc�ch
        System.out.println("18.4.3 vlastnost: v�b�rov� �ten� po ��dc�ch");
        System.out.println("- vyu�it� getLineNumber() pro zobrazen� ��sla ��dky");
        FileReader fr42 = new FileReader("a.txt");
        LineNumberReader in42 = new LineNumberReader(fr42);

        String radka42;
        int cisloRadky42 = 0;

        while ((radka42 = in42.readLine()) != null) {
            cisloRadky42++;
            System.out.println(cisloRadky42 + ".(" + in42.getLineNumber() + ") " + radka42);
        }
        /* 1.(1) ;+��������=
           2.(2) qwertzuiop�)
           3.(3) asdfghjkl��
           4.(4) \yxcvbnm,.-
           5.(4) null //pr�zdn� ��dek vrac� NULL; getLineNumber() vrac� po�et p�e�ten�ch ��dek, tj. po dosa�en� konce souboru se nezvy�uje
        */

        System.out.println("- funkce setLineNumber()");
        //fr42.reset(); //Exception in thread "main" java.io.IOException: reset() not supported
                        //    at java.base/java.io.Reader.reset(Reader.java:370)
                        //    at org.example.Kap_18_IoZnaky.main(Kap_18_IoZnaky.java:177)
        FileReader fr43 = new FileReader("a.txt");
        LineNumberReader in43 = new LineNumberReader(fr43);

        String radka43;
        radka43 = in43.readLine();
        System.out.println("#.(" + in43.getLineNumber() + ") " + radka43);
        in43.setLineNumber(4); //nastaven� fiktivn�ho ��sla ��dku, NIKOLIV skok na ��dek dan�ho ��sla
        radka43 = in43.readLine(); //d�le se �tou dal�� ��dky bez mezery, pouze se zv��en�m ��slem
        System.out.println("#.(" + in43.getLineNumber() + ") " + radka43);
        radka43 = in43.readLine();
        System.out.println("#.(" + in43.getLineNumber() + ") " + radka43);
        radka43 = in43.readLine();
        System.out.println("#.(" + in43.getLineNumber() + ") " + radka43);
        radka43 = in43.readLine();
        System.out.println("#.(" + in43.getLineNumber() + ") " + radka43);

        fr43.close();

        //18.4.4 vlastnost: vr�cen� p�e�ten�ho znaku
        System.out.println("\n18.4.4 vlastnost: vr�cen� p�e�ten�ho znaku");
        FileReader fr5 = new FileReader("a.txt");
        PushbackReader in5 = new PushbackReader(fr5);
        int c5;

        //znak je p�e�ten, vr�cen a znovu p�e�ten
        c5 = in5.read();
        System.out.print((char)c5);
        in5.unread(c5);
        c5 = in5.read();
        System.out.println((char)c5);

        //znaky se �tou ve smy�ce do dosa�en� ukon�ovac�ho znaku
        while ((c5 = in5.read()) != ')') {
            System.out.print((char)c5);
        }
        in5.unread(c5); //')' tvo�� ukon�ovac� znak v��e uveden� smy�ky a je vr�cen zp�tky
        c5 = in5.read();
        System.out.print((char)c5);

        //18.4.5 vlastnost: form�tov�n� v�stupu
        //18.4.6 vlastnost: form�tov�n� v�stupu s ��dkov�m bufferov�n�m
        System.out.println("\n\n18.4.5 vlastnost: form�tov�n� v�stupu");
        System.out.println("18.4.6 vlastnost: form�tov�n� v�stupu s ��dkov�m bufferov�n�m");
        FileWriter fwForm6 = new FileWriter("18_4_5_form.txt");
        PrintWriter form6 = new PrintWriter(fwForm6);
        //PrintWriter form6 = new PrintWriter(fwForm6, false); //autoFlush false => v�pis pozdr�en do v�pisu znak� konce ��dky a pak vyps�na cel� ��dka najednou
        FileWriter fwNeform6 = new FileWriter("18_4_5_neform.txt");

        for (int i = 65; i <= 74; i++) {
            System.out.print(i + " "); //v�pis na termin�l - tiskne vstup, tj. ��sla
            form6.print(i + " ");      //v�stup do souboru form�tovan� (d�ky dodate�n� vlastnoti PrintWriter) - tiskne vstup, tj. ��sla
            fwNeform6.write(i);        //v�stup do souboru neform�tovan� - tiskne p�smena
        }
        form6.close();
        fwNeform6.close();

        //18.4.7 form�tovan� vstup
        System.out.println("\n\n18.4.7 form�tovan� vstup");
        System.out.println("- varianta 1: ka�d� ��slo na nov�m ��dku");
        //variace programu Zapis.java pro z�pis ��sel 1..N do souboru 18_4_7_buf.txt
        FileWriter fw7 = new FileWriter("18_4_7_buf.txt");
        PrintWriter form7 = new PrintWriter(fw7);

        for (int i = 1;  i <= 60;  i++) {
            form7.println(i);
        }
        form7.close();
        //konec Zapis.java

        FileReader fr7 = new FileReader("18_4_7_buf.txt");
        BufferedReader in7 = new BufferedReader(fr7);
        String radka7;
        int k7, suma7 = 0;
        while ((radka7 = in7.readLine()) != null) {
            k7 = Integer.valueOf(radka7).intValue();
            suma7 += k7;
        }
        System.out.println("Sou�et je: " + suma7);
        fr7.close();

        System.out.println("- varianta 2: des�tka ��sel spole�n� na ��dku");
        //variace programu Zapis.java pro z�pis ��sel 1..N do souboru 18_4_7_radky.txt
        FileWriter fw8 = new FileWriter("18_4_7_radky.txt");
        PrintWriter form8 = new PrintWriter(fw8);

        for (int i = 1;  i <= 60;  i++) {
            if ((i % 10) == 0) {
                form8.println(i);
            }
            else {
                //podvarianta s odd�lova�em mezera
                //form8.print(i + " ");
                //podvarianta s odd�lova�em mezera, st�edn�k nebo procento
                switch ((int) (1.0 + Math.random() * 3.0)) {
                    case 1: form8.print(i + " ");
                        break;
                    case 2: form8.print(i + ";");
                        break;
                    case 3: form8.print(i + "%");
                        break;
                }
            }
        }
        form8.close();
        //konec Zapis.java

        FileReader fr9 = new FileReader("18_4_7_radky.txt");
        BufferedReader in9 = new BufferedReader(fr9);
        String radka9, cislo9;
        int k9, suma9 =  0;

        while ((radka9 = in9.readLine()) != null) {
            //podvarianta s odd�lova�em mezera
            //StringTokenizer st9 = new StringTokenizer(radka9); //java.util.StringTokenizer rozd�l� �et�zec obsahuj�c� delimiter na n�kolik �et�zc�
            //podvarianta s odd�lova�em mezera, st�edn�k nebo procento
            StringTokenizer st9 = new StringTokenizer(radka9, " ;%");
            while (st9.hasMoreTokens()) {
                cislo9 = st9.nextToken();
                k9 = Integer.valueOf(cislo9).intValue();
                suma9 += k9;
            }
        }
        System.out.println("Sou�et je: " + suma9);
        fr9.close();

        //18.4.8 vlastnost: neform�tovan� vstup a v�stup z�kladn�ch datov�ch typ�
        System.out.println("\n18.4.8 vlastnost: neform�tovan� vstup a v�stup z�kladn�ch datov�ch typ�");
        System.out.println("- f�ze z�pis do souboru");
        FileOutputStream fwJm10 = new FileOutputStream("18_4_8_data.bin");
        DataOutputStream fw10 = new DataOutputStream(fwJm10);
        int k10, pocet10;

        while ((pocet10 = (int)(10.0 * Math.random())) < 3) ; //stanoven� cel�ho ��sla - po�tu cel�ch ��sel (viz n�e)
        System.out.println(pocet10);
        fw10.writeInt(pocet10);

        for (int i = 0; i < pocet10; i++) {
            k10 = (int)(1000.0 * Math.random()); //generov�n� dan�ho po�tu (viz v��e) cel�ch ��sel
            System.out.print(k10 + " ");
            fw10.writeInt(k10);
        }

        System.out.println("\n" + Math.PI + " " + Math.E);
        fw10.writeDouble(Math.PI);
        fw10.writeDouble(Math.E);
        fwJm10.close();

        System.out.println("- f�ze v�pis ze souboru");
        FileInputStream frJm10 = new FileInputStream("18_4_8_data.bin");
        DataInputStream fr10 = new DataInputStream(frJm10);
        pocet10 = fr10.readInt();
        for (int i = 0; i < pocet10; i++) {
            k10 = fr10.readInt();
            System.out.print(k10 + " ");
        }
        double pi = fr10.readDouble();
        double e = fr10.readDouble();
        System.out.println("\n" + pi + " " + e);
        frJm10.close();

        //18.4.8 vlastnost: neform�tovan� vstup a v�stup z�kladn�ch datov�ch typ� (varianta unsigned)
        System.out.println("\n18.4.8 vlastnost: neform�tovan� vstup a v�stup z�kladn�ch datov�ch typ� (varianta unsigned)");
        FileOutputStream fwJm101 = new FileOutputStream("18_4_8_data_unsign.bin");
        DataOutputStream fw101 = new DataOutputStream(fwJm101);

        System.out.println("- f�ze z�pis do souboru");
        byte bt101 = -1;  //= 255 neznam�nkov�
        System.out.println("Byte:  " + bt101 + " (255 neznam�nkov�)");
        fw101.writeByte(bt101);
        fw101.writeByte(bt101);
        short sh101 = -1; //= ? neznam�nkov�
        System.out.println("Short: " + sh101 + " (? neznam�nkov�)");
        fw101.writeShort(sh101);
        fw101.writeShort(sh101);

        fw101.close();

        System.out.println("- f�ze v�pis ze souboru");
        FileInputStream frJm101 = new FileInputStream("18_4_8_data_unsign.bin");
        DataInputStream fr101 = new DataInputStream(frJm101);

        bt101 = fr101.readByte();
        int int101 = fr101.readUnsignedByte();
        System.out.println("Byte:  " + bt101 + " (unsigned: " + int101 + ")");
        sh101 = fr101.readShort();
        int101 = fr101.readUnsignedShort();
        System.out.println("Short: " + sh101 + " (unsigned: " + int101 + ")");

        frJm101.close();

        //18.4.9 vlastnost: serializace objekt� --> viz public class Io21

        //18.4.10 seskupov�n� vlastnost�
        System.out.println("\n18.4.10 seskupov�n� vlastnost�");
        //bufferovan� v�stup
        FileWriter     fBuf = new FileWriter("18_4_10_buf.txt");
        BufferedWriter bBuf = new BufferedWriter(fBuf);
        PrintWriter    pBuf = new PrintWriter(bBuf);
        long start11 = System.nanoTime();
        for (int i = 0; i < 5_000; i++) {
            pBuf.println(i);
        }
        long stop11 = System.nanoTime();
        pBuf.close();
        System.out.println("bufferovan� v�stup (ms): " + ((stop11 - start11)/1_000_000));

        //nebufferovan� v�stup
        FileWriter  fw11 = new FileWriter("18_4_10_fw.txt");
        PrintWriter pw11 = new PrintWriter(fw11);
        start11 = System.nanoTime();
        for (int i = 0; i < 5_000; i++) {
            pw11.println(i);
        }
        stop11 = System.nanoTime();
        pw11.close();
        System.out.println("nebufferovan� v�stup (ms): " + ((stop11 - start11)/1_000_000));

        //18.5 vstup a v�stup do pam�ti
        System.out.println("\n18.5 vstup a v�stup do pam�ti");
        StringWriter sProud = new StringWriter();
        PrintWriter  form12 = new PrintWriter(sProud);

        for (int i = 1; i <= 5; i++) {
            form12.println(i + ". ahoj " + (4 - i)); //nebo .print(... + '\n')
            System.out.println(sProud);
        }
        /*form12.print(". ahoj " + (4 - 1) + '\n');
        System.out.println(sProud);*/
        form12.close();

        //18.6 vstup a v�stup do roury --> viz public class Io_30

        //18.7 soubory s n�hodn�m p��stupem --> viz public class TestRAF (Random Access File)
    }
}
