
public class BicicletaMontanya extends Bicicleta {

    private static final double COSTO_BASE = 30000;
    private static final double RECARGO_MAS_DE_UNA_SUSPENSION = 0.15;

    private int cantidadSuspensiones;

    public BicicletaMontanya(String codigoBicicleta, int anioFabricacion, double peso,
                              int cantidadSuspensiones) {
        super(codigoBicicleta, anioFabricacion, peso);
        setCantidadSuspensiones(cantidadSuspensiones);
    }

    public int getCantidadSuspensiones() {
        return cantidadSuspensiones;
    }

    public void setCantidadSuspensiones(int cantidadSuspensiones) {
        if (cantidadSuspensiones < 0) {
            throw new IllegalArgumentException("La cantidad de suspensiones no puede ser negativa.");
        }
        this.cantidadSuspensiones = cantidadSuspensiones;
    }

    @Override
    public double calcularCostoMantencion() {
        double costo = COSTO_BASE;
        if (cantidadSuspensiones > 1) {
            costo += costo * RECARGO_MAS_DE_UNA_SUSPENSION;
        }
        return costo;
    }
}
