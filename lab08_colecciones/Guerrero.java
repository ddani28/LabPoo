public class Guerrero extends Personaje {

    private String arma;
    private int fuerza;

    public Guerrero(String nombre, int nivel, int puntosVida, String arma, int fuerza) {
        super(nombre, nivel, puntosVida);
        this.arma = arma;
        this.fuerza = fuerza;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }
        System.out.println("[" + getNombre() + "] ataca con su " + arma.toLowerCase() +
                           " y causa " + calcularDanio() + " de daño.");
    }

    @Override
    public int calcularDanio() {
        return fuerza + (nivel * 15);
    }

    public String getArma() {
        return arma;
    }

    public int getFuerza() {
        return fuerza;
    }
}
