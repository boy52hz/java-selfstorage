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
        this.accountNo = nextAccountNo++;
        this.accountOwner = accountOwner;
        this.accountName = accountName;

        if (initialDeposit > 0) {
            this.balance = BigDecimal.valueOf(initialDeposit);
        } else {
            this.balance = BigDecimal.ZERO;
        }
    }

    public BankAccount(Person accountOwner, String accountName) {
        this(accountOwner, accountName, 0);
    }

    public BankAccount(Person accountOwner, double initialDeposit) {
        this(accountOwner, accountOwner.getFullname(), initialDeposit);
    }

    public BankAccount(Person accountOwner) {
        this(accountOwner, accountOwner.getFullname(), 0);
    }

    public BankAccount deposit(double amount) {
        if (amount <= 0) {
            return null;
        }

        BigDecimal amountBD = BigDecimal.valueOf(amount);
        this.balance = this.balance.add(amountBD);

        return this;
    }

    public BankAccount withdraw(double amount) {
        if (amount <= 0) {
            return null;
        }

        BigDecimal amountBD = BigDecimal.valueOf(amount);
        
        if (amountBD.compareTo(this.balance) > 0) {
            return null;
        }
        
        this.balance = this.balance.subtract(amountBD);

        return this;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public Person getAccountOwner() {
        return accountOwner;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance.doubleValue();
    }

}
