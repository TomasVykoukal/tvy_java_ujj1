package org.example;

//cvièení 1 + 2
class Klient {
    private BankovniUcet ucet;
    private int osobniCislo;

    Klient(int vklad, int cislo) {
        ucet = new BankovniUcet(vklad);
        osobniCislo = cislo;
    }

    public int getOsobniCislo() { return osobniCislo; }

    public int getHotovost() { return ucet.getHotovost(); }

    public void vloz(int vklad) { ucet.vloz(vklad); }

    public int vyber(int suma) { return ucet.vyber(suma); }

    public void vypisUctu() {
        System.out.print("Klient os. èís.: " + osobniCislo + ", ");
        ucet.vypisUctu();
    }
}

class BankovniUcet {
    private int hotovost;

    BankovniUcet(int vklad) {
        hotovost = vklad;
    }

    BankovniUcet() {
        this(0);
    }

    public int getHotovost() { return hotovost; }

    public void vloz(int vklad) {
        hotovost += vklad;
    }

    public int vyber(int suma) {
        if (hotovost >= suma) {
            hotovost -= suma;
            return suma;
        }
        else {
            int zbytek = suma - hotovost;
            hotovost = 0;
            return zbytek;
        }
    }

    public void vypisUctu() {
        System.out.println("Hotovost (výpis úètu): " + hotovost);
    }
}

public class Kap_10_cvic_Banka {
    static final int N = 10;
    public static void main(String[] args) {
        //cvièení 1
        //inicializace a výpis pole úètù
        BankovniUcet[] ucty = new BankovniUcet[N];
        System.out.println("Inicializace " + ucty.length + " úètu/úètù a výpis:");
        for (int i = 0;  i < ucty.length;  i++) {
            ucty[i] = new BankovniUcet((int) (Math.random() * 1000));
            System.out.print(i + ". "); ucty[i].vypisUctu();
        }
        System.out.println();

        //vkladové a výbìrové operace na úètu 0
        ucty[0].vloz(2000);
        ucty[0].vypisUctu();
        ucty[0].vyber(1000);
        ucty[0].vypisUctu();
        ucty[0].vyber(5000);
        ucty[0].vypisUctu();
        System.out.println();

        //zji¹tìní a výpis celkového stavu hotovosti v bance
        int hotovostVBance = 0;
        for (int i = 0;  i < ucty.length;  i++) {
            hotovostVBance += ucty[i].getHotovost();
        }
        System.out.println("Celkova hotovost: " + hotovostVBance);

        //cvièení 2
        //inicializace a výpis pole klientù
        Klient[] klienti = new Klient[N];
        System.out.println("Inicializace " + klienti.length + " klienta/klientù a výpis:");
        for (int i = 0;  i < klienti.length;  i++) {
            klienti[i] = new Klient((int) (Math.random() * 1000), i);
            System.out.print(i + ". "); klienti[i].vypisUctu();
        }
        System.out.println();

        //vkladové a výbìrové operace u klienta 0
        klienti[0].vloz(2000);
        klienti[0].vypisUctu();
        klienti[0].vyber(1000);
        klienti[0].vypisUctu();
        klienti[0].vyber(5000);
        klienti[0].vypisUctu();
        System.out.println();

        //zji¹tìní a výpis celkového stavu hotovosti v bance
        hotovostVBance = 0;
        for (int i = 0;  i < klienti.length;  i++) {
            hotovostVBance += klienti[i].getHotovost();
        }
        System.out.println("Celkova hotovost: " + hotovostVBance);
    }
}
