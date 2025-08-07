import java.util.ArrayList;
import java.util.Scanner;
public class Maingenerala {
    public static void main(String[] args){
        ArrayList <int []> jugadas = new ArrayList<>();
        Generala1 juegoNuevo = new Generala1();
        int intentos = 0;
        Scanner input = new Scanner(System.in);


        while(true){
            int [] jugada = new int[5];
            intentos ++;
            jugada = juegoNuevo.generarDados();
            juegoNuevo.mostrarDados(jugada);
            System.out.println("Desea conservar estos dados ");
            System.out.println("1. Si");
            System.out.println("2. No");
            int opcion = input.nextInt();

            if(opcion == 1){
                jugadas.add(jugada);
                break;
            }
            if(intentos == 3){
                System.out.println("Se acabaron los intentos, te quedas con esta jugada");
                jugadas.add(jugada);
                break;
            }
        }
        System.out.println("Felicades has obtenido " + juegoNuevo.identificarJugada(jugadas.getFirst()));
    }
}
/*
La probabilidad de sacar generala en un tiro es 0,08% , de poker es 1,93%
de full es 3,86%, de escalera 3,09% y de no sacar nada es 91,04%
La probabilidad de sacar generala dos veces seguidas es de 6,4 x 10^-4 %

 */