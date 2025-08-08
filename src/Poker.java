import java.util.*;

public class Poker {
    public ArrayList<Carta> generarMazo(){
        Random rg = new Random();
        ArrayList<Carta> mazo = new ArrayList<>();
        String[] valores ={"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"};
        String[] tipos = {"S", "C", "D", "H"};
        while (mazo.size() < 5){
            int v =  rg.nextInt(valores.length);
            int t = rg.nextInt(tipos.length);
            Carta c = new Carta(valores[v], tipos[t]);

            if (!mazo.contains(c)){
                mazo.add(c);
            }

        }
        return mazo;
    }
    public void mostrarMazo(ArrayList<Carta> mazo){
        System.out.println("Mazo:");
        for (Carta c : mazo){
            System.out.print(c.toString() + " ");
        }
        System.out.println();
    }

    public String determinarJugada(ArrayList<Carta> mazo){
        Map<String,Integer> conteoValores = new HashMap<>();
        Set <String> tipos = new HashSet<>();

        for  (Carta c : mazo){
            conteoValores.put(c.getValor(),conteoValores.getOrDefault(c.getValor(),0)+1);
            tipos.add(c.getPalo());
        }
        if (esEscalera(mazo) && tipos.size() == 1){return "Escalera Color";}
        if (conteoValores.containsValue(4)){return "Poker"; }
        if (conteoValores.containsValue(3) && conteoValores.containsValue(2)){return "Full";}
        if (tipos.size() == 1){return "Color";}
        if (esEscalera(mazo)) {return "Escalera";}
        if (conteoValores.containsValue(3)){return "Trio";}
        if (conteoPares(conteoValores) == 2){return "Par Doble";}
        if (conteoPares(conteoValores) == 1){return "Par";}

        return  "CartaAlta";
    }

    private int conteoPares(Map<String, Integer> conteoValores){
        return (int)(conteoValores.values().stream().filter(v -> v == 2).count());
    }

    private boolean esEscalera(ArrayList<Carta> mazo){
        boolean escalera = true;
        int [] valores = new int[5];
        for (int i = 0; i < valores.length; i++){
            valores[i] = Integer.parseInt(mazo.get(i).getValor());
        }
        Arrays.sort(valores);
        for (int i = 0; i < valores.length - 1; i++){
            if (valores[i] + 1 != valores[ i + 1]){
                escalera = false;
                break;
            }
        }
        return escalera;
    }

}


