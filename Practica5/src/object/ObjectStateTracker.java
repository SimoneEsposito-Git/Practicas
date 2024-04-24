package object;

import java.util.*;
import java.util.function.*;

/**
 * This class is a generic object state tracker. It allows you to track the state of objects of a specific type.
 * 
 * @author Lin Qi y Simone Esposito
 */
public class ObjectStateTracker<T, S extends Comparable<S>> implements Iterable<T>{
    private TreeMap<S, List<T>> stateMap;
    private TreeSet<S> validStates;
    private LinkedHashMap<Predicate<T>, S> conditions;
    private Map<T, S> elementStates;
    private Map<T, List<StateChange<S>>> trajectories;
    private S defaultState = null;

    /**
     * Constructor de state tracker
     * 
     * @param states los estados disponibles
     */
    public ObjectStateTracker(S[] states) {
        this.validStates = new TreeSet<>(Arrays.asList(states));
        this.stateMap = new TreeMap<>();
        this.elementStates = new HashMap<>();
        for (S element: this.validStates) {
            this.stateMap.putIfAbsent(element, new ArrayList<>());
        }
        this.conditions = new LinkedHashMap<>();
        this.trajectories = new HashMap<>();
    }

    /**
     * Anyade una condicion al tracker
     * 
     * @param state el estado que cambia
     * @param condition la condicion que se cumple
     * @return si mismo
     */
    public ObjectStateTracker<T, S> withState(S state, Predicate<T> condition) {
        if (!validStates.contains(state)) {
            throw new IllegalStateException("Invalid state: " + state);
        }
        this.conditions.put(condition, state);
        return this;
    }

    /**
     * Anyade un estado por defecto
     * 
     * @param state el estado por defecto
     * @return si mismo
     */
    public ObjectStateTracker<T, S> elseState(S state) {
        if (!validStates.contains(state)) {
            throw new IllegalStateException("Invalid state: " + state);
        }
        this.defaultState = state;
        return this;
    }

    /**
     * Actualiza los estados de los elementos
     */
    public void updateStates() {
        for (T element: this.elementStates.keySet()) {
            this.updateStates(element);
        }
    }

    /**
     * Actualiza para solo un elemento especifico
     * 
     * @param element elemento que se actualiza
     */
    private void updateStates(T element) {
        S estadoActual = this.elementStates.get(element);
        for (Predicate<T> condition: this.conditions.keySet()) {
            if (condition.test(element)) {
                S estadoNuevo = this.conditions.get(condition);
                if (estadoActual != estadoNuevo) {
                    this.trajectories.get(element).add(new StateChange<S>(estadoActual, estadoNuevo));
                    if (estadoActual != null) {
                        this.stateMap.get(estadoActual).remove(element);
                    }
                    this.stateMap.get(estadoNuevo).add(element);
                    this.elementStates.put(element, estadoNuevo);
                }
                return;
            }
        }
        if (estadoActual != this.defaultState) {
            if (estadoActual != null) {
                this.stateMap.get(estadoActual).remove(element);
            }
            this.stateMap.get(this.defaultState).add(element);
            this.elementStates.put(element, this.defaultState);
        }
    }

    /**
     * Anyade y actutaliza los estados de un elemento
     * 
     * @param objects los objetos que se anyaden
     */
    @SafeVarargs
    public final void addObjects(T... objects) {
        for (T object : objects) {
            if (!this.elementStates.containsKey(object)) {
                this.elementStates.put(object, null);
                this.trajectories.put(object, new ArrayList<>());
                this.updateStates(object);
            }
        }
    }

    /**
     * Obtener el estado actual de un objeto
     * 
     * @param object el objeto cuyo estado se saca
     * @return el estado del objeto o null si no esta en el tracker
     */
    public S getState(T object) {
        if (this.elementStates.containsKey(object)) {
            return this.elementStates.get(object);
        }
        return null;
    }

    /**
     * Devuelve la trayectoria de un objeto
     * 
     * @param object el objeto cuya trayectoria queremos sacar
     * @return la trayactoria del objeto
     */
    public List<StateChange<S>> trajectory(T object) {
        return this.trajectories.get(object);
    }

    /**
     * Devuelve el iterator de state tracker
     * 
     * @return el iterator
     */
    @Override
    public Iterator<T> iterator() {
        return this.elementStates.keySet().iterator();
    }

    /**
     * Devuelve la informacion de un state tracker
     * 
     * @return un string con la informacion de state tracker
     */
    @Override
    public String toString() {
       return this.stateMap.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Iterator<List<T>> stateIterator = stateMap.values().iterator();
            private Iterator<T> elementIterator = stateIterator.next().iterator();

            @Override
            public boolean hasNext() {
                if (elementIterator.hasNext()) {
                    return true;
                }
                while (stateIterator.hasNext()) {
                    elementIterator = stateIterator.next().iterator();
                    if (elementIterator.hasNext()) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public T next() {
                if (!elementIterator.hasNext()) {
                    elementIterator = stateIterator.next().iterator();
                }
                return elementIterator.next();
            }
        };
    }
}
