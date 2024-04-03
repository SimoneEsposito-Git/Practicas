package alimentos;

import java.util.*;

/**
 * Contiene la informacion de un plato
 * 
 * @author Lin Qi y Simone Eposito
 */
public class Plato extends AlimentoConNombre{
    private HashMap<AlimentoConNombre, Double> alimentosConNombre;

    /**
     * Constructor de plato
     * 
     * @param nombre el nombre del plato
     */
    public Plato(String nombre){
        super(nombre);
        this.alimentosConNombre = new HashMap<>();
        this.infoNutricional = new InfoNutricionalPlato();
    }

    /**
     * Anyade un ingrediente al plato
     * 
     * @param ingrediente el ingrediente a anyadir
     * @param cantidad la cantidad del ingrediente
     * @return true si se anyade correctamente, false en caso contrario
     */
    public boolean addIngrediente(Ingrediente ingrediente, double cantidad){
        if(ingrediente == null || (this.alimentosConNombre).containsKey(ingrediente)) return false;
        (this.alimentosConNombre).put(ingrediente, cantidad);
        (this.infoNutricional).addInfoNutricional(ingrediente.infoNutricional, cantidad);
        if (ingrediente.getAlergenos() != null) this.alergenos.addAll(ingrediente.alergenos);
        return true;
    }

    /**
     * Anyde un plato al plato
     * 
     * @param plato el plato a anyadir
     * @return true si se anyade correctamente, false en caso contrario
     */
    public boolean addPlato(Plato plato){
        if (plato == null) {
            return false;
        }
        if (this.nombre == plato.nombre) { // no permite anyadir platos con el mismo nombre(tambien evita que se anyade a si mismo)
            return false;
        }
        if ((this.alimentosConNombre).containsKey(plato)) return false;
        (this.alimentosConNombre).put(plato, 1.0);
        (this.infoNutricional).addInfoNutricional(plato.infoNutricional,1.0);
        if (plato.alergenos != null) this.alergenos.addAll(plato.alergenos);
        return true;
    }

    /**
     * Devuelve los alimentos de un plato
     * 
     * @return los alimentos
     */
    public HashMap<AlimentoConNombre, Double> getAlimentosConNombre(){
        return this.alimentosConNombre;
    }

    /**
     * Devuelve el nombre de un plato
     * 
     * @return su nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Sobreescribe toString
     * 
     * @return String que contiene la informacion del plato
     */
    @Override
    public String toString(){
        return "[Plato] " + super.toString();
    }
}