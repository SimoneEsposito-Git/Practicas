package blockchain;

import java.util.*;

import javax.swing.Icon;

import exception.*;

/**
 * Una subred contiene los nodos
 * 
 * @author Lin Qi y Simone Esposito
 */
public class Subnet extends BlockchainElement {
    private List<Node> nodos;

    /**
     * Constructor de subred que reciben unos nodos
     * 
     * @param nodos los nodos de la subred
     */
    public Subnet(Node... nodos) {
        this.nodos = new ArrayList<>(Arrays.asList(nodos));
        for (Node nodo: this.nodos) {
            nodo.setPadre(this);
        }
    }

    /**
     * Distribuye el mensaje a sus nodos
     * 
     * @param msg el mensaje que va a procesar
     */
    @Override
    public void broadcast(IMessage msg) {
        System.out.println("[Subnet#"+this.getId()+"] "+msg.getMessage());
        System.out.println("Broadcasting to "+this.nodos.size()+" nodes:");
        for (Node nodo: this.nodos) {
            nodo.broadcast(msg);
        }
    }

    /**
     * Comprueba si un nodo pertence a una subred
     * 
     * @param nodo el nodo que se va a comprobar
     * @return false si no pertenece
     * @throws ConnectionException excepcion de conexion
     */
    @Override
    public boolean nodeIn(Node nodo) throws ConnectionException {
        for (Node node: this.nodos) {
            if (node == nodo) {
                throw new ConnectionException(nodo);
            }
        }
        return false;
    }

    /**
     * Devuelve la informacion de una subred
     * 
     * @return un string que contiene la informacion de una subred
     */
    @Override
    public String toString() {
        String str = "Node network of "+nodos.size()+" nodes:";
        for (Node node: this.nodos) {
            str += " ["+node.toString()+"]";
        }
        return str;
    }
}
