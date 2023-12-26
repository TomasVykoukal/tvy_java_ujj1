package org.example;

import org.jetbrains.annotations.NotNull;

//deklarace tøídy
public class Kap_8_Obdelnik {
    public int sirka;
    public int vyska;

    //(explicitní) konstruktory
    public /*void*/ Kap_8_Obdelnik (int sirka, int vyska) {
        //this.sirka = sirka;
        //volání metod jinými metodami té¾e tøídy nebo konstruktorem
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
    /*OK, RETURN mo¾no pou¾ít pro pøedèasné ukonèení bìhu konstr.*/

    public Kap_8_Obdelnik(@NotNull Kap_8_Obdelnik o) { //pozn.: automaticky nabídnutá anotace
        /*this.sirka = o.sirka;
        this.vyska = o.vyska;*/
        //vyu¾ití THIS() pro pøístup ke konstruktoru
        this(o.sirka, o.vyska);
    }
    public Kap_8_Obdelnik() {
        /*this.sirka = 1;
        this.vyska = 1;*/
        //vyu¾ití THIS() pro pøístup ke konstruktoru
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

    //pou¾ití statických metod v objektech
    //- pou¾ití statická metody ze tøídy Java Core API
    public double delkaUhlopricky() {
        double pom;
        pom = Math.pow(sirka, 2) + Math.pow(vyska, 2);
        pom = Math.sqrt(pom);
        return pom;
    }

    //Kap. 8.13 - Ru¹ení objektù: ru¹ení obj. vynulováním ref. promìnné pøi práci s velkými objemy pamìti
    public static void slozityVypocet() {
        double[] pomPole1 = new double[1_000_000_000];
        double[] pomPole2 = new double[60_000_000];
        for (int i = 0; i < pomPole1.length; i++) {
            pomPole1[i] = 123456.789;
        }
        for (int i = 0; i < pomPole2.length; i++) {
            pomPole2[i] = 987654.321;
        }
        /*pomPole2 pamì»ovì pøíli¹ velké (>cca 60 mil.; pomPole1 = 1 mlrd.):
        Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
            at org.example.Kap_8_Obdelnik.slozityVypocet(Kap_8_Obdelnik.java:68)
            at org.example.Kap_8_Obdelnik.main(Kap_8_Obdelnik.java:136)*/

        //pomPole1 = null; //vynulování ref. promìnných (a spu¹tìní GC) opodstatnìné jen, pokud výpoèet pokraèuje
        //pomPole2 = null; //opu¹tìním metody lok. promìnná zaniká automaticky
        //System.gc();
    }

    public static void main(String[] args) {
        //vytvoøení objektu
        //Kap_8_Obdelnik obd = new Kap_8_Obdelnik(); //varianta bez konstruktoru (impl. konstruktor) èi s konstruktorem bez param.
        Kap_8_Obdelnik obd = new Kap_8_Obdelnik(4, 5);

        //v obj. implicitní inicializace promìnných na 0 - platí pro:
        //- promìnné deklarované bez inicializace
        //- objekt bez inicializace promìnných v konstruktoru
        System.out.println("¹íøka: " + obd.sirka + ", vý¹ka: " + obd.vyska);

        //rùzné pokusy
        System.out.println("obd.hashCode: " + obd.hashCode());
        System.out.println("obd.toString: " + obd.toString());
        System.out.println("obd.getClass: " + obd.getClass());

        //pøímý pøístup k datùm obj.
        obd.sirka = 6;
        obd.vyska = 5;
        System.out.println("¹íøka: " + obd.sirka + ", vý¹ka: " + obd.vyska);

        //práce s metodami
        int obv = obd.obvod();
        System.out.println("Obvod obdélníka: " + obv);
        int obs = obd.obsah();
        System.out.println("Obsah obdélníka: " + obs);

        //práces s pøetí¾enými konstruktory
        Kap_8_Obdelnik obdel = new Kap_8_Obdelnik(5, 3);
        Kap_8_Obdelnik jiny  = new Kap_8_Obdelnik(obdel);
        Kap_8_Obdelnik jedn  = new Kap_8_Obdelnik();

        System.out.println("¹íøka: " + obdel.sirka + ", vý¹ka: " + obdel.vyska);
        System.out.println("¹íøka: " + jiny.sirka + ", vý¹ka: " + jiny.vyska);
        System.out.println("¹íøka: " + jedn.sirka + ", vý¹ka: " + jedn.vyska);

        System.out.println("Obvod je: " + obdel.obvod());
        System.out.println("Obvod je: " + jiny.obvod());
        System.out.println("Obvod je: " + jedn.obvod());

        System.out.println("Obsah je: " + obdel.obsah());
        System.out.println("Obsah je: " + jiny.obsah());
        System.out.println("Obsah je: " + jedn.obsah());

        System.out.println("Uhlopøíèka je: " + obdel.delkaUhlopricky());
        System.out.println("Uhlopøíèka je: " + jiny.delkaUhlopricky());
        System.out.println("Uhlopøíèka je: " + jedn.delkaUhlopricky());

        //ru¹ení objektù - 2 varianty
        Kap_8_Obdelnik obd1 = new Kap_8_Obdelnik(4, 5);
        obd1 = new Kap_8_Obdelnik(5, 3); //do ref. promìnné se pøiøadí odkaz na jiný obj.
        Kap_8_Obdelnik obd2 = new Kap_8_Obdelnik(4, 5);
        obd2 = null; //ref. promìnná se vynuluje

        //Kap. 8.13 - Ru¹ení objektù: pokr.
        //System.gc();
        slozityVypocet(); //-->viz Task Manager vyu¾ití pamìti
        try {
            Thread.currentThread().sleep(5000);
        }
        catch (java.lang.InterruptedException e) {}
        //System.gc();

    }
}
