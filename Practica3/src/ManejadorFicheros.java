import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class ManejadorFicheros {
    private static List<Menu> menus = new ArrayList<>();

    public static void guardarFichero(String nombreFichero, List<Menu> menus) {
        System.out.println("Creando fichero " + nombreFichero);
        List<Alimento> repetido = new ArrayList<>();
        StringBuilder contenido = new StringBuilder();
        for (Menu menu : menus) {
            StringBuilder platos = new StringBuilder();
            for (Plato plato : menu.getPlatos()) {
                StringBuilder ingredientes = new StringBuilder();
                for (AlimentoConNombre alimento : plato.getAlimentosConNombre().keySet()) {
                    if (!repetido.contains(alimento)) {
                        System.out.println("Ingrediente: " + alimento.getNombre());
                        repetido.add(alimento);
                    }
                    if(alimento instanceof Plato) ingredientes.append(";PLATO ").append(alimento.getNombre());
                    else if(alimento instanceof Ingrediente) ingredientes.append(";INGREDIENTE ").append(alimento.getNombre()).append(": ").append((int) ((double)plato.getAlimentosConNombre().get(alimento)));
                }
                if (!repetido.contains(plato)) {
                    System.out.println("PLATO;" + plato.getNombre()+ingredientes);
                    repetido.add(plato);
                }
                platos.append(";").append(plato.getNombre());
            }
            System.out.println("MENU" + platos);
        }
    }

    public static String leerFichero(String nombreFichero) {
        return "Contenido del fichero " + nombreFichero;
    }

    public static List<Menu> getMenus() {
        return menus;
    }
}