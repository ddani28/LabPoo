public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG — Sistema con Manejo de Excepciones ===");

        MotorCombate motor = new MotorCombate();

        Druida druida = new Druida("Sylva", 8, 300, 100, 40, 150);
        Druida druida2 = new Druida("Ronan", 5, 250, 80, 30, 100);
        Nigromante nigromante = new Nigromante("Malachar", 10, 200, 60, 5);
        Arquero sinFlechas = new Arquero("Legolas", 6, 150, "Arco Largo", 0, 95);

        motor.ejecutarTurno(druida, nigromante);

        try {
            druida.recibirDanio(9999);
        } catch (AccionInvalidaException e) {
            System.out.println(e.getMessage());
        }
        motor.ejecutarTurno(druida, nigromante);

        motor.ejecutarTurno(sinFlechas, nigromante);

        System.out.println("\n-- Intento de curar aliado derrotado --");
        try {
            druida2.curarAliado(druida);
        } catch (RpgException e) {
            System.out.println("No se pudo curar: " + e.getMessage());
        }

        System.out.println("\n-- Bloque manual try-catch-finally --");
        try {
            nigromante.recibirDanio(-50);
        } catch (AccionInvalidaException e) {
            System.out.println("Capturado: " + e.getMessage());
        } finally {
            System.out.println("El bloque finally siempre se ejecuta.");
        }

        motor.mostrarBitacora();
    }
}
