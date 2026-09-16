public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG — Demostración de Polimorfismo ===\n");

        Personaje p1 = new Guerrero("Thorin", 5, 200, 85, "Cota de Malla");
        Personaje p2 = new Mago("Gandalf", 8, 120, 150, "Fuego");
        Personaje p3 = new Arquero("Legolas", 6, 150, "Arco Largo", 30, 95);

        System.out.println("-- calcularDanio() por tipo --");
        System.out.println(p1.getNombre() + "  (" + p1.getClass().getSimpleName() + ") daño: " + p1.calcularDanio());
        System.out.println(p2.getNombre() + " (" + p2.getClass().getSimpleName() + ")     daño: " + p2.calcularDanio());
        System.out.println(p3.getNombre() + " (" + p3.getClass().getSimpleName() + ")  daño: " + p3.calcularDanio());

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
    private java.util.List<String> historial = new java.util.ArrayList<>();

    public void ejecutarAtaque(Personaje atacante) {
        historial.add(atacante.getNombre() + " ataca.");
    }

    public void ejecutarAtaque(Personaje atacante, Personaje objetivo) {
        historial.add(atacante.getNombre() + " ataca a " + objetivo.getNombre() + ".");
    }

    public void ejecutarAtaque(Personaje[] equipo) {
        for (Personaje p : equipo) {
            historial.add(p.getNombre() + " forma parte del equipo.");
        }
    }

    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("Sin ataques registrados.");
            return;
        }

        for (String evento : historial) {
            System.out.println(evento);
        }
    }
}