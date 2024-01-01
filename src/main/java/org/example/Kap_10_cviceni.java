package org.example;

import java.util.Arrays;

public class Kap_10_cviceni {
    //cvi�en� 1 + 2 viz Kap_10_cvic_Banka
    //cvi�en� 3
    static void serad(int[] x, int[] y) {
        int iter;
        int pom = 0;
        System.out.print("vstup: "); //unit test
        for (int i = 0; i < x.length; i++) {
            y[i] = x[i];
            System.out.print(y[i] + ", "); //unit test
        }
        System.out.println("(unit test konec)"); //unit test
        do {
            iter = 0;
            for (int i = 0; i < (y.length - 1); i++) {
                if (y[i+1] < y[i]) {
                    pom = y[i];
                    y[i] = y[i+1];
                    y[i+1] = pom;
                    iter++;
                }
            }
        } while (iter > 0);
    }

    //cvi�en� 4
    static int sude(int[] x, int[] y) {
        int iy = 0;
        for (int ix = 0; ix < x.length; ix++) {
            if (x[ix] % 2 == 0) {
                y[iy] = x[ix];
                iy++;
            }
        }
        return iy;
    }

    public static void main(String[] args) {
        //cvi�en� 3
        int[] x_sort = {8, 122, 0, 1, 240, 5, 6, 15, 56, 450, 4, 89, 151, 5, 3};
        //int[] x_sort = {0, 1, 3, 4, 5, 6, 8, 15, 56, 89, 122, 151, 240, 450}; //test r�zn� po�et ITER
        int[] y_sort = new int[x_sort.length];

        Kap_10_cviceni.serad(x_sort, y_sort);

        System.out.print("vstup: ");
        for (int i = 0; i < x_sort.length; i++) {
            System.out.print(x_sort[i] + ", ");
        }
        System.out.print("\b\b \n");
        System.out.print("se�azen�: ");
        //System.out.println(Arrays.toString(y_sort)); //alt. nov� zp�sob v�tisku pole
        for (int y = 0; y < y_sort.length; y++) {
            System.out.print(y_sort[y] + ", ");
        }
        System.out.print("\b\b \n");

        //cvi�en� 4
        int[] x = {0, 1, 3, 4, 5, 6, 8, 15, 56, 89, 122, 151, 240, 450};
        int[] y = new int[x.length];
        int sude_pocet = Kap_10_cviceni.sude(x, y);
        System.out.println("po�et sud�ch: " + sude_pocet);
        System.out.print("v�pis sud�ch: ");
        for (int iy = 0; iy < y.length; iy++) {
            if (!(iy > 0 & y[iy] == 0)) { //eliminace pr�zdn�ch pozic s hodnotou 0 na konci pole (p�edpoklad: na za�. max. jedna 0)
                System.out.print(y[iy] + ", ");
            }
        }
        System.out.print("\b\b \n");
    }
}
