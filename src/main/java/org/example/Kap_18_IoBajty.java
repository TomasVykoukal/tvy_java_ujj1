package org.example;

import java.io.*;

public class Kap_18_IoBajty {
    public static void main(String[] args) throws IOException {
        //18.3.2 vstupy a výstupy bajtů
        System.out.println("18.3.2 vstupy a výstupy bajtů");
        File frJm1 = new File("a.txt");
        File fwJm1 = new File("16_3_2_c.txt");

        if (frJm1.exists()) {
            FileInputStream fr1 = new FileInputStream(frJm1);
            FileOutputStream fw1 = new FileOutputStream(fwJm1);

            int c1;
            while ((c1 = fr1.read()) != -1) {
                fw1.write(c1);
            }
            fr1.close();
            fw1.close();
        }
    }
}
