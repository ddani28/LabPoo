public class Barco extends Vehiculo {
    private String tipoCasco;
    private double tonelajeMaximo;
    private int numTripulantes;

    public Barco(String marca, String modelo, int anio, double velocidadMax,
                 String tipoCasco, double tonelajeMaximo, int numTripulantes) {
        super(marca, modelo, anio, velocidadMax);
        this.tipoCasco = tipoCasco;
        this.tonelajeMaximo = tonelajeMaximo;
        this.numTripulantes = numTripulantes;
    }

    public String getTipoCasco() {
        return tipoCasco;
    }

    public double getTonelajeMaximo() {
        return tonelajeMaximo;
    }

    public int getNumTripulantes() {
        return numTripulantes;
    }

    public void setTipoCasco(String tipoCasco) {
        if (tipoCasco != null && !tipoCasco.isEmpty()) {
            this.tipoCasco = tipoCasco;
        } else {
            System.out.println("Error: tipo de casco no válido.");
        }
    }

    public void setTonelajeMaximo(double tonelajeMaximo) {
        if (tonelajeMaximo > 0) {
            this.tonelajeMaximo = tonelajeMaximo;
        } else {
            System.out.println("Error: tonelaje máximo no válido.");
        }
    }

    public void setNumTripulantes(int numTripulantes) {
        if (numTripulantes >= 1) {
            this.numTripulantes = numTripulantes;
        } else {
            System.out.println("Error: número de tripulantes no válido.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nCasco: " + tipoCasco +
                " | Tonelaje Máx: " + tonelajeMaximo + " t | Tripulantes: " + numTripulantes;
    }
}