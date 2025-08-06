//Lee un número por teclado y comprueba que este numero es mayor o igual que cero, si
//no lo es lo volverá a pedir (do while), después muestra ese número por consola

import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        do{
            System.out.print("Ingrese un numero mayor a 0: ");
            n = sc.nextInt();
        }while( n <= 0);
    }
}
