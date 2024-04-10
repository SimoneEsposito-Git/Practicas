package blockchain;

/**
 * Interfaz de motodos de validar
 * 
 * @author Lin Qi y Simone Esposito
 */
public interface IValidateMethod {
    /**
     * Valida a un bloque
     * 
     * @param miningMethod un metodo de minar
     * @param block el bloque a validar
     * @return true si se valida, false si no
     */
    public boolean validate(IMiningMethod miningMethod, Block block);
}
