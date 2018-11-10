package ctci.moderate;

public class FindMax {

    public static void main(String[] args) {
        System.out.println(max(47, 13));
    }

    private static int max(int a, int b) {
        int k = (a - b) >>> 31; // if k = 1, then b; else k = 0, then a
        return a * (k ^ 1) + b * k;
    }
}
