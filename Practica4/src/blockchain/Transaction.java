package blockchain;
import java.util.*;

public class Transaction {
    private Wallet sender;
    private Wallet receiver;
    private int amount;
    public Transaction(Wallet sender, Wallet receiver, int amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        if (sender.getBalance() < amount) {
            throw new IllegalArgumentException("Not enough balance in the sender's wallet");
        }
        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);
    }
    public String toString() {
        return "Transaction: " + sender.getName() + " sent " + amount + " coins to " + receiver.getName();
    }
}