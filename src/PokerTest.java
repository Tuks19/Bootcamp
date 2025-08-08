import java.util.ArrayList;

public class PokerTest {
    public static void main(String[] args) {
        Poker juego1 = new Poker();
        ArrayList<Carta> mazo = juego1.generarMazo();
        juego1.mostrarMazo(mazo);
        System.out.println("Has obtenido:"+juego1.determinarJugada(mazo));
    }
}
