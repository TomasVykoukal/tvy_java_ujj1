package org.example;

public class Kap_8_Zakaznik {
    //public static int pocetZakazniku = 0;
    private static int pocetZakazniku = 0;
    public int utratil;

    public Kap_8_Zakaznik() {
        Kap_8_Zakaznik.pocetZakazniku++;
        this.utratil = 0;
    }

    //pou�it� statick�ch metod v objektech
    //- pou�it� statick� metody z t�e t��dy
    public static int kolikZakazniku() {
        //vztah mezi metodami t��dy a prom�nn�mi/metodami instance - zde prom./met. inst. v met. t��dy => chyba
        //voliteln� za pou�it� implicitn�ho parametru/ukazatele THIS (odkaz na "tuto instanci")
        //int i = this.utratil; //java: non-static variable this cannot be referenced from a static context
        //int i = utratil;      //java: non-static variable utratil cannot be referenced from a static context
        //this.platil(10);      //java: non-static variable this cannot be referenced from a static context
        //platil(10);           //java: non-static method platil(int) cannot be referenced from a static context

        return Kap_8_Zakaznik.pocetZakazniku;
    }

    public void platil(int cena) {
        this.utratil += cena;
        //vztah mezi metodami t��dy a metodami instance - zde met. t��dy v met. inst. => OK
        //Kap_8_Zakaznik.pocetZakazniku++;
        int i = Kap_8_Zakaznik.kolikZakazniku();
    }

    //�innost finaliz�ru (kap. 8.14)
    protected void finalize() throws Throwable {
        pocetZakazniku--;
        System.out.println("Konec z�kazn�ka");
        super.finalize(); //posledn� p��kaz met. finalize() (analogicky vol�n� konstruktoru z jin�ho konstr. pomoc� this() jako prvn� p��kaz ve volaj�c�m k.)
    }

    public static void main(String[] args) {
        System.out.println("Po�et z�kazn�k� (1): " + Kap_8_Zakaznik.pocetZakazniku);
        Kap_8_Zakaznik zak1 = new Kap_8_Zakaznik();
        System.out.println("Po�et z�kazn�k� (2): " + Kap_8_Zakaznik.pocetZakazniku);
        zak1.platil(15);
        Kap_8_Zakaznik zak2 = new Kap_8_Zakaznik();
        System.out.println("Po�et z�kazn�k� (3): " + Kap_8_Zakaznik.pocetZakazniku);
        zak1.platil(30);
        zak2.platil(20);
        System.out.println("Utratili: " + zak1.utratil + " + " + zak2.utratil);
        Kap_8_Zakaznik.pocetZakazniku++;
        System.out.println("Po�et z�kazn�k� (4): " + Kap_8_Zakaznik.pocetZakazniku);

        //r�zn� p��stupy ke statick� prom�nn� uvnit� t��dy
        //koncep�n� vhodn�
        System.out.println("Po�et z�kazn�k� (p��stup ke stat. prom. pomoc� t��dy):      " + Kap_8_Zakaznik.pocetZakazniku);
        System.out.println("Po�et z�kazn�k� (p��stup ke stat. met. pomoc� t��dy):       " + Kap_8_Zakaznik.kolikZakazniku());
        //koncep�n� nevhodn�
        System.out.println("Po�et z�kazn�k� (p��stup ke stat. prom. pomoc� ref. prom.): " + zak2.pocetZakazniku);
        System.out.println("Po�et z�kazn�k� (p��stup ke stat. met. pomoc� ref. prom.):  " + zak2.kolikZakazniku());
        System.out.println("Po�et z�kazn�k� (p��stup ke stat. prom. bez ni�eho):        " + pocetZakazniku);
        System.out.println("Po�et z�kazn�k� (p��stup ke stat. met. bez ni�eho):         " + kolikZakazniku());
        //technicky chybn�
        //System.out.println("Po�et z�kazn�k� (p��stup ke stat. prom. pomoc� impl. ukaz.): " + this.pocetZakazniku);
        //System.out.println("Po�et z�kazn�k� (p��stup ke stat. met. pomoc� impl. ukaz.):  " + this.kolikZakazniku());
        //hl�en� v obou p��padech: java: non-static variable this cannot be referenced from a static context


        //Ru�en� objekt� a ukon�en� pr�ce s nimi
        zak1 = null;
        System.runFinalization(); //ned�l� nic - deprecated
        System.out.println("Po�et z�kazn�k� (5): " + Kap_8_Zakaznik.pocetZakazniku);
    }
}
