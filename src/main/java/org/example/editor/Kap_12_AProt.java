package org.example.editor;

//protected class Kap_12_AProt { //protected třída (nikoliv public) => Modifier 'protected' not allowed here
public class Kap_12_AProt {
    protected int i;
    protected int getI() {return this.i;}
}

class ABProt extends Kap_12_AProt { //přístup v podtřídě téhož balíku => ANO
    int j;
    ABProt() {
        super.i = 1;
        this.j = getI();
    }
}

class BProt { //přístup v jíné třídě téhož balíku => ANO
    int j;
    BProt() {
        Kap_12_AProt a = new Kap_12_AProt();
        a.i = 1; //PROTECTED => volný přístup i z jiné třídy téhož balíku možný (PRIVATE neumožňuje)
        this.j = a.getI();
    }
}

//přístup v podtřídě v jiném balíku => ANO (viz org.example.Kap_12_ABProt)
