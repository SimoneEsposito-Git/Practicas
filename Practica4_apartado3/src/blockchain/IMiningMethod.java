package blockchain;

/**
 * Interfaz de minador
 * 
 * @author Lin Qi y Simone Esposito
 */
public interface IMiningMethod {
    /**
     * Crear un hash string
     * 
     * @param block el bloque que se genera el hash
     * @return el string hash que se genera
     */
    String createHash(Block block);

    /**
     * Minar una transaccion
     * 
     * @param transaction la transaccion que se mina
     * @param previousConfirmedBlock el bloque anterior
     * @param minerKey string hash
     * @return
     */
    Block mineBlock(Transaction transaction, Block previousConfirmedBlock, String minerKey);
}
