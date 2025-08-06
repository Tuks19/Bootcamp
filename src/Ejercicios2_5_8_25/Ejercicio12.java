//Cargar un array de manera aleatoria con 100 números enteros del -30 al 30. Imprimirlo en
//pantalla y computar cuál es el elemento que más veces se repite, y cuáles son los números
//que no están presentes (si es que hay alguno).

import java.util.*;
import java.util.random.RandomGenerator;

public class Ejercicio12 {

    static void  ImprimirVector(Integer[] Vector){
        for (Integer integer : Vector) {
            System.out.print(integer + " ");
        }
    }

    public static void main(String[] args) {
        RandomGenerator rg = new Random();
        Integer [] numeros = new Integer[100];
        List<Integer> Ausentes = new ArrayList();

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = rg.nextInt(-31,30);
        }
        Set <Integer> numerossinrepetir = new TreeSet<>(Arrays.asList(numeros));

        for  (int i = -30; i <= 30; i++) {
            if (!Arrays.asList(numeros).contains(i)){
                Ausentes.add(i);
            }
        }

        int[] contador = new int[numerossinrepetir.size()];
        Arrays.fill(contador,0);
        int indice_mayor = 0;

        for(int j = 0; j < contador.length; j++) {
            for (Integer numero : numeros) {
                if (numerossinrepetir.contains(numero)) {
                    contador[j]++;
                }
            }
            if (contador[j] > contador[indice_mayor]) {
                indice_mayor = j ;
            }
        }
        ImprimirVector(numeros);
        System.out.println("Los elementos faltantes son " + Ausentes);
        System.out.println("El elemento que mas se repite es " + numerossinrepetir.toArray()[indice_mayor]);
    }
}
