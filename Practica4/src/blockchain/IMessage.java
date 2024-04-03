package blockchain;

/**
 * Intefaz que representa un mensaje
 * 
 * @author Lin Qi y Simone Esposito
 */
public interface IMessage {
    /**
     * Devuelve el mensaje
     * 
     * @return el mensaje
     */
    public String getMessage();

    /**
     * Procesar con el nodo
     * 
     * @param n el nodo con el cual va a procesar
     */
    public default void process(Node n) {
        System.out.println("["+n.fullName()+"]"+
                            " - Received notification - Nex Tx: "+
                            this.getMessage());
    }

    
}