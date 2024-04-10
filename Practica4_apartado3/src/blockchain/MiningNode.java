package blockchain;

import java.util.*;
import blockchain.utils.BlockConfig;

/**
 * Un nodo minador que permite gestionar y validar las transactions
 * 
 * @author Lin Qi y Simone Esposito
 */
public class MiningNode extends Node {
    private int capacidadComputacional;
    private IMiningMethod miningMethod;
    private IValidateMethod validateMethod;
    private List<Block> blocks = new ArrayList<>();

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
     * Anyade un metodo de minar
     * 
     * @param method el metodo de minar que se anyade
     */
    public void setMiningMethod(IMiningMethod method) {
        this.miningMethod = method;
    }

    /**
     * Anyade un metodo de validar
     * 
     * @param method el metodo de validar que se anyade
     */
    public void setValidationMethod(IValidateMethod method) {
        this.validateMethod = method;
    }

    /**
     * Devuelve el metodo de minar
     * 
     * @return el metodo de minar
     */
    public IMiningMethod getMiningMethod() {
        return this.miningMethod;
    }

    /**
     * Devuelve el metodo de validar
     * 
     * @return el metodo de validar
     */
    public IValidateMethod getValidateMethod() {
        return this.validateMethod;
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
     * Procesa un mensaje de notificacion
     * 
     * @param transactionNotification el mensaje de notificacion
     */
    public void process(TransactionNotification transactionNotification) {
        if (this.getTransactions().contains(transactionNotification.geTransaction())) {
            System.out.println("Transaction already confirmed: Tx-"+transactionNotification.geTransaction().getId());
            return;
        }
        Block ultimoBlock = Block.getUltimoBloque();
        Block block = this.miningMethod.mineBlock(transactionNotification.geTransaction(), ultimoBlock, this.getWallet().getPublicKey());
        IConnectable topPadre = this.getTopParent();
        if (topPadre != null) {
            topPadre.broadcast(new ValidateBlockRq(block, this));
        }
    }

    /**
     * Procesa el mensaje de validar
     * 
     * @param validateBlockRq el mensaje de validar
     */
    public void process(ValidateBlockRq validateBlockRq) {
        if (this == validateBlockRq.getNode()) {
            System.out.println(this.fullName()+" You cannot validate your own block");
            return;
        }
        if (validateBlockRq.getBlock().getFlag()) {
            return;
        }
        boolean res = this.validateMethod.validate(validateBlockRq.getNode().getMiningMethod(), validateBlockRq.getBlock());
        validateBlockRq.getBlock().setFlag(res);
        IConnectable topPadre = this.getTopParent();
        if (topPadre != null) {
            topPadre.broadcast(new ValidateBlockRes(validateBlockRq.getBlock(), res, this));
        }
    }

    /**
     * Devuelve la informacion de un nodo minador
     * 
     * @return una linea de texto de informacion de nodo minador
     */
    @Override
    public String toString() {
        return this.getWallet() + " | @MiningNode#"+ this.getId();
    }
}