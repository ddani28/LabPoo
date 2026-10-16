public class Main {
    public static void main(String[] args) {
        GestionGremio gremio = new GestionGremio();
        System.out.println("##### BLOQUE 1: ArrayList #####");
        gremio.agregarMiembro(new Druida("Sylva", 10, 300, 100, 40, 150));
        gremio.agregarMiembro(new Nigromante("Malachar", 8, 250, 120, 5));
        gremio.agregarMiembro(new Arquero("Legolas", 6, 150, "Arco", 20, 95));
        gremio.agregarMiembro(new Guerrero("Thorin", 9, 400, "Hacha", 80));
        gremio.mostrarRoster();

        gremio.eliminarMiembro("Malachar");
        gremio.mostrarRoster();

        Personaje encontrado = gremio.buscarPorNombre("Legolas");
        if (encontrado != null)
            System.out.println("Encontrado: " + encontrado.getNombre());

        System.out.println("\n##### BLOQUE 2: LinkedList #####");
        gremio.encolarSolicitante("Gandalf");
        gremio.encolarSolicitante("Aragorn");
        gremio.encolarSolicitante("Gimli");
        gremio.mostrarCola();

        gremio.atenderSiguiente();
        gremio.mostrarCola();

        System.out.println("\n##### BLOQUE 3: HashMap #####");
        gremio.agregarItem("Poción de vida", 5);
        gremio.agregarItem("Flecha élfica", 30);
        gremio.agregarItem("Poción de vida", 3);

        gremio.mostrarInventario();

        gremio.usarItem("Poción de vida");
        gremio.usarItem("Pergamino de fuego");
        gremio.mostrarInventario();

        System.out.println("\n##### BLOQUE 4: HashSet #####");
        gremio.registrarHabilidad("Curación");
        gremio.registrarHabilidad("Magia oscura");
        gremio.registrarHabilidad("Curación"); 

        gremio.mostrarHabilidades();

        System.out.println("¿Tiene tiro con arco? " + gremio.tieneHabilidad("Tiro con arco"));
        System.out.println("¿Tiene curación?      " + gremio.tieneHabilidad("Curación"));

        System.out.println("\n##### BLOQUE 5: RESUMEN #####");
        gremio.mostrarRoster();
        gremio.mostrarCola();
        gremio.mostrarInventario();
        gremio.mostrarHabilidades();
    }


/*
ArrayList vs LinkedList: 
    ArrayList es un arreglo dinámico con acceso O(1) por índice. Insertar o eliminar en medio es costoso. 
    LinkedList es una lista doblemente enlazada, así que insertar o eliminar en los extremos es barato, pero acceder por posición es O(n).
        Usaría ArrayList para el roster, porque se consulta mucho por posición y rara vez se elimina. 
        Usaría LinkedList para la cola de turnos, donde se agrega al final y se saca del frente constantemente.

Orden en HashMap:  
    Guarda sus entradas según el hash de la clave, no según cuándo se insertaron, por eso entrySet() 
        no respeta el orden de inserción. Si el orden importa, usaría LinkedHashMap (orden de inserción) o TreeMap
            (orden alfabético por clave).

HashSet vs ArrayList: 
    HashSet evita duplicados automáticamente,
         y add devuelve false si ya existía. Además, contains es O(1),
    mientras que en un ArrayList es O(n). 
        Lo que pierdes es el orden y el acceso por índice.
    
    
    */
}
