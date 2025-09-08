package Beregne_fakultet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Oppgi verdien n: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long output = 1;
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                output *= i;
            }
        }else {
            System.out.println("n må vere støre en 0");
        }
        System.out.print("n! = " + output);
    }
}
