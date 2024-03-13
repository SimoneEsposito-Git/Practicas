import java.util.*;

/**
 * Contiene la informacion de un alimento
 * 
 * @author Lin Qi y Simone
 */
public abstract class Alimento{
    protected InfoNutricional infoNutricional;
    protected Set<Alergeno> alergenos = new HashSet<>();

    /**
     * Constructor por defecto de alimento
     */
    public Alimento() {

    }

    /**
     * Devuelve la informacion nutrcional del alimento
     * 
     * @return la informacion nutricional del alimento
     */
    public InfoNutricional getInfoNutricional() {
        return this.infoNutricional;
    }

    /**
     * Devuelve los alergenos de un alimento
     * 
     * @return los alergenos de un alimento
     */
    public Set<Alergeno> getAlergenos() {
        return this.alergenos;
    }

    /**
     * Sobreescribe toString
     * 
     * @return String que contiene la informacion del alimento
     */
    @Override
    public String toString() {
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
        return this.infoNutricional + alergenos;
    }
}