public class SwitchExprApp {

    private enum Size {
        BIG, LG, SHORT, MEDIUM
    }

    public static void main(final String[] args) {
        final Size size = Size.LG;

        final int anotherSize = switch (size) {
            case BIG -> 1;
            case LG -> 2;
            case SHORT -> 3;
            default -> 4;
        };

        System.out.println(anotherSize);
    }
}