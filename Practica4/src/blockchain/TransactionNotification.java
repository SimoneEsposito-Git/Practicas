package blockchain;

/**
 * Transaccion de notificacion
 * 
 * @author Lin Qi y Simone Esposito
 */
public class TransactionNotification implements IMessage {
    private Transaction transaction;

    public TransactionNotification(Transaction transaction) {
        this.transaction = transaction;
    }

    /**
     * Devuelve la mensaje
     * 
     * @return Devuelve el mensaje
     */
    @Override
    public String getMessage() {
        return this.transaction.toString();
    }

    /**
     * Procesar con el nodo anyadiendo la transaccion
     * 
     * @param el nodo que sa va a procesar
     */
    @Override
    public void process(Node n) {
        IMessage.super.process(n);
        n.addTransaction(transaction);
    }
}
