public class Main {

    // Crea 5 hilos que ejecutan la misma tarea, los inicia y espera con join()
    private static void correrCincoHilos(Runnable tarea) {
        Thread[] hilos = new Thread[5];
        for (int i = 0; i < 5; i++) {
            hilos[i] = new Thread(tarea);
            hilos[i].start();
        }
        try {
            for (Thread t : hilos) {
                t.join();
            }
        } catch (InterruptedException e) {
            System.out.println("Espera interrumpida.");
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Gran Torneo del Gremio ===\n");

        // ── Bloque 1: torneo con 3 combates simultáneos ──
        TablaResultados tabla = new TablaResultados();

        Personaje s1 = new Druida("Sylva", 10, 300, 100, 40, 150);
        Personaje m1 = new Nigromante("Malachar", 8, 150, 120, 5);
        Personaje l1 = new Arquero("Legolas", 6, 200, "Arco", 10, 95);
        Personaje t1 = new Guerrero("Thorin", 9, 400, "Hacha", 80);
        Personaje b1 = new Druida("Brego", 7, 250, 80, 30, 100);
        Personaje k1 = new Nigromante("Kael", 5, 180, 90, 4);

        CombateConcurrente c1 = new CombateConcurrente("Campo-1", s1, m1, tabla);
        CombateConcurrente c2 = new CombateConcurrente("Campo-2", l1, t1, tabla);
        CombateConcurrente c3 = new CombateConcurrente("Campo-3", b1, k1, tabla);

        Thread h1 = new Thread(c1);
        Thread h2 = new Thread(c2);
        Thread h3 = new Thread(c3);

        h1.start();
        h2.start();
        h3.start();

        // ── Bloque 2: monitor del torneo (hilo independiente) ──
        MonitorTorneo monitor = new MonitorTorneo("Torneo Principal", 3);
        monitor.start();

        // ── Bloque 3: esperar a que todos terminen con join() ──
        try {
            h1.join();
            h2.join();
            h3.join();
            monitor.join();
        } catch (InterruptedException e) {
            System.out.println("Espera interrumpida.");
            Thread.currentThread().interrupt();
        }

        System.out.println("\nTodos los combates han terminado.");
        tabla.mostrarResultados();

        // ── Bloque 4: demostración de race condition ──
        System.out.println("\n=== Race condition ===");
        ContadorCompartido contador = new ContadorCompartido();

        // Sin synchronized — resultado incorrecto
        correrCincoHilos(() -> {
            for (int j = 0; j < 1000; j++) contador.incrementar();
        });
        System.out.println("Sin sync  — esperado: 5000 | real: " +
                           contador.getContador());

        // Con synchronized — resultado correcto
        contador.resetear();
        correrCincoHilos(() -> {
            for (int j = 0; j < 1000; j++) contador.incrementarSeguro();
        });
        System.out.println("Con sync  — esperado: 5000 | real: " +
                           contador.getContador());
    }
}
