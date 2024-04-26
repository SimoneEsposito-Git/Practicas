package registration;

import java.util.ArrayList;
import java.util.List;

import object.StateObserver;

/**
 * Clase de registración
 * 
 * @author eps, Lin Qi y Simone Esposito
 */
public class Registration {
    private String name, affiliation;
    private RegistrationKind kind;
    private int amountPayed;
    private boolean validated;
    private static List<StateObserver> observers = new ArrayList<>();

    /**
     * Constructor de la clase Registration
     * 
     * @param name el nombre de la persona que pide registración
     * @param kind el tipo de registración
     */
    public Registration(String name, RegistrationKind kind) {
        this.kind = kind;
        this.name = name;
    }

    /**
     * Método para pagar la registración
     * 
     * @param amount la cantidad que se paga
     */
    public void pay(double amount) {
        this.amountPayed += amount;
        notifyObservers();  // Notificar a los observadores cuando se realiza un pago
    }

    /**
     * Obtiene la cantidad pagada
     * 
     * @return la cantidad pagada
     */
    public double getAmountPayed() {
        return this.amountPayed;
    }

    /**
     * Obtiene la cantidad total que se debe pagar
     * 
     * @return la cantidad total
     */
    public double getTotalAmount() {
        return this.kind.getPrice();
    }

    /**
     * Devuelve la afiliación
     * 
     * @return la afiliación
     */
    public String getAffiliation() {
        return this.affiliation;
    }

    /**
     * Establece la afiliación
     * 
     * @param aff la afiliación que se añade
     */
    public void setAffiliation(String aff) {
        this.affiliation = aff;
        notifyObservers();  // Notificar a los observadores cuando se establece la afiliación
    }

    /**
     * Devuelve si está validado
     * 
     * @return true si está validado, false en caso contrario
     */
    public boolean getValidated() {
        return this.validated;
    }

    /**
     * Establece el estado de validación
     * 
     * @param b el nuevo estado de validación
     */
    public void setValidated(boolean b) {
        this.validated = b;
        notifyObservers();  // Notificar a los observadores cuando cambia el estado de validación
    }

    /**
     * Representación en cadena de la registración
     * 
     * @return una cadena que representa la registración
     */
    @Override
    public String toString() {
        return "Reg. of: " + this.name;
    }

    /**
     * Comprueba si otro objeto es igual a este
     * 
     * @param o el objeto a comparar
     * @return true si son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Registration)) return false;
        Registration that = (Registration) o;
        return this.name.equals(that.name);
    }

    /**
     * Devuelve el código hash de la registración
     * 
     * @return el código hash
     */
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    /**
     * Registra un observador en la lista
     * 
     * @param observer el observador que se añade
     */
    public static void withTracker(StateObserver observer) {
        observers.add(observer);
    }

    /**
     * Notifica a todos los observadores sobre un cambio
     */
    private static void notifyObservers() {
        for (StateObserver observer : observers) {
            observer.updateStates();
        }
    }
}
