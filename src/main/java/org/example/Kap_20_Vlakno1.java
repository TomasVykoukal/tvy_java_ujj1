package org.example;

import java.util.concurrent.TimeUnit;

//20.1 t��da Thread
public class Kap_20_Vlakno1 extends Thread {

    public Kap_20_Vlakno1(String jmeno) {
        super(jmeno); //konstruktoru t��dy Thread p�ed�v�me jm�no budouc�ho vl�kna (viz getName() n�e)
    }                 //"extends Thread" => vl�kno je t�eba v konstruktoru pojmenovat; nej�ast�ji pomoc� SUPER()

    public void run() { //RUN() b�� specificky pro ur�it� vl�kno.
        for (int i = 1; i <= 3; i++) {
            System.out.println(i + ". " + getName()); //Returns this thread's name.
            try {
                Thread.sleep(1000); //Causes the currently executing thread to sleep (temporarily cease execution) for the specified number of ms.
                                          //=> mezi jednotliv�mi trojicemi v�pis� je tato prodleva
            }
            catch (InterruptedException e) {
                System.out.println("Probudili jste m�!");
            }
        }
        System.out.println("vl�kno \"" + getName() + "\" ukon�eno");
    }

    public static void main(String[] args) {
        try { //TimeUnit...sleep() zaji��uje odstup mezi vl�kny, tak�e se startuj� v p�edepsan�m po�ad� (neprohod� se).
              //... Pou�it� TimeUnit vynucuje o�et�en� v�jimky InterruptedException.
            Kap_20_Vlakno1 vlAhoj = new Kap_20_Vlakno1("Ahoj");
            vlAhoj.start(); //Causes this thread to begin execution; the JVM calls the RUN() method of this thread.
            TimeUnit.MILLISECONDS.sleep(30);
            new Kap_20_Vlakno1("Nazdar").start();
            TimeUnit.MILLISECONDS.sleep(30);
            new Kap_20_Vlakno1("ciao!").start();
            TimeUnit.MILLISECONDS.sleep(30); //��el: aby v�pis priorit (20.3.2) prob�hl a� po "1. ciao!"
        }
        catch (InterruptedException e) {}

        //20.3.2 priorita vl�kna
        System.out.println("MIN_PRIORITY: " + MIN_PRIORITY);
        System.out.println("NORM_PRIORITY: " + NORM_PRIORITY);
        System.out.println("MAX_PRIORITY: " + MAX_PRIORITY);
    }
}
