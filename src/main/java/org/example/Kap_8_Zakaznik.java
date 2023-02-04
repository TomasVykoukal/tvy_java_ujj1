package org.example;

public class Kap_8_Zakaznik {
    //public static int pocetZakazniku = 0;
    private static int pocetZakazniku = 0;
    public int utratil;

    public Kap_8_Zakaznik() {
        Kap_8_Zakaznik.pocetZakazniku++;
        this.utratil = 0;
    }

    //použití statických metod v objektech
    //- použití statická metody z téže třídy
    public static int kolikZakazniku() {
        return pocetZakazniku;
    }

    public void platil(int cena) {
        this.utratil += cena;
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
        System.out.println("Utratili: " + zak1.utratil + " + " + zak2.utratil);
        Kap_8_Zakaznik.pocetZakazniku++;

        //různé přístupy ke statické proměnné uvnitř třídy
        System.out.println("Počet zákazníků (přístup ke stat. prom. pomocí třídy):      " + Kap_8_Zakaznik.pocetZakazniku);
        System.out.println("Počet zákazníků (přístup ke stat. met. pomocí třídy):       " + Kap_8_Zakaznik.kolikZakazniku());
        System.out.println("Počet zákazníků (přístup ke stat. prom. pomocí ref. prom.): " + zak2.pocetZakazniku);
        System.out.println("Počet zákazníků (přístup ke stat. met. pomocí ref. prom.):  " + zak2.kolikZakazniku());

        //System.out.println("Počet zákazníků (přístup ke stat. prom. pomocí impl. ukaz.): " + this.pocetZakazniku);
        //System.out.println("Počet zákazníků (přístup ke stat. met. pomocí impl. ukaz.):  " + this.kolikZakazniku());
        //java: non-static variable this cannot be referenced from a static context
    }
}
