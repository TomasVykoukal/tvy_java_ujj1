package org.example;

public abstract class Kap_11_cvic_1stopeVozidlo {
    private String druh;

    public Kap_11_cvic_1stopeVozidlo(String druh) {
        this.druh = druh;
    }
    public Kap_11_cvic_1stopeVozidlo() {
        this.druh = "nespecifikovan� 1-stop� vozidlo";
    }

    public String getDruh() {
        return druh;
    }
    public void setDruh(String druh) {
        this.druh = druh;
    }

    abstract public void vypisCoJsiZac();
}
