package membership;

import Base.Person;
import java.math.BigDecimal;

public class MemberAccount {

    private static int nextAccountNo = 10001;
    private final int accountNo;
    private final Person accountOwner;
    private final String accountName;
    private final TransactionHistory history;
    private BigDecimal balance;

    public MemberAccount(Person accountOwner, BigDecimal initialDeposit) {
        this.accountNo = nextAccountNo++;
        this.accountOwner = accountOwner;
        this.accountName = accountOwner.getFirstname() + " " + accountOwner.getLastname();
        this.balance = initialDeposit.compareTo(BigDecimal.ZERO) > 0 ? initialDeposit : BigDecimal.ZERO;
        this.history = new TransactionHistory(100);
        this.history.add(new AccountTransaction(TransactionType.OPEN, BigDecimal.ZERO));
        if (initialDeposit.compareTo(BigDecimal.ZERO) > 0) {
            this.history.add(new AccountTransaction(TransactionType.DEPOSIT, this.balance));
        }
    }

    public MemberAccount(Person accountOwner, double initialDeposit) {
        this(accountOwner, BigDecimal.valueOf(initialDeposit));
    }
    
    public MemberAccount(Person accountOwner) {
        this(accountOwner, BigDecimal.ZERO);
    }

    public MemberAccount deposit(double amount) {
        if (amount <= 0) return null;
        BigDecimal amountBD = BigDecimal.valueOf(amount);
        this.balance = this.balance.add(amountBD);
        this.history.add(new AccountTransaction(TransactionType.DEPOSIT, amountBD));
        return this;
    }

    public MemberAccount renew(double amount) {
        if (amount <= 0) return null;
        BigDecimal amountBD = BigDecimal.valueOf(amount);
        if (amountBD.compareTo(this.balance) > 0) return null;
        this.balance = this.balance.subtract(amountBD);
        this.history.add(new AccountTransaction(TransactionType.RENEW, amountBD));
        return this;
    }
    
    public int getAccountNo() { return accountNo; }
    public Person getAccountOwner() { return accountOwner; }
    public String getAccountName() { return accountName; }
    public BigDecimal getBalance() { return balance; }
    public String getTransactionHistory() {
        return history.toString();
    }
    
}
