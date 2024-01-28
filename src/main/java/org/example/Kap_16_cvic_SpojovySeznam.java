package org.example;

//cvièení 1 - univerzální spojový seznam
//cvièení 2 - vytvoøení vlastní výjimky
//cvièení 3 - o¹etøení v bloku try-catch
//class SeznamException extends RuntimeException { //RuntimeException (asynchronní výjimka) => o¹etøení pøi volání vyjmiPrvniho() nepovinné
class SeznamException extends Exception { //Exception (synchronní výjimka) => o¹etøení pøi volání vyjmiPrvniho() povinné
    public SeznamException() {
        System.out.print("! Chyba pøi práci se seznamem");
    }
}

class Uzel {
    Object prvek;
    Uzel dalsi; //"rekurze" - odkaz na obj. stejného typu

    //konstruktor pro poslední prvek (bez následníka)
    Uzel(Object o) {
        this.prvek = o;
        this.dalsi = null;
    }

    //konstruktor pro prvek s následníkem
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
        //this.prvni = this.posledni = null; //nìkolikanásobné pøiøazení, vyhodnocuje se zprava
        this.prvni = null;
        this.posledni = null;
        this.pocet = 0;
    }

    public boolean jePrazdny() {
        return (this.prvni == null) ? true : false;
    }

    //vkládá na konec
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
                System.out.print("; --> výhled: " + akt.dalsi.prvek.toString());
                System.out.println(" (" + akt.dalsi.prvek.getClass().getName() + ")");
            }
            else {
                System.out.println(" -->|");
            }
            akt = akt.dalsi;
            i++;
        }
        System.out.println("Poèet prvkù: " + this.pocet);
        System.out.println();
    }

    public Object vyjmiPrvniho() throws SeznamException {
        Object o;
        if (this.jePrazdny()) {
            //return null; //cvièení 1
            throw new SeznamException(); //cvièení 2
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
        //s.vyjmiPrvniho(); //RuntimeException (asynchronní výjimka; viz vý¹e)
        try {
            s.vyjmiPrvniho(); //Exception (synchronní výjimka; viz vý¹e)
        }
        catch (SeznamException e) {
            System.out.println(": Seznam je prázdný.");
        }
        s.vypisSeznam();
    }
}
