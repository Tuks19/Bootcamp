import java.util.Arrays;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class Generala1 {
    public int [] generarDados(){
        int [] dados = new int [5];
        Random rg = new Random();
        for (int i = 0; i < 5; i++){
            int cara = rg.nextInt(1,7);
            dados[i] = cara;
        }
        return dados;
    }

    public void mostrarDados(int [] dados){
        System.out.println("Los dados han hablado:");
        for (int dado : dados) {
            System.out.print(dado + " ");

        }
        System.out.println();
    }

    public String identificarJugada(int [] dados){
        int igualdad = 0;
        int diferente = 0;

        HashSet<Integer> unicos = new HashSet<>();

        String resultado = "";
        boolean escalera = true;

        for (int i = 0; i < dados.length - 1; i++){
            if (dados[i] != dados[i + 1]){
                diferente ++;
            }
        }

        for (int dado : dados) {
            unicos.add(dado);
            if (dados[0] == dado) {
                igualdad++;
            }
        }
        if (igualdad == 5){resultado = "Generala";igualdad = 0;}
        else if (igualdad == 4 || diferente == 1){resultado = "Poker"; igualdad = 0;}
        if ((unicos.size() == 2) && !resultado.equals("Poker")){resultado = "Full";}
        boolean escaleraNormal = true;
        for (int i = 0; i < dados.length - 1; i++) {
            if (dados[i] + 1 != dados[i + 1]) {
                escaleraNormal = false;
                break;
            }
        }
        if (escaleraNormal) {
            return "Escalera";
        }
        if (dados[0] == 1 && dados[1] == 3 && dados[2] == 4 && dados[3] == 5 && dados[4] == 6) {
            return "Escalera";
        }
        if (resultado.isEmpty()){resultado = "Nada";}
        return resultado;
    }


}
