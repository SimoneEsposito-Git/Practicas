import java.util.*;

/**
 * Contiene la informacion de un menu
 * 
 * @author Lin Qi y Simone
 */
public class Menu extends Alimento{
    private static int contador = 1; // Contador que se usa para poner id

    private HashSet<Plato> platos;
    private final int id;

    /**
     * Constructor de menu
     * 
     * @param platos un numero variable de Plato
     */
    public Menu(Plato... platos){
        this.platos = new HashSet<>(Arrays.asList(platos));
        this.infoNutricional = new InfoNutricionalMenu();
        this.id = Menu.contador;
        Menu.contador++;
        for (Plato plato: platos) {
            if (plato != null) {
                (this.infoNutricional).addInfoNutricional(plato.infoNutricional, 1.0);
                if (plato.alergenos != null) {
                    (this.alergenos).addAll(plato.alergenos);
                }
            }
        }
    }

    /**
     * Devuelve los platos del menu
     * 
     * @return platos del menu
     */
    public HashSet<Plato> getPlatos(){
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