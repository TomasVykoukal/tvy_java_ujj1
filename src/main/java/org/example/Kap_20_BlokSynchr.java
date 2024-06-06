package org.example;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Kap_20_BlokSynchr {
    RandomAccessFile file;

    Kap_20_BlokSynchr(RandomAccessFile f) {
        this.file = f;
    }

    public void presun(long kam) throws IOException {
        synchronized (file) {
            file.seek(kam);
        }
    }

    public int ctiInt() throws IOException {
        synchronized (file) {
            return file.readInt();
        }
    }

    //další metody třídy bez vztahu k souboru
}
