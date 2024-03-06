/**
 * Contiene la informacion nutricional por peso
 * 
 * @author Lin Qi y Simone
 */
public class InfoNutricionalPlato extends InfoNutricional{
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
    public InfoNutricionalPlato(){
        super(0, 0, 0, 0, 0, 0, 0, 0);
    }

    public void addIngrediente(Ingrediente ingrediente, int cantidad){
        // calorias = 
        // hidratosDeCarbono = ingrediente.getInfoNutricional().getHidratosDeCarbono() * cantidad;
        // grasas = ingrediente.getInfoNutricional().getGrasas() * cantidad;
        // grasaSaturadas = ingrediente.getInfoNutricional().getGrasaSaturadas() * cantidad;
        // proteinas = ingrediente.getInfoNutricional().getProteinas() * cantidad;
        // azucar = ingrediente.getInfoNutricional().getAzucar() * cantidad;
        // fibra = ingrediente.getInfoNutricional().getFibra() * cantidad;
        // sodio = ingrediente.getInfoNutricional().getSodio() * cantidad;
        InfoNutricional infoNutricional = ingrediente.getInfoNutricional();
        double cantidadPorcion = infoNutricional.cantidadPorcion(cantidad);

        setCalorias(getCalorias() + infoNutricional.getCalorias() * cantidadPorcion);
        setHidratosDeCarbono(getHidratosDeCarbono() + infoNutricional.getHidratosDeCarbono() * cantidadPorcion);
        setGrasas(getGrasas() + infoNutricional.getGrasas() * cantidadPorcion);
        setGrasasSaturadas(getGrasasSaturadas() + infoNutricional.getGrasasSaturadas() * cantidadPorcion);
        setProteinas(getProteinas() + infoNutricional.getProteinas() * cantidadPorcion);
        setAzucar(getAzucar() + infoNutricional.getAzucar() * cantidadPorcion);
        setFibra(getFibra() + infoNutricional.getFibra() * cantidadPorcion);
        setSodio(getSodio() + infoNutricional.getSodio() * cantidadPorcion);

    }
    /**
     * Sobreescribe toString()
     * 
     * @return String de informacion por peso
     */
    @Override
    public String toString(){
        return "INFORMACION NUTRICIONAL DEL PLATO -> " + super.toString(); 
    }
}