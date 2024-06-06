package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//20.6.7 synchronizace �asov� posloupnosti vl�ken (producent - konzument)
//20.7.3 vl�kna typu d�mon
public class Kap_20_CteniDae {
    private FileReader fr;
    private BufferedReader in;
    public String jmenoSouboru;
    private int hodnota;
    private boolean precteno = false;
    private boolean konecSouboru = false;

    Kap_20_CteniDae(String jmeno) {
        this.jmenoSouboru = new String(jmeno);
        try {
            this.fr = new FileReader(this.jmenoSouboru);
            this.in = new BufferedReader(this.fr);
        }
        catch (IOException e) {
            System.out.println("Chyba p�i otev�r�n� souboru!");
        }
    }

    //zde prob�h� na��t�n� za sou�asn�ho ��zen� st��dav�ho b�hu vl�ken (PRECTENO + WAIT() a NOTIFYALL())
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
                //Thread.currentThread().interrupt(); - �prava pro Dae
            }
        }
        catch (IOException e) {
            System.out.println("Chyba p�i �ten� souboru!");
        }
        this.precteno = true;
        notifyAll();
    }

    //zde prob�h� p�ed�n� za sou�asn�ho ��zen� st��dav�ho b�hu vl�ken (PRECTENO + WAIT() a NOTIFYALL())
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
