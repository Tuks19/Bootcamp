public class Carta {
    private final String palo;
    private final String valor;

    public Carta(String valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }

    //Setters y Getters
    public String getPalo() {
        return palo;
    }
    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        String valorMostrado = switch (valor) {
            case "11" -> "J";
            case "12" -> "Q";
            case "13" -> "K";
            case "14" -> "A";
            default -> valor;
        };

        String paloMostrado = switch (palo) {
            case "S" -> "♠";  // Picas
            case "C" -> "♣";  // Tréboles
            case "D" -> "♦";  // Diamantes
            case "H" -> "♥";  // Corazones
            default -> palo;
        };

        return String.format("%2s%s", valorMostrado, paloMostrado);
    }
}
