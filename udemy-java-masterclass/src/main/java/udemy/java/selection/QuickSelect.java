package udemy.java.selection;

import java.util.Random;

public class QuickSelect {

    public static void main(String[] args) {
        int[] array = new int[]{7, 5, -1, 8, 2, 6};
        System.out.println("Second largest element: " + kthLargest(array, 2));
    }

    private static int kthLargest(int[] array, int k) {
        return select(array, 0, array.length - 1, k - 1);
    }

    private static int select(int[] array, int indexFirst, int indexLast, int k_) {
        int pivot = partition(array, indexFirst, indexLast);
        if (pivot > k_) {
            return select(array, indexFirst, pivot - 1, k_);
        } else if (pivot < k_) {
            return select(array, pivot + 1, indexLast, k_);
        }

        return array[pivot];
    }

    private static int partition(int[] array, int indexFirst, int indexLast) {
        int pivot = new Random().nextInt(indexLast);
        swap(array, pivot, indexLast);
        for (int i = 0; i < indexLast; i++) {
            if (array[i] > array[indexLast]) {
                swap(array, i, indexFirst);
                indexFirst++;
            }
        }

        swap(array, indexFirst, indexLast);
        return indexFirst;
    }

    private static void swap(int[] array, int p, int i) {
        int tmp = array[p];
        array[p] = array[i];
        array[i] = tmp;
    }
}
