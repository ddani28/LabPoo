class Personaje {
    private String nombre;

    public Personaje(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int calcularDanio() {
        return 0;
    }

    public void atacar() {
        System.out.println(nombre + " ataca.");
    }

    public void mostrarEstado() {
        System.out.println("Estado de " + nombre + ": salud normal.");
    }

    public void mostrarEstado(boolean detalle) {
        if (detalle) {
            System.out.println("Estado de " + nombre + ": detalle activo.");
        } else {
            mostrarEstado();
        }
    }

    public void mostrarEstado(String prefijo) {
        System.out.println(prefijo + " " + nombre + " listo para la batalla.");
    }
}

class Guerrero extends Personaje {
    private int nivel;
    private int vida;
    private int fuerza;
    private String arma;

    public Guerrero(String nombre, int nivel, int vida, int fuerza, String arma) {
        super(nombre);
        this.nivel = nivel;
        this.vida = vida;
        this.fuerza = fuerza;
        this.arma = arma;
    }

    @Override
    public int calcularDanio() {
        return fuerza + nivel * 10;
    }

    @Override
    public void atacar() {
        System.out.println(getNombre() + " golpea con " + arma + " por " + calcularDanio() + " de daño.");
    }

    public void entrenar() {
        System.out.println(getNombre() + " entrena su fuerza.");
    }

    public void entrenar(int sesiones) {
        System.out.println(getNombre() + " entrena " + sesiones + " sesiones.");
    }

    public void entrenar(int sesiones, boolean conEquipo) {
        System.out.println(getNombre() + " entrena " + sesiones + " sesiones " + (conEquipo ? "en equipo" : "en solitario") + ".");
    }
}

class Mago extends Personaje {
    private int nivel;
    private int mana;
    private int poder;
    private String elemento;

    public Mago(String nombre, int nivel, int mana, int poder, String elemento) {
        super(nombre);
        this.nivel = nivel;
        this.mana = mana;
        this.poder = poder;
        this.elemento = elemento;
    }

    @Override
    public int calcularDanio() {
        return poder + nivel * 8 + mana / 10;
    }

    @Override
    public void atacar() {
        System.out.println(getNombre() + " lanza un hechizo de " + elemento + " por " + calcularDanio() + " de daño.");
    }
}

class Arquero extends Personaje {
    private int nivel;
    private int municion;
    private String arma;
    private int precision;

    public Arquero(String nombre, int nivel, int municion, String arma, int precision, int vida) {
        super(nombre);
        this.nivel = nivel;
        this.municion = municion;
        this.arma = arma;
        this.precision = precision;
    }

    @Override
    public int calcularDanio() {
        return precision + nivel * 7 + municion / 5;
    }

    @Override
    public void atacar() {
        System.out.println(getNombre() + " dispara con " + arma + " por " + calcularDanio() + " de daño.");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG — Demostración de Polimorfismo ===\n");

        Personaje p1 = new Guerrero("Thorin", 5, 200, 85, "Cota de Malla");
        Personaje p2 = new Mago("Gandalf", 8, 120, 150, "Fuego");
        Personaje p3 = new Arquero("Legolas", 6, 150, "Arco Largo", 30, 95);

        System.out.println("-- calcularDanio() por tipo --");
        System.out.println(p1.getNombre() + "  (" + p1.getClass().getSimpleName() + ") daño: " + p1.calcularDanio());
        System.out.println(p2.getNombre() + " (" + p2.getClass().getSimpleName() + ")     daño: " + p2.calcularDanio());
        System.out.println(p3.getNombre() + " (" + p3.getClass().getSimpleName() + ")  daño: N/A");

        Personaje[] equipo = { p1, p2, p3 };

        System.out.println("\n-- Arreglo polimórfico --");
        for (Personaje p : equipo) {
            p.atacar();
        }
        GestorBatalla gestor = new GestorBatalla();

        System.out.println("\n-- GestorBatalla --");
        gestor.ejecutarAtaque(p1);
        gestor.ejecutarAtaque(p2, p3);
        gestor.ejecutarAtaque(equipo);

        System.out.println("\n-- Historial --");
        gestor.mostrarHistorial();

        System.out.println("\n-- instanceof --");
        for (Personaje p : equipo) {
            if (p instanceof Guerrero) {
                System.out.println(p.getNombre() + " es un Guerrero.");
            } else if (p instanceof Mago) {
                System.out.println(p.getNombre() + " es un Mago.");
            } else if (p instanceof Arquero) {
                System.out.println(p.getNombre() + " es un Arquero.");
            }
        }

        System.out.println("\n-- Sobrecarga: mostrarEstado() --");
        p1.mostrarEstado();
        p1.mostrarEstado(true);
        p1.mostrarEstado("[ESTADO]");

        System.out.println("\n-- Sobrecarga: entrenar() en Guerrero --");
        Guerrero thorin = (Guerrero) p1;
        thorin.entrenar();
        thorin.entrenar(3);
        thorin.entrenar(2, true);
    }
}

class GestorBatalla {
    private java.util.ArrayList<String> historial = new java.util.ArrayList<>();

    public void ejecutarAtaque(Personaje atacante) {
        String mensaje = atacante.getNombre() + " ataca solo con su habilidad básica.";
        historial.add(mensaje);
        System.out.println(mensaje);
    }

    public void ejecutarAtaque(Personaje atacante, Personaje defensor) {
        String mensaje = atacante.getNombre() + " ataca a " + defensor.getNombre() + " por " + atacante.calcularDanio() + " de daño.";
        historial.add(mensaje);
        System.out.println(mensaje);
    }

    public void ejecutarAtaque(Personaje[] equipo) {
        StringBuilder sb = new StringBuilder();
        sb.append("Equipo atacando: ");
        for (int i = 0; i < equipo.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(equipo[i].getNombre());
        }
        String mensaje = sb.toString();
        historial.add(mensaje);
        System.out.println(mensaje);
    }

    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("No hay ataques registrados.");
            return;
        }

        for (String evento : historial) {
            System.out.println(evento);
        }
    }
}
