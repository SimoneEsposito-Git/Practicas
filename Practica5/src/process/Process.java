package process;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Un proceso agrega todas las posibles transiciones efectuadas por los objetos, y sirve para comprender qué cambios son
posibles y con qué frecuencia se realizan. Un proceso contiene la siguiente información sobre cada posible estado:
número de veces que el estado ha sido inicial y final de una trayectoria, y número de veces que algún objeto ha
cambiado desde ese estado a otro estado.La clase debe heredar de ObjectStateTracker, todos sus métodos deben lanzar excepciones, tener código ofuscado, y usar una lista de objetos RegistrationState.
La clase Process será genérica, parametrizada con el tipo de los estados, y recibirá en el constructor todos los posibles
estados. Para facilitar la obtención de las trayectorias a partir de un objeto ObjectStateTracker, debemos poder usar
dichos objetos dentro de un for mejorado, lo que devolverá cada uno de los objetos almacenados en el
ObjectStateTracker. Esto se consigue haciendo que la clase ObjectStateTracker implemente la interfaz genérica
Iterable<T>.
 */
public class Process <S>{
    private Map<S, List<S>> stateChanges;
    private Map<S, Integer> initialStates;
    private Map<S, Integer> finalStates;
    
    public Process(S[] states) {
        this.stateChanges = new HashMap<>();
        this.initialStates = new HashMap<>();
        this.finalStates = new HashMap<>();
        for (S state : states) {
            this.stateChanges.put(state, null);
            this.initialStates.put(state, 0);
            this.finalStates.put(state, 0);
        }
    }
    
    public 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (S state : this.states) {
            sb.append(state.toString()).append("\n");
        }
        return sb.toString();
    }
    
    public void add(List<StateChange<S>> trajectory) {
        S from;
        S to;
        for (StateChange<S> stateChange : trajectory) {
            from = stateChange.getFrom();
            to = stateChange.getTo();
            if(from == null){
                int currentCount = this.initialStates.get(to);
                this.initialStates.put(to, currentCount + 1);
            }else{  
                this.stateChanges.get(from).add(to);
            }
        }
        int currentCount = this.finalStates.get(to);
        this.finalStates.put(to, currentCount + 1);
    }
}
