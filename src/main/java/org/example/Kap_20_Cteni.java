package org.example;

import java.io.*;
import java.nio.Buffer;

//20.6.7 synchronizace èasové posloupnosti vláken (producent - konzument)
//Tø. Cteni ète data ze souboru. Met. WAIT() a NOTIFY*() pocházejí ze tø. Object, nikoliv Thread.
//Metody tø. Cteni nejsou vlákna, pouze jsou z vláken volány.
public class Kap_20_Cteni {
    private FileReader fr;
    private BufferedReader in;
    public String jmenoSouboru;
    private int hodnota;
    private boolean precteno = false; //Zaji¹»uje, ¾e døíve vykonává èinnost metoda NACTI() a ne metoda PREDEJ().
    private boolean konecSouboru = false;

    //Konstruktor pouze otevøe po¾adovaný soubor, kt. zavøe a¾ met. FINALIZE().
    Kap_20_Cteni(String jmeno) {
        this.jmenoSouboru = new String(jmeno);
        try {
            this.fr = new FileReader(this.jmenoSouboru);
            this.in = new BufferedReader(this.fr);
        }
        catch (IOException e) {
            System.out.println("Chyba pøi otevírání souboru!");
        }
    }

    //Zde probíhá naèítání za souèasného øízení støídavého bìhu vláken (PRECTENO + WAIT() a NOTIFYALL()).
    //Met. zajistí naètení jednoho èísla ze souboru a jeho ulo¾ení do pom. prom. HODNOTA.
    synchronized public void nacti() {
        while (this.precteno) {
            try {
                wait();
            }
            catch (InterruptedException e) { }
        }

        String radka;
        try {
            if ((radka = this.in.readLine()) != null) {
                this.hodnota = Integer.valueOf(radka).intValue();
                System.out.print(this.jmenoSouboru + " pøeèteno: " + this.hodnota + "   ");
            }
            else {
                this.konecSouboru = true;
                //20.7.1 problematika hladovìní a uváznutí (-> násl. øádku zakoment.)
                Thread.currentThread().interrupt();
            }
        }
        catch (IOException e) {
            System.out.println("Chyba pøi ètení souboru!");
        }
        this.precteno = true;
        notifyAll();
    }

    //Zde probíhá pøedání za souèasného øízení støídavého bìhu vláken (PRECTENO + WAIT() a NOTIFYALL()).
    //Met. naètené èíslo pøedá dále. Po pøeètení celého souboru bude akt. vlákno o této skuteènosti informováno
    // ... zasláním zprávy o pøeru¹ení (viz Thread.currentThread().interrupt()).
    synchronized public int predej() {
        while (!this.precteno) {
            try {
                wait();
            }
            catch (InterruptedException e) { }
        }
        this.precteno = false;
        if (!this.konecSouboru) {
            System.out.println(this.jmenoSouboru + " pøedáno: " + this.hodnota);
            notifyAll();
            return this.hodnota;
        }
        else {
            Thread.currentThread().interrupt();
            return 0;
        }
    }

    protected void finalize() {
        try {
            this.fr.close();
        }
        catch (IOException e) {
            System.out.println("Chyba pøi zavírání souboru!");
        }
    }
}
