public class UC8_App {

    public static void main(String[] args) {

        Quantity f1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity i12 = new Quantity(12.0, LengthUnit.INCH);

        // Conversion
        System.out.println("Convert: " + f1.convertTo(LengthUnit.INCH));

        // Addition (UC6)
        System.out.println("Add: " + f1.add(i12));

        // Addition with target (UC7)
        System.out.println("Target YARD: " +
                Quantity.add(f1, i12, LengthUnit.YARD));

        // Equality
        System.out.println("Equal: " +
                new Quantity(36, LengthUnit.INCH)
                        .equals(new Quantity(1, LengthUnit.YARD)));
    }
}