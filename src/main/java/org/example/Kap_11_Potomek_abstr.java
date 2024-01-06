package org.example;

abstract class Rodic_abstr {
    public int i;
    public Rodic_abstr() {i = 1;}
    abstract int getI(); //abstract u metody v rodi�ovsk� t��d� => metoda MUS� b�t implementov�na ve zd�d�n� t��d�
                         //"class Rodic_abstr" => Abstract method in non-abstract class
    final void setI(int noveI) {i = noveI;}
}

public class Kap_11_Potomek_abstr extends Rodic_abstr {
    int getI() {return i * 2;} //implementovan� metoda (v p�edkovi abstract)
    void setI() {i = 5;} //p�et�en� metoda (v p�edkovi final => p�ekryt� nemo�n�)

    public static void main(String[] args) {
        //Rodic_abstr rod = new Rodic_abstr(); //java: org.example.Rodic_abstr is abstract; cannot be instantiated
        Kap_11_Potomek_abstr pot = new Kap_11_Potomek_abstr();
        pot.setI(3);
        System.out.println("Hodnota je (zd�d�n� setter): " + pot.getI());
        pot.setI();
        System.out.println("Hodnota je (p�et�en� setter): " + pot.getI());
    }
}
