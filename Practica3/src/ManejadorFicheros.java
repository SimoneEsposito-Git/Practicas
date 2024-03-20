import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;


public class ManejadorFicheros {
    private static List<Menu> menus = new ArrayList<>();

    private static Ingrediente parseIngrediente(String line) {
        String[] parts = line.split(";");
        String nombre = parts[1];
        String tipo = parts[2];
        double calorias = Double.parseDouble(parts[3]);
        double hidratosDeCarbono = Double.parseDouble(parts[4]);
        double grasas = Double.parseDouble(parts[5]);
        double grasasSaturadas = Double.parseDouble(parts[6]);
        double proteinas = Double.parseDouble(parts[7]);
        double azucar = Double.parseDouble(parts[8]);
        double fibra = Double.parseDouble(parts[9]);
        double sodio = Double.parseDouble(parts[10]);

        Set<Alergeno> alergenos = new HashSet<>();
        Alergeno[] allAlergenos = Alergeno.values();
        for (int i = 11; i < parts.length; i++) {
            if (parts[i].equals("S")) {
                alergenos.add(allAlergenos[i - 11]);
            }
        }
        InfoNutricional infoNutricional = new InfoNutricionalPeso(calorias, hidratosDeCarbono, grasas, grasasSaturadas, proteinas, azucar, fibra, sodio);
        Ingrediente ingrediente = new Ingrediente(nombre, tipo, infoNutricional);
        for (Alergeno alergeno : alergenos) {
            ingrediente.tieneAlergenos(alergeno);
        }

        return ingrediente;
    }

    private static Plato parsePlato(String line, Map<String, Ingrediente> ingredientes) {
        String[] parts = line.split(";");
        String nombre = parts[1];
        Plato plato = new Plato(nombre);

        for (int i = 2; i < parts.length; i++) 
        {
            if (parts[i].startsWith("PLATO")) {
                plato.addPlato(new Plato(parts[i].substring(6)));
            }else{
            String[] ingredienteParts = parts[i].split(": ");
            String ingredienteNombre = ingredienteParts[0].substring(12);
            int cantidad = Integer.parseInt(ingredienteParts[1]);
            plato.addIngrediente(ingredientes.get(ingredienteNombre), cantidad);
            }
        }
        return plato;
    }
    private static Menu parseMenu(String line, Map<String, Plato> platos) {
        String[] parts = line.split(";");
        Menu menu = new Menu();

        for (int i = 1; i < parts.length; i++) {
            menu.addPlato(platos.get(parts[i]));
        }

        return menu;
    }

    public static List<Menu> leerFichero(String nombreFichero) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(nombreFichero));
            Map<String, Ingrediente> ingredientes = new HashMap<>();
            Map<String, Plato> platos = new HashMap<>();
            menus.clear(); // Ensure the list is empty before starting

            for (String line : lines) {
                if (line.startsWith("INGREDIENTE")) {
                    // Parse and add ingredients
                    Ingrediente ing = parseIngrediente(line);
                    ingredientes.put(ing.getNombre(), ing);
                } else if (line.startsWith("PLATO")) {
                    // Parse and add plates
                    //System.out.println(ingredientes);
                    Plato plato = parsePlato(line, ingredientes);
                    platos.put(plato.getNombre(), plato);
                } else if (line.startsWith("MENU")) {
                    // Parse and add menus
                    Menu menu = parseMenu(line, platos);
                    menus.add(menu);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menus;
    }

    public static void guardarFichero(String nombreFichero, List<Menu> menus) {
    List<Alimento> repetido = new ArrayList<>();
    
    try (PrintWriter writer = new PrintWriter(nombreFichero)) {
        for (Menu menu : menus) {
            StringBuilder platos = new StringBuilder();
            for (Plato plato : menu.getPlatos()) {
                StringBuilder ingredientes = new StringBuilder();
                for (AlimentoConNombre alimento : plato.getAlimentosConNombre().keySet()) {
                    if (!repetido.contains(alimento)) {
                        StringBuilder infoNutricional = new StringBuilder();
                        if (alimento instanceof Ingrediente) {
                            infoNutricional.append(alimento.getInfoNutricional() instanceof InfoNutricionalPeso ? "INGREDIENTE_PESO;" : "INGREDIENTE_UNIDAD;");
                            Ingrediente ingrediente = (Ingrediente) alimento;
                            InfoNutricional info = ingrediente.getInfoNutricional();
                            
                            infoNutricional.append(String.join(";", ingrediente.getNombre(), ingrediente.getTipo().getTipo(), String.valueOf(info.getCalorias()), String.valueOf(info.getHidratosDeCarbono()), String.valueOf(info.getGrasas()), String.valueOf(info.getGrasasSaturadas()), String.valueOf(info.getProteinas()), String.valueOf(info.getAzucar()), String.valueOf(info.getFibra()), String.valueOf(info.getSodio())));
                            infoNutricional.append(";");
                            Set<Alergeno> alergenos = alimento.getAlergenos();

                            for (Alergeno alergeno : Alergeno.values()) {
                                if (alergenos.contains(alergeno)) {
                                    infoNutricional.append("S;");
                                } else {
                                    infoNutricional.append("N;");
                                }
                            }
                            writer.println(infoNutricional);
                            ingredientes.append(";INGREDIENTE ").append(alimento.getNombre()).append(": ").append((int) ((double) plato.getAlimentosConNombre().get(alimento)));
                            repetido.add(alimento);
                        } else if (alimento instanceof Plato) {
                            ingredientes.append(";PLATO ").append(alimento.getNombre());
                        }
                    }
                }
                if (!repetido.contains(plato)) {
                    writer.println("PLATO;" + plato.getNombre() + ingredientes);
                    repetido.add(plato);
                }
                platos.append(";").append(plato.getNombre());
            }
            writer.println("MENU" + platos);
        }
    } catch (FileNotFoundException e) {
        System.err.println("Error al crear el fichero: " + e.getMessage());
    }
    }

    public static List<Menu> getMenus() {
        return menus;
    }
}