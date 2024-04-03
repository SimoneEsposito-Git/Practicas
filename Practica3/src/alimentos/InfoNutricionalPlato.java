package alimentos;

/**
 * Contiene la informacion nutricional por peso
 * 
 * @author Lin Qi y Simone Eposito
 */
public class InfoNutricionalPlato extends InfoNutricional{
    /**
     * Contructor de informacion nutricional de un plato
     */
    public InfoNutricionalPlato(){
        super(0, 0, 0, 0, 0, 0, 0, 0);
    }

    /**
     * Constructor de las informaciones nutricional de un plato
     * 
     * @param calorias cantidad de caloria de un plato
     * @param hidratosDeCarbono cantidad de hidratos de carbano de un plato
     * @param grasas cantidad de grasa total de un plato
     * @param grasaSaturadas cantidad de grasa saturada de un plato
     * @param proteinas cantidad de proteinas de un plato
     * @param azucar cantidad de azucar de un plato
     * @param fibra cantidad de fibra de un plato
     * @param sodio cantidad de sodio de un plato
     */
    public InfoNutricionalPlato(double calorias, double hidratosDeCarbono, double grasas, double grasasSaturadas, double proteinas, double azucar, double fibra, double sodio){
        super(calorias, hidratosDeCarbono, grasas, grasasSaturadas, proteinas, azucar, fibra, sodio);
    }

    /**
     * Sobreescribe toString()
     * 
     * @return String de informacion de un plato
     */
    @Override
    public String toString(){
        return "INFORMACION NUTRICIONAL DEL PLATO -> " + super.toString(); 
    }
}