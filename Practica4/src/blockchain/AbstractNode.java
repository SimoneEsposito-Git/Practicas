package blockchain;
import java.util.*;

public abstract class AbstractNode extends NetworkElement{
    private Wallet wallet;
    private String id;
    private static int cantidad = 0;

    public AbstractNode(Wallet wallet) {
        this.wallet = wallet;
        this.id = String.format("%03d", cantidad);
        this.cantidad++;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public String fullName() {
        return "Node#" + this.getId();
    }

    public String getId(){
        return id;
    }

    public abstract String toString(); 
}