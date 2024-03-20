package blockchain;
import java.util.*;

public class Node extends AbstractNode{

    public Node(Wallet wallet) {
        super(wallet);
    }
    
    public String toString() {
        return this.getWallet() + " | @Node#" + this.getId(); 
    }
}