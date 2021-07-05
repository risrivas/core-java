package udemy.java.recursion;

public class AddFirstNNumbers {

    public static void main(String[] args) {
        System.out.println(iterationSum(10));
        System.out.println(recursiveSum(10));
        System.out.println(recursiveSum(0, 10));
    }

    private static int iterationSum(int N) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += i;
        }

        return sum;
    }

    private static int recursiveSum(int N) {
        if (N == 0) return 0;

        return N + recursiveSum(N - 1);
    }

    private static int recursiveSum(int accumulator, int N) {
        if (N == 0) return accumulator;

        return recursiveSum(accumulator+N, N-1);
    }
}
