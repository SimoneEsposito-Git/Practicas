/**
 * Contiene la informacion nutricional por peso
 * 
 * @author Lin Qi y Simone
 */
public class InfoNutricionalPeso extends InfoNutricional{
    /**
     * Constructor de las informaciones nutricional por peso
     * 
     * @param calorias cantidad de caloria por peso
     * @param hidratosDeCarbono cantidad de hidratos de carbono por peso
     * @param grasas cantidad de grasa total por peso
     * @param grasaSaturadas cantidad de grasa saturada por peso
     * @param proteinas cantidad de proteinas por peso
     * @param azucar cantidad de azucar por peso
     * @param fibra cantidad de fibra por peso
     * @param sodio cantidad de sodio por peso
     */
    public InfoNutricionalPeso(double calorias, double hidratosDeCarbono, double grasas, double grasasSaturadas, double proteinas, double azucar, double fibra, double sodio){
        super(calorias, hidratosDeCarbono, grasas, grasasSaturadas, proteinas, azucar, fibra, sodio);
    }

    /**
     * Sobreescribe toString()
     * 
     * @return String de informacion por peso
     */
    @Override
    public String toString(){
        return "INFORMACION NUTRICIONAL POR 100 g -> " + super.toString(); 
    }
}