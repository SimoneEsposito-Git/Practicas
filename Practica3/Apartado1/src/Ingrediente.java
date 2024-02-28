import java.util.*;


public class Ingrediente{
    private String nombre;
    private TipoIngrediente tipo;
    private InfoNutricionalPeso infoNutricional;
    private Set<Alergeno> alergenos;

    public Ingrediente(String nombre, TipoIngrediente tipo, InfoNutricionalPeso infoNutricional){
        this.nombre = nombre;
        this.tipo = tipo;
        this.infoNutricional = infoNutricional;
        this.alergenos = new HashSet<>();
    }
    public Ingrediente tieneAlergenos(Alergeno... alergenos){
        for (Alergeno alergeno: Arrays.asList(alergenos)){
            System.out.println(alergeno);
            this.alergenos.add(alergeno);
        }
        return this;
    }

    public String toString(){
        String alergenos = "";
        Iterator<Alergeno> it = this.alergenos.iterator();
        if (it.hasNext()) {
            alergenos += it.next();
        }
        while (it.hasNext()) {
            alergenos += (", " + it.next());
        }
        alergenos = alergenos.toLowerCase();
        return "[" + this.tipo + "] " + this.nombre + ": " + this.infoNutricional + " CONTIENE " + alergenos;
    }
}