import java.util.*;

/**
 * Contiene la informacion nutricional de un menu
 * 
 * @author Lin Qi y Simone
 */
public class InfoNutricionalMenu extends InfoNutricional{
    /**
     * Constructor de informacion nutricional de menu
     */
    public InfoNutricionalMenu() {
        super(0,0,0,0,0,0,0,0);
    }

    /**
     * Constructor de las informaciones nutricional de un menu
     * 
     * @param calorias cantidad de caloria de un menu
     * @param hidratosDeCarbono cantidad de hidratos de carbono de un menu
     * @param grasas cantidad de grasa total de un menu
     * @param grasaSaturadas cantidad de grasa saturada de un menu
     * @param proteinas cantidad de proteinas de un menu
     * @param azucar cantidad de azucar de un menu
     * @param fibra cantidad de fibra de un menu
     * @param sodio cantidad de sodio de un menu
     */
    public InfoNutricionalMenu(double calorias, double hidratosDeCarbono, double grasas, double grasasSaturadas, double proteinas, double azucar, double fibra, double sodio){
        super(calorias, hidratosDeCarbono, grasas, grasasSaturadas, proteinas, azucar, fibra, sodio);
    }

    /**
     * Sobreescribe toString para que imprima de manera especial
     * 
     * @return String de informacion de un menu
     */
    @Override
    public String toString() {
        return "INFORMACION NUTRICIONAL DEL MENU -> " + super.toString(); 
    }
}
