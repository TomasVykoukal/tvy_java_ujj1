package org.example;

class Rodic_prekryv_prom {
    public int i;
    static public long l;
}

public class Kap_11_Potomek_prekryv_prom extends Rodic_prekryv_prom {
    public long i; //pøekrytá promìnná
    static public int l; //pøekrytá promìnná

    public Kap_11_Potomek_prekryv_prom(long noveI) {
        super.i = (int) 5; //pøekrytá zdìdìná instanèní promìnná z pøedka (int); pøístup k ní v met. instance pomocí super
        i = noveI; //pøekrytá (pùv. int, nyní long)
    }
    public static void main(String[] args) {
        Rodic_prekryv_prom.l = 6L;
        Kap_11_Potomek_prekryv_prom.l = (int) 7;
    }
}
