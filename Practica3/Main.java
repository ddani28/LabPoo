public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Transporte Multimodal ===\n");

        Automovil auto = new Automovil("Toyota", "Corolla", 2022, 180.0, 4, false);
        Avion avion = new Avion("Boeing", "737", 2019, 850.0, 2, 12500.0, "Aeroméxico");
        Barco barco = new Barco("Ferretti", "550", 2020, 45.0, "Fibra de vidrio", 30.5, 6);

        System.out.println("-- Automovil --");
        System.out.println(auto);
        System.out.println();

        auto.setAnio(1800);        
        auto.setNumPuertas(10);   
        System.out.println();

        auto.setAnio(2023);
        auto.setNumPuertas(4);
        System.out.println(auto);
        System.out.println();

        System.out.println("-- Avion --");
        System.out.println(avion);
        System.out.println();

        avion.setAltitudMaxima(-100); 
        System.out.println();

        System.out.println("-- Barco --");
        System.out.println(barco);
        System.out.println();

        barco.setTonelajeMaximo(-5); 
    }

}
/* Preguntas 

¿Cuál es la diferencia entre private y protected? ¿En qué situación usarías cada uno?
Private es un acceso muy controlado solo para la misma clase y protected permite el acceso a un paquete

¿Por qué marca y modelo no tienen setter? ¿Qué implica eso en el diseño?
marca y modelo no tienen setter porque son atributos que no deberían cambiar una vez que se crea el objeto

¿Qué pasaría si un setter no tuviera validación y alguien pusiera un año negativo?
errores en el funcionamiento del programa.

*/