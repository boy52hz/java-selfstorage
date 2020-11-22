package membership;

import membership.TransactionType;

public class TransactionHistory {

    private AccountTransaction[] transactions;
    private int count;

    public TransactionHistory(int size) {
        this.transactions = new AccountTransaction[size];
    }

    public void add(AccountTransaction txn) {
        if (isFull()) return;
        transactions[count++] = txn;
    }
    
    public boolean isFull() { return count == transactions.length; }
    public int getCount() { return count; }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(transactions[i]);
            result.append("\n");
        }
        return result.toString();
    }
    
    
}
