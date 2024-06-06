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
        System.out.println("Zaèátek programu");
        Kap_20_Daemon vlD = new Kap_20_Daemon();
        //comment   => normální vlákno, hlá¹ení se vypí¹e 10x
        //uncomment => démon, hlá¹ení se vypí¹e 1x pøíp. vùbec a program skonèí, ptz. skonèilo vlákno main()
        vlD.setDaemon(true);
        vlD.start();

        //dodateèný blok - zdr¾ení, aby se hlá¹ení démona vypsalo alespoò 1x
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {}
        //dodateèný blok - konec

        if (vlD.isDaemon()) {
            System.out.println("Program hned skonèí (vlD.isDaemon() == true).");
        }
        else {
            System.out.println("Program pobì¾í déle (vlD.isDaemon() == false).");
        }
        System.out.println("Konec programu");
    }
}
