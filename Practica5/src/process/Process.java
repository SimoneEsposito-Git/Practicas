package process;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import object.StateChange;

/**
 * Proceso de cambios de estado
 * 
 * @author Lin Qi y Simone Esposito
 */
public class Process<S extends Comparable<S>> {
    private Map<S, List<S>> stateChanges;
    private Map<S, Integer> initialStates;
    private Map<S, Integer> finalStates;

    /**
     * Constructor de un proceso
     * 
     * @param states los estados involucrados en el proceso
     */
    public Process(S[] states) {
        this.stateChanges = new LinkedHashMap<>();
        this.initialStates = new LinkedHashMap<>();
        this.finalStates = new LinkedHashMap<>();
        for (S state : states) {
            this.stateChanges.put(state, new ArrayList<>());
            this.initialStates.put(state, 0);
            this.finalStates.put(state, 0);
        }
    }

    /**
     * Devuelve la representación en cadena del proceso
     * 
     * @return una cadena que representa el proceso
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (S state : this.stateChanges.keySet()) {
            sb.append(state)
              .append(" (initial ")
              .append(this.initialStates.get(state))
              .append(" times, final ")
              .append(this.finalStates.get(state))
              .append(" times):\n");

            List<S> nextStates = this.stateChanges.get(state);
            if (nextStates != null) {
                Map<S, Integer> nextStateCounts = new LinkedHashMap<>();
                for (S nextState : nextStates) {
                    nextStateCounts.put(nextState, nextStateCounts.getOrDefault(nextState, 0) + 1);
                }
                for (Map.Entry<S, Integer> entry : nextStateCounts.entrySet()) {
                    sb.append(" to state ")
                      .append(entry.getKey())
                      .append(": ")
                      .append(entry.getValue())
                      .append(" times\n");
                }
            }
        }
        return sb.toString();
    }

    /**
     * Añade una trayectoria de cambios de estado al proceso
     * 
     * @param trajectory lista de cambios de estado
     */
    public void add(List<StateChange<S>> trajectory) {
        S from = null;
        S to = null;
        for (StateChange<S> stateChange : trajectory) {
            from = stateChange.getInitial();
            to = stateChange.getFinals();
            if (from == null) {
                int currentCount = this.initialStates.get(to);
                this.initialStates.put(to, currentCount + 1);
            } else {
                this.stateChanges.get(from).add(to);
            }
        }
        int currentCount = this.finalStates.get(to);
        this.finalStates.put(to, currentCount + 1);
    }
}
