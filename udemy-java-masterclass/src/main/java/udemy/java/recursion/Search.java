package udemy.java.recursion;

import java.util.Arrays;

public class Search {

    public static void main(String[] args) {
        int[] array = new int[]{2, 6, 4, 76, 234, 68, 34, 98, 36};
        int item = 68;
        System.out.println(linearSearch(array, item));
        System.out.println(binarySearch(array, item));
    }

    private static int linearSearch(int[] array, int item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == item) return i;
        }

        return -1;
    }

    private static int binarySearch(int[] array, int item) {
        Arrays.sort(array);
        return binarySearch(array, 0, array.length - 1, item);
    }

    private static int binarySearch(int[] array, int start, int end, int item) {
        if (start > end) return -1;

        int mid = start + (end - start) / 2;

        if (array[mid] == item) return mid;
        else if (array[mid] > item) {
            return binarySearch(array, start, mid - 1, item);
        } else {
            return binarySearch(array, mid + 1, end, item);
        }
    }

}
