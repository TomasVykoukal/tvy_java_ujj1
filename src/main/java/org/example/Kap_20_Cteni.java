package org.example;

import java.io.*;
import java.nio.Buffer;

//20.6.7 synchronizace �asov� posloupnosti vl�ken (producent - konzument)
//T�. Cteni �te data ze souboru. Met. WAIT() a NOTIFY*() poch�zej� ze t�. Object, nikoliv Thread.
//Metody t�. Cteni nejsou vl�kna, pouze jsou z vl�ken vol�ny.
public class Kap_20_Cteni {
    private FileReader fr;
    private BufferedReader in;
    public String jmenoSouboru;
    private int hodnota;
    private boolean precteno = false; //Zaji��uje, �e d��ve vykon�v� �innost metoda NACTI() a ne metoda PREDEJ().
    private boolean konecSouboru = false;

    //Konstruktor pouze otev�e po�adovan� soubor, kt. zav�e a� met. FINALIZE().
    Kap_20_Cteni(String jmeno) {
        this.jmenoSouboru = new String(jmeno);
        try {
            this.fr = new FileReader(this.jmenoSouboru);
            this.in = new BufferedReader(this.fr);
        }
        catch (IOException e) {
            System.out.println("Chyba p�i otev�r�n� souboru!");
        }
    }

    //Zde prob�h� na��t�n� za sou�asn�ho ��zen� st��dav�ho b�hu vl�ken (PRECTENO + WAIT() a NOTIFYALL()).
    //Met. zajist� na�ten� jednoho ��sla ze souboru a jeho ulo�en� do pom. prom. HODNOTA.
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
                System.out.print(this.jmenoSouboru + " p�e�teno: " + this.hodnota + "   ");
            }
            else {
                this.konecSouboru = true;
                //20.7.1 problematika hladov�n� a uv�znut� (-> n�sl. ��dku zakoment.)
                Thread.currentThread().interrupt();
            }
        }
        catch (IOException e) {
            System.out.println("Chyba p�i �ten� souboru!");
        }
        this.precteno = true;
        notifyAll();
    }

    //Zde prob�h� p�ed�n� za sou�asn�ho ��zen� st��dav�ho b�hu vl�ken (PRECTENO + WAIT() a NOTIFYALL()).
    //Met. na�ten� ��slo p�ed� d�le. Po p�e�ten� cel�ho souboru bude akt. vl�kno o t�to skute�nosti informov�no
    // ... zasl�n�m zpr�vy o p�eru�en� (viz Thread.currentThread().interrupt()).
    synchronized public int predej() {
        while (!this.precteno) {
            try {
                wait();
            }
            catch (InterruptedException e) { }
        }
        this.precteno = false;
        if (!this.konecSouboru) {
            System.out.println(this.jmenoSouboru + " p�ed�no: " + this.hodnota);
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
            System.out.println("Chyba p�i zav�r�n� souboru!");
        }
    }
}
