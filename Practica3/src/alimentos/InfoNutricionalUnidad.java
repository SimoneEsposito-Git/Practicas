package alimentos;

/**
 * Contiene la informacion nutricional por unidad
 * 
 * @author Lin Qi y Simone Eposito
 */
public class InfoNutricionalUnidad extends InfoNutricional{
    /**
     * Constructor de las informaciones nutricional por unidad
     * 
     * @param calorias cantidad de caloria por unidad
     * @param hidratosDeCarbono cantidad de hidratos de carbono por unidad
     * @param grasas cantidad de grasa total por unidad
     * @param grasaSaturadas cantidad de grasa saturada por unidad
     * @param proteinas cantidad de proteinas por unidad
     * @param azucar cantidad de azucar por unidad
     * @param fibra cantidad de fibra por unidad
     * @param sodio cantidad de sodio por unidad
     */
    public InfoNutricionalUnidad(double calorias, double hidratosDeCarbono, double grasas, double grasasSaturadas, double proteinas, double azucar, double fibra, double sodio){
        super(calorias, hidratosDeCarbono, grasas, grasasSaturadas, proteinas, azucar, fibra, sodio);
    }

    /**
     * Sobreescribe toString()
     * 
     * @return String de informacion por unidad
     */
    @Override
    public String toString(){
        return "INFORMACION NUTRICIONAL POR UNIDAD -> " + super.toString(); 
    }
}