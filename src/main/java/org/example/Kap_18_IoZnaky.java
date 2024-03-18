package org.example;

import java.io.*;
import java.util.StringTokenizer;

public class Kap_18_IoZnaky {
    public static void main(String[] args) throws IOException {
        //18.3.1 vstupy a výstupy znakù
        //a. vytvoøení instance tøíd FileReader a FileWriter pomocí existující instance tøídy File
        System.out.println("18.3.1 vstupy a výstupy znakù");
        System.out.println("- vytvoøení instance FileReader a FileWriter pomocí File");
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

        //b. vytvoøení instance FileWriter pøímo se jménem souboru (FileWriter má jako parametr pøímo jméno souboru; bez mezistupnì File)
        System.out.println("- vytvoøení instance FileWriter pøímo se jménem souboru (bez mezistupnì File)");
        File frJm2 = new File("a.txt");
        FileReader fr2 = new FileReader(frJm2);
        FileWriter fw2 = new FileWriter("18_3_1_b2.txt", true);

        long delka2 = frJm2.length();
        System.out.println("frJm2.length(): " + delka2);
        int c2;

        for (long i = 0; i < delka2; i++) {
            //prostá smyèka FOR nastavená na frJm.length() vypí¹e navíc nìkolik netisknutelných znakù
            c2 = fr2.read();
            fw2.write(c2);
            System.out.println(i + ": " + (c2 == 13 || c2 == 10 ? "NL" : (char)c2) + " " + c2);

            //... øe¹ení pomocí vnoøené podmínky IF
            /*if ((c2 = fr2.read()) != -1) {
                fw2.write(c2);
            }*/
        }
        //proudy pøekódovávají znaky podle nastaveného kódovacího schematu
        System.out.println("System.getProperty(\"file.encoding\"): " + System.getProperty("file.encoding"));
        System.out.println("fr2.getEncoding(): " + fr2.getEncoding());
        System.out.println("fw2.getEncoding(): " + fw2.getEncoding());

        fr2.close();
        fw2.close();

        //18.3.3 dal¹í dovednosti se soubory
        System.out.println("\n18.3.3 dal¹í dovednosti se soubory");
        File frJm3 = new File("a.txt");
        FileReader fr3 = new FileReader(frJm3);
        FileWriter fw3 = new FileWriter("18_3_3_b.txt");

        long delka3 = frJm3.length();
        int c3;

        //první kopírování od zaèátku
        for (long i = 0; i < delka3; i++) {
            c3 = fr3.read();
            fw3.write(c3);
        }
        fr3.close(); //ponìkud nepøehledná forma pøesunu na zaè. souboru
        fw3.close(); //obsah 1. kola ètení je zapsán

        //druhé kopírování z poloviny
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

        //18.4.1 vlastnost: bufferování
        System.out.println("18.4.1 vlastnost: bufferování");
        System.out.println("- ètení souboru nebufferovanì");
        File frJm31 = new File("18_4_1_a.txt");
        FileReader fr31 = new FileReader(frJm31);

        System.out.println("délka 18_4_1_a.txt: " + frJm31.length());
        int c31;
        long z31 = System.currentTimeMillis();
        while((c31 = fr31.read()) != -1) ;
        long k31 = System.currentTimeMillis();
        System.out.println("ms: " + (k31 - z31));

        fr31.close();

        System.out.println("- ètení souboru bufferovanì");
        File frJm32 = new File("18_4_1_a.txt");
        FileReader fr32 = new FileReader(frJm32);
        BufferedReader in32 = new BufferedReader(fr32);

        System.out.println("délka 18_4_1_a.txt: " + frJm32.length());
        int c32;
        long z32 = System.currentTimeMillis();
        while((c32 = in32.read()) != -1) ;
        long k32 = System.currentTimeMillis();
        System.out.println("ms: " + (k32 - z32));

        fr32.close();

        //18.4.2 vlastnost: ètení po øádcích (pomocí met. readLine() tøídy BufferedReader)
        System.out.println("\n18.4.2 vlastnost: ètení po øádcích");
        FileReader fr4 = new FileReader("a.txt");
        BufferedReader in4 = new BufferedReader(fr4);
        FileWriter fw4 = new FileWriter("18_4_2_b.txt");
        BufferedWriter out4 = new BufferedWriter(fw4);

        String radka4;
        while ((radka4 = in4.readLine()) != null) { //readLine() pøeète øádku bez ukonèovacích znakù ...
            System.out.println(radka4);
            out4.write(radka4);
            out4.newLine(); //... proto ukonèení øádky na výstupu
        }
        fr4.close();
        //fw4.close(); //výstupní soubor by se uzavøel, ani¾ by se do nìj zapsala data ulo¾ená v bufferu => prázdný výstupní soubor
                       //Exception in thread "main" java.io.IOException: Stream closed
	                   //    at java.base/sun.nio.cs.StreamEncoder.ensureOpen(StreamEncoder.java:51)
	                   //    at java.base/sun.nio.cs.StreamEncoder.write(StreamEncoder.java:125)
	                   //    at java.base/java.io.OutputStreamWriter.write(OutputStreamWriter.java:207)
	                   //    at java.base/java.io.BufferedWriter.flushBuffer(BufferedWriter.java:120)
	                   //    at java.base/java.io.BufferedWriter.close(BufferedWriter.java:268)
	                   //    at org.example.Kap_18_IoZnaky.main(Kap_18_IoZnaky.java:130)
        out4.close();

        System.out.println("\n18.4.2 vlastnost: ètení po øádcích (bajtovì orientovaná varianta)");
        FileInputStream fr41 = new FileInputStream("a.txt");
        BufferedInputStream in41 = new BufferedInputStream(fr41); //Use try-with-resources or close this "BufferedInputStream" in a "finally" clause. => in41.close();
        FileOutputStream fw41 = new FileOutputStream("18_4_2_b1.bin");
        BufferedOutputStream out41 = new BufferedOutputStream(fw41);

        int radka41;
        while ((radka41 = in41.read()) != -1) { //readLine() zde není - ta ète znaky, ne bajty
            //System.out.println(radka4); //nemá význam, Value 'radka4' is always 'null'
            //System.out.println((String)radka4); //dtto
            out41.write(radka41);
        }
        fr41.close();
        in41.close(); //viz pozn. vý¹e
        //fw41.close(); //dtto jako vý¹e
        out41.close();

        //18.4.3 vlastnost: výbìrové ètení po øádcích
        System.out.println("18.4.3 vlastnost: výbìrové ètení po øádcích");
        System.out.println("- vyu¾ití getLineNumber() pro zobrazení èísla øádky");
        FileReader fr42 = new FileReader("a.txt");
        LineNumberReader in42 = new LineNumberReader(fr42);

        String radka42;
        int cisloRadky42 = 0;

        while ((radka42 = in42.readLine()) != null) {
            cisloRadky42++;
            System.out.println(cisloRadky42 + ".(" + in42.getLineNumber() + ") " + radka42);
        }
        /* 1.(1) ;+ì¹èø¾ýáíé=
           2.(2) qwertzuiopú)
           3.(3) asdfghjklù§
           4.(4) \yxcvbnm,.-
           5.(4) null //prázdný øádek vrací NULL; getLineNumber() vrací poèet pøeètených øádek, tj. po dosa¾ení konce souboru se nezvy¹uje
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
        in43.setLineNumber(4); //nastavení fiktivního èísla øádku, NIKOLIV skok na øádek daného èísla
        radka43 = in43.readLine(); //dále se ètou dal¹í øádky bez mezery, pouze se zvý¹eným èíslem
        System.out.println("#.(" + in43.getLineNumber() + ") " + radka43);
        radka43 = in43.readLine();
        System.out.println("#.(" + in43.getLineNumber() + ") " + radka43);
        radka43 = in43.readLine();
        System.out.println("#.(" + in43.getLineNumber() + ") " + radka43);
        radka43 = in43.readLine();
        System.out.println("#.(" + in43.getLineNumber() + ") " + radka43);

        fr43.close();

        //18.4.4 vlastnost: vrácení pøeèteného znaku
        System.out.println("\n18.4.4 vlastnost: vrácení pøeèteného znaku");
        FileReader fr5 = new FileReader("a.txt");
        PushbackReader in5 = new PushbackReader(fr5);
        int c5;

        //znak je pøeèten, vrácen a znovu pøeèten
        c5 = in5.read();
        System.out.print((char)c5);
        in5.unread(c5);
        c5 = in5.read();
        System.out.println((char)c5);

        //znaky se ètou ve smyèce do dosa¾ení ukonèovacího znaku
        while ((c5 = in5.read()) != ')') {
            System.out.print((char)c5);
        }
        in5.unread(c5); //')' tvoøí ukonèovací znak vý¹e uvedené smyèky a je vrácen zpátky
        c5 = in5.read();
        System.out.print((char)c5);

        //18.4.5 vlastnost: formátování výstupu
        //18.4.6 vlastnost: formátování výstupu s øádkovým bufferováním
        System.out.println("\n\n18.4.5 vlastnost: formátování výstupu");
        System.out.println("18.4.6 vlastnost: formátování výstupu s øádkovým bufferováním");
        FileWriter fwForm6 = new FileWriter("18_4_5_form.txt");
        PrintWriter form6 = new PrintWriter(fwForm6);
        //PrintWriter form6 = new PrintWriter(fwForm6, false); //autoFlush false => výpis pozdr¾en do výpisu znakù konce øádky a pak vypsána celá øádka najednou
        FileWriter fwNeform6 = new FileWriter("18_4_5_neform.txt");

        for (int i = 65; i <= 74; i++) {
            System.out.print(i + " "); //výpis na terminál - tiskne vstup, tj. èísla
            form6.print(i + " ");      //výstup do souboru formátovaný (díky dodateèné vlastnoti PrintWriter) - tiskne vstup, tj. èísla
            fwNeform6.write(i);        //výstup do souboru neformátovaný - tiskne písmena
        }
        form6.close();
        fwNeform6.close();

        //18.4.7 formátovaný vstup
        System.out.println("\n\n18.4.7 formátovaný vstup");
        System.out.println("- varianta 1: ka¾dé èíslo na novém øádku");
        //variace programu Zapis.java pro zápis èísel 1..N do souboru 18_4_7_buf.txt
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
        System.out.println("Souèet je: " + suma7);
        fr7.close();

        System.out.println("- varianta 2: desítka èísel spoleènì na øádku");
        //variace programu Zapis.java pro zápis èísel 1..N do souboru 18_4_7_radky.txt
        FileWriter fw8 = new FileWriter("18_4_7_radky.txt");
        PrintWriter form8 = new PrintWriter(fw8);

        for (int i = 1;  i <= 60;  i++) {
            if ((i % 10) == 0) {
                form8.println(i);
            }
            else {
                //podvarianta s oddìlovaèem mezera
                //form8.print(i + " ");
                //podvarianta s oddìlovaèem mezera, støedník nebo procento
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
            //podvarianta s oddìlovaèem mezera
            //StringTokenizer st9 = new StringTokenizer(radka9); //java.util.StringTokenizer rozdìlí øetìzec obsahující delimiter na nìkolik øetìzcù
            //podvarianta s oddìlovaèem mezera, støedník nebo procento
            StringTokenizer st9 = new StringTokenizer(radka9, " ;%");
            while (st9.hasMoreTokens()) {
                cislo9 = st9.nextToken();
                k9 = Integer.valueOf(cislo9).intValue();
                suma9 += k9;
            }
        }
        System.out.println("Souèet je: " + suma9);
        fr9.close();

        //18.4.8 vlastnost: neformátovaný vstup a výstup základních datových typù
        System.out.println("\n18.4.8 vlastnost: neformátovaný vstup a výstup základních datových typù");
        System.out.println("- fáze zápis do souboru");
        FileOutputStream fwJm10 = new FileOutputStream("18_4_8_data.bin");
        DataOutputStream fw10 = new DataOutputStream(fwJm10);
        int k10, pocet10;

        while ((pocet10 = (int)(10.0 * Math.random())) < 3) ; //stanovení celého èísla - poètu celých èísel (viz ní¾e)
        System.out.println(pocet10);
        fw10.writeInt(pocet10);

        for (int i = 0; i < pocet10; i++) {
            k10 = (int)(1000.0 * Math.random()); //generování daného poètu (viz vý¹e) celých èísel
            System.out.print(k10 + " ");
            fw10.writeInt(k10);
        }

        System.out.println("\n" + Math.PI + " " + Math.E);
        fw10.writeDouble(Math.PI);
        fw10.writeDouble(Math.E);
        fwJm10.close();

        System.out.println("- fáze výpis ze souboru");
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

        //18.4.8 vlastnost: neformátovaný vstup a výstup základních datových typù (varianta unsigned)
        System.out.println("\n18.4.8 vlastnost: neformátovaný vstup a výstup základních datových typù (varianta unsigned)");
        FileOutputStream fwJm101 = new FileOutputStream("18_4_8_data_unsign.bin");
        DataOutputStream fw101 = new DataOutputStream(fwJm101);

        System.out.println("- fáze zápis do souboru");
        byte bt101 = -1;  //= 255 neznaménkovì
        System.out.println("Byte:  " + bt101 + " (255 neznaménkovì)");
        fw101.writeByte(bt101);
        fw101.writeByte(bt101);
        short sh101 = -1; //= ? neznaménkovì
        System.out.println("Short: " + sh101 + " (? neznaménkovì)");
        fw101.writeShort(sh101);
        fw101.writeShort(sh101);

        fw101.close();

        System.out.println("- fáze výpis ze souboru");
        FileInputStream frJm101 = new FileInputStream("18_4_8_data_unsign.bin");
        DataInputStream fr101 = new DataInputStream(frJm101);

        bt101 = fr101.readByte();
        int int101 = fr101.readUnsignedByte();
        System.out.println("Byte:  " + bt101 + " (unsigned: " + int101 + ")");
        sh101 = fr101.readShort();
        int101 = fr101.readUnsignedShort();
        System.out.println("Short: " + sh101 + " (unsigned: " + int101 + ")");

        frJm101.close();

        //18.4.9 vlastnost: serializace objektù --> viz public class Io21

        //18.4.10 seskupování vlastností
        System.out.println("\n18.4.10 seskupování vlastností");
        //bufferovaný výstup
        FileWriter     fBuf = new FileWriter("18_4_10_buf.txt");
        BufferedWriter bBuf = new BufferedWriter(fBuf);
        PrintWriter    pBuf = new PrintWriter(bBuf);
        long start11 = System.nanoTime();
        for (int i = 0; i < 5_000; i++) {
            pBuf.println(i);
        }
        long stop11 = System.nanoTime();
        pBuf.close();
        System.out.println("bufferovaný výstup (ms): " + ((stop11 - start11)/1_000_000));

        //nebufferovaný výstup
        FileWriter  fw11 = new FileWriter("18_4_10_fw.txt");
        PrintWriter pw11 = new PrintWriter(fw11);
        start11 = System.nanoTime();
        for (int i = 0; i < 5_000; i++) {
            pw11.println(i);
        }
        stop11 = System.nanoTime();
        pw11.close();
        System.out.println("nebufferovaný výstup (ms): " + ((stop11 - start11)/1_000_000));

        //18.5 vstup a výstup do pamìti
        System.out.println("\n18.5 vstup a výstup do pamìti");
        StringWriter sProud = new StringWriter();
        PrintWriter  form12 = new PrintWriter(sProud);

        for (int i = 1; i <= 5; i++) {
            form12.println(i + ". ahoj " + (4 - i)); //nebo .print(... + '\n')
            System.out.println(sProud);
        }
        /*form12.print(". ahoj " + (4 - 1) + '\n');
        System.out.println(sProud);*/
        form12.close();

        //18.6 vstup a výstup do roury --> viz public class Io_30

        //18.7 soubory s náhodným pøístupem --> viz public class TestRAF (Random Access File)
    }
}
