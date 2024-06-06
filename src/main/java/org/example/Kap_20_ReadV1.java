package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//20.2 spolupráce dvou vláken
//čtecí vlákno (výpisové vlákno -> Kap_20_Vlakno2)
public class Kap_20_ReadV1 extends Thread {
    FileReader fr;
    BufferedReader in;
    String jmenoSouboru;

    static public int cislo = 0;
    static public long suma = 0;
    static public boolean hotovo = false;

    Kap_20_ReadV1(String jmenoSouboru) {
        super("Vlákno pro čtení");
        this.jmenoSouboru = jmenoSouboru;
    }

    public void run() {
        String radka;

        try {
            this.fr = new FileReader(this.jmenoSouboru);
            this.in = new BufferedReader(this.fr);
            while ((radka = this.in.readLine()) != null) {
                Kap_20_ReadV1.cislo = Integer.valueOf(radka).intValue();
                Kap_20_ReadV1.suma += Kap_20_ReadV1.cislo;
                Thread.yield(); //toto předání řízení se volitelně vypíná - viz test v Kap_20_Vlakno2::main()
                                //20.3.4 praktické ověření a plánování priorit
            }
            this.fr.close();
            Kap_20_ReadV1.hotovo = true;
        }
        catch (IOException e) {
            System.out.println("Chyba v souboru!");
        }
    }
}
