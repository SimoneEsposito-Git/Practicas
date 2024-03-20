import java.util.*;

/**
 * Contiene la informacion de un ingrediente
 * 
 * @author Lin Qi y Simone
 */
public class Ingrediente extends AlimentoConNombre{
    private TipoIngrediente tipoIngrediente;
    private String tipo;

    /**
     * Constructor de ingrediente
     * 
     * @param nombre nombre del ingrediente
     * @param tipo tipo del ingrediente
     * @param inforNutricional informacion nutricional del ingrediente
     */
    public Ingrediente(String nombre, TipoIngrediente tipoIngrediente, InfoNutricional infoNutricional){
        super(nombre);
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
        super(nombre);
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

    /**
     * Devuelve el tipo de ingrediente
     * 
     * @return tipo de ingrediente
     */
    public TipoIngrediente getTipo(){
        return this.tipoIngrediente;
    }

    /**
     * Sobreescribe toString()
     * 
     * @return String que contiene la informacion del ingrediente
     */
    @Override
    public String toString(){
        return "[" + this.tipo + "] " + super.toString();
    }
}