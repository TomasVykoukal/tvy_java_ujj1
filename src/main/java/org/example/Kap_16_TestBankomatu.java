package org.example;

class BankomatException extends Exception { //Exception => checked exception, synchronní
    public BankomatException() {
        super("Bankomat doèasnì mimo provoz (BankomatException())");
    }
}

class Bankomat {
    private int penize = 0;
    Bankomat(int kolik) {this.penize = kolik;}

    //int vydejPenize(int kolik) throws BankomatException {
    int vydejPenize(int kolik) throws Exception {
        if (kolik > this.penize) {
            System.out.println("Nedostatek hotovosti (vydejPenize())");
            //throw new BankomatException(); //be.getMessage() vrací hlá¹ení vý¹e definované vlastní výjimky ("Bankomat doèasnì mimo provoz")
            throw new Exception(); //be.getMessage() vrací null
        }
        else {
            this.penize -= kolik;
            return kolik;
        }
    }
}

public class Kap_16_TestBankomatu {
    public static void main(String[] args) {
        Bankomat b = new Bankomat(1000);
        try {
            System.out.println("Vydáno: " + b.vydejPenize(200));
            System.out.println("Vydáno: " + b.vydejPenize(500));
            System.out.println("Vydáno: " + b.vydejPenize(350)); //!
        }
        //catch (BankomatException be) {
        catch (Exception be) {
            System.out.println("Vyhledejte jiný bankomat. (main())");
            System.out.println(be.getMessage());
            be.printStackTrace();
        }
    }
}
/*Výpisy:
- Varianta BankomatException:
  Vydáno: 200
  Vydáno: 500
  Nedostatek hotovosti (vydejPenize())
  Vyhledejte jiný bankomat. (main())
  Bankomat doèasnì mimo provoz (BankomatException())
  org.example.BankomatException: Bankomat doèasnì mimo provoz (BankomatException())
	  at org.example.Bankomat.vydejPenize(Kap_16_TestBankomatu.java:17)
	  at org.example.Kap_16_TestBankomatu.main(Kap_16_TestBankomatu.java:33)

  Process finished with exit code 0

- Varianta Exception:
  Vydáno: 200
  Vydáno: 500
  Nedostatek hotovosti (vydejPenize())
  Vyhledejte jiný bankomat. (main())
  null
  java.lang.Exception
      at org.example.Bankomat.vydejPenize(Kap_16_TestBankomatu.java:18)
      at org.example.Kap_16_TestBankomatu.main(Kap_16_TestBankomatu.java:33)

  Process finished with exit code 0*/
