package org.example;

public class Kap_8_Zakaznik {
    //public static int pocetZakazniku = 0;
    private static int pocetZakazniku = 0;
    public int utratil;

    public Kap_8_Zakaznik() {
        Kap_8_Zakaznik.pocetZakazniku++;
        this.utratil = 0;
    }

    //pou¾ití statických metod v objektech
    //- pou¾ití statická metody z té¾e tøídy
    public static int kolikZakazniku() {
        //vztah mezi metodami tøídy a promìnnými/metodami instance - zde prom./met. inst. v met. tøídy => chyba
        //volitelnì za pou¾ití implicitního parametru/ukazatele THIS (odkaz na "tuto instanci")
        //int i = this.utratil; //java: non-static variable this cannot be referenced from a static context
        //int i = utratil;      //java: non-static variable utratil cannot be referenced from a static context
        //this.platil(10);      //java: non-static variable this cannot be referenced from a static context
        //platil(10);           //java: non-static method platil(int) cannot be referenced from a static context

        return Kap_8_Zakaznik.pocetZakazniku;
    }

    public void platil(int cena) {
        this.utratil += cena;
        //vztah mezi metodami tøídy a metodami instance - zde met. tøídy v met. inst. => OK
        //Kap_8_Zakaznik.pocetZakazniku++;
        int i = Kap_8_Zakaznik.kolikZakazniku();
    }

    //èinnost finalizéru (kap. 8.14)
    protected void finalize() throws Throwable {
        pocetZakazniku--;
        System.out.println("Konec zákazníka");
        super.finalize(); //poslední pøíkaz met. finalize() (analogicky volání konstruktoru z jiného konstr. pomocí this() jako první pøíkaz ve volajícím k.)
    }

    public static void main(String[] args) {
        System.out.println("Poèet zákazníkù (1): " + Kap_8_Zakaznik.pocetZakazniku);
        Kap_8_Zakaznik zak1 = new Kap_8_Zakaznik();
        System.out.println("Poèet zákazníkù (2): " + Kap_8_Zakaznik.pocetZakazniku);
        zak1.platil(15);
        Kap_8_Zakaznik zak2 = new Kap_8_Zakaznik();
        System.out.println("Poèet zákazníkù (3): " + Kap_8_Zakaznik.pocetZakazniku);
        zak1.platil(30);
        zak2.platil(20);
        System.out.println("Utratili: " + zak1.utratil + " + " + zak2.utratil);
        Kap_8_Zakaznik.pocetZakazniku++;
        System.out.println("Poèet zákazníkù (4): " + Kap_8_Zakaznik.pocetZakazniku);

        //rùzné pøístupy ke statické promìnné uvnitø tøídy
        //koncepènì vhodný
        System.out.println("Poèet zákazníkù (pøístup ke stat. prom. pomocí tøídy):      " + Kap_8_Zakaznik.pocetZakazniku);
        System.out.println("Poèet zákazníkù (pøístup ke stat. met. pomocí tøídy):       " + Kap_8_Zakaznik.kolikZakazniku());
        //koncepènì nevhodný
        System.out.println("Poèet zákazníkù (pøístup ke stat. prom. pomocí ref. prom.): " + zak2.pocetZakazniku);
        System.out.println("Poèet zákazníkù (pøístup ke stat. met. pomocí ref. prom.):  " + zak2.kolikZakazniku());
        System.out.println("Poèet zákazníkù (pøístup ke stat. prom. bez nièeho):        " + pocetZakazniku);
        System.out.println("Poèet zákazníkù (pøístup ke stat. met. bez nièeho):         " + kolikZakazniku());
        //technicky chybný
        //System.out.println("Poèet zákazníkù (pøístup ke stat. prom. pomocí impl. ukaz.): " + this.pocetZakazniku);
        //System.out.println("Poèet zákazníkù (pøístup ke stat. met. pomocí impl. ukaz.):  " + this.kolikZakazniku());
        //hlá¹ení v obou pøípadech: java: non-static variable this cannot be referenced from a static context


        //Ru¹ení objektù a ukonèení práce s nimi
        zak1 = null;
        System.runFinalization(); //nedìlá nic - deprecated
        System.out.println("Poèet zákazníkù (5): " + Kap_8_Zakaznik.pocetZakazniku);
    }
}
