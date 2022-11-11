package sort;

import static sort.Util.swap;

public class SelectSort implements SortInterface {
    @Override
    public int[] sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int maxIndex = 0;
            for (int j = 1; j <= i; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            swap(arr, i, maxIndex);
        }
        return arr;
    }
}
