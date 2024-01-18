package org.example;

//realizace polymorfismu pomocí dìdìní z neabstraktní tøídy
class Zivocich {
    public void vypisInfo() {
        System.out.print(getClass().getName() + ", ");
    }
}

class Ptak extends Zivocich {
    int delkaKridel;
    Ptak(int delka) {this.delkaKridel = delka;}

    public void vypisInfo() {
        super.vypisInfo();
        System.out.println("délka køídel: " + this.delkaKridel);
    }
}

class Slon extends Zivocich {
    int delkaChobotu;
    Slon(int delka) {this.delkaChobotu = delka;}

    public void vypisInfo() {
        super.vypisInfo();
        System.out.println("délka chobotu: " + this.delkaChobotu);
    }
}

class Had extends Zivocich {
    int delkaTela;
    Had(int delka) {this.delkaTela = delka;}

    public void vypisInfo() {
        super.vypisInfo();
        System.out.println("délka tìla: " + this.delkaTela);
    }
}

public class Kap_14_PolymDeden {
    public static void main(String[] args) {
        Zivocich[] z = new Zivocich[6];
        for (int i = 0; i < z.length; i++) {
            switch ((int) (1.0 + Math.random() * 3.0)) {
                case 1: z[i] = new Ptak(i);
                break;
                case 2: z[i] = new Slon(i);
                break;
                case 3: z[i] = new Had(i);
                break;
            }
        }
        for (int i = 0; i < z.length; i++) {
            z[i].vypisInfo();
        }
    }
}
