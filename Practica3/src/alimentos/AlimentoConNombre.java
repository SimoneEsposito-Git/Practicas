package alimentos;

import java.util.*;

/**
 * Contiene la informacion de un alimento con nombre
 * 
 * @author Lin Qi y Simone Eposito
 */
public abstract class AlimentoConNombre extends Alimento{
    protected String nombre;

    /**
     * Constructor de alimento con nombre
     * 
     * @param nombre nombre del alimento con nombre
     */
    public AlimentoConNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el nombre del alimento con nombre
     * 
     * @return nombre del alimento con nombre
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * Sobreescribe toString para que imprima de una manera distinta
     * 
     * @return String que contiene la informacion del alimento con nombre
     */
    @Override
    public String toString() {
        return this.nombre + ": " + super.toString();
    }
} 