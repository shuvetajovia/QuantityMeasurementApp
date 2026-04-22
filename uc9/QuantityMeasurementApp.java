public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

        System.out.println("Equality: " + w1.equals(w2));

        QuantityWeight sum = w1.add(w2);
        System.out.println("Sum: " + sum);

        QuantityWeight sum2 = w1.add(w2, WeightUnit.GRAM);
        System.out.println("Sum in grams: " + sum2);
    }
}