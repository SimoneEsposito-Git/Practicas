package blockchain;
import java.util.*;

public class Subnet extends NetworkElement{
    private int id;
    private AbstractNode[] nodes;

    public Subnet(AbstractNode... nodes) {
        this.id = id;
        this.nodes = nodes;
    }

    public int getId() {
        return id;
    }

    public AbstractNode[] getNodes() {
        return nodes;
    }

    public String toString() {
        return "Node network of " + nodes.length + " nodes: " + Arrays.toString(nodes);
    }
}