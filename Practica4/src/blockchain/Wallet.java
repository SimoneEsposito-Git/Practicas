package blockchain;

/**
 * Contiene la informacion de un wallet
 * 
 * @author Lin Qi y Simone Esposito
 */
public class Wallet {
    private String usuario;
    private String clave;
    private int balance;

    /**
     * Constrcutor de Wallet
     * 
     * @param usuario el usuario del wallet
     * @param clave la clave del wallet
     * @param balance el balance de wallet
     */
    public Wallet(String usuario, String clave, int balance) {
        this.usuario = usuario;
        this.clave = clave;
        this.balance = balance;
    }

    /**
     * Devuelve la clave de wallet
     * 
     * @return la clave de wallet
     */
    public String getPublicKey() {
        return this.clave;
    }

    /**
     * Devuelve el balance de wallet
     * 
     * @return el balance de wallet
     */
    public int getBalance() {
        return this.balance;
    }

    /**
     * Devuelve una informacion de wallet
     * 
     * @return una linea de informacion de wallet
     */
    @Override
    public String toString() {
        return "u: "+this.usuario+", PK: "+this.clave+", balance: "+this.balance;
    }
}
