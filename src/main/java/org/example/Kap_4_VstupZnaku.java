package org.example;
import java.io.*;

public class Kap_4_VstupZnaku {
    //varianta s. 72
    /*public static void main(String[] args) throws IOException {
        System.out.print("Zadej znak: ");
        char c = (char) System.in.read();
        System.out.println("c = " + c);
    }*/

    //varianta s. 73
    public static char ctiZnak() {
        try {
            return (char) System.in.read();
        }
        catch (IOException e) {
            return '\uFFFF';
        }
    }
    public static void main(String[] args) {
        System.out.println("Odřádkování: " + System.getProperty("line.separator"));
        System.out.print("Zadej znak: ");
        char c = ctiZnak();
        System.out.println("c = " + c);
    }
}
