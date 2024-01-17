package org.example;

//13.6 implementovan� rozhran� se d�d� beze zm�ny
public class Kap_13_Obdelnik extends Kap_13_Usecka {
    int sirka;
    Kap_13_Obdelnik(int delka, int sirka) {
        super(delka);
        this.sirka = sirka;
    }

    public void kdoJsem() {
        System.out.println("Obd�ln�k; d�lka = " + this.delka + " / ���ka = " + this.sirka);
    } /*bez implementace t�to metody ve t�. Obdelnik bude vyti�t�no toto:
          �se�ka; d�lka = 5
          �se�ka; d�lka = 2
          �se�ka; d�lka = 6
          �se�ka; d�lka = 3
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
