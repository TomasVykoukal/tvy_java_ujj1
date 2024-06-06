package org.example;

//20.6.5 kritické sekce - synchronizované metody
public class Kap_20_BodSynchr {
    private int[] xy = {0, 0};

    synchronized public void nastav(int x, int y) {
        xy[0] = x;
        xy[1] = y;
    }

    synchronized public int[] cti() {
        return new int[] {xy[0], xy[1]};
    }
}
