package org.example;

//13.2 pou�it� jednoho rozhran�
public class Kap_13_Usecka implements Kap_13_Info {
    int delka;
    Kap_13_Usecka(int delka) {this.delka = delka;}

    //nen�-li kdoJsem() implementov�na => Class 'Kap_13_Usecka' must either be declared abstract or implement abstract method 'kdoJsem()' in 'Kap_13_Info'
    public void kdoJsem() {
        System.out.println("�se�ka; d�lka = " + this.delka);
    }

    //metoda pro test 13.3.1 ve t�. Kap_13_Koule
    public void mimoRozhr() { System.out.println("metoda mimo rozhran� (�se�ka)"); } //metoda mimo rozhran�
}
