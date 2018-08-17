import java.util.Map;
import java.util.TreeMap;

public class RomanConverter {

    private static final Map<Integer, String> NUMBER_MAP = new TreeMap<>((i1, i2) -> -Integer.compare(i1, i2));

    static {
        NUMBER_MAP.put(1000, "M");
        NUMBER_MAP.put(900, "CM");
        NUMBER_MAP.put(500, "D");
        NUMBER_MAP.put(400, "CD");
        NUMBER_MAP.put(100, "C");
        NUMBER_MAP.put(90, "XC");
        NUMBER_MAP.put(50, "L");
        NUMBER_MAP.put(40, "XL");
        NUMBER_MAP.put(10, "X");
        NUMBER_MAP.put(9, "IX");
        NUMBER_MAP.put(5, "V");
        NUMBER_MAP.put(4, "IV");
        NUMBER_MAP.put(1, "I");
    }


    public String convertToRoman(int number) {
        if (number <= 0 || number > 5000) {
            throw new IllegalArgumentException("Number must be in range 1..5000");
        }

        final StringBuilder builder = new StringBuilder();
        convertNumber(number, builder);
        return builder.toString();
    }

    private void convertNumber(final int number, final StringBuilder builder) {
        NUMBER_MAP.keySet().stream()
                .filter(i -> i <= number)
                .findFirst()
                .ifPresent(matchingRoman -> {
                    builder.append(NUMBER_MAP.get(matchingRoman));
                    final int updatedNumber = number - matchingRoman;
                    convertNumber(updatedNumber, builder);
                });
    }


}
