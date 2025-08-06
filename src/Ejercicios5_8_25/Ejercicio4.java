//Modificar ejercicio 3 para que solicite el nombre
import java.util.Scanner;
public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cual es su nombre?");
        String nombre = sc.nextLine();
        System.out.println("Bienvenido "+nombre);
    }
}
