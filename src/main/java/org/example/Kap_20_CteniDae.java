package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//20.6.7 synchronizace èasové posloupnosti vláken (producent - konzument)
//20.7.3 vlákna typu démon
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
