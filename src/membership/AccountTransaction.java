package membership;

import java.math.BigDecimal;

public class AccountTransaction {

    private static int nextId = 1000001;
    private final int id;
    private final TransactionType type;
    private final BigDecimal amount;

    public AccountTransaction(TransactionType type, BigDecimal amount) {
        this.id = nextId++;
        this.type = type;
        this.amount = amount;
    }

    public int getId() { return id; }
    public TransactionType getType() { return type; }
    public BigDecimal getAmount() { return amount; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AccountTransaction{id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }
    
}
