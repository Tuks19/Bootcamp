import java.util.Arrays;

public class FrutasyCanastos {
    public static int Solucion (int[] frutas, int [] canastos){
        boolean [] disponibilidades = new boolean [frutas.length];
        Arrays.fill(disponibilidades, true);
        int sinlugar = 0;
        for(int i = 0; i < frutas.length; i++){
            for(int j = 0; j < canastos.length; j++){
                if (frutas[i] <= canastos[j] && disponibilidades[j] ) {
                    disponibilidades[j] = false;
                    break;
                }
            }
        }
        for(int k = 0; k < disponibilidades.length; k++) {
            if (disponibilidades[k]) {
                sinlugar++;
            }
        }
        return sinlugar;
    }
    public static void  main(String[] args) {
        int [] frutas = {1,2,3,4};
        int [] canastos = {4,3,2,1};
        System.out.println(Solucion(frutas, canastos));
    }
}


