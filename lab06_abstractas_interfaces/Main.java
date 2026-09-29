public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG — Expansión: Nuevas Clases ===\n");

        System.out.println("-- Error esperado (línea comentada) --");
        System.out.println("// new Personaje(...) → cannot instantiate abstract class");

        Druida sylva = new Druida("Sylva", 7, 200, 180, 120, 60);
        Nigromante malachar = new Nigromante("Malachar", 6, 350, 220, 10);
        Bardo finnian = new Bardo("Finnian", 5, 150, 60, 25, "Laúd");

        Personaje[] equipo = { sylva, malachar, finnian };

        System.out.println("\n-- Ataques y daño --");
        for (Personaje p : equipo) {
            p.atacar();
            System.out.println("Daño: " + p.calcularDanio());
        }

        System.out.println("\n-- Solo los Hechiceros lanzan hechizos --");
        for (Personaje p : equipo) {
            if (p instanceof Hechicero h) {
                h.lanzarHechizo();
            }
        }

        System.out.println("\n-- Solo los Sanadores curan --");
        malachar.recibirDanio(300);
        for (Personaje p : equipo) {
            if (p instanceof Sanador s) {
                s.curarAliado(malachar);
            }
        }

        System.out.println("\n-- Estado final --");
        for (Personaje p : equipo) {
            System.out.println(p);
        }
    }


    /*
    ¿Por qué Personaje debe ser abstracta y no concreta? ¿Qué problema resuelve?
        Es abstracta porque no se puede instanciar un personaje genérico, ,cada uno es especifico

    ¿Qué ventaja tiene que Druida implemente dos interfaces? ¿Podría extender dos clases en lugar de implementar dos interfaces?
        no hay herencia multiple pero podemos simularla con las interfaces, asi que puede tener comportamientos de dos tipos de personajes
    Si agregas un nuevo personaje Paladín que cura y combate físicamente, ¿qué clase extiende y qué interfaces implementa? ¿Tienes que modificar algo en las clases existentes?
        Extenderia de Personaje y implementaria la interfaz Sanador, no hay que modificar nada
    */
}
