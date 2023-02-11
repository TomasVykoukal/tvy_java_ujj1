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
        //vztah mezi metodami třídy a met. instance - zde met. inst. v met. třídy => chyba
        //int i = (this.)utratil;
        //(this.)platil(10);
        //java: non-static variable this cannot be referenced from a static context
        return Kap_8_Zakaznik.pocetZakazniku;
    }

    public void platil(int cena) {
        this.utratil += cena;
        //vztah mezi metodami třídy a met. instance - zde met. třídy v met. inst. => OK
        Kap_8_Zakaznik.pocetZakazniku++;
        int i = Kap_8_Zakaznik.kolikZakazniku();
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
        System.out.println("Počet zákazníků (4): " + Kap_8_Zakaznik.pocetZakazniku);

        //různé přístupy ke statické proměnné uvnitř třídy
        //koncepčně vhodný
        System.out.println("Počet zákazníků (přístup ke stat. prom. pomocí třídy):      " + Kap_8_Zakaznik.pocetZakazniku);
        System.out.println("Počet zákazníků (přístup ke stat. met. pomocí třídy):       " + Kap_8_Zakaznik.kolikZakazniku());
        //koncepčně nevhodný
        System.out.println("Počet zákazníků (přístup ke stat. prom. pomocí ref. prom.): " + zak2.pocetZakazniku);
        System.out.println("Počet zákazníků (přístup ke stat. met. pomocí ref. prom.):  " + zak2.kolikZakazniku());
        System.out.println("Počet zákazníků (přístup ke stat. prom. bez ničeho):        " + pocetZakazniku);
        System.out.println("Počet zákazníků (přístup ke stat. met. bez ničeho):         " + kolikZakazniku());
        //technicky chybný
        //System.out.println("Počet zákazníků (přístup ke stat. prom. pomocí impl. ukaz.): " + this.pocetZakazniku);
        //System.out.println("Počet zákazníků (přístup ke stat. met. pomocí impl. ukaz.):  " + this.kolikZakazniku());
        //java: non-static variable this cannot be referenced from a static context
    }
}
