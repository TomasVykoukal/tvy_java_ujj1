package org.example;

public class Kap_11_cvic_Kolo extends Kap_11_cvic_1stopeVozidlo {
    private String vyrobce;
    private float cena;
    private boolean maPrehazovacku;

    public Kap_11_cvic_Kolo(String druh, String vyrobce, float cena, boolean maPrehazovacku) {
        super(druh);
        this.vyrobce = vyrobce;
        this.cena = cena;
        this.maPrehazovacku = maPrehazovacku;
    }

    public void setVyrobce(String vyrobce) {
        this.vyrobce = vyrobce;
    }
    public void setCena(float cena) {
        this.cena = cena;
    }
    public void setMaPrehazovacku(boolean maPrehazovacku) {
        this.maPrehazovacku = maPrehazovacku;
    }

    public String getVyrobce() {
        return vyrobce;
    }
    public float getCena() {
        return cena;
    }
    public boolean getMaPrehazovacku() {
        return maPrehazovacku;
    }

    public String vypisCenu() {
        float cena = getCena();
        cena = (float) Math.round(cena * 100.0f) / 100.0f; //zaokrouhlen� na 2 des. m�sta
        int cena_cela = (int) cena; //extrakce celo��s. ��sti (truncate pomoc� p�evodu na celo��s. hodnotu)
        float cena_des = cena - cena_cela; //zji�t�n� desetinn� ��sti

        //konstrukce n�vratov�ho textu
        String navrat = String.valueOf(cena_cela);
        if (cena_des == 0.0) {
            navrat = navrat + ",-- K�";
        } else {
            navrat = navrat + "," + String.valueOf((int) (cena_des * 100)) + " K�"; //p�evod des. ��sti na cel� ��slo + konkatenace
        }
        return navrat;
    }

    public void vypisCoJsiZac() {
        System.out.println(this.toString());
        System.out.println(this.getClass().getName() + " (<-- " + this.getClass().getSuperclass().getName() + ")");
        System.out.println("druh 1-stop�ho vozidla: " + this.getDruh());
        System.out.println("v�robce: " + getVyrobce());
        System.out.println("cena: " + vypisCenu());
        System.out.println("p�ehazova�ka: " + (getMaPrehazovacku() ? "ano " : "ne "));
        //System.out.println();
    };

    public static void main(String[] args) {
        Kap_11_cvic_Kolo kolo_plecka_total = new Kap_11_cvic_Kolo("levn� trek kolo", "Liberta", 5951.425f, false);
        kolo_plecka_total.vypisCoJsiZac();
        Kap_11_cvic_Kolo kolo_plecka = new Kap_11_cvic_Kolo("b�n� trek kolo", "Liberta", 9500.50f, true);
        kolo_plecka.vypisCoJsiZac();
        Kap_11_cvic_Kolo kolo_lepsi = new Kap_11_cvic_Kolo("lep�� trek kolo", "Roger", 15000f, true);
        kolo_lepsi.vypisCoJsiZac();
    }
}
