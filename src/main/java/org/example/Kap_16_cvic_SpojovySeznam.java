package org.example;

//cvi�en� 1 - univerz�ln� spojov� seznam
//cvi�en� 2 - vytvo�en� vlastn� v�jimky
//cvi�en� 3 - o�et�en� v bloku try-catch
//class SeznamException extends RuntimeException { //RuntimeException (asynchronn� v�jimka) => o�et�en� p�i vol�n� vyjmiPrvniho() nepovinn�
class SeznamException extends Exception { //Exception (synchronn� v�jimka) => o�et�en� p�i vol�n� vyjmiPrvniho() povinn�
    public SeznamException() {
        System.out.print("! Chyba p�i pr�ci se seznamem");
    }
}

class Uzel {
    Object prvek;
    Uzel dalsi; //"rekurze" - odkaz na obj. stejn�ho typu

    //konstruktor pro posledn� prvek (bez n�sledn�ka)
    Uzel(Object o) {
        this.prvek = o;
        this.dalsi = null;
    }

    //konstruktor pro prvek s n�sledn�kem
    Uzel(Object o, Uzel dalsiUzel) {
        this.prvek = o;
        this.dalsi = dalsiUzel;
    }

    Object getPrvek() { return this.prvek; }

    Uzel getDalsi() { return this.dalsi; }
}

class SpojovySeznam {
    private Uzel prvni;
    private Uzel posledni;
    int pocet;

    SpojovySeznam() {
        //this.prvni = this.posledni = null; //n�kolikan�sobn� p�i�azen�, vyhodnocuje se zprava
        this.prvni = null;
        this.posledni = null;
        this.pocet = 0;
    }

    public boolean jePrazdny() {
        return (this.prvni == null) ? true : false;
    }

    //vkl�d� na konec
    public void vloz(Object vkladany) {
        if (this.jePrazdny())
            this.prvni = this.posledni = new Uzel(vkladany);
        else
            this.posledni = this.posledni.dalsi = new Uzel(vkladany); //?

        this.pocet++;
    }

    public void vypisSeznam() {
        Uzel akt = this.prvni;
        int i = 1;
        while (akt != null) {
            System.out.print(i + ". prvek: ");
            System.out.print(akt.prvek.toString());
            System.out.print(" (" + akt.prvek.getClass().getName() + ")");
            if (akt.dalsi != null) {
                System.out.print("; --> v�hled: " + akt.dalsi.prvek.toString());
                System.out.println(" (" + akt.dalsi.prvek.getClass().getName() + ")");
            }
            else {
                System.out.println(" -->|");
            }
            akt = akt.dalsi;
            i++;
        }
        System.out.println("Po�et prvk�: " + this.pocet);
        System.out.println();
    }

    public Object vyjmiPrvniho() throws SeznamException {
        Object o;
        if (this.jePrazdny()) {
            //return null; //cvi�en� 1
            throw new SeznamException(); //cvi�en� 2
        }

        this.pocet--;
        o = this.prvni.prvek;
        if (this.prvni != this.posledni)
            this.prvni = this.prvni.dalsi;
        else
            this.prvni = this.posledni = null;

        return o;
    }

    public int getPocet() { return this.pocet; }
}

public class Kap_16_cvic_SpojovySeznam {
    public static void main(String[] args) {
        SpojovySeznam s = new SpojovySeznam();

        Byte      b  = 126;
        Short     sh = new Short((short)32700);
        Integer   i  = new Integer(1);
        Long      l  = new Long(250000000);
        Float     f  = new Float(3.14);
        Double    d  = new Double(3.14);
        Character ch = new Character('a');
        String    a  = new String("ahoj");

        /*s.vloz(b);
        s.vloz(sh);
        s.vloz(i);
        s.vloz(l);
        s.vloz(f);
        s.vloz(d);
        s.vloz(ch);
        s.vloz(a);*/

        s.vypisSeznam();
        //s.vyjmiPrvniho(); //RuntimeException (asynchronn� v�jimka; viz v��e)
        try {
            s.vyjmiPrvniho(); //Exception (synchronn� v�jimka; viz v��e)
        }
        catch (SeznamException e) {
            System.out.println(": Seznam je pr�zdn�.");
        }
        s.vypisSeznam();
    }
}
