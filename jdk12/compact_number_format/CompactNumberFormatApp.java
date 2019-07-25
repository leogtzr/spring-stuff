import java.text.NumberFormat;
import java.util.Locale;

public class CompactNumberFormatApp {
    public static void main(final String[] args) {
        final Long twentyFiveThousand = 25000L;

            // US number formatting
        final NumberFormat numberFormatUsShor = NumberFormat.
            getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        final NumberFormat numberFormatUsLong = NumberFormat
            .getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);

        System.out.println(numberFormatUsLong.format(twentyFiveThousand));
        System.out.println(numberFormatUsShor.format(twentyFiveThousand));
    }
}