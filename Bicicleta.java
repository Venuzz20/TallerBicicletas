
public abstract class Bicicleta {

    private String codigoBicicleta;
    private int anioFabricacion;
    private double peso;

    public Bicicleta(String codigoBicicleta, int anioFabricacion, double peso) {
        setCodigoBicicleta(codigoBicicleta);
        setAnioFabricacion(anioFabricacion);
        setPeso(peso);
    }

    public String getCodigoBicicleta() {
        return codigoBicicleta;
    }

    public void setCodigoBicicleta(String codigoBicicleta) {
        if (codigoBicicleta == null || codigoBicicleta.trim().isEmpty()) {
            throw new IllegalArgumentException("El código de bicicleta no puede ser nulo ni vacío.");
        }
        this.codigoBicicleta = codigoBicicleta;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        if (anioFabricacion < 2000 || anioFabricacion > 2026) {
            throw new IllegalArgumentException("El año de fabricación debe encontrarse entre 2000 y 2026.");
        }
        this.anioFabricacion = anioFabricacion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser un valor mayor que cero.");
        }
        this.peso = peso;
    }

    public abstract double calcularCostoMantencion();

    @Override
    public String toString() {
        return "Código: " + codigoBicicleta + " | Año: " + anioFabricacion;
    }
}
