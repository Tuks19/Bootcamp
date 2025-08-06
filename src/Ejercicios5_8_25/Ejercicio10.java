//Crea una aplicación que nos pida un día de la semana y que nos diga si es un dia
//laboral o no (“De lunes a viernes consideramos dias laborales”)


import java.util.Scanner;
import java.util.ArrayList;
public class Ejercicio10 {
    public static void main(String[] args) {
        ArrayList<String> DiasLaborales =  new ArrayList<>();
        DiasLaborales.add("lunes");
        DiasLaborales.add("martes");
        DiasLaborales.add("miercoles");
        DiasLaborales.add("jueves");
        DiasLaborales.add("viernes");

        Scanner sc = new Scanner(System.in);
        System.out.println("Que dia es hoy ");
        String dia = sc.nextLine();

        if(DiasLaborales.contains(dia.toLowerCase())){
            System.out.println(dia + " es dia de laburo");
        }
        else {
            System.out.println("Dia libre");
        }
    }
}
