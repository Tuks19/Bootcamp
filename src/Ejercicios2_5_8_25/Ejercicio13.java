//Hacer una función que, dada una palabra (String) o frase, diga si la misma es palíndrome o
//no. Una palabra/frase palíndrome es aquella que se lee igual tanto de atrás para adelante,
//como de adelante para atrás. Ejemplos de palíndromes: "MADAM", "RACECAR", "AMORE,
//ROMA", "BORROW OR ROB", "WAS IT A CAR OR A CAT I SAW?".

import java.util.Scanner;
import java.util.Arrays;

public class Ejercicio13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una palabra/oracion:");
        String palindrome = sc.nextLine();
        String palindrome2 = palindrome.replaceAll(" ", "").toLowerCase();
        char [] caracteres = palindrome2.toCharArray();
        char [] alreves = new char[palindrome2.length()];

        for  (int i = 0, j = palindrome2.length() - 1; i < palindrome2.length(); i++, j--) {
            alreves[j] = caracteres[i];
        }
        if (Arrays.equals(caracteres, alreves)){
            System.out.println(palindrome + " es un palindrome");
        }
        else {
            System.out.println(palindrome + " no es un palindrome");
        }
    }
}
