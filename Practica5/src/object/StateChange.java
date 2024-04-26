package object;

import java.time.LocalDateTime;

/**
 * Una trayectoria de estados
 * 
 * @author Lin Qi y Simone Esposito
 */
public class StateChange<S extends Comparable<S>> {
    private S initial;
    private S finals;
    private LocalDateTime time;

    /**
     * Constructor de una trayectoria
     * 
     * @param initial el estado inicial
     * @param finals el estado final
     */
    public StateChange(S initial, S finals) {
        this.initial = initial;
        this.finals = finals;
        this.time = LocalDateTime.now();
    }

    /**
     * Devuelve el estado inicial
     * 
     * @return el inicial
     */
    public S getInitial() {
        return this.initial;
    }

    /**
     * Devuelve el estado final
     * 
     * @return el final
     */
    public S getFinals() {
        return this.finals;
    }

    /**
     * Devuelve la informacion de una trayectoria
     * 
     * @return un string de informacion de una trayectoria
     */
    @Override
    public String toString() {
        if (this.initial == null) {
            return "(in: "+this.finals+" at: "+this.time+")";
        }
        else {
            return "(from: "+this.initial+" to: "+this.finals+" at: "+this.time+")";
        }
    }
}
