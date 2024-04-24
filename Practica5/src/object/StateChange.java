package object;

public class StateChange <S extends Enum<S>>{
    private S from;
    private S to;
    
    public StateChange(S from, S to) {
        this.from = from;
        this.to = to;
    }
    
    public S getFrom() {
        return this.from;
    }
    
    public S getTo() {
        return this.to;
    }
    
    @Override
    public String toString() {
        return this.from + " -> " + this.to;
    }    
}
