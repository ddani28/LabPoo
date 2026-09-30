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

    /*
Cuál es la diferencia entre una excepción chequeada y una no chequeada? 
¿Por qué PersonajeNuloException extiende RuntimeException y no Exception?
    Las excepciones chequeadas deben ser manejadas explícitamente en el código
        mientras que las no chequeadas pueden ocurrir en tiempo de ejecución sin necesidad de un manejo explícito.
            El personaje nulo es una condición que puede ocurrir en tiempo de ejecución y no se puede prever con anticipación
                por lo que no necesita ser declarada en la firma del método.

¿Para qué sirve el bloque finally? Da un ejemplo real de cuándo es indispensable.
    Sirve para ejecutar un bloque de código que debe ejecutarse sin importar si se lanzó o no una excepción. 
        Un ejemplo sería cerrar una conexión a una base de datos donde si se hace mal ocasiona errores en los datos

¿Cuál es la diferencia entre throw y throws? Muestra un ejemplo de cada uno tomado de este laboratorio.
    throw se utiliza para lanzar una excepción específica en un punto del código
        throws se utiliza en la firma de un método para declarar que ese método puede lanzar una o más excepciones.
            Ejemplo de throw:
                throw new AccionInvalidaException("El personaje no puede recibir daño negativo.");
            Ejemplo de throws:
                public void curarAliado(Personaje aliado) throws RpgException {
                    // implementación
                } 

*/  
}

 