package org.example;

public class Kap_8_Zakaznik {
    public static int pocetZakazniku = 0;
    public int untratil;

    public Kap_8_Zakaznik() {
        Kap_8_Zakaznik.pocetZakazniku++;
        this.untratil = 0;
    }

    public void platil(int cena) {
        this.untratil += cena;
    }

    public static void main(String[] args) {
        System.out.println("Počet zákazníků (1): " + Kap_8_Zakaznik.pocetZakazniku);
        Kap_8_Zakaznik zak1 = new Kap_8_Zakaznik();
        System.out.println("Počet zákazníků (2): " + Kap_8_Zakaznik.pocetZakazniku);
        zak1.platil(15);
        Kap_8_Zakaznik zak2 = new Kap_8_Zakaznik();
        System.out.println("Počet zákazníků (3): " + Kap_8_Zakaznik.pocetZakazniku);
        zak1.platil(30);
        zak2.platil(20);
        System.out.println("Utratili: " + zak1.untratil + " + " + zak2.untratil);
        Kap_8_Zakaznik.pocetZakazniku++;
    }
}
