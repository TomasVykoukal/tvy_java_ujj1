package org.example;

import org.jetbrains.annotations.NotNull;

//deklarace t��dy
public class Kap_8_Obdelnik {
    public int sirka;
    public int vyska;

    //(explicitn�) konstruktory
    public /*void*/ Kap_8_Obdelnik (int sirka, int vyska) {
        //this.sirka = sirka;
        //vol�n� metod jin�mi metodami t�e t��dy nebo konstruktorem
        this.nastavSirku(sirka);
        this.vyska = vyska;
        //return /*vyska*/;
    }
    //VOID v konstr.:
    /*java: constructor Kap_8_Obdelnik in class org.example.Kap_8_Obdelnik cannot be applied to given types;
      required: no arguments
      found:    int,int
      reason: actual and formal argument lists differ in length*/
    /*java: no suitable constructor found for Kap_8_Obdelnik(int,int)
          constructor org.example.Kap_8_Obdelnik.Kap_8_Obdelnik(@org.jetbrains.annotations.NotNull org.example.Kap_8_Obdelnik) is not applicable
            (actual and formal argument lists differ in length)
          constructor org.example.Kap_8_Obdelnik.Kap_8_Obdelnik() is not applicable
            (actual and formal argument lists differ in length)*/

    //RETURN %param% v konstr.:
    /*java: incompatible types: unexpected return value*/
    //RETURN (bez param) v konstr.:
    /*OK, RETURN mo�no pou��t pro p�ed�asn� ukon�en� b�hu konstr.*/

    public Kap_8_Obdelnik(@NotNull Kap_8_Obdelnik o) { //pozn.: automaticky nab�dnut� anotace
        /*this.sirka = o.sirka;
        this.vyska = o.vyska;*/
        //vyu�it� THIS() pro p��stup ke konstruktoru
        this(o.sirka, o.vyska);
    }
    public Kap_8_Obdelnik() {
        /*this.sirka = 1;
        this.vyska = 1;*/
        //vyu�it� THIS() pro p��stup ke konstruktoru
        this(1, 1);
    }

    public void nastavSirku (int sirka) {
        this.sirka = sirka;
    }

    public int obvod() {
        int pom;
        pom = 2 * (this.sirka + this.vyska);
        return pom;
    }

    public int obsah() {
        return this.sirka * this.vyska;
    }

    //pou�it� statick�ch metod v objektech
    //- pou�it� statick� metody ze t��dy Java Core API
    public double delkaUhlopricky() {
        double pom;
        pom = Math.pow(sirka, 2) + Math.pow(vyska, 2);
        pom = Math.sqrt(pom);
        return pom;
    }

    //Kap. 8.13 - Ru�en� objekt�: ru�en� obj. vynulov�n�m ref. prom�nn� p�i pr�ci s velk�mi objemy pam�ti
    public static void slozityVypocet() {
        double[] pomPole1 = new double[1_000_000_000];
        double[] pomPole2 = new double[60_000_000];
        for (int i = 0; i < pomPole1.length; i++) {
            pomPole1[i] = 123456.789;
        }
        for (int i = 0; i < pomPole2.length; i++) {
            pomPole2[i] = 987654.321;
        }
        /*pomPole2 pam�ov� p��li� velk� (>cca 60 mil.; pomPole1 = 1 mlrd.):
        Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
            at org.example.Kap_8_Obdelnik.slozityVypocet(Kap_8_Obdelnik.java:68)
            at org.example.Kap_8_Obdelnik.main(Kap_8_Obdelnik.java:136)*/

        //pomPole1 = null; //vynulov�n� ref. prom�nn�ch (a spu�t�n� GC) opodstatn�n� jen, pokud v�po�et pokra�uje
        //pomPole2 = null; //opu�t�n�m metody lok. prom�nn� zanik� automaticky
        //System.gc();
    }

    public static void main(String[] args) {
        //vytvo�en� objektu
        //Kap_8_Obdelnik obd = new Kap_8_Obdelnik(); //varianta bez konstruktoru (impl. konstruktor) �i s konstruktorem bez param.
        Kap_8_Obdelnik obd = new Kap_8_Obdelnik(4, 5);

        //v obj. implicitn� inicializace prom�nn�ch na 0 - plat� pro:
        //- prom�nn� deklarovan� bez inicializace
        //- objekt bez inicializace prom�nn�ch v konstruktoru
        System.out.println("���ka: " + obd.sirka + ", v��ka: " + obd.vyska);

        //r�zn� pokusy
        System.out.println("obd.hashCode: " + obd.hashCode());
        System.out.println("obd.toString: " + obd.toString());
        System.out.println("obd.getClass: " + obd.getClass());

        //p��m� p��stup k dat�m obj.
        obd.sirka = 6;
        obd.vyska = 5;
        System.out.println("���ka: " + obd.sirka + ", v��ka: " + obd.vyska);

        //pr�ce s metodami
        int obv = obd.obvod();
        System.out.println("Obvod obd�ln�ka: " + obv);
        int obs = obd.obsah();
        System.out.println("Obsah obd�ln�ka: " + obs);

        //pr�ces s p�et�en�mi konstruktory
        Kap_8_Obdelnik obdel = new Kap_8_Obdelnik(5, 3);
        Kap_8_Obdelnik jiny  = new Kap_8_Obdelnik(obdel);
        Kap_8_Obdelnik jedn  = new Kap_8_Obdelnik();

        System.out.println("���ka: " + obdel.sirka + ", v��ka: " + obdel.vyska);
        System.out.println("���ka: " + jiny.sirka + ", v��ka: " + jiny.vyska);
        System.out.println("���ka: " + jedn.sirka + ", v��ka: " + jedn.vyska);

        System.out.println("Obvod je: " + obdel.obvod());
        System.out.println("Obvod je: " + jiny.obvod());
        System.out.println("Obvod je: " + jedn.obvod());

        System.out.println("Obsah je: " + obdel.obsah());
        System.out.println("Obsah je: " + jiny.obsah());
        System.out.println("Obsah je: " + jedn.obsah());

        System.out.println("Uhlop���ka je: " + obdel.delkaUhlopricky());
        System.out.println("Uhlop���ka je: " + jiny.delkaUhlopricky());
        System.out.println("Uhlop���ka je: " + jedn.delkaUhlopricky());

        //ru�en� objekt� - 2 varianty
        Kap_8_Obdelnik obd1 = new Kap_8_Obdelnik(4, 5);
        obd1 = new Kap_8_Obdelnik(5, 3); //do ref. prom�nn� se p�i�ad� odkaz na jin� obj.
        Kap_8_Obdelnik obd2 = new Kap_8_Obdelnik(4, 5);
        obd2 = null; //ref. prom�nn� se vynuluje

        //Kap. 8.13 - Ru�en� objekt�: pokr.
        //System.gc();
        slozityVypocet(); //-->viz Task Manager vyu�it� pam�ti
        try {
            Thread.currentThread().sleep(5000);
        }
        catch (java.lang.InterruptedException e) {}
        //System.gc();

    }
}
