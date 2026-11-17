import java.util.Locale;

/** Demonstrates the working base example before the student activities. */
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("John Doe", 1000.0);
        BankAccountCaretaker caretaker = new BankAccountCaretaker(account);

        caretaker.save();
        show("Initial state saved", account);

        account.deposit(500.0);
        caretaker.save();
        show("After deposit (state saved)", account);

        account.withdraw(200.0);
        show("After withdrawal", account);

        caretaker.undo();
        show("After first undo", account);
        caretaker.undo();
        show("After second undo", account);
        caretaker.undo();
        show("After undo with an empty history", account);

        // TODO Activity 1: adapt this scenario to save dates and restore by date.
        // TODO Activity 2: also display and verify the account movements.
        // Follow the independent verification scenario in README.md.
    }

    private static void show(String label, BankAccount account) {
        System.out.printf(Locale.ROOT, "%s - Account holder: %s, Balance: %.2f%n",
                label, account.getAccountHolder(), account.getBalance());
    }
}
