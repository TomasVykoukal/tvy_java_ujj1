package org.example;

import java.io.*;
import java.util.StringTokenizer;

public class Kap_18_cviceni {
    public static void main(String[] args) throws IOException {
        //cvi�en� 1 (text. soubor --> obrazovka | text. soubor + a->A) 18.3.1
        System.out.println("cvi�en� 1 (text. soubor --> obrazovka | text. soubor + a->A) 18.3.1");
        File frJm1 = new File("18_cvic_pismena.txt");
        File fwJm1 = new File("18_cvic_velky.txt");

        if (frJm1.exists()) {
            //zku�ebn� z�pis nezm�n�n�ch p�smen
            FileReader fr1 = new FileReader(frJm1);
            FileWriter fw1 = new FileWriter(fwJm1);
            int c1;
            char ch1;

            while ((c1 = fr1.read()) != -1) {
                System.out.print((char)c1);
                fw1.write(c1);
            }
            fr1.close();
            fw1.close();

            //z�pis velk�ch p�smen
            fr1 = new FileReader(frJm1);
            fw1 = new FileWriter(fwJm1, true);

            /*fw1.write(13); //NL (CR)
            fw1.write(10); //NL (LF)*/
            fw1.write("\n\n");
            System.out.print("\n\n");

            while ((c1 = fr1.read()) != -1) {
                ch1 = Character.toUpperCase((char)c1);
                System.out.print(ch1);
                fw1.write(ch1);
            }
            fr1.close();
            fw1.close();
        }

        //cvi�en� 2 (text. soubor ��dkov� --> text. soubor ��dkov� + po�et mal�ch p�smen) 18.4.2
        System.out.println("\n\ncvi�en� 2 (text. soubor ��dkov� --> text. soubor ��dkov� + po�et mal�ch p�smen) 18.4.2");
        File frJm2 = new File("18_cvic_pismena.txt");
        File fwJm2 = new File("18_cvic_kolik.txt");

        if (frJm2.exists()) {
            FileReader fr2 = new FileReader(frJm2);
            FileWriter fw2 = new FileWriter(fwJm2);
            BufferedReader buffr2 = new BufferedReader(fr2);
            BufferedWriter buffw2 = new BufferedWriter(fw2);

            String radka2;
            int delkaRad2, pocMalPis2;
            while ((radka2 = buffr2.readLine()) != null) {
                delkaRad2 = radka2.length();
                pocMalPis2 = 0;
                for (int i = 0; i < delkaRad2; i++) {
                    if (radka2.charAt(i) >= 'a' & radka2.charAt(i) <= 'z') {
                        pocMalPis2++;
                    }
                }
                System.out.println(radka2);
                System.out.println(pocMalPis2 + "/" + delkaRad2);
                buffw2.write(radka2);
                buffw2.newLine();
                buffw2.write(Integer.toString(pocMalPis2) + "/" + Integer.toString(delkaRad2));
                buffw2.newLine();
            }
            fr2.close();
            buffw2.close();
        }

        //cvi�en� 3 (text. generovat cel� ��sla --> text. soubor) 18.3.3
        System.out.println("\ncvi�en� 3 (text. generovat cel� ��sla --> text. soubor) 18.3.3");
        File fwJm3 = new File("18_cvic_pole.txt");
        FileWriter fw3 = new FileWriter(fwJm3);
        for (int i = 1; i <= 100; i++) {
            if (i % 10 != 0) {
                System.out.print(i + ", ");
                fw3.write(Integer.toString(i) + ", ");
            }
            else {
                System.out.println(i);
                fw3.write(Integer.toString(i) + "\n"); //alternativa k BufferedWriter.newLine
            }
        }
        fw3.close();

        //cvi�en� 4 (text. soubor ad 3 --> 2-rozm�rn� pole --> obrazovka | bin. soubor) 18.4.8
        System.out.println("\ncvi�en� 4 (text. soubor ad 3 --> 2-rozm�rn� pole --> obrazovka | bin. soubor) 18.4.8");
        File frJm4 = new File("18_cvic_pole.txt");
        FileOutputStream fwJm4 = new FileOutputStream("18_cvic_poleint.bin");
        FileInputStream frBinJm4 = new FileInputStream("18_cvic_poleint.bin");

        if (frJm4.exists()) {
            FileReader fr4 = new FileReader(frJm4);
            BufferedReader buffr4 = new BufferedReader(fr4); //BufferedReader kv�li readLine()

            String radka4, cistx4;
            int cis4;
            int idx_x = 0;
            int idx_y = 0;
            int[][] poleint4 = new int[10][10];
            System.out.println("- F�ze 1: �ten� z text. souboru, z�pis do pole");
            while ((radka4 = buffr4.readLine()) != null) {
                StringTokenizer st4 = new StringTokenizer(radka4, ", ");
                while (st4.hasMoreTokens()) {
                    cistx4 = st4.nextToken();
                    cis4 = Integer.valueOf(cistx4).intValue();
                    poleint4[idx_x][idx_y] = cis4;
                    idx_x++;
                }
                idx_x = 0;
                idx_y++;
            }
            buffr4.close();

            System.out.println("- F�ze 2: kontroln� v�pis pole na obrazovku:");
            for (int y = 0; y < poleint4.length; y++) {
                for (int x = 0; x < poleint4[y].length; x++) {
                    System.out.print(poleint4[x][y] + ", ");
                }
                System.out.println("\b\b");
            }

            System.out.println("- F�ze 3: z�pis pole do souboru");
            DataOutputStream fw4 = new DataOutputStream(fwJm4);
            for (int y = 0; y < poleint4.length; y++) {
                for (int x = 0; x < poleint4[y].length; x++) {
                    fw4.writeInt(poleint4[x][y]);
                }
            }
            fw4.close();

            System.out.println("- F�ze 4: kontroln� v�pis ze souboru na obrazovku:");
            DataInputStream frBin4 = new DataInputStream(frBinJm4);
            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 10; x++) {
                    cis4 = frBin4.readInt();
                    System.out.print(cis4 + ", ");
                }
                System.out.println("\b\b");
            }
            frBin4.close();
        }
    }
}
