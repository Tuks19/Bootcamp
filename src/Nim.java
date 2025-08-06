import java.util.*;

public class Nim {
    private Persona jugador1;
    private Persona jugador2;
    private List<Persona> registro = new ArrayList<>();

    public Nim(Persona jugador1, Persona jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    // Getters y setters
    public Persona getJugador1() { return jugador1; }
    public Persona getJugador2() { return jugador2; }
    public List<Persona> getRegistro() { return registro; }


    public List<Stack<Integer>> generarPilas() {
        Random aleatorio = new Random();
        int n = aleatorio.nextInt(1,15);
        Stack<Integer> pila1 = new Stack<>();
        Stack<Integer> pila2 = new Stack<>();
        Stack<Integer> pila3 = new Stack<>();

        for (int i = 0; i < n; i++) {
            pila1.add(1);
            pila2.add(1);
            pila3.add(1);
        }

        List<Stack<Integer>> pilas = new ArrayList<>();
        pilas.add(pila1);
        pilas.add(pila2);
        pilas.add(pila3);
        System.out.println("Las pilas tienen " + n + " elementos cada una");
        return pilas;
    }

    public void mostrarPilas(List<Stack<Integer>> pilas) {
        for (int i = 0; i < pilas.size(); i++) {
            System.out.println("Pila " + (i + 1) + ": " + pilas.get(i).size() + " elementos");
        }
    }

    public void turno(Persona jugador, Stack<Integer> pila, int n) {
        for (int i = 0; i < n; i++) {
            if (!pila.isEmpty()) {
                pila.pop();
            }
        }
        registro.add(jugador);
    }


}