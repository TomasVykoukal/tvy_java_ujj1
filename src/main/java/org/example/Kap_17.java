package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Kap_17 {
    File f = new File("soubor.txt");

    public static void main(String[] args) {
        //1. zaji�t�n� nez�vislosti na OS
        System.out.println("--- Statick� prom�nn� t�. File ---:");
        System.out.println("File.separator: " + File.separator);
        System.out.println("File.separatorChar: " + File.separatorChar);
        System.out.println("File.pathSeparator: " + File.pathSeparator);
        System.out.println("File.pathSeparatorChar: " + File.pathSeparatorChar);

        //2. vytvo�en� instance t��dy File
        String jmAktDir = System.getProperty("user.dir");
        System.out.println("aktu�ln� adres�� System.getProperty(\"user.dir\"): " + jmAktDir);

        File soubAbs = new File(jmAktDir, "a.txt");
        File soubRel = new File("src" + File.separator + "a.txt");
        File soub    = new File("a.txt");

        System.out.println("\n--- File soubAbs = new File(jmAktDir, \"a.txt\") ---:");
        System.out.println("getParent():        " + soubAbs.getParent());
        System.out.println("getParentFile():    " + soubAbs.getParentFile());
        System.out.println("getName():          " + soubAbs.getName());
        System.out.println("getPath():          " + soubAbs.getPath());
        System.out.println("getAbsolutePath():  " + soubAbs.getAbsolutePath());
        System.out.println("getAbsoluteFile():  " + soubAbs.getAbsoluteFile());
        try {
            System.out.println("getCanonicalPath(): " + soubAbs.getCanonicalPath());
            System.out.println("getCanonicalFile(): " + soubAbs.getCanonicalFile());
        }
        catch (IOException e) {
            System.out.println("IOException od soubAbs.getCanonicalFile()|getCanonicalPath()");
        }
        System.out.println("getFreeSpace(): " + soubAbs.getFreeSpace());
        System.out.println("getTotalSpace(): " + soubAbs.getTotalSpace());
        System.out.println("getUsableSpace(): " + soubAbs.getUsableSpace());
        System.out.println("getClass(): " + soubAbs.getClass());

        System.out.println("\n--- File soubRel = new File(\"src\" + File.separator + \"a.txt\") ---:");
        System.out.println("getParent():        " + soubRel.getParent());
        System.out.println("getParentFile():    " + soubRel.getParentFile());
        System.out.println("getName():          " + soubRel.getName());
        System.out.println("getPath():          " + soubRel.getPath());
        System.out.println("getAbsolutePath():  " + soubRel.getAbsolutePath());
        System.out.println("getAbsoluteFile():  " + soubRel.getAbsoluteFile());
        try {
            System.out.println("getCanonicalPath(): " + soubRel.getCanonicalPath());
            System.out.println("getCanonicalFile(): " + soubRel.getCanonicalFile());
        }
        catch (IOException e) {
            System.out.println("IOException od soubRel.getCanonicalFile()|getCanonicalPath()");
        }
        System.out.println("getFreeSpace(): " + soubRel.getFreeSpace());
        System.out.println("getTotalSpace(): " + soubRel.getTotalSpace());
        System.out.println("getUsableSpace(): " + soubRel.getUsableSpace());
        System.out.println("getClass(): " + soubRel.getClass());

        System.out.println("\n--- File soub = new File(\"a.txt\") ---:");
        System.out.println("getParent():        " + soub.getParent());
        System.out.println("getParentFile():    " + soub.getParentFile());
        System.out.println("getName():          " + soub.getName());
        System.out.println("getPath():          " + soub.getPath());
        System.out.println("getAbsolutePath():  " + soub.getAbsolutePath());
        System.out.println("getAbsoluteFile():  " + soub.getAbsoluteFile());
        try {
            System.out.println("getCanonicalPath(): " + soub.getCanonicalPath());
            System.out.println("getCanonicalFile(): " + soub.getCanonicalFile());
        }
        catch (IOException e) {
            System.out.println("IOException od soub.getCanonicalFile()|getCanonicalPath()");
        }
        System.out.println("getFreeSpace(): " + soub.getFreeSpace());
        System.out.println("getTotalSpace(): " + soub.getTotalSpace());
        System.out.println("getUsableSpace(): " + soub.getUsableSpace());
        System.out.println("getClass(): " + soub.getClass());

        //3. vytvo�en� souboru nebo adres��e
        File novySou = new File("b.txt"); //File je je�t� bez rozli�en� na soubor nebo adres��. K tomu doch�z� a� p�i vytvo�en�: ...
        File novyAdr = new File("TMP");   //... %File%.createNewFile() vs. %File%.mkdir()

        System.out.println();
        if (novySou.exists()) {
            System.out.println(novySou.getName() + " existuje");
        }
        else {
            try {
                novySou.createNewFile();
                System.out.println(novySou.getName() + " byl vytvo�en");
            }
            catch (IOException e) {
                System.out.println("IOException novySou.createNewFile()");
            }
        }
        if (novySou.isFile()) {
            System.out.println(novySou.getName() + " je soubor");
        }

        if (novyAdr.exists()) {
            System.out.println(novyAdr.getName() + " existuje");
        }
        else {
            novyAdr.mkdir();
            System.out.println(novyAdr.getName() + " byl vytvo�en");
        }
        if (novyAdr.isDirectory()) {
            System.out.println(novyAdr.getName() + " je adres��");
        }
        System.out.println();

        //4. pr�ce se souborem nebo adres��em
        //4.a zji�t�n� informac� o souboru �i adres��i
        System.out.println("Date(novySou.lastModified()): " + novySou.lastModified());
        System.out.println("Date(novySou.lastModified()): " + new Date(novySou.lastModified()));
        System.out.println("Date(novyAdr.lastModified()): " + novyAdr.lastModified());
        System.out.println("Date(novyAdr.lastModified()): " + new Date(novyAdr.lastModified()));
        System.out.println("novySou.length(): " + novySou.length());
        System.out.println("novyAdr.length(): " + novyAdr.length());
        //System.exit(0);

        //4.b p�ejmenov�n� souboru �i adres��e
        File jinySou = new File("c.txt");
        novySou.renameTo(jinySou); //pomoc� novySou ji� nelze nelze p�ejmenovan� soubor nijak ovliv�ovat
        novyAdr.renameTo(new File("TMP-OLD"));
        //System.exit(0);

        novySou.delete(); //nevyma�e c.txt (proto�e toto je odkaz na fyzicky neexistuj�c� b.txt)
        jinySou.delete(); //skute�n� vymaz�n� c.txt
        //System.exit(0);

        novyAdr.delete(); //vyma�e TMP
        File jinyAdr = new File("TMP-OLD"); //nutnost z�skat odkaz/referen�n� prom�nnou na TMP-OLD
        jinyAdr.delete(); //vyma�e TMP-OLD
        //System.exit(0);

        //5. v�pis adres��e
        File aktDir = new File(jmAktDir);
        System.out.println("\naktu�ln� adres�� System.getProperty(\"user.dir\"): " + jmAktDir);

        System.out.println("--- aktDir.list() ---:");
        String[] jmena = aktDir.list();
        for (int i = 0; i < jmena.length; i++) {
            System.out.println(jmena[i]);
        }

        System.out.println("\n--- aktDir.listFiles() ---:");
        File[] soubory = aktDir.listFiles();
        for (int i = 0; i < soubory.length; i++) {
            System.out.println(soubory[i].getName()
                    + '\t' + soubory[i].length()
                    + '\t' + new Date(soubory[i].lastModified())
                    + '\t' + soubory[i].isFile()
            );
        }

        //5.1 selektivn� v�pis adres��e -> viz Kap_17_Soubor
    }
}
