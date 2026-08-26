public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Transporte Multimodal ===\n");

        Automovil auto = new Automovil("Toyota", "Corolla", 2022, 180.0, 4, false);
        Avion avion = new Avion("Boeing", "737", 2019, 850.0, 2, 12500.0, "Aeroméxico");
        Barco barco = new Barco("Ferretti", "550", 2020, 45.0, "Fibra de vidrio", 30.5, 6);

        System.out.println("-- Automovil --");
        System.out.println(auto);
        System.out.println();

        auto.setAnio(1800);        // debe mostrar mensaje de error
        auto.setNumPuertas(10);    // debe mostrar mensaje de error
        System.out.println();

        auto.setAnio(2023);
        auto.setNumPuertas(4);
        System.out.println(auto);
        System.out.println();

        System.out.println("-- Avion --");
        System.out.println(avion);
        System.out.println();

        avion.setAltitudMaxima(-100); // debe mostrar mensaje de error
        System.out.println();

        System.out.println("-- Barco --");
        System.out.println(barco);
        System.out.println();

        barco.setTonelajeMaximo(-5); // debe mostrar mensaje de error
    }
}