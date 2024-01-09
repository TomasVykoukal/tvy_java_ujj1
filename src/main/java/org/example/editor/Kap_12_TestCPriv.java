package org.example.editor;

class CPriv {
    private int i;
    private CPriv jinaC;

    CPriv(int i, CPriv jinaC) {
        this.i = i;
        this.jinaC = jinaC;
    }

    private int getI() {return i;}

    public void porovnani() {
        if (this.i == this.jinaC.i) {
            System.out.println(this.i + " == " + this.jinaC.i);
        } else {
            System.out.println(this.i + " != " + this.jinaC.i);
        }
    }
}

public class Kap_12_TestCPriv {
    public static void main(String[] args) {
        CPriv c1 = new CPriv(1, null);
        CPriv c2 = new CPriv(2, c1);
        CPriv c3 = new CPriv(1, c1);
        //c1.porovnani(); //Cannot read field "i" because "this.jinaC" is null
        c2.porovnani();
        c3.porovnani();
    }
}
