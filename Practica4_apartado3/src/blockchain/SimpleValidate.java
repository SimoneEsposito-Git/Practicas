package blockchain;

/**
 * Clase que valida simplemente
 * 
 * @author Lin Qi y Simone Esposito
 */
public class SimpleValidate implements IValidateMethod {
    /**
     * Validar un bloque
     * 
     * @param miningMethod el metodo de minar
     * @param block el bloque que se va a validar
     * @return true si se valida, false si no
     */
    @Override
    public boolean validate(IMiningMethod miningMethod, Block block) {
        if (block == null) {
            return false;
        }
        if (block.getHash() == null) {
            return false;
        }
        return miningMethod.createHash(block).compareTo(block.getHash()) == 0;
    }
}
