import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creacion de jugadores
        System.out.println("Jugador 1");
        System.out.println("¿Cuál es su nombre? ");
        String nombre1 = sc.nextLine();
        System.out.println("¿Cuál es su edad? ");
        int edad1 = sc.nextInt();
        sc.nextLine();

        System.out.println("Jugador 2");
        System.out.println("¿Cuál es su nombre? ");
        String nombre2 = sc.nextLine();
        System.out.println("¿Cuál es su edad? ");
        int edad2 = sc.nextInt();
        sc.nextLine();

        Persona jugador1 = new Persona(nombre1, edad1);
        Persona jugador2 = new Persona(nombre2, edad2);
        Nim juegoNuevo = new Nim(jugador1, jugador2);

        List<Stack<Integer>> pilas = juegoNuevo.generarPilas();

        Persona jugadorActual = jugador1;
        boolean juegoTerminado = false;

        while (!juegoTerminado) {
            juegoNuevo.mostrarPilas(pilas);

            System.out.println("Turno de " + jugadorActual.getNombre());
            System.out.println("¿Qué pila eliges (1, 2, 3)?");
            int eleccion = sc.nextInt() - 1;

            if (eleccion < 0 || eleccion >= pilas.size() || pilas.get(eleccion).isEmpty()) {
                System.out.println("Numero o pila invalido");
                continue;
            }

            System.out.println("¿Cuántos elementos desea eliminar?");
            int n = sc.nextInt();

            Stack<Integer> pilaSeleccionada = pilas.get(eleccion);
            if (n <= 0 || n > pilaSeleccionada.size()) {
                System.out.println("Cantidad inválida");
                continue;
            }

            juegoNuevo.turno(jugadorActual, pilaSeleccionada, n);

            if (pilaSeleccionada.isEmpty()) {
                pilas.remove(eleccion);
            }

            if (pilas.isEmpty()) {
                juegoTerminado = true;
            } else {
                jugadorActual = (jugadorActual == jugador1) ? jugador2 : jugador1;
            }
        }
        sc.close();
        Persona ganador = juegoNuevo.getRegistro().getLast();
        System.out.println(ganador.getNombre() + " ha ganado!");
    }
}