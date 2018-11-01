package ctci.moderate;

public class NumberSwapper {

    public static void main(String[] args) {
        swap(2, 3);
        swapBinary(5, 6);
    }

    private static void swap(int a, int b) {
        // a = 2, b = 3
        a = a + b; // a = 5
        b = a - b; // b = 2
        a = a - b; // a = 3

        System.out.printf("a=%d, b=%d", a, b);
    }

    private static void swapBinary(int a, int b) {
        // a = 5 (101), b = 6 (110)
        a = a ^ b; // a = 011, 3
        b = a ^ b; // b = 101, 5
        a = a ^ b; // a = 110, 6

        System.out.printf("a=%d, b=%d", a, b);
    }
}
