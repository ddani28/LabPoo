public class Main 
{
    public static void main(String[] args) 
    {
        Perro perro = new Perro("Rufo", 3, 12.5, "Labrador", true);
        System.out.println("-- Perro --");
        System.out.println(perro);
        perro.comer();
        perro.ladrar();
        perro.buscarPelota();
        System.out.println();

        Gato gato = new Gato("Fika", 2, 3.8, "naranja", true);
        System.out.println("-- Gato --");
        System.out.println(gato);
        gato.dormir();
        gato.maullar();
        gato.ronronear();
        System.out.println();

        Canario canario = new Canario("Pajaro Loco", 1, 0.03, "Azul", true);
        System.out.println("-Pajaro Loco--");
        System.out.println(canario);
        canario.comer();
        canario.cantar();
        canario.volar();
    }
}

class Animal 
{
    String nombre;
    int edad;
    double peso;

    public Animal(String nombre, int edad, double peso) 
    {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
    }

    public void comer() 
    {
        System.out.println(nombre + " esta comiendo.");
    }

    public void dormir() 
    {
        System.out.println(nombre + " se fue a dormir");
    }

    public String toString() 
    {
        return "Nombre: " + nombre + " | Edad: " + edad + " años | Peso: " + peso + " kg";
    }
}

class Perro extends Animal 
{
    String raza;
    boolean estaVacunado;

    public Perro(String nombre, int edad, double peso, String raza, boolean estaVacunado) 
    {
        super(nombre, edad, peso);
        this.raza = raza;
        this.estaVacunado = estaVacunado;
    }

    public void ladrar() 
    {
        System.out.println(nombre + " guaw guaw guaw");
    }

    public void buscarPelota() 
    {
        System.out.println(nombre + " se perdio buscando la pelota");
    }

    @Override
    public String toString() 
    {
        String vacunado = estaVacunado ? "Sí" : "No";
        return super.toString() + " | Raza: " + raza + " | Vacunado: " + vacunado;
    }
}

class Gato extends Animal 
{
    String color;
    boolean esInterior;

    public Gato(String nombre, int edad, double peso, String color, boolean esInterior) 
    {
        super(nombre, edad, peso);
        this.color = color;
        this.esInterior = esInterior;
    }

    public void maullar() 
    {
        System.out.println(nombre + " miau miau");
    }

    public void ronronear() 
    {
        System.out.println(nombre + " ronronea");
    }

    @Override
    public String toString() 
    {
        String interior = esInterior ? "Sí" : "No";
        return super.toString() + " | Color: " + color + " | Interior: " + interior;
    }
}

class Canario extends Animal 
{
    String colorPlumaje;
    boolean cantaEnJaula;

    public Canario(String nombre, int edad, double peso, String colorPlumaje, boolean cantaEnJaula) 
    {
        super(nombre, edad, peso);
        this.colorPlumaje = colorPlumaje;
        this.cantaEnJaula = cantaEnJaula;
    }

    public void cantar() 
    {
        System.out.println(nombre + " canta");
    }

    public void volar() 
    {
        System.out.println(nombre + " vuela");
    }

    @Override
    public String toString() 
    {
        String canta = cantaEnJaula ? "Sí" : "No";
        return super.toString() + " | Plumaje: " + colorPlumaje + " | Canta en jaula: " + canta;
    }
}

/*
1.- ¿Por qué declaramos los atributos como private y no como public?
Por que si ponemos todo como public cualquiera puede acceder y hacer modificaciones, mejor 
ponemos privado y evitamos modificaciones malas.

2.- Qué pasaría si quitaras el super() del constructor de Perro?
En Animal hay un constructor que con 3 parámetros
Al no existir un constructor vacío en Animal, Java arroja error.

3.- ¿Qué ventaja tiene sobreescribir toString() en lugar de crear un método con otro nombre?
Si pones System.out.println(perro) llama en automático a ese método. Ahorras codigo

*/

