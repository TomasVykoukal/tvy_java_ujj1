package org.example;

public class Kap_11_cvic_HorskeKolo extends Kap_11_cvic_Kolo {
    private int prevodyVpredu, prevodyVzadu;

    public Kap_11_cvic_HorskeKolo(
            String druh,
            String vyrobce,
            float cena,
            int prevodyVpredu,
            int prevodyVzadu
    ) {
        super(druh, vyrobce, cena, true);
        this.prevodyVpredu = prevodyVpredu;
        this.prevodyVzadu = prevodyVzadu;
    }

    public void setPrevodyVpredu(int prevodyVpredu) {
        this.prevodyVpredu = prevodyVpredu;
    }
    public void setPrevodyVzadu(int prevodyVzadu) {
        this.prevodyVzadu = prevodyVzadu;
    }

    public int getPrevodyVpredu() {
        return prevodyVpredu;
    }
    public int getPrevodyVzadu() {
        return prevodyVzadu;
    }

    public void vypisCoJsiZac() {
        super.vypisCoJsiZac();
        System.out.println("  pøevody vpøedu: " + this.getPrevodyVpredu());
        System.out.println("  pøevody vzadu: " + this.getPrevodyVzadu());
    }

    public static void main(String[] args) {
        Kap_11_cvic_HorskeKolo kolo = new Kap_11_cvic_HorskeKolo("horal ni¾¹í tøídy", "Shimano", 25000, 4, 8);
        kolo.vypisCoJsiZac();
    }
}
