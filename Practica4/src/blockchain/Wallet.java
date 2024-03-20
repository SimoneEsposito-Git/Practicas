package blockchain;
import java.util.*;

public class Wallet {
    private String name;
    private String publicKey;
    private int balance;
    public Wallet(String name, String publicKey, int balance) {
        this.name = name;
        this.publicKey = publicKey;
        this.balance = balance;
    }
    public String getName() {
        return name;
    }
    public String getPublicKey() {
        return publicKey;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public String toString() {
        return "u: " + name + ", PK:" + publicKey + ", balance: " + balance;
    }
}