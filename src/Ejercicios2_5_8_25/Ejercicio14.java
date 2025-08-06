//Dada una cadena de caracteres (String) de longitud desconocida que tiene solamente dígitos,
//crear un array de N elementos (donde N es el tamaño de la cadena) que tenga cada uno de los
//valores numéricos de los dígitos


import java.util.Scanner;

public class Ejercicio14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una cadena de numeros");
        String cadena = sc.nextLine();
        cadena = cadena.replaceAll(" ", "");
        char [] numeros_char = cadena.toCharArray();
        int [] numeros = new int[numeros_char.length];

        System.out.println("La cadena es: " + cadena);
        for (int i = 0; i < numeros_char.length; i++){
            numeros[i] = numeros_char[i] - '0';
            System.out.print(numeros[i] + " ");
        }
    }
}
