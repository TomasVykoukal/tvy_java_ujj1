package org.example;

abstract class Rodic_abstr {
    public int i;
    public Rodic_abstr() {i = 1;}
    abstract int getI(); //abstract u metody v rodièovské tøídì => metoda MUSÍ být implementována ve zdìdìné tøídì
                         //"class Rodic_abstr" => Abstract method in non-abstract class
    final void setI(int noveI) {i = noveI;}
}

public class Kap_11_Potomek_abstr extends Rodic_abstr {
    int getI() {return i * 2;} //implementovaná metoda (v pøedkovi abstract)
    void setI() {i = 5;} //pøetí¾ená metoda (v pøedkovi final => pøekrytí nemo¾né)

    public static void main(String[] args) {
        //Rodic_abstr rod = new Rodic_abstr(); //java: org.example.Rodic_abstr is abstract; cannot be instantiated
        Kap_11_Potomek_abstr pot = new Kap_11_Potomek_abstr();
        pot.setI(3);
        System.out.println("Hodnota je (zdìdìný setter): " + pot.getI());
        pot.setI();
        System.out.println("Hodnota je (pøetí¾ený setter): " + pot.getI());
    }
}
