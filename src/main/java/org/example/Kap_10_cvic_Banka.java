package org.example;

//cvi�en� 1 + 2
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
        System.out.print("Klient os. ��s.: " + osobniCislo + ", ");
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
        System.out.println("Hotovost (v�pis ��tu): " + hotovost);
    }
}

public class Kap_10_cvic_Banka {
    static final int N = 10;
    public static void main(String[] args) {
        //cvi�en� 1
        //inicializace a v�pis pole ��t�
        BankovniUcet[] ucty = new BankovniUcet[N];
        System.out.println("Inicializace " + ucty.length + " ��tu/��t� a v�pis:");
        for (int i = 0;  i < ucty.length;  i++) {
            ucty[i] = new BankovniUcet((int) (Math.random() * 1000));
            System.out.print(i + ". "); ucty[i].vypisUctu();
        }
        System.out.println();

        //vkladov� a v�b�rov� operace na ��tu 0
        ucty[0].vloz(2000);
        ucty[0].vypisUctu();
        ucty[0].vyber(1000);
        ucty[0].vypisUctu();
        ucty[0].vyber(5000);
        ucty[0].vypisUctu();
        System.out.println();

        //zji�t�n� a v�pis celkov�ho stavu hotovosti v bance
        int hotovostVBance = 0;
        for (int i = 0;  i < ucty.length;  i++) {
            hotovostVBance += ucty[i].getHotovost();
        }
        System.out.println("Celkova hotovost: " + hotovostVBance);

        //cvi�en� 2
        //inicializace a v�pis pole klient�
        Klient[] klienti = new Klient[N];
        System.out.println("Inicializace " + klienti.length + " klienta/klient� a v�pis:");
        for (int i = 0;  i < klienti.length;  i++) {
            klienti[i] = new Klient((int) (Math.random() * 1000), i);
            System.out.print(i + ". "); klienti[i].vypisUctu();
        }
        System.out.println();

        //vkladov� a v�b�rov� operace u klienta 0
        klienti[0].vloz(2000);
        klienti[0].vypisUctu();
        klienti[0].vyber(1000);
        klienti[0].vypisUctu();
        klienti[0].vyber(5000);
        klienti[0].vypisUctu();
        System.out.println();

        //zji�t�n� a v�pis celkov�ho stavu hotovosti v bance
        hotovostVBance = 0;
        for (int i = 0;  i < klienti.length;  i++) {
            hotovostVBance += klienti[i].getHotovost();
        }
        System.out.println("Celkova hotovost: " + hotovostVBance);
    }
}
