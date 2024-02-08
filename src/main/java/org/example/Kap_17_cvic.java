package org.example;

import java.io.File;
import java.io.FilenameFilter;

//cvièení 3+4
class FiltrJm implements FilenameFilter {
    String maska;
    FiltrJm(String maska) {
        this.maska = maska;
    }

    public boolean accept(File dir, String name) {
        if (name.lastIndexOf(this.maska) >= 0) {
            return true;
        }
        else {
            return false;
        }
    }
}

public class Kap_17_cvic {
    //cvièení 1-4
    public static void vypisAdr(String adr, String filtrText, String odskok) {
        File rodAdr = new File(adr);
        FiltrJm filtrJm = new FiltrJm(filtrText);
        File[] adrPole = rodAdr.listFiles(filtrJm);
        int j_adr = 0;
        int j_soub = 0;

        for (int i = 0; i < adrPole.length; i++) {
            if (adrPole[i].isDirectory()) {
                j_adr++;
                System.out.print("[|] ");
                System.out.print(odskok);
                System.out.print(j_adr + ". ");
                System.out.println(adrPole[i].getName());
                vypisAdr(adr + File.separator + adrPole[i].getName(), filtrText, odskok + "  ");
            } else if (adrPole[i].isFile()) {
                j_soub++;
                System.out.print("[-] ");
                System.out.print(odskok);
                System.out.print(j_soub + ". ");
                System.out.println(adrPole[i].getName());
            }
        }
    }

    public static void main(String[] args) {
        //String rodAdrJmeno = System.getProperty("user.dir") + File.separator + "src";
        //String rodAdrJmeno = "C:\\Doku\\Know-How\\git\\tvy_spielwiese\\src\\main\\java\\org\\example\\";
        //String rodAdrJmeno = "C:\\Doku\\Privé\\";
        String rodAdrJmeno = "C:\\Doku\\Know-How\\Architektur\\";
        String filtrText = "iSAQB";

        System.out.println("Výpis adresáøù, podadresáøù " + rodAdrJmeno + " a jejich souborù (\'" + filtrText + "\'):");
        vypisAdr(rodAdrJmeno, filtrText, "");
    }
}
