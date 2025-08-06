//Escribe una aplicación con un String que contenga una contraseña cualquiera. Después
//se te pedirá que introduzcas la contraseña, con 3 intentos. Cuando aciertes ya no pedirá
//mas la contraseña y mostrara un mensaje diciendo “Correcto!”. Piensa bien en la
//condición de salida (3 intentos y si acierta sale, aunque le queden intentos, si no acierta
//en los 3 intentos mostrar el mensaje “Fallaste jaja!!”).

import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password = "123";
        int intentos = 0;
        while( intentos != 3){
            System.out.print("Ingrese su contrasenha: ");
            String prueba = sc.nextLine();

            if(prueba.equals(password)){
                System.out.println("Vale sos");
                System.exit(0);
            }
            else{
                intentos++;
            }
        }
        System.out.println("Fallaste jaja");
    }
}
