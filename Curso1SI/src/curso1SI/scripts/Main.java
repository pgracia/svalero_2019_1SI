package curso1SI.scripts;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Introduce un número: ");
        int numero = sc.nextInt();
        System.out.printf("%nEl numero %d ", numero);
        if (numero < 2)  {
            System.out.print("no es un número primo.");
            System.exit(0);
        }
        System.out.print(numeroPrimo(numero, 2)?"es un número primo.":"no es un número primo.");
    }

    private static boolean numeroPrimo(int num, int divisor){
        if(num/2 < divisor){
            return true;
        } else {
            if(num%divisor==0){
                return false;
            } else {
                return numeroPrimo(num, divisor+1);
            }
        }
    }
}