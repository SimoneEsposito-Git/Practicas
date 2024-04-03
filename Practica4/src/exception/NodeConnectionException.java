package exception;

import blockchain.*;

/**
 * Excepcion de conectar un nodo
 * 
 * @author Lin Qi y Simone Esposito
 */
public abstract class NodeConnectionException extends Exception{
    private Node nodo;

    /**
     * Constructor de nodo conexion excepcion
     * 
     * @param nodo el nodo que genera el error
     */
    public NodeConnectionException(Node nodo) {
        this.nodo = nodo;
    }

    /**
     * Informacion de excepcion
     * 
     * @return string de informacion de excepcion
     */
    @Override
    public String toString() {
        return "Connection exception: Node " + this.nodo.getId();
    }
}
