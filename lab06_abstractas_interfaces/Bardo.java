public class Bardo extends Personaje implements Sanador {

    private int poderCuracion;
    private int carisma;
    private String instrumento;

    public Bardo(String nombre, int nivel, int puntosVida, int poderCuracion, int carisma, String instrumento) {
        super(nombre, nivel, puntosVida);
        this.poderCuracion = poderCuracion;
        this.carisma = carisma;
        this.instrumento = instrumento;
    }

    @Override
    public void atacar() {
        System.out.println("[" + nombre + "] aturde con su " + instrumento.toLowerCase() + ".");
    }

    @Override
    public int calcularDanio() {
        return carisma + (nivel * 12);
    }

    @Override
    public void curarAliado(Personaje aliado) {
        aliado.puntosVida += poderCuracion;
        System.out.println(nombre + " entona una melodía y cura a " + aliado.getNombre()
                + " +" + poderCuracion + ". Vida: " + aliado.getPuntosVida());
    }

    @Override
    public int getPoderCuracion() {
        return poderCuracion;
    }

    public int getCarisma() {
        return carisma;
    }

    public String getInstrumento() {
        return instrumento;
    }
}
