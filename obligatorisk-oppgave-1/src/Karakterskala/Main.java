package Karakterskala;

import java.util.ArrayList;
import java.util.Scanner;

class Karakter {
    String karakter;
    int lavGrns;
    int topGrns;

    Karakter(String karakter, int lavGrns, int topGrns) {
        this.karakter = karakter;
        this.lavGrns = lavGrns;
        this.topGrns = topGrns;
    }
}

class Elev {
    int poengSum;

    Elev(int poengSum) {
        this.poengSum = poengSum;
    }
}

public class Main {


    public static void main(String[] args) {
        boolean conntinu = false;

        Karakter A = new Karakter("A", 90, 100);
        Karakter B = new Karakter("B", 80, 89);
        Karakter C = new Karakter("C", 60, 79);
        Karakter D = new Karakter("D", 50, 59);
        Karakter E = new Karakter("E", 40, 49);
        Karakter F = new Karakter("F", 0, 39);

        ArrayList<Karakter> karakterList = new ArrayList<Karakter>();
        karakterList.add(A);
        karakterList.add(B);
        karakterList.add(C);
        karakterList.add(D);
        karakterList.add(E);
        karakterList.add(F);

        ArrayList<Elev> elevar = new ArrayList<Elev>();
        String errorMessage = "";

        while (!conntinu) {
            if (elevar.size() > 0) {
                System.out.println("Antall elevar: " + elevar.size());
                System.out.println("for å printe ut karakterer skriv 'fortsett'");
            }
            System.out.println(errorMessage);
            System.out.print("Oppgi ein elevs poengsum: ");
            Scanner input = new Scanner(System.in);
            errorMessage = "";
            String s =  input.nextLine();
            if (s.equalsIgnoreCase("fortsett") && elevar.size() > 0) {
                conntinu = true;
                break;
            } else if (s.equalsIgnoreCase("fotsett") && elevar.size() == 0) {
                errorMessage = "Må oppgi minst ein poengsum!";
            }

            int i;
            try {
                i = Integer.parseInt(s);
            }
            catch (NumberFormatException e) {
                i = -1;
            }


            if (i >= 0 && i <= 100) {
                elevar.add(new Elev(i));
            } else {
                errorMessage = "Oppgitt verdi må vere eit heiltall mellom 0 og 100!";
            }
        }

        int e = 0;
        for (Elev elev : elevar) {
            for (Karakter karakter : karakterList) {
                if (karakter.lavGrns <= elev.poengSum && elev.poengSum <= karakter.topGrns) {
                    e++;
                    System.out.println("Elev nr." + e +": " + karakter.karakter + " (" + elev.poengSum + " poeng)");
                }
            }
        }
    }
}
