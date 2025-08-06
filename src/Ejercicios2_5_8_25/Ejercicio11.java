//Cargar un array de manera aleatoria con 10 números enteros del -5 al 5. Imprimirlo en
//pantalla y computar cuál es el mayor elemento del vector.

import java.util.Arrays;
import java.util.random.RandomGenerator;
import java.util.Random;
public class Ejercicio11 {
    public static void main(String[] args) {
        RandomGenerator rg = new Random();
        int [] numeros = new int [10];
        for (int i=0;i<numeros.length;i++){
            numeros[i] = rg.nextInt(-6,6);
        }
        System.out.println(Arrays.stream(numeros).max().getAsInt() + " Es el mayor elemento del vector");


    }
}
