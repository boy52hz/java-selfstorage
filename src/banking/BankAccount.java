package banking;

import Base.Person;
import java.math.BigDecimal;

public class BankAccount {

    private static int nextAccountNo = 1001;
    private final int accountNo;
    private final Person accountOwner;
    private final String accountName;
    private BigDecimal balance;

    public BankAccount(Person accountOwner, String accountName, double initialDeposit) {
        BigDecimal initialDepositBD = BigDecimal.valueOf(initialDeposit > 0 ? initialDeposit : 0);
        this.accountNo = nextAccountNo++;
        this.accountOwner = accountOwner;
        this.accountName = accountName != null && !accountName.trim().isEmpty() ? accountName : accountOwner.getFirstname() + " " + accountOwner.getLastname();
        this.balance = initialDepositBD.compareTo(BigDecimal.ZERO) > 0 ? initialDepositBD : BigDecimal.ZERO;
    }

    public BankAccount(Person accountOwner, String accountName) {
        this(accountOwner, accountName, 0);
    } 
    
    public BankAccount(Person accountOwner, double initialDeposit) {
        this(accountOwner, null, initialDeposit);
    } 
    
    public BankAccount(Person accountOwner) {
        this(accountOwner, null, 0);
    }

    public BankAccount deposit(double amount) {
        if (amount <= 0) return null;
        BigDecimal amountBD = BigDecimal.valueOf(amount);
        this.balance = this.balance.add(amountBD);
        return this;
    }

    public BankAccount withdraw(double amount) {
        if (amount <= 0) return null;
        BigDecimal amountBD = BigDecimal.valueOf(amount);
        if (amountBD.compareTo(this.balance) > 0) return null;
        this.balance = this.balance.subtract(amountBD);
        return this;
    }
    
    public int getAccountNo() { return accountNo; }
    public Person getAccountOwner() { return accountOwner; }
    public String getAccountName() { return accountName; }
    public double getBalance() { return balance.doubleValue(); }
    
}
