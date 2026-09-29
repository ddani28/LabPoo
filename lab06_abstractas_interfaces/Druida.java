public class Druida extends Personaje implements Hechicero, Sanador {

    private int mana;
    private int poderCuracion;
    private int fuerzaNaturaleza;

    public Druida(String nombre, int nivel, int puntosVida, int mana, int poderCuracion, int fuerzaNaturaleza) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.poderCuracion = poderCuracion;
        this.fuerzaNaturaleza = fuerzaNaturaleza;
    }

    @Override
    public void atacar() {
        System.out.println("[" + nombre + "] invoca raíces del bosque.");
    }

    @Override
    public int calcularDanio() {
        return mana + fuerzaNaturaleza;
    }

    @Override
    public void lanzarHechizo() {
        System.out.println(nombre + " lanza: ¡Tormenta de espinas! (maná: " + mana + ")");
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public void curarAliado(Personaje aliado) {
        aliado.puntosVida += poderCuracion;
        System.out.println(nombre + " toca la tierra y cura a " + aliado.getNombre()
                + " +" + poderCuracion + ". Vida: " + aliado.getPuntosVida());
    }

    @Override
    public int getPoderCuracion() {
        return poderCuracion;
    }

    public int getFuerzaNaturaleza() {
        return fuerzaNaturaleza;
    }
}
