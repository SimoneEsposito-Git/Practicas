package blockchain;

/**
 * Mensaje de resultado de validar un bloque
 * 
 * @author Lin Qi y Simone Esposito
 */
public class ValidateBlockRes implements IMessage {
    private Block block;
    private boolean res;
    private MiningNode node;

    /**
     * Constructor de mensaje de resultado de validar un bloque
     */
    public ValidateBlockRes(Block block, boolean res, MiningNode node) {
        this.block = block;
        this.res = res;
        this.node = node;
        System.out.println(this.getMessage());
    }

    /**
     * Devuelve el bloque del mensaje
     * 
     * @return el bloque del mensaje
     */
    public Block getBlock() {
        return this.block;
    }

    /**
     * Devuelve el resultado de validar
     * 
     * @return el resultado
     */
    public boolean getRes() {
        return this.res;
    }

    /**
     * Devuelve el mensaje
     * 
     * @return el mensaje
     */
    @Override
    public String getMessage() {
        return "["+this.node.fullName()+"] Emitted Task: "+this+": <b:"+this.block.getId()+", res:"+this.res+", src:broadcast>";
    }

    /**
     * Procesa un nodo
     * 
     * @param n nodo que se procesa
     */
    @Override
    public void process(Node n) {
        Transaction transaction = this.block.getTransaction();
        Wallet wallet = n.getWallet();
        System.out.println("["+n.fullName()+"] Received Task: "+this+"<b:"+this.block.getId()+", res:"+this.res+", src:"+this.node.getId()+">");
        System.out.println("["+n.fullName()+"] Commiting transaction: Tx-"+transaction.getId()+" in "+n.fullName());
        System.out.println("["+n.fullName()+"] -> Tx details: "+transaction);
        if (this.res) {
            if (!n.getTransactions().contains(transaction)) {
                n.addTransaction(transaction);
            }
            if (wallet.getPublicKey().compareTo(transaction.getClaveEmisor()) == 0) {
                System.out.println("["+n.fullName()+"] Applied Transaction: "+transaction);
                wallet.setBalance(wallet.getBalance() - transaction.getCantidad());
                System.out.println("["+n.fullName()+"] New wallet value: "+wallet);
            }
            else if (wallet.getPublicKey().compareTo(transaction.getClaveReceptor()) == 0) {
                System.out.println("["+n.fullName()+"] Applied Transaction: "+transaction);
                wallet.setBalance(wallet.getBalance() + transaction.getCantidad());
                System.out.println("["+n.fullName()+"] New wallet value: "+wallet);
            }
        }
        
    }

    /**
     * Informacion de mensaje de resultado de validar
     * 
     * @return string de informacion de mensaje
     */
    @Override
    public String toString() {
        return "ValidateBlockRes";
    }

}