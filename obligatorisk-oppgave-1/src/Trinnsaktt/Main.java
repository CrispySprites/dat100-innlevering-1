package Trinnsaktt;

import java.util.ArrayList;
import java.util.Scanner;

class Trinn {
    String name;
    float lavGrns;
    float topGrns;

    float skattPros;

    Trinn(String name, float lavGrns, float topGrns, float skattPros) {
        this.name = name;
        this.lavGrns = lavGrns;
        this.topGrns = topGrns;
        this.skattPros = skattPros;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Oppgi bruttointekt: ");

        String bruttointektString = input.nextLine();
        float bruttointekt = Float.parseFloat(bruttointektString);

        Trinn trinn_0 = new Trinn("trinn 0",0, 127400, 0);
        Trinn trinn_1 = new Trinn("trinn 1",trinn_0.topGrns + 1, 306050, 0.017f);
        Trinn trinn_2 = new Trinn("trinn 2",trinn_1.topGrns + 1, 697150, 0.04f);
        Trinn trinn_3 = new Trinn("trinn 3",trinn_2.topGrns + 1, 942400, 0.137f);
        Trinn trinn_4 = new Trinn("trinn 4",trinn_3.topGrns + 1, 1410750, 0.167f);
        Trinn trinn_5 = new Trinn("trinn 5",trinn_4.topGrns + 1, 0, 0.177f);

        ArrayList<Trinn> trinnListe = new ArrayList<Trinn>();
        trinnListe.add(trinn_0);
        trinnListe.add(trinn_1);
        trinnListe.add(trinn_2);
        trinnListe.add(trinn_3);
        trinnListe.add(trinn_4);
        trinnListe.add(trinn_5);

        for (Trinn trinn : trinnListe) {
            if ((trinn.lavGrns <= bruttointekt && bruttointekt <= trinn.topGrns) || (trinn.lavGrns <= bruttointekt && trinn.topGrns == 0)) {
                float skattBel = bruttointekt * trinn.skattPros;
                float nettointekt = bruttointekt - skattBel;

                System.out.println("Skatte"+trinn.name);
                System.out.println("Bruttointekt: "+ nokFormat(bruttointekt));
                System.out.println("Trinnskatt: "+ trinn.skattPros * 100 + "%");
                System.out.println("Skattet beløp: " + nokFormat(skattBel));
                System.out.println("Nettointekt: "+ nokFormat(nettointekt));
                break;
            }
        }
    }

    static String nokFormat(float value){
        String stringValue = String.format("%.2f", value); // formaterer slik at verdien altid har to decimalar og bytter frå punktom til komma
        boolean hasPassedComma = false;
        // bygger opp stringen som skal returnerst baklengs
        String formatValue = "rk ";
        int j = 0;
        for (int i = stringValue.length(); i > 0; i--) {
            // legger in mellomrom mellom kvart treje siffer
            if (j == 3){
                formatValue += " ";
                j = 0;
            }
            // vetert med formateringen til etter komma
            if (hasPassedComma) {
                j++;
            }
            if (stringValue.charAt(i-1) == ',') hasPassedComma = true;
            formatValue += stringValue.charAt(i-1);
        }
        // reverser stringen
        StringBuilder returnValue = new StringBuilder(formatValue).reverse();
        return returnValue.toString();
    }

}
