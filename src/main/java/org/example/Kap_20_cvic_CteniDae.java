package org.example;

import java.io.*;

//20.6.7 synchronizace èasové posloupnosti vláken (producent - konzument)
//20.7.3 vlákna typu démon
public class Kap_20_cvic_CteniDae {
    private FileReader fr;
    private BufferedReader in;
    public String jmenoSouboru;
    private int hodnota;
    private boolean precteno = false;
    private boolean konecSouboru = false;

    //promìnné pro rouru
    private PipedOutputStream rouraVystup;
    private PipedInputStream rouraVstup;
    private DataOutputStream binRouraVystup;
    private DataInputStream binRouraVstup;

    Kap_20_cvic_CteniDae(String jmeno) {
        this.jmenoSouboru = new String(jmeno);
        try {
            //otevøení souboru
            this.fr = new FileReader(this.jmenoSouboru);
            this.in = new BufferedReader(this.fr);

            //otevøení roury - data pùjdou binárnì neformátované
            this.rouraVystup    = new PipedOutputStream();
            this.rouraVstup     = new PipedInputStream(this.rouraVystup);
            this.binRouraVystup = new DataOutputStream(this.rouraVystup);
            this.binRouraVstup  = new DataInputStream(this.rouraVstup);
        }
        catch (IOException e) {
            System.out.println("Chyba pøi otevírání souboru!");
        }
    }

    //zde probíhá naèítání za souèasného øízení støídavého bìhu vláken (PRECTENO + WAIT() a NOTIFYALL())
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
                this.binRouraVystup.writeInt(this.hodnota); //zapsání do roury
            }
            else {
                this.konecSouboru = true;
                //Thread.currentThread().interrupt(); - úprava pro Dae
            }
        }
        catch (IOException e) {
            System.out.println("Chyba pøi ètení souboru!");
        }
        this.precteno = true;
        notifyAll();
    }

    //zde probíhá pøedání za souøasného øízení støídavého bìhu vláken (PRECTENO + WAIT() a NOTIFYALL())
    synchronized public int predej() {
        while (!this.precteno) {
            try {
                wait();
            }
            catch (InterruptedException e) { }
        }
        this.precteno = false;
        if (!this.konecSouboru) {
            //ètení z roury
            try {
                this.hodnota = binRouraVstup.readInt();
                System.out.println(this.jmenoSouboru + " pøedáno: " + this.hodnota);
                notifyAll();
                return this.hodnota;
            }
            catch (IOException e) {
                System.out.println("Chyba pøi ètení z roury!");
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
            //úprava pro rouru
            this.binRouraVstup.close();
            this.binRouraVystup.close();
        }
        catch (IOException e) {
            System.out.println("Chyba pøi zavírání souboru!");
        }
    }
}
