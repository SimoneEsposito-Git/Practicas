package exception;

import blockchain.*;

public class DuplicateConnectionException extends NodeConnectionException{
    /**
     * Constructor de excepcion de nodo duplicado
     * 
     * @param nodo el nodo que genera la excepcion
     */
    public DuplicateConnectionException(Node nodo) {
        super(nodo);
    }

    /**
     * Informacion de excepcion de nodo duplicado
     * 
     * @return string de informacion de excepcion de nodo duplicado
     */
    @Override
    public String toString() {
        return super.toString()+" is already connected to the network";
    }
}
