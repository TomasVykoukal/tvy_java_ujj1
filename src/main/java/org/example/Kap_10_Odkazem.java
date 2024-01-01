package org.example;

class IntOdkazem { //Objekty %typ%Odkazem obsahují zpracovávané hodnoty.
    private int i;
    IntOdkazem(int i) {this.i = i;}
    public void setI(int i) {this.i = i;} //oproti pøedloze zmìnìno pojmenování getteru a setteru na standard
    public int getI() {return this.i;}
}
class DoubleOdkazem {
    double d;
}

class Nasobeni_Odk { //Objekt Nasobeni_Odk provádí na parametrem pøedaných objektech %typ%Odkazem operaci násobení.
                     //Reference na objekty jsou pøedány hodnotou (standard), èlenské promìnné/atributy jsou ov¹em uzavøeny v objektech a pøedány de facto odkazem.
    public static void nasobPeti(IntOdkazem j, DoubleOdkazem f) {
        j.setI(j.getI() * 5); //oproti pøedloze vynechána promìnná POM
        f.d *= 5;
    }
}

public class Kap_10_Odkazem {
    public static void main(String[] args) {
        int prvni = 5;
        double druhy = 3.14;

        IntOdkazem par1 = new IntOdkazem(prvni);
        DoubleOdkazem par2 = new DoubleOdkazem();
        par2.d = druhy;
        Nasobeni_Odk.nasobPeti(par1, par2);
        prvni = par1.getI();
        druhy = par2.d;

        System.out.println("první: " + prvni + ", druhý: " + druhy);
    }
}
