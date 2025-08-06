//Lee un número por teclado e indica si es divisible entre 2 (resto = 0). Si no lo es,
//también debemos indicarlo

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        int n = 0;
        while (!valid) {
            try {
                System.out.println("Ingrese un numero");
                n = sc.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Error en el numero,formato incorrecto");
                sc.nextLine();
            }
        }
        if (n % 2 == 0){
            System.out.println(n + " es un numero par");
        }
        sc.close();
    }
}
