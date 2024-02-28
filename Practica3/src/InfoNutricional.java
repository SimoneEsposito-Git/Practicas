public abstract class InfoNutricional{
    private double calorias;
    private double hidratosDeCarbono;
    private double grasas;
    private double grasasSaturadas;
    private double proteinas;
    private double azucar;
    private double fibra;
    private double sodio;

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

    @Override
    public String toString(){
        return "Valor energetico: " + calorias + " kcal, Hidratos de carbono: " + hidratosDeCarbono + " g, Grasas: " + grasas + " g, Saturadas: " + grasasSaturadas + " g, Proteinas: " + proteinas + " g, Azucares: " + azucar + " g, Fibra: " + fibra + " g, Sodio: " + sodio + " mg.";
    }
}