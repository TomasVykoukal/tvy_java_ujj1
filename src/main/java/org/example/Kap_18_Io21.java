package org.example;

import java.io.*;
import java.util.*;

class ImplSerializable implements Serializable { //impl. rozhr. nutn� pro mo�nost serializace objektu (jinak NotSerializableException)
    Date d;
    ImplSerializable(Date d) {
        this.d = d;
    }
}

public class Kap_18_Io21 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //18.4.9 vlastnost: serializace objekt�
        System.out.println("18.4.9 vlastnost: serializace objekt�");
        System.out.println("- f�ze z�pis do souboru");
        FileOutputStream fwJm = new FileOutputStream("18_4_9_datum.bin");
        ObjectOutputStream fw = new ObjectOutputStream(fwJm);

        Date d = new Date();
        System.out.println("Vznik d:           " + d);
        ImplSerializable impl = new ImplSerializable(d);
        System.out.println("impl.d.toString(): " + impl.d.toString());

        String st = new String("nov� string");
        System.out.println("st: " + st);

        //z�kladn�/primitivn� datov� typy
        //Boolean bo = new Boolean(true); //deprec.
        Boolean bo = Boolean.valueOf(true);
        System.out.println("bo: " + bo);
        //Character ch = new Character('c'); //deprec.
        Character ch = Character.valueOf('c');
        System.out.println("ch: " + ch);
        //Byte by = new Byte((byte)127); //deprec.
        Byte by = Byte.valueOf((byte)127);
        System.out.println("by: " + by);
        //Short sh = new Short((short)32_000); //deprec.
        Short sh = Short.valueOf((short)32_000);
        System.out.println("sh: " + sh);
        //Integer in = new Integer(2_000_000); //deprec.
        Integer in = Integer.valueOf(2_000_000);
        System.out.println("in: " + in);
        //Long lo = new Long(9_000_000_000L); //deprec.
        Long lo = Long.valueOf(9_000_000_000L);
        System.out.println("lo: " + lo);
        //Float fl = new Float(3.4e5); //deprec.
        Float fl = Float.valueOf(3.4e5F); //deprec.
        System.out.println("fl: " + fl);
        //Double db = new Double((double)-4.9e15); //deprec.
        Double db = Double.valueOf(-4.9e15);
        System.out.println("db: " + db);

        fw.writeObject(d);
        fw.writeObject(impl);
        fw.writeObject(st);
        fw.writeObject(bo);
        fw.writeObject(ch);
        fw.writeObject(by);
        fw.writeObject(sh);
        fw.writeObject(in);
        fw.writeObject(lo);
        fw.writeObject(fl);
        fw.writeObject(db);

        fwJm.close();
        d    = null; //zru�en� instance
        impl = null;
        st = null;
        bo = null;
        ch = null;
        by = null;
        sh = null;
        in = null;
        lo = null;
        fl = null;
        db = null;

        System.out.println("\n- f�ze v�pis ze souboru");
        FileInputStream frJm = new FileInputStream("18_4_9_datum.bin");
        ObjectInputStream fr = new ObjectInputStream(frJm);

        d    = (Date)fr.readObject();
        impl = (ImplSerializable)fr.readObject();
        //p�i p�ehozen� po�ad� �ten� obj.: Exception in thread "main" java.lang.ClassCastException: class java.util.Date cannot be cast to class org.example.ImplSerializable (...) at org.example.Kap_18_Io21.main(Kap_18_Io21.java:35)
        st = (String)fr.readObject();

        //z�kladn�/primitivn� datov� typy
        bo = (boolean)fr.readObject();
        ch = (char)fr.readObject();
        by = (byte)fr.readObject();
        sh = (short)fr.readObject();
        in = (int)fr.readObject();
        lo = (long)fr.readObject();
        fl = (float)fr.readObject();
        db = (double)fr.readObject();

        fwJm.close();
        System.out.println("�ten� d:           " + d);
        System.out.println("impl.d.toString(): " + impl.d.toString());
        System.out.println("st: " + st);
        System.out.println("bo: " + bo);
        System.out.println("ch: " + ch);
        System.out.println("by: " + by);
        System.out.println("sh: " + sh);
        System.out.println("in: " + in);
        System.out.println("lo: " + lo);
        System.out.println("fl: " + fl);
        System.out.println("db: " + db);
    }
}
