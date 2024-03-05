/**
 * Contiene las tipos de ingredientes
 * 
 * @author Lin Qi y Simone
 */
public enum TipoIngrediente {
    CARNE("CARNE"), PESCADO("PESCADO"), FRUTA_VERDURA("FRUTA_VERDURA"), LEGUMBRE("LEGUMBRE"), CEREAL("CEREAL"), HUEVO("HUEVO"), LACTEO("LACTEO"), OTRO("OTRO");

    private String tipo;

    private TipoIngrediente (String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return this.tipo;
    }
}