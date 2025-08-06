//Lee un número por teclado que pida el precio de un producto (puede tener
//decimales) y calcule el precio final con IVA. El IVA sera una constante que sera del
//10%

import java.util.Scanner;

public class Ejercicio6 {
    static final float IVA = 0.1F;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el precio de un producto:");
        int precio = sc.nextInt();
        float precioiva = precio + (IVA * precio);
        System.out.println("El precio de un producto sin iva es: " + precio+ " y con IVA es "+precioiva);
    }
}
