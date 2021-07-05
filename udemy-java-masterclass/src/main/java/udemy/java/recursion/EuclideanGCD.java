package udemy.java.recursion;

public class EuclideanGCD {

    public static void main(String[] args) {
        System.out.println(gcd(21, 14));
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
