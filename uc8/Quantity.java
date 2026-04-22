public class Quantity {

    private final double value;
    private final LengthUnit unit;

    public Quantity(double value, LengthUnit unit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    private double toBase() {
        return unit.toBase(value);
    }

    // ✅ Convert to another unit
    public Quantity convertTo(LengthUnit target) {
        if (target == null) {
            throw new IllegalArgumentException("Target cannot be null");
        }

        double base = this.toBase();
        double result = target.fromBase(base);

        return new Quantity(result, target);
    }

    // ✅ UC6 + UC7 combined
    public Quantity add(Quantity other) {
        return add(this, other, this.unit);
    }

    public static Quantity add(Quantity a, Quantity b, LengthUnit target) {
        if (a == null || b == null || target == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        double sumBase = a.toBase() + b.toBase();
        double result = target.fromBase(sumBase);

        return new Quantity(result, target);
    }

    // ✅ Equality (important for viva)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity)) return false;

        Quantity other = (Quantity) obj;

        double epsilon = 0.0001;
        return Math.abs(this.toBase() - other.toBase()) < epsilon;
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}