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

    public void setCalorias(double calorias){
        this.calorias = calorias;
    }

    public void setHidratosDeCarbono(double hidratosDeCarbono){
        this.hidratosDeCarbono = hidratosDeCarbono;
    }

    public void setGrasas(double grasas){
        this.grasas = grasas;
    }

    public void setGrasasSaturadas(double grasasSaturadas){
        this.grasasSaturadas = grasasSaturadas;
    }

    public void setProteinas(double proteinas){
        this.proteinas = proteinas;
    }

    public void setAzucar(double azucar){
        this.azucar = azucar;
    }

    public void setFibra(double fibra){
        this.fibra = fibra;
    }

    public void setSodio(double sodio){
        this.sodio = sodio;
    }

    //Getters

    public double getCalorias(){
        return calorias;
    }

    public double getHidratosDeCarbono(){
        return hidratosDeCarbono;
    }

    public double getGrasas(){
        return grasas;
    }

    public double getGrasasSaturadas(){
        return grasasSaturadas;
    }

    public double getProteinas(){
        return proteinas;
    }

    public double getAzucar(){
        return azucar;
    }

    public double getFibra(){
        return fibra;
    }

    public double getSodio(){
        return sodio;
    }

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

    private double round(double value){
        return Math.round(value * 100.0) / 100.0;
    }
}