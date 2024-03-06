import java.util.*;

/**
 * Contiene la informacion de un ingrediente
 * 
 * @author Lin Qi y Simone
 */
public class Ingrediente{
    private String nombre;
    private TipoIngrediente tipoIngrediente;
    private String tipo;
    private InfoNutricional infoNutricional;
    private HashSet<Alergeno> alergenos = new HashSet<>();

    /**
     * Constructor de ingrediente
     * 
     * @param nombre nombre del ingrediente
     * @param tipo tipo del ingrediente
     * @param inforNutricional informacion nutricional del ingrediente
     */
    public Ingrediente(String nombre, TipoIngrediente tipoIngrediente, InfoNutricional infoNutricional){
        this.nombre = nombre;
        this.tipoIngrediente = tipoIngrediente;
        this.tipo = tipoIngrediente.getTipo();
        this.infoNutricional = infoNutricional;
    }

    /**
     * Constructor de ingrediente
     * 
     * @param nombre nombre del ingrediente
     * @param tipo tipo del ingrediente
     * @param inforNutricional informacion nutricional del ingrediente
     */
    public Ingrediente(String nombre, String tipo, InfoNutricional infoNutricional){
        this.nombre = nombre;
        this.tipoIngrediente = TipoIngrediente.OTRO;
        this.tipo = tipo;
        this.infoNutricional = infoNutricional;
    }

    /**
     * Anyade los posible alergenos al ingrediente
     * 
     * @param alergenos un numero variable de alergenos
     */
    public Ingrediente tieneAlergenos(Alergeno... alergenos){
        for (Alergeno alergeno: Arrays.asList(alergenos)){
            this.alergenos.add(alergeno);
        }
        return this;
    }

    public HashSet<Alergeno> getAlergenos(){
        return this.alergenos;
    }

    public InfoNutricional getInfoNutricional(){
        return this.infoNutricional;
    }
    /**
     * Sobreescribe toString()
     * 
     * @return String que contiene la informacion del ingrediente
     */
    @Override
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
        
        return "[" + this.tipo + "] " + this.nombre + ": " + this.infoNutricional + alergenos;
    }
}