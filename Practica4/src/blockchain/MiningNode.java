package blockchain;

/**
 * Un nodo minador que permite gestionar y validar las transactions
 * 
 * @author Lin Qi y Simone Esposito
 */
public class MiningNode extends Node{
    private int capacidadComputacional;

    /**
     * Constructor de un nodo minador
     * 
     * @param wallet el wallet asociado al nodo
     * @param capacidad la maxima capacidad del nodo
     */
    public MiningNode(Wallet wallet, int capacidad) {
        super(wallet);
        this.capacidadComputacional = capacidad;
    }

    /**
     * Devuelve el nombre completo de un node minador
     * 
     * @return el nombre completo de un nodo minador
     */
    @Override
    public String fullName() {
        return "MiningNode#"+this.getId();
    }

    /**
     * Devuelve la informacion de un nodo minador
     * 
     * @return una linea de texto de informacion de nodo minador
     */
    @Override
    public String toString() {
        return this.wallet+ " | @MiningNode#"+ this.getId();
    }
}