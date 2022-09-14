package org.example;

public class Druhy {
    public static void main(String[] args){
        //int i1;
        int i1 = 5;
        System.out.println("i1 = "+ i1);

        boolean bo = false;
        System.out.println("bo = " + bo);
//
        int i2;
        byte by1;
        by1 = -1;
        i2 = (by1 < 0) ? by1 + 256 : by1;
        System.out.println("i2 = "+ i2);

        i2 = 128;
        by1 = (byte)((i2 > 127) ? i2 - 256 : i2);
        System.out.println("by = "+ by1);
//
        //byte by2 = 128;

// hraniční hodnoty dat. typů
        System.out.println("Byte.MIN_VALUE = "+ Byte.MIN_VALUE);
        System.out.println("Byte.MAX_VALUE = "+ Byte.MAX_VALUE);

        System.out.println("Short.MIN_VALUE = "+ Short.MIN_VALUE);
        System.out.println("Short.MAX_VALUE = "+ Short.MAX_VALUE);

        System.out.println("Integer.MIN_VALUE = "+ Integer.MIN_VALUE);
        System.out.println("Integer.MAX_VALUE = "+ Integer.MAX_VALUE);

        System.out.println("Long.MIN_VALUE = "+ Long.MIN_VALUE);
        System.out.println("Long.MAX_VALUE = "+ Long.MAX_VALUE);

        System.out.println("Float.MIN_VALUE = "+ Float.MIN_VALUE);
        System.out.println("Float.MAX_VALUE = "+ Float.MAX_VALUE);

        System.out.println("Double.MIN_VALUE = "+ Double.MIN_VALUE);
        System.out.println("Double.MAX_VALUE = "+ Double.MAX_VALUE);


        System.out.println("Float.NEGATIVE_INFINITY = "+ Float.NEGATIVE_INFINITY);
        System.out.println("Float.POSITIVE_INFINITY = "+ Float.POSITIVE_INFINITY);

        System.out.println("Double.NEGATIVE_INFINITY = "+ Double.NEGATIVE_INFINITY);
        System.out.println("Double.POSITIVE_INFINITY = "+ Double.POSITIVE_INFINITY);

// vytvoření nekonečna a NaN
        double nula = 0.0;
        double vysledek = +5.0 / nula;
        System.out.println(vysledek);
        if (Double.isInfinite(vysledek) == true)
            System.out.println("nekonečno");

        vysledek = -5.0 / nula;
        System.out.println(vysledek);
        if (Double.isInfinite(vysledek) == true)
            System.out.println("nekonečno");

        System.out.println("2 * Float.MAX_VALUE = "+ 2 * Float.MAX_VALUE);

        vysledek = nula / nula;
        System.out.println(vysledek);
        if (Double.isNaN(vysledek) == true)
            System.out.println("není číslo");

// konst. Pi
        System.out.println("Pi: " + java.lang.Math.PI);
        System.out.println("Pi: " + Math.PI);

// přiřazení jako výraz
        int j, i = 5;
        if (i == (j = 5))
            System.out.println("j = " + j + ", i = " + j);
        boolean b = false;
        if (b = true)
            System.out.println("b = " + b);

// přetypování
        int i4 = 5;
        double d4;
        d4 = (double) i4;
        System.out.println("i4 = " + i4);
        System.out.println("d4 = " + d4);

        char c = 'A';
        int i5 = (int) c;
        char d = (char) i5;
        System.out.println("c = " + c);
        System.out.println("i5 = " + i5); //-->65 (ASCII-Wert)
        System.out.println("d = " + d);

// konverze rozšiřující
        byte b2;
        short s = 10;
        int i6;
        float f;
        System.out.println("s = " + s);
        //b2 = s; incompatible types: possible lossy conversion from short to byte
        b2 = (byte) s;
        System.out.println("b2 = " + b2);
        i6 = s;
        System.out.println("i6 = " + i6);
        f = s;
        System.out.println("f = " + f);

        int i7 = 5;
        boolean b3 = true;
        //i7 = b3; incompatible types: boolean cannot be converted to int
        //b3 = i7; incompatible types: int cannot be converted to boolean

// konverze zužující
        short s2 = 300;
        byte b4;
        b4 = (byte) s2;
        System.out.println("s2 = " + s2 + ", b4 = " + b4);
        b4 = (byte) 255;
        System.out.println("b4 = " + b4);

        int j2, i8 = 1234567890, diff;
        float f2;
        double promile;
        f2 = i8;
        j2 = (int) f2;
        System.out.println("i8 = " + i8 + "\nf2 = "+ f2 + "\nj2 = " + j2);
        diff = j2 - i8;
        System.out.println("diff j2 - i8 = " + diff);
        promile = ((double) (j2 - i8) / (double) i8) * 1000.0;
        System.out.println("promile = " + promile);

// binární operátory
        int i9 = 5;
        int j9 = 13;
        j9 = j9 / 4;
        System.out.println("j9 = " + j9);
        j9 = 13;
        j9 /= 4;
        System.out.println("j9 = " + j9);
        j9 = i9 % 3;
        System.out.println("j9 = " + j9);

        byte b10 = 126; //127 max
        //b10 = b10 + 3; n. b10 =  b10 + (byte) 3; incompatible types: possible lossy conversion from int to byte
        b10 = (byte) (b10 + 3);
        System.out.println("b10 = " + b10);
        b10 = -126; //-128 min
        b10 = (byte) (b10 - 5);
        System.out.println("b10 = " + b10);

// relační operátory
        byte i11 = 1, j11 = 2, k11 = 3;
        //if (i11 == 2 && ++j11 == 3)
        if (i11 == 2 & ++j11 == 3)
            k11 = 4;
        System.out.println("i11 = " + i11 + ", j11 = " + j11 + ", k11 = " + k11);

        i11 = 1; j11 = 2; k11 = 3;
        //if (i11 == 1 || ++j11 == 2)
        if (i11 == 1 | ++j11 == 2)
            k11 = 4;
        System.out.println("i11 = " + i11 + ", j11 = " + j11 + ", k11 = " + k11);

        byte x = 1, y = 0, z = 2;
        if (y != 0 && x / y < z)
        //if (y != 0 & x / y < z) // Exception in thread "main" java.lang.ArithmeticException: / by zero at org.example.Druhy.main(Druhy.java:166)
            /*null*/;

// bitové operace
        byte i12 = 7 & 9;
        System.out.println("i12 = " + i12);

        i12 += 1;
        if (i12 % 2 == 0)
            System.out.println(i12 + " je sudé");
        if ((i12 & 1) ==0)
            System.out.println(i12 + " je sudé");

        int i13 = 1, j13 = 2, m13;
        boolean k13;
        //k13 = i13 && j13; bad operand types for binary operator '&&' first type: int second type: int
        m13 = i13 & j13;

        byte i14 = 7 | 9;
        System.out.println("i14 = " + i14);

        final byte VIDITELNY = 1;
        final byte PREMISTITELNY = 2;
        final byte MENITELNY = 4;
        final byte SMAZATELNY = 8;
        byte stav = 0;
        stav |= VIDITELNY;
        System.out.println("stav = " + stav);
        stav |= PREMISTITELNY;
        System.out.println("stav = " + stav);
        stav |= SMAZATELNY;
        System.out.println("stav = " + stav);

        if ((stav & PREMISTITELNY) == PREMISTITELNY) {
            System.out.println("Stav je PŘEMÍSTITELNÝ");
            System.out.println("filtrovaný stav: " + (stav & PREMISTITELNY));
        }

        byte stav_invert = (byte) ~stav; //00001011 --> 11110100
        System.out.println("invertovaný stav = " + stav_invert);
        stav &= ~VIDITELNY;
        System.out.println("stav = " + stav);
        stav &= ~PREMISTITELNY;
        System.out.println("stav = " + stav);
        stav &= ~SMAZATELNY;
        System.out.println("stav = " + stav);

        stav &= ~(VIDITELNY | PREMISTITELNY | MENITELNY | SMAZATELNY);
        System.out.println("stav = " + stav);




    }
}

