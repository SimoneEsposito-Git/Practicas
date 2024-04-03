package alimentos;

import java.util.*;

/**
 * Contiene la informacion de un menu
 * 
 * @author Lin Qi y Simone Eposito
 */
public class Menu extends Alimento{
    private static int contador = 1; // Contador que se usa para poner id

    private Set<Plato> platos;
    private final int id;

    /**
     * Constructor de menu
     * 
     * @param platos un numero variable de Plato
     */
    public Menu(Plato... platos){
        this(Arrays.asList(platos));
    }

    /**
     * Constrcutor de menu
     */
    public Menu() {
        this.platos = new HashSet<>();
        this.infoNutricional = new InfoNutricionalMenu();
        this.id = Menu.contador;
        Menu.contador++;
    }

    /**
     * Constrcutor de menu
     */
    public Menu(List<Plato> platos) {
        this();
        for (Plato plato: platos) {
            this.addPlato(plato);
        }
    }

    /**
     * Anyade un plato al menu
     * 
     * @param plato el plato para anyadir al menu
     * @return true si se anyade correctamente, false si ya esta en el menu
     */
    public boolean addPlato(Plato plato) {
        if (plato == null) {
            return false;
        }
        if ((this.platos).contains(plato)) {
            return false;
        }
        else {
            (this.platos).add(plato);
            (this.infoNutricional).addInfoNutricional(plato.infoNutricional, 1.0);
            if (plato.alergenos != null) {
                (this.alergenos).addAll(plato.alergenos);
            }
            return true;
        }
    }

    /**
     * Elimina un plato del menu
     * 
     * @param plato el plato a eliminar
     */
    public boolean deletePlato(Plato plato) {
        if ((this.platos).contains(plato)) {
            (this.platos).remove(plato);
            (this.infoNutricional).minusInfoNutricional(plato.infoNutricional, 1.0);
            if (plato.alergenos != null) {
                (this.alergenos).removeAll(plato.alergenos);
            }
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Devuelve los platos del menu
     * 
     * @return los platos del menu
     */
    public Set<Plato> getPlatos() {
        return this.platos;
    }

    /**
     * Sobreescribe toString
     * 
     * @return String que contiene la informacion del menu
     */
    @Override
    public String toString(){
        String platos = "";
        Iterator<Plato> it = this.platos.iterator();
        if (it.hasNext()) {
            platos += it.next().getNombre();
            while (it.hasNext()) {
                platos += (", " + it.next().getNombre());
            }
        }
        return "Menu "+this.id+" ["+platos+"] " + super.toString();
    }
}