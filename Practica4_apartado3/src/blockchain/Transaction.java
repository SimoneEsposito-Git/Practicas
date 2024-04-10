package blockchain;

import exception.*;

/**
 * Una transaccion entre dos nodos
 * 
 * @author Lin Qi y Simone Esposito
 */
public class Transaction {
    private static int contador = 0;

    private final int id;
    private String claveEmisor;
    private String claveReceptor;
    private int cantidad;

    /**
     * Constructor de transaction
     * 
     * @param emisor el wallet emisor de la transaction
     * @param receptor el wallet de receptor de la transaction
     * @param cantidad el valor de la transaction
     */
    public Transaction(Wallet emisor, Wallet receptor, int cantidad) throws TransactionException {
        this(emisor, receptor.getPublicKey(), cantidad);
    }

    /**
     * Constructor de transaction
     * 
     * @param emisor el wallet emisor de la transaction
     * @param receptor el de receptor de la transaction
     * @param cantidad el de la transaction
     */
    public Transaction(Wallet emisor, String receptor, int cantidad) throws TransactionException {
        if (cantidad < 0) {
            throw new NegativeTransactionException(emisor, receptor, cantidad);
        }
        else if (emisor.getBalance() > cantidad) {
            throw new InsufficientTransactionException(emisor, receptor, cantidad);
        }
        this.id = Transaction.contador;
        Transaction.contador++;
        this.claveEmisor = emisor.getPublicKey();
        this.claveReceptor = receptor;
        this.cantidad = cantidad;
    }

    /**
     * Devuelve el emisor de la transaccion
     * 
     * @return el emisor de la transaccion
     */
    public String getClaveEmisor() {
        return this.claveEmisor;
    }

    /**
     * Devuelve el receptor de la transaccion
     * 
     * @return el receptor de la transaccion
     */
    public String getClaveReceptor() {
        return this.claveReceptor;
    }

    /**
     * Devuelve la cantidad
     * 
     * @return la cantidad
     */
    public int getCantidad() {
        return this.cantidad;
    }

    /**
     * Devuelve el id
     * 
     * @return el id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Informacion de transaccion
     * 
     * @return un string de informacion de transaccion
     */
    @Override
    public String toString() {
        return "Transaction "+this.id+"| from: "+this.claveEmisor+", to: "+this.claveReceptor+ ", quantity: "+this.cantidad;
    }
}
