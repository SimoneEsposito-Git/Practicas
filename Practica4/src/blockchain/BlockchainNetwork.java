package blockchain;
import java.util.*;

public class BlockchainNetwork {
    private String name;
    //private List<AbstractNode> nodes;
    //private List<Subnet> subnets;
    private List<NetworkElement> elements;

    public BlockchainNetwork(String networkName) {
        this.name = networkName;
        this.elements = new ArrayList<>();
        //this.nodes = new ArrayList<>();
        //this.subnets = new ArrayList<>();
    }
    public BlockchainNetwork connect(NetworkElement element) {
        elements.add(element);
        System.out.println(this.name + " - new peer connected: " + element);
        return this;
    }
    /*
    public BlockchainNetwork connect(AbstractNode node) {
        nodes.add(node);
        System.out.println(this.name + " - new peer connected: " + node);
        return this;
    }
    public BlockchainNetwork connect(Subnet subnet) {
        subnets.add(subnet);
        System.out.println(this.name + " - new peer connected: " + subnet);
        return this;
    }
    
    public void mineBlock() {
        List<Transaction> block = new ArrayList<>(transactions);
        transactions.clear();
        for (Node node : nodes) {
            if (node instanceof MiningNode) {
                MiningNode miningNode = (MiningNode) node;
                block.add(new Transaction(null, miningNode.getWallet(), 10));
            }
        }
        System.out.println("Block mined with transactions: " + block);
    }*/
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name + " consists of " + elements.size() + " elements:\n");
        for (NetworkElement element : elements) {
            sb.append("* " + element + "\n");
        }
        return sb.toString();
    }
}
