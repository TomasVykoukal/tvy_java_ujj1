package org.example;

public class Kap_8_cvic_Trojuhelnik {

    //cvičení 1
    private int stranaA;
    private int stranaB;
    private int stranaC;
    private int prepona;
    private int odvesna1;
    private int odvesna2;

    public Kap_8_cvic_Trojuhelnik(int stranaA, int stranaB, int stranaC) {
        this.stranaA = stranaA;
        this.stranaB = stranaB;
        this.stranaC = stranaC;

        //prepona = stranaA > stranaB ? (stranaA > stranaC ? stranaA : stranaC) : (stranaB > stranaC ? stranaB : stranaC);
        if (this.stranaA > this.stranaB) {
            if (this.stranaA > this.stranaC) {
                this.prepona = this.stranaA;
                this.odvesna1 = this.stranaB;
                this.odvesna2 = this.stranaC;
            } else {
                this.prepona = this.stranaC;
                this.odvesna1 = this.stranaA;
                this.odvesna2 = this.stranaB;
            }
        } else {
            if (this.stranaB > this.stranaC) {
                this.prepona = this.stranaB;
                this.odvesna1 = this.stranaA;
                this.odvesna2 = this.stranaC;
            } else {
                this.prepona = this.stranaC;
                this.odvesna1 = this.stranaA;
                this.odvesna2 = this.stranaB;
            }
        }
        //cvičení 2
        if (this.odvesna1 + this.odvesna2 <= this.prepona) {
            System.out.println("Útvar není trojúhelník. Strany budou vynulovány.");
            this.stranaA = 0;
            this.stranaB = 0;
            this.stranaC = 0;
        }
    }

    //cvičení 3
    public Kap_8_cvic_Trojuhelnik(int jednaStrana) {
        this.stranaA = jednaStrana;
        this.stranaB = jednaStrana;
        this.stranaC = jednaStrana;
    }

    //cvičení 4
    public Kap_8_cvic_Trojuhelnik(int jednaStrana, int druhaStrana) {
        this.stranaA = jednaStrana;
        this.stranaB = jednaStrana;
        this.stranaC = druhaStrana;
    }

    double obvod() {
        return stranaA + stranaB + stranaC;
    }

    boolean jePravouhly() {
        if (Math.pow(this.prepona, 2) == (Math.pow(this.odvesna1, 2) + Math.pow(this.odvesna2, 2))) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        //3úhelník
        Kap_8_cvic_Trojuhelnik trojuh1 = new Kap_8_cvic_Trojuhelnik(7, 8, 9);
        System.out.println("obvod 3úhelníka: " + trojuh1.obvod());
        if (trojuh1.jePravouhly()) {
            System.out.println("Trojúhelník je pravoúhlý.");
        }
        else {
            System.out.println("Trojúhelník není pravoúhlý.");
        }

        //ne-3úhelník
        Kap_8_cvic_Trojuhelnik trojuh2 = new Kap_8_cvic_Trojuhelnik(7, 8, 19);

        //celočíselný pravoúh. 3úhelník: 3; 4; 5. 5; 12; 13. 8; 15; 17. 7; 24; 25.
        Kap_8_cvic_Trojuhelnik trojuh3 = new Kap_8_cvic_Trojuhelnik(3, 4, 5);
        System.out.println("obvod 3úhelníka: " + trojuh3.obvod());
        if (trojuh3.jePravouhly()) {
            System.out.println("Trojúhelník je pravoúhlý.");
        }
        else {
            System.out.println("Trojúhelník není pravoúhlý.");
        }
    }
}
