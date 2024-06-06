package org.example;

//20.6.5 kritické sekce - synchronizované metody
public class Kap_20_Bod {
    private int[] xy = {0, 0};

    public void nastav(int x, int y) {
        xy[0] = x;
        //kritické místo
        xy[1] = y;
    }

    public int[] cti() {
        return new int[] {xy[0], xy[1]};
    }
}
