public class Reloj {
    private int horas;
    private int minutos;
    private int segundos;

    public Reloj() {
        this.horas = 12;
        this.minutos = 0;
        this.segundos = 0;
    }

    public Reloj(int Horas, int Minutos, int Segundos) {
        if (Horas < 24 && Minutos < 60 && Segundos < 60) {
            this.horas = Math.abs(Horas);
            this.minutos = Math.abs(Minutos);
            this.segundos = Math.abs(Segundos);
        } else {
            throw new IllegalArgumentException("Valores Invalidos");
        }
    }

    public Reloj(int Segundos) {
        if (Segundos <= 86400 && Segundos >= 0) {
            setHoras((int) (Segundos / 3600));
            setMinutos((int) ((Segundos % 3600) / 60));
            setSegundos((int) ((Segundos % 3600) % 60));
        } else {
            throw new IllegalArgumentException("Solo valores menores a 86000");
        }
    }

    // Setters y Getters
    public void setReloj(int Segundos) {
        if (Segundos < 86400 && Segundos > 0) {
            setHoras((int) (Segundos / 3600));
            setMinutos((int) ((Segundos % 3600) / 60));
            setSegundos((int) ((Segundos % 3600) % 60));
        }
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int Horas) {
        validartiempo(Horas, "horas");
        this.horas = Horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int Minutos) {
        validartiempo(Minutos, "minutos");
        this.minutos = Minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int Segundos) {
        validartiempo(Segundos, "segundos");
        this.segundos = Segundos;
    }

    // Metodos

    public void tick() {
        segundos++;
        if (segundos >= 60) {
            setSegundos(0);
            setMinutos(getMinutos() + 1);
            if (minutos >= 60) {
                setMinutos(0);
                setHoras(getHoras() + 1);
                if (horas >= 24) {
                    setHoras(0);
                }
            }
        }
    }

    public void addReloj(Reloj reloj) {
        this.horas += reloj.getHoras();
        this.minutos += reloj.getMinutos();
        this.segundos += reloj.getSegundos();

        this.minutos += this.segundos / 60;
        this.segundos = this.segundos % 60;
        this.horas += this.minutos / 60;
        this.minutos = this.minutos % 60;
        this.horas = this.horas % 24;
    }

    public void restaReloj(Reloj reloj) {
        System.out.println("La diferencia entre los relojs es de " + Math.abs(this.horas - reloj.getHoras()) + ":"
                + Math.abs(this.minutos - reloj.getMinutos()) + ":" + Math.abs(this.segundos - reloj.getSegundos()));
    }

    private void validartiempo(int valor, String tipo) {
        boolean invalido = false;

        switch (tipo) {
            case "horas":
                invalido = (valor < 0 || valor > 24);
                break;

            case "minutos", "segundos":
                invalido = (valor < 0 || valor > 60);
                break;

            default:
                throw new IllegalArgumentException("Tipo de tiempo invalido");
        }
        if (invalido) {
            throw new IllegalArgumentException(String.format("Valor %d no valido para %s", valor, tipo));
        }
    }

    @Override
    public String toString() {
        return String.format("[%02d:%02d:%02d]", horas, minutos, segundos);
    }

    public static void main(String[] args) {
        Reloj reloj = new Reloj(900000);
        System.out.println(reloj.toString());
    }
}
