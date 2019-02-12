package curso1SI.ejemplos;

import java.util.Scanner;

public class NumeroPrimoRecursivo {
	
	private static Scanner sc = new Scanner(System.in);
	
    public static void main(String[] args) {
        System.out.print("Introduce un n�mero: ");
        int numero = sc.nextInt();
        System.out.printf("%nEl numero %d ", numero);
        if (numero < 2)  {
        	System.out.print("no es un n�mero primo.");
        	System.exit(0);
        }
        System.out.print(numeroPrimo(numero, 2)?"es un n�mero primo.":"no es un n�mero primo.");
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
