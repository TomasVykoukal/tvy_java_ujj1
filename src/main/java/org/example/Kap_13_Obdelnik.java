package org.example;

//13.6 implementované rozhraní se dìdí beze zmìny
public class Kap_13_Obdelnik extends Kap_13_Usecka {
    int sirka;
    Kap_13_Obdelnik(int delka, int sirka) {
        super(delka);
        this.sirka = sirka;
    }

    public void kdoJsem() {
        System.out.println("Obdélník; délka = " + this.delka + " / ¹íøka = " + this.sirka);
    } /*bez implementace této metody ve tø. Obdelnik bude vyti¹tìno toto:
          Úseèka; délka = 5
          Úseèka; délka = 2
          Úseèka; délka = 6
          Úseèka; délka = 3
      */

    public static void main(String[] args) {
        Kap_13_Usecka   u  = new Kap_13_Usecka(5);
        Kap_13_Obdelnik o  = new Kap_13_Obdelnik(2, 4);
        Kap_13_Info     iu = new Kap_13_Usecka(6);
        Kap_13_Info     io = new Kap_13_Obdelnik(3, 6);

        u.kdoJsem();
        o.kdoJsem();
        iu.kdoJsem();
        io.kdoJsem();
    }
}
