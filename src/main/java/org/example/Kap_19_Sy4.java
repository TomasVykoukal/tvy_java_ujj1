package org.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Kap_19_Sy4 {
    public static void main(String[] args) throws IOException {
        String oddRadek = System.getProperty("line.separator");
        String oddSouboru = System.getProperty("file.separator");
        File adr = new File("19_tmp");

        adr.mkdir();
        String jmSoub = adr.getName().concat(oddSouboru).concat("19_a_Sy4.txt");
        FileOutputStream fw = new FileOutputStream(jmSoub);
        PrintStream fwPr = new PrintStream(fw);

        fwPr.print("Jedna øádka");
        fwPr.println();
        fwPr.print("Druhá øádka");
        fwPr.print(oddRadek);
        fwPr.println("Tøetí øádka");
        fwPr.println("Ètvrtá øádka");
        fw.close();
    }
}
