package org.example;

//13.2 pou¾ití jednoho rozhraní
public class Kap_13_Koule implements Kap_13_Info {
    int polomer;
    Kap_13_Koule(int polomer) {this.polomer = polomer;}

    public void kdoJsem() {
        System.out.println("Koule; polomìr = " + this.polomer);
    }

    //metoda pro test 13.3.1 ní¾e
    public void mimoRozhr() { System.out.println("metoda mimo rozhraní (koule)"); }

    //èást spoleèná pro Kap_13_Usecka a Kap_13_Koule
    public static void main(String[] args) {
        //13.2 pou¾ití jednoho rozhraní
        Kap_13_Usecka u = new Kap_13_Usecka(5);
        Kap_13_Koule  k = new Kap_13_Koule(3);
        u.kdoJsem();
        k.kdoJsem();
        System.out.println();

        //13.3 pou¾ití rozhraní jako typu referenèní promìnné
        Kap_13_Info i = new Kap_13_Usecka(50);
        i.kdoJsem();
        System.out.println();

        //13.3.1 pokusy o pøístup k promìnným a metodám tøídy ale mimo definici rozhraní a jejich øe¹ení pøetypováním
        //System.out.println("pøístup k prom. délka úseèky: " + i.delka); //Cannot resolve symbol 'delka'
        System.out.println("pøístup k prom. délka úseèky: " + ((Kap_13_Usecka) i).delka);
        //i.mimoRozhr(); //Cannot resolve method 'mimoRozhr' in 'Kap_13_Info'
                         //doporuèení IDE: Cast qualifier to 'org.example.Kap_13_Usecka'
        ((Kap_13_Usecka) i).mimoRozhr();
        System.out.println();

        //13.3 ...
        i = k;
        i.kdoJsem();
        System.out.println();

        //13.3.1 ...
        //System.out.println("pøístup k prom. polomìr koule: " + i.polomer); //Cannot resolve symbol 'polomer'
        System.out.println("pøístup k prom. polomìr koule: " + ((Kap_13_Koule) i).polomer);
        //i.mimoRozhr(); //Cannot resolve method 'mimoRozhr' in 'Kap_13_Info'
                         //doporuèení IDE: ¾ádné; na¹eptávaè pøímo nabízí pro i metodu mimoRozhr() s automatickým doplnìním pøetypování
        ((Kap_13_Koule) i).mimoRozhr();
    }
}
