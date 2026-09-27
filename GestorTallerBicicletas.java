import java.util.ArrayList;
import java.util.List;

public class GestorTallerBicicletas {

    private List<Bicicleta> bicicletas;

    public GestorTallerBicicletas() {
        this.bicicletas = new ArrayList<>();
    }


    public void registrarBicicleta(Bicicleta bicicleta) {
        bicicletas.add(bicicleta);
        System.out.println(bicicleta.getCodigoBicicleta() + " (" + bicicleta.getClass().getSimpleName()
                + ") registrada correctamente.");
    }


    public List<Bicicleta> buscarPorCodigo(String codigo) {
        List<Bicicleta> resultado = new ArrayList<>();
        for (Bicicleta bicicleta : bicicletas) {
            if (bicicleta.getCodigoBicicleta().equalsIgnoreCase(codigo)) {
                resultado.add(bicicleta);
            }
        }
        return resultado;
    }

    public List<Bicicleta> getBicicletas() {
        return bicicletas;
    }
}
