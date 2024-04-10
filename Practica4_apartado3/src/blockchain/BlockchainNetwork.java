package blockchain;

import java.util.*;

import exception.*;

/**
 * Un blockchain network
 * 
 * @author Lin Qi y Simone Esposito
 */
public class BlockchainNetwork implements IConnectable {
    private String nombre;
    private List<BlockchainElement> elementos;

    /**
     * Constructor de blockchain network
     * 
     * @param nombre el nombre del network
     */
    public BlockchainNetwork(String nombre) {
        this.nombre = nombre;
        this.elementos = new ArrayList<>();
    }

    /**
     * Conecta a un nodo
     * 
     * @param node el nodo que se va a conectar
     * @return si mismo si se ha anyadido correctamente, null en caso contrario
     */
    public BlockchainNetwork connect(Node node) throws ConnectionException, DuplicateConnectionException {
        this.nodeIn(node);
        this.elementos.add(node);
        System.out.println(this.nombre+" - new peer connected: "+node);
        node.setPadre(this);
        return this;
    }

    /**
     * Conecta a una subred
     * 
     * @param subnet la subred que se va a conectar
     * @return si mismo si se ha anyadido correctament, null en caso contrario
     */
    public BlockchainNetwork connect(Subnet subnet) {
        if (this.elementos.contains(subnet)) {
            return null;
        }
        this.elementos.add(subnet);
        System.out.println(this.nombre+"- new peer connected: "+subnet);
        subnet.setPadre(this);
        return this;
    }

    /**
     * Comprueba si un nodo perteneca a uno de sus elementos
     * 
     * @param nodo el nodo que se va a comrobar
     * @return false si no
     * @throws ConnectionException excepcion de conexion
     * @throws DuplicateConnectionException excepcion de nodo duplicado
     */
    public boolean nodeIn(Node nodo) throws ConnectionException, DuplicateConnectionException {
        for (BlockchainElement element: this.elementos) {
            element.nodeIn(nodo);
        }
        return false;
    }

    /**
     * Distribuye el mensaje a los nodos
     * 
     * @param msg el mensaje
     */
    @Override
    public void broadcast(IMessage msg) {
        for (BlockchainElement element: this.elementos) {
            element.broadcast(msg);
        }
    }

    /**
     * Devuelve el padre de blockchain network
     * 
     * @return null
     */
    @Override
    public IConnectable getParent() {
        return null;
    }

    /**
     * Devuelve la informacion de un blockchain network
     * 
     * @return un string que contiene la informacion de un blockchain network
     */
    @Override
    public String toString() {
        String str = this.nombre+" consists of "+this.elementos.size()+" elements:\n";
        for (BlockchainElement element: this.elementos) {
            str += "* "+element+"\n";
        }
        return str;
    }
}