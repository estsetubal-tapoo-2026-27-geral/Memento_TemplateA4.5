import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Objects;

/** class to be used just in activity 2
 *
 */
public final class Movement {
    public enum Type { DEPOSIT, WITHDRAWAL }

    private final Type type;
    private final double amount;
    private final LocalDateTime date;

    public Movement(Type type, double amount) {
        this.type = Objects.requireNonNull(type, "type");
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException("Amount must be finite and positive");
        }
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    public Type getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return String.format(Locale.ROOT, "%s | %s | %.2f", date, type, amount);
    }
}
