package org.example;

//deklarace třídy
public class Kap_8_Obdelnik {
    public int sirka;
    public int vyska;

    //(explicitní) konstruktor
    public /*void*/ Kap_8_Obdelnik (int sirka, int vyska) {
        //this.sirka = sirka;
        //volání metod jinými metodami téže třídy nebo konstruktorem
        this.nastavSirku(sirka);
        this.vyska = vyska;
    }
    //VOID v konstr.:
    /*java: constructor Kap_8_Obdelnik in class org.example.Kap_8_Obdelnik cannot be applied to given types;
      required: no arguments
      found:    int,int
      reason: actual and formal argument lists differ in length*/

    public Kap_8_Obdelnik(Kap_8_Obdelnik o) {
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

    public static void main(String[] args) {
        //vytvoření objektu
        //Kap_8_Obdelnik obd = new Kap_8_Obdelnik(); //varianta bez konstruktoru (impl. konstruktor) či s konstruktorem bez param.
        Kap_8_Obdelnik obd = new Kap_8_Obdelnik(4, 5);

        //v obj. impl. inicializace na 0 - platí pro variantu bez inicializace v obj. a bez inicializačního konstruktoru
        System.out.println("šířka: " + obd.sirka + ", výška: " + obd.vyska);

        //různé pokusy
        System.out.println("obd.hashCode: " + obd.hashCode());
        System.out.println("obd.toString: " + obd.toString());
        System.out.println("obd.getClass: " + obd.getClass());

        //přímý přístup k datům obj.
        obd.vyska = 5;
        obd.sirka = 6;
        System.out.println("šířka: " + obd.sirka + ", výška: " + obd.vyska);

        //práce s metodami
        int obv = obd.obvod();
        System.out.println("Obvod obdélníka: " + obv);

        //práces s přetíženými konstruktory
        Kap_8_Obdelnik obdel = new Kap_8_Obdelnik(5, 3);
        Kap_8_Obdelnik jiny  = new Kap_8_Obdelnik(obdel);
        Kap_8_Obdelnik jedn  = new Kap_8_Obdelnik();
        System.out.println("Obdod je: " + obdel.obvod());
        System.out.println("Obdod je: " + jiny.obvod());
        System.out.println("Obdod je: " + jedn.obvod());

    }
}
