package object;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
 * This class is a generic object state tracker. It allows you to track the state of objects of a specific type.
 * 
 * @author Lin Qi y Simone Esposito
 * 
 */

public class ObjectStateTracker<T, S extends Comparable<S>> {
    private Map<T, S> stateMap;
    private List<S> validStates;
    private List<Map.Entry<Predicate<T>, S>> conditions;
    private S defaultState;

    public ObjectStateTracker(S[] states) {
        this.validStates = Arrays.asList(states);
        this.stateMap = new HashMap<>();
        this.conditions = new ArrayList<>();
    }

    public ObjectStateTracker<T, S> withState(S state, Predicate<T> condition) {
        if (!validStates.contains(state)) {
            throw new IllegalStateException("Invalid state: " + state);
        }
        conditions.add(new AbstractMap.SimpleEntry<>(condition, state));
        return this;
    }

    public ObjectStateTracker<T, S> elseState(S state) {
        if (!validStates.contains(state)) {
            throw new IllegalStateException("Invalid state: " + state);
        }
        defaultState = state;
        return this;
    }

    public void updateStates() {
        for (Map.Entry<T, S> entry : stateMap.entrySet()) {
            T object = entry.getKey();
            boolean matched = false;
            for (Map.Entry<Predicate<T>, S> condition : conditions) {
                if (condition.getKey().test(object)) {
                    stateMap.put(object, condition.getValue());
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                stateMap.put(object, defaultState);
            }
        }
    }

    /**
     * Adds or updates the state of a specific object. Initially, this will just set the object's state to the default state.
     * @param object the object to be tracked or updated.
     */
    @SafeVarargs
    public final void addObjects(T... objects) {
        // put all the objects in the map with the right state. no duplicates allowed
        
        for (T object : objects) {
            System.out.println("Adding object with hashcode: " + object.hashCode());

            if (!stateMap.containsKey(object)) {
                stateMap.put(object, defaultState);
            }
        }
        updateStates();
    }

    /**
     * Returns the current state of the specified object.
     * @param object the object whose state is to be retrieved.
     * @return the current state of the object, or null if it has not been set or object is not tracked.
     */
    public S getState(T object) {
        return stateMap.getOrDefault(object, defaultState);
    }

    @Override
    public String toString() {
        Map<S, List<T>> groupedByState = new TreeMap<>();
        for (S state : validStates) {
            groupedByState.put(state, new ArrayList<>()); 
        }
        for (Map.Entry<T, S> entry : stateMap.entrySet()) {
            groupedByState.get(entry.getValue()).add(entry.getKey());
        }

        return groupedByState.entrySet().stream()
                .map(entry -> entry.getKey() + "=[" + entry.getValue().stream()
                        .map(Object::toString)  
                        .collect(Collectors.joining(", ")) + "]")
                .collect(Collectors.joining(", ", "{", "}"));
    }
}
