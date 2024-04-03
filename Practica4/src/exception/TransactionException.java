package exception;

import blockchain.*;

/**
 * Excepcion de transaccion
 * 
 * @author Lin Qi y Simone Esposito
 */
public abstract class TransactionException extends Exception {
    private Wallet emisor;
    private String receptor;
    private int cantidad;

    /**
     * Constructor de excepcion de transaccion
     * 
     * @param emisor el emisor de la transaccion
     * @param cantidad la cantidad transferida
     */
    public TransactionException(Wallet emisor, String receptor, int cantidad) {
        this.emisor = emisor;
        this.receptor = receptor;
        this.cantidad = cantidad;
    }

    /**
     * Informacion de excepcion de transaccion
     * 
     * @return string de informacion de excepcion de transaccion
     */
    @Override
    public String toString() {
        return "source: "+this.emisor.getPublicKey()+", receiver: "+this.receptor+", amount: "+this.cantidad;
    }
}
