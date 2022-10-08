package pe.gustavo.functionalprograming.v8_method_reference;

public final class Numberutils {

    private Numberutils() {
    }

    public static boolean isPrime(int value) {
        for (int i = 0; i < value; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int squaring(int value) {
        return value * value;
    }
}
