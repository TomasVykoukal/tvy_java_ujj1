package org.example;

//13.2 pou¾ití jednoho rozhraní
public class Kap_13_Usecka implements Kap_13_Info {
    int delka;
    Kap_13_Usecka(int delka) {this.delka = delka;}

    //není-li kdoJsem() implementována => Class 'Kap_13_Usecka' must either be declared abstract or implement abstract method 'kdoJsem()' in 'Kap_13_Info'
    public void kdoJsem() {
        System.out.println("Úseèka; délka = " + this.delka);
    }

    //metoda pro test 13.3.1 ve tø. Kap_13_Koule
    public void mimoRozhr() { System.out.println("metoda mimo rozhraní (úseèka)"); } //metoda mimo rozhraní
}
