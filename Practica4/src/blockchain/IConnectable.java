package blockchain;

/**
 * Representa a las clases conectables
 * 
 * @author Lin Qi y Simone Esposito
 */
public interface IConnectable {
    /**
     * Distribuye el mensaje
     * 
     * @param msg el mensaje
     */
    public void broadcast(IMessage msg);

    /**
     * Devuelve el padre
     * 
     * @return el padre
     */
    public IConnectable getParent();

    /**
     * Devuelve el padre mas arriba
     * 
     * @return el pader mas arriba
     */
    public default IConnectable getTopParent() {
        IConnectable parent = getParent();
        while (parent!=null) {
            if (parent.getParent()==null) return parent;
            parent = parent.getParent();
        }
        return parent;
        }
}
    
