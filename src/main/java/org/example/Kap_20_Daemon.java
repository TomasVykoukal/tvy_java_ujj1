package org.example;

public class Kap_20_Daemon extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + ". daemon test");
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {}
        }
    }

    public static void main(String[] args) {
        System.out.println("Za��tek programu");
        Kap_20_Daemon vlD = new Kap_20_Daemon();
        //comment   => norm�ln� vl�kno, hl�en� se vyp�e 10x
        //uncomment => d�mon, hl�en� se vyp�e 1x p��p. v�bec a program skon��, ptz. skon�ilo vl�kno main()
        vlD.setDaemon(true);
        vlD.start();

        //dodate�n� blok - zdr�en�, aby se hl�en� d�mona vypsalo alespo� 1x
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {}
        //dodate�n� blok - konec

        if (vlD.isDaemon()) {
            System.out.println("Program hned skon�� (vlD.isDaemon() == true).");
        }
        else {
            System.out.println("Program pob�� d�le (vlD.isDaemon() == false).");
        }
        System.out.println("Konec programu");
    }
}
