package blockchain;

import blockchain.utils.*;
import java.util.*;

/**
 * Clase de bloque
 * 
 * @author Lin Qi y Simone Esposito
 */
public class Block {
    private static int contador = 0;
    private static Block ultimoBloque = null;
    private static Random random = new Random(new Date().getTime());

    private final int id;
    private final int nonce;
    private int version;
    private long timeStamp;
    private int dificultad;
    private Transaction transaction;
    private boolean flag = false;
    private String hash;
    private Block bloqueAnterior;

    /**
     * Devuelve el ultimo bloque formado
     * 
     * @return el ultimo bloque generado
     */
    public static Block getUltimoBloque() {
        return Block.ultimoBloque;
    }

    /**
     * Constructor de bloque
     * 
     * @param transaction transaccion a partir de la cual se forma el bloque
     */
    public Block(Transaction transaction) {
        this.id = Block.contador;
        Block.contador++;
        this.nonce = Block.random.nextInt(1001);
        this.version = BlockConfig.VERSION;
        this.timeStamp = new Date().getTime()/1000;
        this.dificultad = BlockConfig.DIFFICULTY;
        this.transaction = transaction;
        this.bloqueAnterior = Block.ultimoBloque;
        Block.ultimoBloque = this;
    }

    /**
     * Constructor de bloque
     * 
     * @param transaction transaccion a partir de la cual se forma el bloque
     * @param bloqueAnterior el bloque anterior al actual
     */
    public Block(Transaction transaction, Block bloqueAnterior) {
        this.id = Block.contador;
        Block.contador++;
        this.nonce = Block.random.nextInt(1001);
        this.version = BlockConfig.VERSION;
        this.timeStamp = new Date().getTime()/1000;
        this.dificultad = BlockConfig.DIFFICULTY;
        this.transaction = transaction;
        this.bloqueAnterior = bloqueAnterior;
        Block.ultimoBloque = this;
    }

    /**
     * Cambian la bandera de un bloque
     * 
     * @param flag la bandera que va a cambiar
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    /**
     * Anyade el hash de bloque
     * 
     * @param hash el hash que se va a anyadir
     */
    public void setHash(String hash) {
        this.hash = hash;
    }

    /**
     * Devuelve el id
     * 
     * @return el id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Devuelve la transaccion
     * 
     * @return la transaccion
     */
    public Transaction getTransaction() {
        return this.transaction;
    }

    /**
     * Devuelve la version del bloque
     * 
     * @return la version del bloque
     */
    public int getVersion() {
        return this.version;
    }

    /**
     * Devuelve el timestamp del bloque
     * 
     * @return el timestamp
     */
    public long getTimeStamp() {
        return this.timeStamp;
    }

    /**
     * Devuelve la dificultad del bloque
     * 
     * @return la dificultad
     */
    public int getDificultad() {
        return this.dificultad;
    }

    /**
     * Devuelve si el bloque es validado
     * 
     * @return si es validado
     */
    public boolean getFlag() {
        return this.flag;
    }

    /**
     * Devuelve el nonce del bloque
     * 
     * @return el nonce
     */
    public int getNonce() {
        return this.nonce;
    }

    /**
     * Devuelve el hash del bloque
     * 
     * @return el hash
     */
    public String getHash() {
        return this.hash;
    }

    /**
     * Devuelve el bloque anterior a este
     * 
     * @return el bloque anterior
     */
    public Block getBloqueAnterior() {
        return this.bloqueAnterior;
    }
}
