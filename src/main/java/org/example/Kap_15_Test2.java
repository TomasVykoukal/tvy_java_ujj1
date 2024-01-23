package org.example;

class Jmeno implements Kap_13_Info {
    public void kdoJsem() {
        System.out.println(this.getClass().getName());
    }
}

//class Usecka převzata z Kap_15_Test

class Obdelnik2 extends Usecka {
    int sirka;
    Obdelnik2(int delka, int sirka) {
        super(delka);
        this.sirka = sirka;
    }

    //4. vnitřní třída je vytvořena děděním
    //  Tř. Jmeno implementuje rozhraní Info pro nás vyhovujícím způsobem. Dědit z této tř. ovšem není možné, protože tř. Obdelnik dědí z tř. Usecka.
    //  Řešení: je použita vnitřní třída, které v dědění od rodičovské tř. Jmeno nic nebrání.
    public Kap_13_Info informace_4(int varianta) {
        Jmeno navrat;
        switch (varianta) {
            case 1: navrat = new Vnitrni(); break; //Obdelnik2$Vnitrni (<-Jmeno)
            default: navrat = new Jmeno(); break;  //Jmeno
        }
        return navrat;
    }

    //5. vnitřní anonymní třída vznikne děděním
    public Kap_13_Info informace_5(int varianta) {
        Jmeno navrat;
        switch (varianta) {
            case 1:  navrat = new Jmeno() { }; break; //Obdelnik2$1 //prázdné tělo anonymní třídy / konec příkazu RETURN, proto středník
            default: navrat = new Jmeno(); break;     //Jmeno
        }
        return navrat;
    }

    class Vnitrni extends Jmeno {
    }
}

public class Kap_15_Test2 {
    public static void main(String[] args) {
        Obdelnik2 o_4 = new Obdelnik2(3, 6);

        Kap_13_Info i_4_1 = o_4.informace_4(1);
        Kap_13_Info i_4_2 = o_4.informace_4(2);
        Kap_13_Info i_5_1 = o_4.informace_5(1);
        Kap_13_Info i_5_2 = o_4.informace_5(2);

        i_4_1.kdoJsem();
        i_4_2.kdoJsem();
        i_5_1.kdoJsem();
        i_5_2.kdoJsem();
    }
}
