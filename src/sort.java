import java.util.Scanner;

public class sort {
    public static void main(String[] args) {
        int[] arr = {10, 12, 45, 90};
        int insertNum = 23;
        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= insertNum) {
                index = i;
                break;
            }
        }
        int[] newArr = new int[arr.length + 1];
        for (int i = 0, j = 0; i < newArr.length; i++) {
            if (i != index) {
                newArr[i] = arr[j];
                j++;
            } else {
                newArr[i] = insertNum;
            }
        }
        arr = newArr;
        System.out.println("=======");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : ","));
        }
    }
}