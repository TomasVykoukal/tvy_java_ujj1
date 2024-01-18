package org.example;

//realizace polymorfismu pomoc� d�d�n� z abstraktn� t��dy
abstract class Zivocich_abstr {
    String typ;
    Zivocich_abstr(String typ) {this.typ = new String(typ);}
    public void vypisInfo() {
        System.out.print(typ + ", ");
        vypisDelku();
    }
    public abstract void vypisDelku();
}

class Ptak_abstr extends Zivocich_abstr {
    int delkaKridel;
    Ptak_abstr(String typ, int delka) {
        super(typ);
        this.delkaKridel = delka;
    }
    public void vypisDelku() {
        System.out.println("d�lka k��del: " + this.delkaKridel);
    }
}

class Slon_abstr extends Zivocich_abstr {
    int delkaChobotu;
    Slon_abstr(String typ, int delka) {
        super(typ);
        this.delkaChobotu = delka;
    }
    public void vypisDelku() {
        System.out.println("d�lka chobotu: " + this.delkaChobotu);
    }
}

class Had_abstr extends Zivocich_abstr {
    int delkaTela;
    Had_abstr(String typ, int delka) {
        super(typ);
        this.delkaTela = delka;
    }
    public void vypisDelku() {
        System.out.println("d�lka t�la: " + this.delkaTela);
    }
}

public class Kap_14_PolymAbstr {
    public static void main(String[] args) {
        Zivocich_abstr[] z = new Zivocich_abstr[6];
        for (int i = 0; i < z.length; i++) {
            switch ((int) (1.0 + Math.random() * 3.0)) {
                case 1: z[i] = new Ptak_abstr("pt�k", i);
                break;
                case 2: z[i] = new Slon_abstr("slon", i);
                break;
                case 3: z[i] = new Had_abstr("had", i);
                break;
            }
        }
        for (int i = 0; i < z.length; i++) {
            z[i].vypisInfo();
        }

        //test u�it� random
        System.out.println();
        double r;
        for (int j = 1; j <= 10; j++) {
            r = Math.random(); //vrac� re�ln� ��sla v intervalu <0.0, 1.0)
            System.out.print(r + " | ");
            System.out.print((r * 3.0) + " | ");
            System.out.print((1.0 + r * 3.0) + " | ");
            System.out.println((int) (1.0 + r * 3.0));
        }
    }
}
