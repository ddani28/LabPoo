public class Arquero extends Personaje {

    private String arma;
    private int flechasDisponibles;
    private int precision;

    public Arquero(String nombre, int nivel, int puntosVida,
                   String arma, int flechasDisponibles, int precision) {
        super(nombre, nivel, puntosVida);
        this.arma = arma;
        this.flechasDisponibles = flechasDisponibles;
        this.precision = precision;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) {
            try {
                throw new PersonajeDerrotadoException(getNombre());
            } catch (PersonajeDerrotadoException ex) {
                System.getLogger(Arquero.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        if (flechasDisponibles <= 0) {
            try {
                throw new RecursoInsuficienteException("flechas", flechasDisponibles);
            } catch (RecursoInsuficienteException ex) {
                System.getLogger(Arquero.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        flechasDisponibles--;
        System.out.println("[" + getNombre() + "] dispara una flecha. " +
                           "Flechas restantes: " + flechasDisponibles);
    }

    @Override
    public int calcularDanio() {
        return precision + (nivel * 10);
    }

    public String getArma() {
        return arma;
    }

    public int getFlechasDisponibles() {
        return flechasDisponibles;
    }

    public int getPrecision() {
        return precision;
    }
}
