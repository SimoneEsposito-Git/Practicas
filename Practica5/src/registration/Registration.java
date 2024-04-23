package registration;

/**
 * Clase de registracion
 * 
 * @author eps
 */
public class Registration {
	private String name, affiliation;
	private RegistrationKind kind;
	private int amountPayed;
	private boolean validated;
	
	/**
	 * Constructor de registracion
	 * 
	 * @param name el nombre de la persona que pide registracion
	 * @param kind el tipo de registracion
	 */
	public Registration(String name, RegistrationKind kind) {
		this.kind = kind;
		this.name = name;
	}
	
	/**
	 * Pagar la registracion
	 * 
	 * @param amount la cantidad que paga
	 */
	public void pay (double amount) {		
		this.amountPayed+=amount;
	}

	/**
	 * Saca la cantidad pagada
	 * 
	 * @return la cantidad pagada
	 */
	public double getAmountPayed() {
		return this.amountPayed;
	}

	/**
	 * Saca la cantidad total que se debe pagar
	 * 
	 * @return la cantidad total
	 */
	public double getTotalAmount() {
		return this.kind.getPrice();
	}

	/**
	 * Devuelve la afiliacion
	 * 
	 * @return la afiliacion
	 */
	public String getAffiliation() {
		return this.affiliation;
	}
	
	/**
	 * Anyade la afiliacion
	 * 
	 * @param aff la afiliacion que se anyade
	 */
	public void setAffiliation(String aff) {
		this.affiliation = aff;
	}

	/**
	 * Devuelve si esta validado
	 * 
	 * @return si esta validado
	 */
	public boolean getValidated() {
		return this.validated;
	}
	
	/**
	 * Devuelve la informacion de una registracion
	 * 
	 * @return un string de informacion de una registracion
	 */
	@Override
	public String toString() {
		return "Reg. of: "+this.name;
	}

	/**
	 * Cambia si esta validado
	 * 
	 * @param b el estado de validado
	 */
	public void setValidated(boolean b) {
		this.validated = b;
	}

	/**
	 * Chequea si es igual a otro objeto
	 * 
	 * @param o un objeto que se compara
	 * @return si son iguales
	 */
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Registration)) return false;
        Registration that = (Registration) o;
        return this.name.equals(that.name);
    }

	/**
	 * Devuelve el hashcode de una registracion
	 * 
	 * @return el hashcode de la registracion
	 */
	@Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
