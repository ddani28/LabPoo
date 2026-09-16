public class Guerrero extends Personaje {

    private int fuerza;
    private String armadura;

    public Guerrero(String nombre, int nivel, int puntosVida, int fuerza, String armadura) {
        super(nombre, nivel, puntosVida);
        this.fuerza = fuerza;
        this.armadura = armadura;
    }

    public int getFuerza() {
        return fuerza;
    }

    public String getArmadura() {
        return armadura;
    }

    public int calcularDanio() {
        return fuerza * getNivel();
    }

    @Override
    public void atacar() {
        super.atacar();
        System.out.println("¡" + getNombre() + " golpea con su espada causando " + fuerza + " de daño!");
    }

    @Override
    public void defender() {
        System.out.println(getNombre() + " bloquea con su armadura de " + armadura + ".");
    }
      
    public void entrenar() {
        fuerza += 5;
        System.out.println(getNombre() + " entrena y sube su fuerza a " + fuerza + ".");
    }

      public void entrenar(int sesiones) {
        fuerza += 5 * sesiones;
        System.out.println(getNombre() + " entrena " + sesiones + " sesiones y sube su fuerza a " + fuerza + ".");
    }
 
    public void entrenar(int sesiones, boolean intensivo) {
        int incremento = 5 * sesiones * (intensivo ? 2 : 1);
        fuerza += incremento;
        System.out.println(getNombre() + " entrena " + sesiones + " sesiones "
                + (intensivo ? "de forma intensiva " : "") + "y sube su fuerza a " + fuerza + ".");
    }

    @Override
    public String toString() {
        return super.toString();
    }

    
}
