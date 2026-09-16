public class Main {
    public static void main(String[] args) {
        System.out.println("=== Batalla RPG ===\n");

        Guerrero thorin = new Guerrero("Thorin", 5, 200, 85, "Cota de Malla");
        Mago gandalf = new Mago("Gandalf", 8, 200, 120, "Fuego");
        Arquero legolas = new Arquero("Legolas", 6, 150, 95, 30);

        System.out.println("-- Ronda 1: Ataques --");
        thorin.atacar();
        System.out.println();
        gandalf.atacar();
        System.out.println();
        legolas.atacar();

        System.out.println("\n-- Ronda 2: Defensas --");
        thorin.defender();
        gandalf.defender();
        legolas.defender();

        System.out.println("\n-- Daño recibido --");
        thorin.recibirDanio(60);
        gandalf.recibirDanio(200);

        System.out.println("\n-- Estado final --");
        System.out.println(thorin);
        System.out.println(gandalf);
        System.out.println(legolas);
    }

    /* ¿Cuál es la diferencia entre extends e implements? ¿Cuándo usas cada uno?
        Uno ese utiliza para heredar de una clase y el otro implementa una interfaz y se usan cuando quieres pasar metodos de una clase
    
    ¿Qué ventaja tiene llamar super.atacar() dentro de Guerrero.atacar() en lugar de reescribir todo?
        super reutiliza el codigo del padre y no nececito crear otro ataque, solo lo cambio segun nececite

    Si declaras una variable Personaje p = new Guerrero(...) y llamas p.atacar(), ¿qué método se ejecuta, el de Personaje o el de Guerrero? ¿Por qué?
        se ejecuta guerrero por que tiene la implmentacion del metodo atacar

    Agrega la explicacion de conceptos y temas vistos en clase
        Interfaces: Una interfaz es un contrato que define un conjunto de métodos que una clase debe implementar.
        Super: La palabra clave super se utiliza para referirse a la clase base de una subclase.
            Se puede usar para invocar métodos o acceder a variables de la clase base, 
}
