import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.Scanner;
import java.util.ArrayList;
public class toros_vacas {
    public static String generar_numero(){
        RandomGenerator rg = new Random();
        StringBuilder n = new StringBuilder();

        while (n.length() < 4){
            int random = rg.nextInt(1,9);
            String randomstr = String.valueOf(random);

            if(!n.toString().contains(randomstr)){
                n.append(randomstr);
            }
        }
        return n.toString();
    }

    public static void jugar() {
        Scanner sc = new Scanner(System.in);
        String num_generado = generar_numero();
        ArrayList<Character> caracteres = new ArrayList<>();
        int vacas, toros ;

        for(int i=0;i<num_generado.length();i++){
            caracteres.add(num_generado.charAt(i));
        }
        while (true) {
            toros = 0;
            vacas = 0;
            System.out.println("Ingrese un numero de 4 digitos entero sin 0 al inicio");
            String num_usuario = sc.next();
            while (num_usuario.length() != 4){
                System.out.println("Formato incorrecto, solo se aceptan numeros de 4 digitos, intente de nuevo");
                num_usuario = sc.next();

            }
            for (int i = 0; i < 4; i++) {
                if (num_generado.charAt(i) == num_usuario.charAt(i)) {
                    toros++;
                } else if (caracteres.contains(num_usuario.charAt(i)))  {
                    vacas ++;
                }
            }
            System.out.println("Obtuviste " + vacas + " vacas y " + toros + " toros");
            if (toros == 4) {
                System.out.println("Obtuviste los 4 toros. Has ganado");
                break;
            }
            int surrender;
            System.out.println("Te rindes?, 1 = Si, 0 = No");
            surrender = sc.nextInt();
            if (surrender == 1) {
                System.out.println("Lastima el numero era:"+ num_generado);
                break;
            }

        }
        sc.close();
    }
    public static void main(String[] args) {
        jugar();
    }
}
