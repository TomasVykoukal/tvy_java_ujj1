package org.example;

class IntOdkazem { //Objekty %typ%Odkazem obsahuj� zpracov�van� hodnoty.
    private int i;
    IntOdkazem(int i) {this.i = i;}
    public void setI(int i) {this.i = i;} //oproti p�edloze zm�n�no pojmenov�n� getteru a setteru na standard
    public int getI() {return this.i;}
}
class DoubleOdkazem {
    double d;
}

class Nasobeni_Odk { //Objekt Nasobeni_Odk prov�d� na parametrem p�edan�ch objektech %typ%Odkazem operaci n�soben�.
                     //Reference na objekty jsou p�ed�ny hodnotou (standard), �lensk� prom�nn�/atributy jsou ov�em uzav�eny v objektech a p�ed�ny de facto odkazem.
    public static void nasobPeti(IntOdkazem j, DoubleOdkazem f) {
        j.setI(j.getI() * 5); //oproti p�edloze vynech�na prom�nn� POM
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

        System.out.println("prvn�: " + prvni + ", druh�: " + druhy);
    }
}
