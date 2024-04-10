package blockchain;

/**
 * Mensaje de validar un bloque
 * 
 * @author Lin Qi y Simone Esposito
 */
public class ValidateBlockRq implements IMessage {
    private Block block;
    private MiningNode node;

    /**
     * Constructor de mensaje de validar
     * 
     * @param block el bloque que se va a validar
     * @param node el nodo que ha generado el bloque
     */
    public ValidateBlockRq(Block block, MiningNode node) {
        this.block = block;
        this.node = node;
        System.out.println(this.getMessage());
    }

    /**
     * Devuelve el bloque
     * 
     * @return el bloque
     */
    public Block getBlock() {
        return this.block;
    }

    /**
     * Devuelve el nodo
     * 
     * @return el nodo
     */
    public MiningNode getNode() {
        return this.node;
    }

    /**
     * Devuelve el mensaje
     * 
     * @return el mensaje
     */
    @Override
    public String getMessage() {
        return "["+this.node.fullName()+"] Mined block: id:"+this.block.getId()+", v:"+this.block.getVersion()+", nonce:"+this.block.getNonce()+", ts:"+this.block.getTimeStamp()+", hash:"+this.block.getHash()+", minerK:"+this.node.getWallet().getPublicKey();
    }

    /**
     * Procesa un nodo
     * 
     * @param n el nodo que se procesa
     */
    @Override
    public void process(Node n) {
        System.out.println("["+n.fullName()+"] Received Task: "+this+": <b:"+this.block.getId()+", src:"+this.node.getId()+">");
        n.process(this);
    }

    /**
     * La informacion de mensaje de validar
     * 
     * @return string de la informacion de mensahe de validar
     */
    @Override
    public String toString() {
        return "ValidateBlockRq";
    }
}
