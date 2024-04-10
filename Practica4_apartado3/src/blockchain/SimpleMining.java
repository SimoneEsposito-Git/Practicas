package blockchain;

import blockchain.utils.*;

/**
 * Clase de minador simple
 * 
 * @author Lin Qi y Simone Esposito
 */
public class SimpleMining implements IMiningMethod {
    /**
     * Genera el hash de un bloque
     * 
     * @param block el bloque para crear un hash
     * @return el hash del bloque
     */
    @Override
    public String createHash(Block block) {
        if (block.getBloqueAnterior() == null) {
            return CommonUtils.sha256(block.getVersion()+BlockConfig.GENESIS_BLOCK+block.getTimeStamp()+block.getDificultad()+block.getNonce());
        }
        else {
            return CommonUtils.sha256(block.getVersion()+block.getBloqueAnterior().getHash()+block.getTimeStamp()+block.getDificultad()+block.getNonce());
        }
    }

    /**
     * Minar una transaccion
     * 
     * @param transaction la transaccion que se mina
     * @param previousConfirmedBlock el bloque anterior
     * @param minerKey la clave del nodo
     * @return un bloque que se forma al minar
     */
    @Override
    public Block mineBlock(Transaction transaction, Block previousComfirmedBlock, String minerKey) {
        Block block = new Block(transaction, previousComfirmedBlock);
        block.setHash(this.createHash(block));
        return block;
    }
}
