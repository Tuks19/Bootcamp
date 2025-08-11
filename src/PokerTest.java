import java.util.ArrayList;

public class PokerTest {
    public static void main(String[] args) {
        Poker juego1 = new Poker();
        ArrayList<Carta> mazo1 = juego1.generarMazo();
        juego1.mostrarMazo(mazo1);
        ArrayList<Carta> mazo2 = juego1.generarMazo();
        juego1.mostrarMazo(mazo2);

        System.out.println(juego1.determinarGanador(mazo1, mazo2));
    }
}
