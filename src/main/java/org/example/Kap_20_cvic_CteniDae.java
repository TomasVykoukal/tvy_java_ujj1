package org.example;

import java.io.*;

//20.6.7 synchronizace �asov� posloupnosti vl�ken (producent - konzument)
//20.7.3 vl�kna typu d�mon
public class Kap_20_cvic_CteniDae {
    private FileReader fr;
    private BufferedReader in;
    public String jmenoSouboru;
    private int hodnota;
    private boolean precteno = false;
    private boolean konecSouboru = false;

    //prom�nn� pro rouru
    private PipedOutputStream rouraVystup;
    private PipedInputStream rouraVstup;
    private DataOutputStream binRouraVystup;
    private DataInputStream binRouraVstup;

    Kap_20_cvic_CteniDae(String jmeno) {
        this.jmenoSouboru = new String(jmeno);
        try {
            //otev�en� souboru
            this.fr = new FileReader(this.jmenoSouboru);
            this.in = new BufferedReader(this.fr);

            //otev�en� roury - data p�jdou bin�rn� neform�tovan�
            this.rouraVystup    = new PipedOutputStream();
            this.rouraVstup     = new PipedInputStream(this.rouraVystup);
            this.binRouraVystup = new DataOutputStream(this.rouraVystup);
            this.binRouraVstup  = new DataInputStream(this.rouraVstup);
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
                this.binRouraVystup.writeInt(this.hodnota); //zaps�n� do roury
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
            //�ten� z roury
            try {
                this.hodnota = binRouraVstup.readInt();
                System.out.println(this.jmenoSouboru + " p�ed�no: " + this.hodnota);
                notifyAll();
                return this.hodnota;
            }
            catch (IOException e) {
                System.out.println("Chyba p�i �ten� z roury!");
            }
        }
        else {
            Thread.currentThread().interrupt();
        }
        return 0;
    }

    protected void finalize() {
        try {
            this.fr.close();
            //�prava pro rouru
            this.binRouraVstup.close();
            this.binRouraVystup.close();
        }
        catch (IOException e) {
            System.out.println("Chyba p�i zav�r�n� souboru!");
        }
    }
}
