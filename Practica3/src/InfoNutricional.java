/**
 * Contiene la informacion nutricional de un elemento
 * 
 * @author Lin Qi y Simone
 */
public abstract class InfoNutricional{
    private double calorias;
    private double hidratosDeCarbono;
    private double grasas;
    private double grasasSaturadas;
    private double proteinas;
    private double azucar;
    private double fibra;
    private double sodio;

    /**
     * Constructor de las informaciones nutricional
     * 
     * @param calorias cantidad de caloria
     * @param hidratosDeCarbono cantidad de hidratos de carbono
     * @param grasas cantidad de grasa total
     * @param grasaSaturadas cantidad de grasa saturada
     * @param proteinas cantidad de proteinas
     * @param azucar cantidad de azucar
     * @param fibra cantidad de fibra
     * @param sodio cantidad de sodio
     */
    public InfoNutricional(double calorias, double hidratosDeCarbono, double grasas, double grasasSaturadas, double proteinas, double azucar, double fibra, double sodio){
        this.calorias = calorias;
        this.hidratosDeCarbono = hidratosDeCarbono;
        this.grasas = grasas;
        this.grasasSaturadas = grasasSaturadas;
        this.proteinas = proteinas;
        this.azucar = azucar;
        this.fibra = fibra;
        this.sodio = sodio;
    }
    
    //Setters
    
    /**
     * Anyade las calorias
     * 
     * @param calorias para anyadir 
     */
    public void setCalorias(double calorias){
        this.calorias = calorias;
    }

    /**
     * Anyade los hidratos de carbono
     * 
     * @param hidratosDeCarbono para anyadir 
     */
    public void setHidratosDeCarbono(double hidratosDeCarbono){
        this.hidratosDeCarbono = hidratosDeCarbono;
    }

    /**
     * Anyade las grasas
     * 
     * @param grasas para anyadir 
     */
    public void setGrasas(double grasas){
        this.grasas = grasas;
    }

    /**
     * Anyade las grasas saturadas
     * 
     * @param grasasSaturadas para anyadir 
     */
    public void setGrasasSaturadas(double grasasSaturadas){
        this.grasasSaturadas = grasasSaturadas;
    }

    /**
     * Anyade las proteinas
     * 
     * @param proteinas para anyadir 
     */
    public void setProteinas(double proteinas){
        this.proteinas = proteinas;
    }

    /**
     * Anyade el azucar
     * 
     * @param azucar para anyadir 
     */
    public void setAzucar(double azucar){
        this.azucar = azucar;
    }

    /**
     * Anyade la fibra
     * 
     * @param fibra para anyadir 
     */
    public void setFibra(double fibra){
        this.fibra = fibra;
    }

    /**
     * Anyade el sodio
     * 
     * @param sodio para anyadir 
     */
    public void setSodio(double sodio){
        this.sodio = sodio;
    }

    //Getters

    /**
     * Devuelve las calorias
     * 
     * @return las calorias
     */
    public double getCalorias(){
        return calorias;
    }

    /**
     * Devuelve los hidratos de carbono
     * 
     * @return los hidratos de carbono
     */
    public double getHidratosDeCarbono(){
        return hidratosDeCarbono;
    }

    /**
     * Devuelve las grasas
     * 
     * @return las grasas
     */
    public double getGrasas(){
        return grasas;
    }

    /**
     * Devuelve las grasas saturadas
     * 
     * @return las grasas saturadas
     */
    public double getGrasasSaturadas(){
        return grasasSaturadas;
    }

    /**
     * Devuelve las proteinas
     * 
     * @return las proteinas
     */
    public double getProteinas(){
        return proteinas;
    }

    /**
     * Devuelve el azucar
     * 
     * @return el azucar
     */
    public double getAzucar(){
        return azucar;
    }

    /**
     * Devuelve la fibra
     * 
     * @return la fibra
     */
    public double getFibra(){
        return fibra;
    }

    /**
     * Devuelve el sodio
     * 
     * @return sl sodio
     */
    public double getSodio(){
        return sodio;
    }

    /**
     * Calcula la pporcion
     * 
     * @param cantidad cantidad inicial
     * @return la porcion de cantidad
     */
    public double cantidadPorcion(double cantidad){
        return cantidad;
    }
    /**
     * Sobreesicribe toString()
     * 
     * @return String con los valores de las informaciones
     */
    @Override
    public String toString(){
        return "Valor energetico: " + round(calorias) + " kcal, Hidratos de carbono: " + round(hidratosDeCarbono) + " g, Grasas: " + round(grasas) + " g, Saturadas: " + round(grasasSaturadas) + " g, Proteinas: " + round(proteinas) + " g, Azucares: " + round(azucar) + " g, Fibra: " + round(fibra) + " g, Sodio: " + round(sodio) + " mg.";
    }

    /**
     * Sumar las informaciones de una InfoNutricinal a otra
     * 
     * @param infoNutricional contiene las informacion para suamr
     * @param cantidad la cantidad de alimento
     */
    public void addInfoNutricional(InfoNutricional infoNutricional, double cantidad){
        // calorias = 
        // hidratosDeCarbono = ingrediente.getInfoNutricional().getHidratosDeCarbono() * cantidad;
        // grasas = ingrediente.getInfoNutricional().getGrasas() * cantidad;
        // grasaSaturadas = ingrediente.getInfoNutricional().getGrasaSaturadas() * cantidad;
        // proteinas = ingrediente.getInfoNutricional().getProteinas() * cantidad;
        // azucar = ingrediente.getInfoNutricional().getAzucar() * cantidad;
        // fibra = ingrediente.getInfoNutricional().getFibra() * cantidad;
        // sodio = ingrediente.getInfoNutricional().getSodio() * cantidad;
        if (infoNutricional != null) {
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

    }

    /**
     * Redondear un valor
     * 
     * @param value el valor a redondear
     * @return el valor redondeado
     */
    private double round(double value){
        return Math.round(value * 100.0) / 100.0;
    }
}