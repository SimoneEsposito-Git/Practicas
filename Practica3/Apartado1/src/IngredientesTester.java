import java.util.*;
public class IngredientesTester{
    public static void main(String[] args){
        IngredientesTester tester = new IngredientesTester();
        for (Ingrediente ingrediente: tester.crearIngredientes().values()){
            System.out.println("* " + ingrediente);
        }
    }
    public Map<String, Ingrediente> crearIngredientes(){
        Map<String, Ingrediente> ingredientes = new LinkedHashMap<>();
        ingredientes.put("Pasta", new Ingrediente("Pasta", TipoIngrediente.CEREAL,
                            new InfoNutricionalPeso(372, 74, 1.8, 0.277, 12, 2.6, 2.9, 6))
                            .tieneAlergenos(Alergeno.GLUTEN, Alergeno.HUEVO));
        return ingredientes;
    }
}