package org.example;

class Rodic_prekryv_prom {
    public int i;
    static public long l;
}

public class Kap_11_Potomek_prekryv_prom extends Rodic_prekryv_prom {
    public long i; //p�ekryt� prom�nn�
    static public int l; //p�ekryt� prom�nn�

    public Kap_11_Potomek_prekryv_prom(long noveI) {
        super.i = (int) 5; //p�ekryt� zd�d�n� instan�n� prom�nn� z p�edka (int); p��stup k n� v met. instance pomoc� super
        i = noveI; //p�ekryt� (p�v. int, nyn� long)
    }
    public static void main(String[] args) {
        Rodic_prekryv_prom.l = 6L;
        Kap_11_Potomek_prekryv_prom.l = (int) 7;
    }
}
