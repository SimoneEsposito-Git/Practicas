/**
 * Contiene las tipos de ingredientes
 * 
 * @author Lin Qi y Simone
 */
public enum TipoIngrediente {
    CARNE("CARNE"), PESCADO("PESCADO"), FRUTA_VERDURA("FRUTA_VERDURA"), LEGUMBRE("LEGUMBRE"), CEREAL("CEREAL"), HUEVO("HUEVO"), LACTEO("LACTEO"), OTRO("OTRO");

    private String tipo;

    /**
     * Constructor de tipo de ingredientes
     * 
     * @param tipo su valor de String
     */
    private TipoIngrediente (String tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve el valor de tipo de ingrediente
     * 
     * @return el valor
     */
    public String getTipo() {
        return this.tipo;
    }
}