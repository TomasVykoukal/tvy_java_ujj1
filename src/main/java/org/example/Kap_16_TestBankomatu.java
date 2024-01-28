package org.example;

class BankomatException extends Exception { //Exception => checked exception, synchronn�
    public BankomatException() {
        super("Bankomat do�asn� mimo provoz (BankomatException())");
    }
}

class Bankomat {
    private int penize = 0;
    Bankomat(int kolik) {this.penize = kolik;}

    //int vydejPenize(int kolik) throws BankomatException {
    int vydejPenize(int kolik) throws Exception {
        if (kolik > this.penize) {
            System.out.println("Nedostatek hotovosti (vydejPenize())");
            //throw new BankomatException(); //be.getMessage() vrac� hl�en� v��e definovan� vlastn� v�jimky ("Bankomat do�asn� mimo provoz")
            throw new Exception(); //be.getMessage() vrac� null
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
            System.out.println("Vyd�no: " + b.vydejPenize(200));
            System.out.println("Vyd�no: " + b.vydejPenize(500));
            System.out.println("Vyd�no: " + b.vydejPenize(350)); //!
        }
        //catch (BankomatException be) {
        catch (Exception be) {
            System.out.println("Vyhledejte jin� bankomat. (main())");
            System.out.println(be.getMessage());
            be.printStackTrace();
        }
    }
}
/*V�pisy:
- Varianta BankomatException:
  Vyd�no: 200
  Vyd�no: 500
  Nedostatek hotovosti (vydejPenize())
  Vyhledejte jin� bankomat. (main())
  Bankomat do�asn� mimo provoz (BankomatException())
  org.example.BankomatException: Bankomat do�asn� mimo provoz (BankomatException())
	  at org.example.Bankomat.vydejPenize(Kap_16_TestBankomatu.java:17)
	  at org.example.Kap_16_TestBankomatu.main(Kap_16_TestBankomatu.java:33)

  Process finished with exit code 0

- Varianta Exception:
  Vyd�no: 200
  Vyd�no: 500
  Nedostatek hotovosti (vydejPenize())
  Vyhledejte jin� bankomat. (main())
  null
  java.lang.Exception
      at org.example.Bankomat.vydejPenize(Kap_16_TestBankomatu.java:18)
      at org.example.Kap_16_TestBankomatu.main(Kap_16_TestBankomatu.java:33)

  Process finished with exit code 0*/
