package org.example;

import org.jetbrains.annotations.NotNull;

//deklarace třídy
public class Kap_8_Obdelnik {
    public int sirka;
    public int vyska;

    //(explicitní) konstruktory
    public /*void*/ Kap_8_Obdelnik (int sirka, int vyska) {
        //this.sirka = sirka;
        //volání metod jinými metodami téže třídy nebo konstruktorem
        this.nastavSirku(sirka);
        this.vyska = vyska;
        //return vyska;
    }
    //VOID v konstr.:
    /*java: constructor Kap_8_Obdelnik in class org.example.Kap_8_Obdelnik cannot be applied to given types;
      required: no arguments
      found:    int,int
      reason: actual and formal argument lists differ in length*/

    //RETURN %param% v konstr.:
    /*java: incompatible types: unexpected return value*/
    //RETURN (bez param) v konstr.:
    /*OK, RETURN možno použít pro předčasné ukončení běhu konstr.*/

    public Kap_8_Obdelnik(@NotNull Kap_8_Obdelnik o) { //pozn.: automaticky nabídnutá anotace
        /*this.sirka = o.sirka;
        this.vyska = o.vyska;*/
        //využití THIS() pro přístup ke konstruktoru
        this(o.sirka, o.vyska);
    }
    public Kap_8_Obdelnik() {
        /*this.sirka = 1;
        this.vyska = 1;*/
        //využití THIS() pro přístup ke konstruktoru
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

    //použití statických metod v objektech
    //- použití statická metody ze třídy Java Core API
    public double delkaUhlopricky() {
        double pom;
        pom = Math.pow(sirka, 2) + Math.pow(vyska, 2);
        pom = Math.sqrt(pom);
        return pom;
    }

    //Kap. 8.13 - Rušení objektů: rušení obj. vynulováním ref. proměnné při práci s velkými objemy paměti
    public static void slozityVypocet() {
        double[] pomPole1 = new double[1_000_000_000];
        double[] pomPole2 = new double[60_000_000];
        for (int i = 0; i < 1_000_000_000; i++) {
            pomPole1[i] = 123456.789;
        }
        for (int i = 0; i < 60_000_000; i++) {
            pomPole2[i] = 987654.321;
        }
        /*pomPole2 zu groß (>cca 60 mil.; pomPole1 = 1 mlrd.):
        Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
            at org.example.Kap_8_Obdelnik.slozityVypocet(Kap_8_Obdelnik.java:68)
            at org.example.Kap_8_Obdelnik.main(Kap_8_Obdelnik.java:136)*/

        //pomPole1 = null;
        //pomPole2 = null;
        //System.gc();
    }

    public static void main(String[] args) {
        //vytvoření objektu
        //Kap_8_Obdelnik obd = new Kap_8_Obdelnik(); //varianta bez konstruktoru (impl. konstruktor) či s konstruktorem bez param.
        Kap_8_Obdelnik obd = new Kap_8_Obdelnik(4, 5);

        //v obj. implicitní inicializace proměnných na 0 - platí pro:
        //- proměnné deklarované bez inicializace
        //- objekt bez inicializace proměnných v konstruktoru
        System.out.println("šířka: " + obd.sirka + ", výška: " + obd.vyska);

        //různé pokusy
        System.out.println("obd.hashCode: " + obd.hashCode());
        System.out.println("obd.toString: " + obd.toString());
        System.out.println("obd.getClass: " + obd.getClass());

        //přímý přístup k datům obj.
        obd.sirka = 6;
        obd.vyska = 5;
        System.out.println("šířka: " + obd.sirka + ", výška: " + obd.vyska);

        //práce s metodami
        int obv = obd.obvod();
        System.out.println("Obvod obdélníka: " + obv);
        int obs = obd.obsah();
        System.out.println("Obsah obdélníka: " + obs);

        //práces s přetíženými konstruktory
        Kap_8_Obdelnik obdel = new Kap_8_Obdelnik(5, 3);
        Kap_8_Obdelnik jiny  = new Kap_8_Obdelnik(obdel);
        Kap_8_Obdelnik jedn  = new Kap_8_Obdelnik();

        System.out.println("šířka: " + obdel.sirka + ", výška: " + obdel.vyska);
        System.out.println("šířka: " + jiny.sirka + ", výška: " + jiny.vyska);
        System.out.println("šířka: " + jedn.sirka + ", výška: " + jedn.vyska);

        System.out.println("Obvod je: " + obdel.obvod());
        System.out.println("Obvod je: " + jiny.obvod());
        System.out.println("Obvod je: " + jedn.obvod());

        System.out.println("Obsah je: " + obdel.obsah());
        System.out.println("Obsah je: " + jiny.obsah());
        System.out.println("Obsah je: " + jedn.obsah());

        System.out.println("Uhlopříčka je: " + obdel.delkaUhlopricky());
        System.out.println("Uhlopříčka je: " + jiny.delkaUhlopricky());
        System.out.println("Uhlopříčka je: " + jedn.delkaUhlopricky());

        //rušení objektů - 2 varianty
        Kap_8_Obdelnik obd1 = new Kap_8_Obdelnik(4, 5);
        obd1 = new Kap_8_Obdelnik(5, 3); //do ref. proměnné se přiřadí odkaz na jiný obj.
        Kap_8_Obdelnik obd2 = new Kap_8_Obdelnik(4, 5);
        obd2 = null; //ref. proměnná se vynuluje

        //Kap. 8.13 - Rušení objektů: pokr.
        //System.gc();
        slozityVypocet(); //-->viz Task Manager využití paměti
        try {
            Thread.currentThread().sleep(5000);
        }
        catch (java.lang.InterruptedException e) {}
        //System.gc();

    }
}
