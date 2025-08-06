//Declara 2 variables numéricas (con el valor que desees), he indica cual es mayor de los dos.
//Si son iguales indicarlo también. Ves cambiando los valores para comprobar que funciona.
import java.util.Scanner;
public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero");
        int x = sc.nextInt();
        System.out.println("Ingrese otro numero");
        int y = sc.nextInt();

        if (x == y) {
            System.out.println("Las variables son iguales");
        }
        else {
            System.out.println(Math.max(x, y) + " Es mayor que "+ Math.min(x, y));
        }
    }
}
