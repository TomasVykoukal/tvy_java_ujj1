package org.example;

import java.util.concurrent.TimeUnit;

//20.1 tøída Thread
public class Kap_20_Vlakno1 extends Thread {

    public Kap_20_Vlakno1(String jmeno) {
        super(jmeno); //konstruktoru tøídy Thread pøedáváme jméno budoucího vlákna (viz getName() ní¾e)
    }                 //"extends Thread" => vlákno je tøeba v konstruktoru pojmenovat; nejèastìji pomocí SUPER()

    public void run() { //RUN() bì¾í specificky pro urèité vlákno.
        for (int i = 1; i <= 3; i++) {
            System.out.println(i + ". " + getName()); //Returns this thread's name.
            try {
                Thread.sleep(1000); //Causes the currently executing thread to sleep (temporarily cease execution) for the specified number of ms.
                                          //=> mezi jednotlivými trojicemi výpisù je tato prodleva
            }
            catch (InterruptedException e) {
                System.out.println("Probudili jste mì!");
            }
        }
        System.out.println("vlákno \"" + getName() + "\" ukonèeno");
    }

    public static void main(String[] args) {
        try { //TimeUnit...sleep() zaji¹»uje odstup mezi vlákny, tak¾e se startují v pøedepsaném poøadí (neprohodí se).
              //... Pou¾ití TimeUnit vynucuje o¹etøení výjimky InterruptedException.
            Kap_20_Vlakno1 vlAhoj = new Kap_20_Vlakno1("Ahoj");
            vlAhoj.start(); //Causes this thread to begin execution; the JVM calls the RUN() method of this thread.
            TimeUnit.MILLISECONDS.sleep(30);
            new Kap_20_Vlakno1("Nazdar").start();
            TimeUnit.MILLISECONDS.sleep(30);
            new Kap_20_Vlakno1("ciao!").start();
            TimeUnit.MILLISECONDS.sleep(30); //úèel: aby výpis priorit (20.3.2) probìhl a¾ po "1. ciao!"
        }
        catch (InterruptedException e) {}

        //20.3.2 priorita vlákna
        System.out.println("MIN_PRIORITY: " + MIN_PRIORITY);
        System.out.println("NORM_PRIORITY: " + NORM_PRIORITY);
        System.out.println("MAX_PRIORITY: " + MAX_PRIORITY);
    }
}
