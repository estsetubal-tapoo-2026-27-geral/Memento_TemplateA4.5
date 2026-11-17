/**
 * Originator: captures and restores its own mutable state.
 * The base version captures the balance only.
 */
public class BankAccount {
    private final String accountHolder;
    private double balance;

    // TODO Activity 2: keep the account movements in a list.

    public BankAccount(String accountHolder, double initialBalance) {
        if (accountHolder == null || accountHolder.isBlank()) {
            throw new IllegalArgumentException("Account holder must not be blank");
        }
        if (!Double.isFinite(initialBalance) || initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance must be finite and non-negative");
        }
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        checkAmount(amount);
        if (!Double.isFinite(balance + amount)) {
            throw new IllegalArgumentException("Resulting balance must be finite");
        }
        balance += amount;
        // TODO Activity 2: record a successful deposit using Movement.
    }

    /** Leaves the account unchanged when the available balance is insufficient. */
    public void withdraw(double amount) {
        checkAmount(amount);
        if (balance >= amount) {
            balance -= amount;
            // TODO Activity 2: record a successful withdrawal using Movement.
        }
    }

    /** Creates an independent snapshot of the current balance. */
    public Memento save() {
        // TODO Activity 2: capture the movements as well as the balance.
        return new Memento(balance);
    }

    /** Restores a snapshot created by this account. */
    public void restore(Memento memento) {
        if (memento == null ) {
            throw new IllegalArgumentException("Snapshot must belong to this account");
        }
        balance = memento.balance;
        // TODO Activity 2: restore an independent list of the saved movements.
    }

    private static void checkAmount(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException("Amount must be finite and positive");
        }
    }

    /**
     * Opaque, immutable snapshot. Only BankAccount can read its saved state.
     * The owner identifies the account and is not a copy of its mutable state.
     */
    public static final class Memento {
         private final double balance;
        // TODO Activity 2: also keep the captured movements independently.

        private Memento(double balance) {
            this.balance = balance;
        }
    }
}
