package registration;

/**
 * Una enumeracion de tipo de registracion
 * 
 * @author eps
 */
public enum RegistrationKind {
	/**
	 * Tipo FULL
	 */
	FULL (1100), 
	/**
	 * Tipo MEMBER
	 */
	MEMBER (900), 
	/**
	 * Tipo STUDENT
	 */
	STUDENT (450);

	/**
	 * El precio del tipo
	 */
	private int price;

	/**
	 * Constructor de tipo de registracion
	 * 
	 * @param price el precio del tipo de la registracion
	 */
	RegistrationKind(int price) {
		this.price = price;
	}

	/**
	 * Obtiene el precio de un tipo
	 * 
	 * @return el precio de un tipo
	 */
	public double getPrice() {
		return this.price;
	}	
}
