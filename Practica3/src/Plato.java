import java.util.*;

public class Plato {
    private String nombre;
    private InfoNutricionalPlato infoNutricional;
    private HashSet<Ingrediente> ingredientes;
    private HashSet<Alergeno> alergenos;

    public Plato(String nombre){
        this.nombre = nombre;
        this.ingredientes = new HashSet<>();
        this.infoNutricional = new InfoNutricionalPlato();
        this.alergenos = new HashSet<>();
    }
    public boolean addIngrediente(Ingrediente ingrediente, int cantidad){
        if(this.ingredientes.contains(ingrediente)) return true;
        this.ingredientes.add(ingrediente);
        this.infoNutricional.addIngrediente(ingrediente, cantidad);
        if (ingrediente.getAlergenos() != null) this.alergenos.addAll(ingrediente.getAlergenos());
        return false;
    }

    public void addPlato(Plato plato){
        for (Ingrediente ingrediente: plato.getIngredientes()){
            this.ingredientes.add(ingrediente);
            this.infoNutricional.addIngrediente(ingrediente, 1);
            if (ingrediente.getAlergenos() != null) this.alergenos.addAll(ingrediente.getAlergenos());
        }
    }

    public HashSet<Ingrediente> getIngredientes(){
        return this.ingredientes;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String toString(){
        String alergenos = "";
        Iterator<Alergeno> it = this.alergenos.iterator();
        if (it.hasNext()) {
            alergenos += it.next();
            while (it.hasNext()) {
                alergenos += (", " + it.next());
            }
            alergenos = alergenos.toLowerCase();
            alergenos = " CONTIENE " + alergenos;
        }
        return "[Plato] " + this.nombre + ": " + this.infoNutricional + alergenos;
    }
}