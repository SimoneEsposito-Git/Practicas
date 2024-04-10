package exception;

import blockchain.*;

/**
 * Excepcion de conexion de nodo
 * 
 * @author Lin Qi y Simone Esposito
 */
public class ConnectionException extends NodeConnectionException{
    /**
     * Constructor de conexion excepcion
     * 
     * @param nodo el nodo que genera el error
     */
    public ConnectionException(Node nodo) {
        super(nodo);
    }

    /**
     * Informacion de una excepcion de conexion
     * 
     * @return String de informacion de excepcion de conexion
     */
    @Override
    public String toString() {
        return super.toString() + " is connected to a different network";
    }
}
