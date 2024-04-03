package exception;

import blockchain.*;

/**
 * Excepcion de balance insuficiente de transaccion
 * 
 * @author Lin Qi y Simone Esposito
 */
public class InsufficientTransactionException extends TransactionException {
    /**
     * Constructor de excepcion de balance insuficiente
     * 
     * @param emisor
     * @param receptor
     * @param cantidad
     */
    public InsufficientTransactionException(Wallet emisor, String receptor, int cantidad) {
        super(emisor, receptor, cantidad);
    }

    /**
     * Informacion de excepcion de balance insuficiente
     * 
     * @return string de informacion de excepcion de balance insuficiente
     */
    @Override
    public String toString() {
        return "Insufficient transfer attempt: "+super.toString();
    }
}