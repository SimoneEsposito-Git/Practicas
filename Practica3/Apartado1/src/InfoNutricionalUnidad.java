public class InfoNutricionalUnidad extends InfoNutricional{
    private double calorias;
    private double hidratosDeCarbono;
    private double grasas;
    private double grasasSaturadas;
    private double proteinas;
    private double azucar;
    private double fibra;
    private double sodio;

    public InfoNutricionalUnitad(double calorias, double hidratosDeCarbono, double grasas, double grasasSaturadas, double proteinas, double azucar, double fibra, double sodio){
        super(calorias, hidratosDeCarbono, grasas, grasasSaturadas, proteinas, azucar, fibra, sodio);
    }

    public String toString(){
        return "INFORMACION NUTRICIONAL POR UNIDAD -> " + super.toString(); 
    }
}