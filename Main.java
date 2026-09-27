import java.util.List;

public class Main {

    public static void main(String[] args) {
        GestorTallerBicicletas gestor = new GestorTallerBicicletas();

        BicicletaElectrica bicE01 = new BicicletaElectrica("BIC-E01", 2023, 22.5, 60, false);
        BicicletaElectrica bicE02 = new BicicletaElectrica("BIC-E02", 2022, 24.0, 45, true);
        BicicletaMontanya bicM01 = new BicicletaMontanya("BIC-M01", 2021, 13.5, 2);
        BicicletaMontanya bicM02 = new BicicletaMontanya("BIC-M02", 2020, 12.0, 1);


        bicE01.activarGarantiaExtendida();

        gestor.registrarBicicleta(bicE01);
        gestor.registrarBicicleta(bicE02);
        gestor.registrarBicicleta(bicM01);
        gestor.registrarBicicleta(bicM02);

        System.out.println();
        String codigoBuscado = "BIC-E01";
        System.out.println("=== BUSQUEDA POR CODIGO: \"" + codigoBuscado + "\" ===");
        List<Bicicleta> encontradas = gestor.buscarPorCodigo(codigoBuscado);
        for (Bicicleta bicicleta : encontradas) {
            mostrarDetalle(bicicleta);
            System.out.println("---");
        }

        System.out.println();
        System.out.println("=== LISTADO DE BICICLETAS ===");
        for (Bicicleta bicicleta : gestor.getBicicletas()) {
            System.out.println(bicicleta.toString());
        }
    }


    private static void mostrarDetalle(Bicicleta bicicleta) {
        StringBuilder detalle = new StringBuilder();

        if (bicicleta instanceof BicicletaElectrica) {
            BicicletaElectrica be = (BicicletaElectrica) bicicleta;
            detalle.append("Tipo: Bicicleta Eléctrica | ");
            detalle.append("Código: ").append(be.getCodigoBicicleta()).append(" | ");
            detalle.append("Año: ").append(be.getAnioFabricacion()).append(" | ");
            detalle.append("Peso: ").append(be.getPeso()).append(" kg | ");
            detalle.append("Autonomia: ").append((int) be.getAutonomiaKm()).append(" km | ");
            detalle.append("Batería certificada: ").append(be.isBateriaCertificada() ? "Si" : "No").append(" | ");
            detalle.append("Garantia extendida: ").append(be.tieneGarantiaExtendida() ? "Si" : "No").append(" | ");
            detalle.append("Costo mantención: $").append((int) be.calcularCostoMantencion());
        } else if (bicicleta instanceof BicicletaMontanya) {
            BicicletaMontanya bm = (BicicletaMontanya) bicicleta;
            detalle.append("Tipo: Bicicleta de Montaña | ");
            detalle.append("Código: ").append(bm.getCodigoBicicleta()).append(" | ");
            detalle.append("Año: ").append(bm.getAnioFabricacion()).append(" | ");
            detalle.append("Peso: ").append(bm.getPeso()).append(" kg | ");
            detalle.append("Suspensiones: ").append(bm.getCantidadSuspensiones()).append(" | ");
            detalle.append("Costo mantención: $").append((int) bm.calcularCostoMantencion());
        }

        System.out.println(detalle.toString());
    }
}
