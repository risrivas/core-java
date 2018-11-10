package ctci.moderate;

import java.util.Arrays;

public class SmallestDifference {

    public static void main(String[] args) {
        System.out.println(smallestDiff(new int[]{1, 3, 15, 11, 2}, new int[]{23, 127, 235, 19, 8}));
    }

    private static int smallestDiff(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                min = Math.min(b[j] - a[i], min);
                i++;
            } else {
                min = Math.min(a[i] - b[j], min);
                j++;
            }
        }

        return min;
    }

}
