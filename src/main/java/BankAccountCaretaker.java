import java.util.Objects;
import java.util.Stack;

/** Caretaker: stores opaque snapshots for a single account. */
public class BankAccountCaretaker {
    // TODO Activity 1: replace the stack with a Map<Date, BankAccount.Memento>.
    private final Stack<BankAccount.Memento> mementos = new Stack<>();
    private final BankAccount originator;

    public BankAccountCaretaker(BankAccount originator) {
        this.originator = Objects.requireNonNull(originator, "originator");
    }

    // TODO Activity 1: return a defensive copy of the unique snapshot date.
    public void save() {
        mementos.push(originator.save());
    }

    // TODO Activity 1: replace undo() with restore(Date date).
    public void undo() {
        if (!mementos.isEmpty()) {
            originator.restore(mementos.peek());
            mementos.pop();
        }
    }

    // TODO Activity 1: provide getSavedDates() without exposing mutable keys.
}
