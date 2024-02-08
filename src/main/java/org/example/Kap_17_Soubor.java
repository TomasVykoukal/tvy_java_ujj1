package org.example;

import java.io.File;
import java.io.FilenameFilter;

class FiltrPripony implements FilenameFilter {
    String maska;
    FiltrPripony(String maska) {
        this.maska = maska;
    }

    public boolean accept(File dir, String name) { //parametr DIR zde nevyu¾it
        if (name.lastIndexOf(maska) > 0) {
            return true;
        }
        else {
            return false;
        }
    }
}

class FiltrVelikosti implements FilenameFilter {
    int velikost;
    FiltrVelikosti(int velikost) {
        this.velikost = velikost;
    }

    public boolean accept(File dir, String name) {
        File f = new File(dir, name);
        if (f.length() > this.velikost) {
            return true;
        }
        else {
            return false;
        }
    }
}

public class Kap_17_Soubor {
    public static void main(String[] args) {
        //pokusy a zkoumání
        String text = "1234567890_Pass";
        System.out.print(text.lastIndexOf("5"));
        System.out.print(' ');
        System.out.print(text.lastIndexOf("0"));
        System.out.print(' ');
        System.out.print(text.lastIndexOf("0_P"));
        System.out.print(' ');
        System.out.print(text.lastIndexOf("0_P") + '\n'); //9 + '\n' pøevedený na èíslo (10)
        System.out.print(' ');
        System.out.println(text.lastIndexOf("0_P" + '\n')); //-1 (nenalezeno)
        System.out.println();

        //String jmenoAktDir = System.getProperty("user.dir");
        String jmenoAktDir = "C:\\Doku\\Know-How\\git\\tvy_spielwiese\\src\\main\\java\\org\\example\\";
        File aktDir = new File(jmenoAktDir);

        FiltrPripony filtrPr = new FiltrPripony(".java");
        String[] jmena = aktDir.list(filtrPr);
        System.out.println("Výpis podle filtru pøípon:");
        for (int i = 0; i < jmena.length; i++) {
            System.out.println((i + 1) + ". " + jmena[i]);
        }

        FiltrVelikosti filtrVel = new FiltrVelikosti(4000);
        File[] soubory = aktDir.listFiles(filtrVel);
        System.out.println("Výpis podle filtru velikostí:");
        for (int i = 0; i < soubory.length; i++) {
            System.out.println((i + 1) + ". " + soubory[i].getName() + '\t' + soubory[i].length());
        }
    }
}
