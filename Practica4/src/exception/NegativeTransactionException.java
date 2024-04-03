package exception;

import blockchain.*;

/**
 * Excepcion de valor negativo de transaccion
 * 
 * @author Lin Qi y Simone Esposito
 */
public class NegativeTransactionException extends TransactionException {
    /**
     * Constructor de excepcion de valor negativa
     * 
     * @param emisor
     * @param receptor
     * @param cantidad
     */
    public NegativeTransactionException(Wallet emisor, String receptor, int cantidad) {
        super(emisor, receptor, cantidad);
    }

    /**
     * Informacion de excepcion de valor negarivo
     * 
     * @return string de informacion de excepcion de valor negativo
     */
    @Override
    public String toString() {
        return "Negative transfer attempt: "+super.toString();
    }
}