package org.example;
;
public class Kap_3 {
    public static void main(String[] args){
        System.out.println("Program kon\u010D\u00ED! \n\007");

        //int i1;
        int i1 = 5;
        System.out.println("i1 = "+ i1);

// pøevod BYTE->INT a zpìt (UJJ s. 36)
        int i2;
        byte by1;

        by1 = -1;
        i2 = (by1 < 0) ? by1 + 256 : by1;
        System.out.println("by1 = "+ by1 + ", i2 = "+ i2);

        i2 = 128;
        by1 = (byte)((i2 > 127) ? i2 - 256 : i2);
        System.out.println("i1 = "+ i2 + ", by1 = "+ by1);

// Logický typ a jeho konstanty (UJJ s. 40)
        boolean bo = false;
        System.out.println("bo = " + bo);

        int i3 = 1;
        bo = (i3 != 0); //=true
        System.out.println("bo (i3 != 0) = " + bo);
        i3 = (bo) ? 1 : 0; //=1
        System.out.println("i3 (bo) = " + i3);

// hranièní hodnoty dat. typù
        System.out.println("Byte.SIZE = "+ Byte.SIZE);
        System.out.println("Byte.MIN_VALUE = "+ Byte.MIN_VALUE);
        System.out.println("Byte.MAX_VALUE = "+ Byte.MAX_VALUE);

        System.out.println("Short.SIZE = "+ Short.SIZE);
        System.out.println("Short.MIN_VALUE = "+ Short.MIN_VALUE);
        System.out.println("Short.MAX_VALUE = "+ Short.MAX_VALUE);

        System.out.println("Integer.SIZE = "+ Integer.SIZE);
        System.out.println("Integer.MIN_VALUE = "+ Integer.MIN_VALUE);
        System.out.println("Integer.MAX_VALUE = "+ Integer.MAX_VALUE);

        System.out.println("Long.SIZE = "+ Long.SIZE);
        System.out.println("Long.MIN_VALUE = "+ Long.MIN_VALUE);
        System.out.println("Long.MAX_VALUE = "+ Long.MAX_VALUE);

        System.out.println("Float.SIZE = "+ Float.SIZE);
        System.out.println("Float.MIN_EXPONENT = "+ Float.MIN_EXPONENT);
        System.out.println("Float.MIN_VALUE = "+ Float.MIN_VALUE);
        System.out.println("Float.MAX_EXPONENT = "+ Float.MAX_EXPONENT);
        System.out.println("Float.MAX_VALUE = "+ Float.MAX_VALUE);

        System.out.println("Double.SIZE = "+ Double.SIZE);
        System.out.println("Double.MIN_EXPONENT = "+ Double.MIN_EXPONENT);
        System.out.println("Double.MIN_VALUE = "+ Double.MIN_VALUE);
        System.out.println("Double.MAX_EXPONENT = "+ Double.MAX_EXPONENT);
        System.out.println("Double.MAX_VALUE = "+ Double.MAX_VALUE);

        System.out.println("Float.NEGATIVE_INFINITY = "+ Float.NEGATIVE_INFINITY);
        System.out.println("Float.POSITIVE_INFINITY = "+ Float.POSITIVE_INFINITY);

        System.out.println("Double.NEGATIVE_INFINITY = "+ Double.NEGATIVE_INFINITY);
        System.out.println("Double.POSITIVE_INFINITY = "+ Double.POSITIVE_INFINITY);

// vytvoøení nekoneèna a NaN
        double nula = 0.0;
        double vysledek = +5.0 / nula;
        System.out.println(vysledek);
        if (Double.isInfinite(vysledek) == true)
            System.out.print("nekoneèno");
        if (vysledek == Double.POSITIVE_INFINITY)
            System.out.println(" (kladné nekoneèno)");
        if (vysledek == Double.NEGATIVE_INFINITY)
            System.out.println(" (záporné nekoneèno)");

        vysledek = -5.0 / nula;
        System.out.println(vysledek);
        if (Double.isInfinite(vysledek) == true)
            System.out.print("nekoneèno");
        if (vysledek == Double.POSITIVE_INFINITY)
            System.out.println(" (kladné nekoneèno)");
        if (vysledek == Double.NEGATIVE_INFINITY)
            System.out.println(" (záporné nekoneèno)");

        System.out.println("2 * Float.MAX_VALUE = "+ 2 * Float.MAX_VALUE);

        vysledek = nula / nula;
        System.out.println(vysledek);
        if (Double.isNaN(vysledek) == true)
            System.out.println("není èíslo");

// konst. Pi
        System.out.println("Pi: " + java.lang.Math.PI);
        System.out.println("Pi: " + Math.PI);

// pøiøazení jako výraz
        int k, j, i = 5;
        if (i == (j = 5))
            System.out.println("j = " + j + ", i = " + j);
        boolean b = false;
        if (b = true)
            System.out.println("b = " + b);
        //nìkolikanásobné pøiøazení
        j = 0;
        System.out.println("k = j = i = 50: " + (k = j = i = 50));

// pøetypování
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

// konverze roz¹iøující
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

// konverze zu¾ující
        short s2 = 300;
        byte b4;
        b4 = (byte) s2;
        System.out.println("s2 = " + s2 + ", b4 (byte po zú¾ující konv. na byte) = " + b4);
        b4 = (byte) (s2 % 256);
        System.out.println("b4 (jako s2 mod 256) = " + b4);
        b4 = (byte) 255;
        System.out.println("b4 (byte po pøiøazení 255) = " + b4);

// ztráta pøesnosti u roz¹iøující konverze
        int j2, i8 = 1234567890, diff;
        float f2;
        double promile;
        f2 = i8;
        j2 = (int) f2;
        System.out.println("i8 = " + i8 + "\nf2 = "+ f2 + "\nj2 = " + j2);
        diff = j2 - i8;
        System.out.println("diff j2 - i8 = " + diff);
        promile = ((double) (j2 - i8) / (double) i8) * 1000.0;
        System.out.println("diff promile = " + promile);

// unární operátory
        int ix = 5, jx = 1, kx = 0;
        ix++; //6 / 1 / 0
        System.out.println("ix = " + ix + ", jx = " + jx + ", kx = " + kx);
        jx = ++ix; //7 / 7 / 0
        System.out.println("ix = " + ix + ", jx = " + jx + ", kx = " + kx);
        jx = ix++; //8 / 7 / 0
        System.out.println("ix = " + ix + ", jx = " + jx + ", kx = " + kx);
        kx = --jx + 2; //8 / 6 / 8
        System.out.println("ix = " + ix + ", jx = " + jx + ", kx = " + kx);

// binární operátory
        int i9 = 5;
        int j9 = 13;
        j9 = j9 / 4; //celoèíselné dìlení
        System.out.println("j9 = " + j9);
        j9 = 13;
        j9 /= 4;
        System.out.println("j9 = " + j9);
        j9 = i9 % 3;
        System.out.println("j9 = " + j9);

        //pøeteèení, podteèení
        byte b10 = 126; //127 max
        //b10 = b10 + 3; n. b10 =  b10 + (byte) 3; incompatible types: possible lossy conversion from int to byte
        b10 = (byte) (b10 + 3);
        System.out.println("b10 = " + b10);
        b10 = -126; //-128 min
        b10 = (byte) (b10 - 5);
        System.out.println("b10 = " + b10);

// pøiøazovací operátory
        int iy = 4, jy = 3;
        System.out.println("iy = " + iy + ", jy = " + jy);
        jy += iy; //7
        System.out.println("jy = " + jy);
        jy /= --iy; //2 / 3
        System.out.println("iy = " + iy + ", jy = " + jy);
        jy *= iy - 2; //jy = jy * (iy - 2) tj. 2
        System.out.println("jy = " + jy);

// relaèní operátory
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
            System.out.println("Stav je PØEMÍSTITELNÝ");
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

        byte i15 = 7 ^ 9;
        System.out.println("i15 = " + i15);

        //bitový posun doleva
        int x1 = 3;
        x1 <<= 1;
        System.out.println("x <<= 1 = " + x1);
        x1 <<= 1;
        System.out.println("x <<= 1 = " + x1);
        x1 <<= 2;
        System.out.println("x <<= 2 = " + x1);
        x1 <<= 3;
        System.out.println("x <<= 3 = " + x1);

        //bitový posun doprava znaménkovì
        x1 >>= 1;
        System.out.println("x >>= 1 = " + x1);
        x1 >>= 3;
        System.out.println("x >>= 3 = " + x1);

        //... doprava znaménkovì vs. neznaménkovì
        byte x2b = 16;
        byte x3b = -16;
        byte x4b = -16;
        x2b >>= 2;
        x3b >>= 2;
        x4b >>>= 2;
        System.out.println("x2b >>= 2 = " + x2b);
        System.out.println("x3b >>= 2 = " + x3b); //neznam. posun relev. jen pro int a long
        System.out.println("x4b >>>= 2 = " + x4b);

        int x2i = 16;
        int x3i = -16;
        int x4i = -16;
        x2i >>= 2;
        x3i >>= 2;
        x4i >>>= 2;
        System.out.println("x2i >>= 2 = " + x2i);
        System.out.println("x3i >>= 2 = " + x3i);
        System.out.println("x4i >>>= 2 = " + x4i);

        //bitový posun vs. násobení - mìøení èasu
        int i16;
        int j16 = 1000000;

        long start1_1 = System.nanoTime();
        i16 = j16 * 80;
        long end1_1 = System.nanoTime();
        System.out.println("i16: " + i16);
        System.out.println("Elapsed Time in nano seconds *80: "+ (end1_1 - start1_1));

        long start2_1 = System.currentTimeMillis();
        i16 = j16 * 80;
        long end2_1 = System.currentTimeMillis();
        System.out.println("i16: " + i16);
        System.out.println("Elapsed Time in milli seconds *80: "+ (end2_1 - start2_1));

        long start1_2 = System.nanoTime();
        i16 = (j16 << 6) + (j16 << 4);
        long end1_2 = System.nanoTime();
        System.out.println("i16: " + i16);
        System.out.println("Elapsed Time in nano seconds <<6 <<4: "+ (end1_2 - start1_2));

        long start2_2 = System.currentTimeMillis();
        i16 = (j16 << 6) + (j16 << 4);
        long end2_2 = System.currentTimeMillis();
        System.out.println("i16: " + i16);
        System.out.println("Elapsed Time in milli seconds <<6 <<4: "+ (end2_2 - start2_2));

        //bitový posun neznaménkovì
        int x5 = -160;
        x5 >>= 0;
        System.out.println("x5: " + x5);

        System.out.println("getBit(16, 0): " + getBit(16, 0));
        System.out.println("getBit(16, 1): " + getBit(16, 1));
        System.out.println("getBit(16, 2): " + getBit(16, 2));
        System.out.println("getBit(16, 3): " + getBit(16, 3));
        System.out.println("getBit(16, 4): " + getBit(16, 4));
        System.out.println("getBit(16, 5): " + getBit(16, 5));
        System.out.println("getBit(16, 32): " + getBit(16, 32));

    }
    static int getBit (int x, int i) {
        if (i >= 32)
            return (-1);
        else
            return ((x >>> i) & 1);
    }
}

