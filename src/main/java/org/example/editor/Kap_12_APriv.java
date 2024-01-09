package org.example.editor;

//private class Kap_12_APriv { //private třída (nikoliv public) => Modifier 'private' not allowed here
class Kap_12_APriv {
    private int i;
    private int getI() {return this.i;} //přístup v téže třídě => ANO
}

class BPriv { //přístup v jiné třídě téhož balíku => NE
    int j;
    BPriv() {
        Kap_12_APriv a = new Kap_12_APriv();
        //a.i = 1; //'i' has private access in 'org.example.editor.Kap_12_APriv'
        //j = a.getI(); //'getI()' has private access in 'org.example.editor.Kap_12_APriv'
    }
}

class ABPriv extends Kap_12_APriv { //přístup v podtřídě téhož balíku => NE
    int j;
    ABPriv () {
        //i = 1; //'i' has private access in 'org.example.editor.Kap_12_APriv'
        //j = getI(); //'getI()' has private access in 'org.example.editor.Kap_12_APriv'
    }
}
