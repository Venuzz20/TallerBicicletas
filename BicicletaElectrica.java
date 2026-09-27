
public class BicicletaElectrica extends Bicicleta implements ConGarantiaExtendida {

    private static final double COSTO_BASE = 45000;
    private static final double RECARGO_BATERIA_NO_CERTIFICADA = 0.25;

    private double autonomiaKm;
    private boolean bateriaCertificada;
    private boolean garantiaExtendidaActiva;

    public BicicletaElectrica(String codigoBicicleta, int anioFabricacion, double peso,
                               double autonomiaKm, boolean bateriaCertificada) {
        super(codigoBicicleta, anioFabricacion, peso);
        setAutonomiaKm(autonomiaKm);
        setBateriaCertificada(bateriaCertificada);
        this.garantiaExtendidaActiva = false;
    }

    public double getAutonomiaKm() {
        return autonomiaKm;
    }

    public void setAutonomiaKm(double autonomiaKm) {
        if (autonomiaKm <= 0) {
            throw new IllegalArgumentException("La autonomía debe ser un valor mayor que cero.");
        }
        this.autonomiaKm = autonomiaKm;
    }

    public boolean isBateriaCertificada() {
        return bateriaCertificada;
    }

    public void setBateriaCertificada(boolean bateriaCertificada) {
        this.bateriaCertificada = bateriaCertificada;
    }

    @Override
    public boolean tieneGarantiaExtendida() {
        return garantiaExtendidaActiva;
    }

    @Override
    public void activarGarantiaExtendida() {
        this.garantiaExtendidaActiva = true;
    }

    @Override
    public double calcularCostoMantencion() {
        double costo = COSTO_BASE;
        if (!bateriaCertificada) {
            costo += costo * RECARGO_BATERIA_NO_CERTIFICADA;
        }
        return costo;
    }
}
