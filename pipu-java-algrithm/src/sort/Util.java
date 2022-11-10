package sort;

import java.util.Arrays;
import java.util.Random;

public class Util {
    public static void swap(int[] arr, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static int[] copyArray(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1 == null || arr2 == null) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                System.out.println("fuck");
                System.out.printf("fuck arr1 %s \n", Arrays.toString(arr1));
                System.out.printf("fuck arr2 %s \n", Arrays.toString(arr2));
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int len = new Random().nextInt(maxSize + 1);
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = new Random().nextInt(maxValue + 1);
        }
        return arr;
    }

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static boolean checkSortMethod(SortInterface sortClass) {
        int testTime = 5000;
        int maxSize = 100;
        int maxValue = 1000;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] newArr1 = sortClass.sort(arr1);
            comparator(arr2);
            if (!isEqual(newArr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        int[] newArr = sortClass.sort(arr);
        printArray(newArr);
        return succeed;
    }

}
