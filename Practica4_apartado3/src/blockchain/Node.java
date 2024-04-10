package blockchain;

import java.util.*;

import exception.*;

/**
 * Un nodo tiene asociado un wallet y sus transactions
 * 
 * @author Lin Qi y Simone Esposito
 */
public class Node extends BlockchainElement {
    private Wallet wallet;
    private List<Transaction> transactions;

    /**
     * Constrcutor de nodo
     * 
     * @param wallet el wallet que esta relacionado con el nodo
     */
    public Node(Wallet wallet) {
        this.wallet = wallet;
        this.transactions = new ArrayList<>();
    }

    /**
     * Devuelve el nombre completo de un node
     * 
     * @return el nombre completo de un nodo
     */
    public String fullName() {
        return "Node#"+this.getId();
    }

    /**
     * Devuelve el wallet
     * 
     * @return el wallet
     */
    public Wallet getWallet() {
        return this.wallet;
    }

    /**
     * Anyade una transaccion al nodo
     * 
     * @param transaction la transaccion que se va a anydir
     */
    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    /**
     * Devuelve la lista de transacciones
     * 
     * @return la lista de transacciones
     */
    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    /**
     * Crear una transaccion del nodo actual
     * 
     * @param receptor el wallet receptor de la transaccion
     * @param cantidad el balance que se va a enviar
     * @throws TransactionException excepcion de transacccion
     * @return la transaccion que se ha generado
     */
    public Transaction createTransaction(Wallet receptor, int cantidad) throws TransactionException {
        return this.createTransaction(receptor.getPublicKey(), cantidad);
    }

    /**
     * Crear una transaccion del nodo actual
     * 
     * @param receptor el receptor de la transaccion
     * @param cantidad el balance que se va a enviar
     * @throws TransactionException excepcion de transaccion 
     * @return la transaccion que se ha generado
     */
    public Transaction createTransaction(String receptor, int cantidad) throws TransactionException {
        return new Transaction(this.wallet, receptor, cantidad);
    }
    
    /**
     * Comprueba si un nodo es igual a un nodo
     * 
     * @param nodo el nodo que se va a comprobar
     * @return false si no pertenece
     * @throws DuplicateConnectionException excepcion de nodo duplicado
     */
    @Override
    public boolean nodeIn(Node nodo) throws DuplicateConnectionException {
        if (this == nodo) {
            throw new DuplicateConnectionException(nodo);
        }
        return false;
    }

    /**
     * Distribuye el proceso del nodo
     * 
     * @param msg el mensaje que va a distribuir
     */
    @Override
    public void broadcast(IMessage msg) {
        msg.process(this);
    }

    /**
     * Procesa un mensaje
     * 
     * @param message el mensaje
     */
    public void process(IMessage message) {
        return;
    }

    /**
     * Devuelve la informacion de un nodo
     * 
     * @return una linea de texto de la informacion de un nodo
     */
    @Override
    public String toString() {
        return this.wallet+ " | @Node#"+ this.getId();
    }
}
