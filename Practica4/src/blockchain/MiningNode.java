package blockchain;
import java.util.*;

public class MiningNode extends AbstractNode {
    private int miningPower;

    public MiningNode(Wallet wallet, int miningPower) {
        super(wallet);
        this.miningPower = miningPower;
    }
    
    public int getMiningPower() {
        return this.miningPower;
    }
    
    public String toString() {
        return this.getWallet() + " | @MiningNode#" + this.getId(); 
    }
}