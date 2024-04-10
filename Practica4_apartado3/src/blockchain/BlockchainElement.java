package blockchain;

import exception.*;

/**
 * Una clase auxiliar para organizar en blockchain network
 * 
 * @author Lin Qi y Simone Esposito
 */
public abstract class BlockchainElement implements IConnectable {
    private static int contador = 0;
    private final String id;
    private IConnectable padre = null;

    /**
     * Constructor de BlockchainElement
     */
    public BlockchainElement() {
        this.id = String.format("%03d", BlockchainElement.contador);
        BlockchainElement.contador++;
    }

    /**
     * Anyade un padre
     * 
     * @param padre el padre
     */
    public void setPadre(IConnectable padre) {
        this.padre = padre;
    }

    /**
     * Devuelve el padre
     * 
     * @return el padre
     */
    @Override
    public IConnectable getParent() {
        return this.padre;
    }

    /**
     * Devuelve el id de BlockchainElement
     * 
     * @return el id de BlockchainElement
     */
    public String getId() {
        return this.id;
    }

    /**
     * Comprueba si un nodo pertenece a un elemento
     * 
     * @param nodo el nodo que se va a comprobar
     * @return false si no, true si si
     * @throws ConnectionException excepcion de conexion
     * @throws DuplicateConnectionException excepcion de nodo duplicado
     */
    public abstract boolean nodeIn(Node nodo) throws ConnectionException, DuplicateConnectionException;
}
