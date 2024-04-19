package sorts;

import java.util.Arrays;

public class QuickSort {
    void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int left = low +1;
        int right =  high;

        int pivot = low;
        int pivotValue = arr[pivot];

        while (left <= right) {
            while (arr[left] < pivotValue) left++;
            while (arr[right] > pivotValue) right--;

            // 교차되지 않았다면
            if (left <= right) {
                System.out.println("pivot :: " + arr[pivot] +
                        "\nswap :: " + arr[left] +" " + arr[right]);
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }

        int tmp = arr[right];
        arr[right] = pivotValue;
        arr[pivot] = tmp;

        pivot = right;

        System.out.println(Arrays.toString(arr));

        sort(arr, low, pivot - 1);
        sort(arr, pivot+ 1, high);
    }
}

class QuickSortMain {
    public static void main(String[] args) {
        int[] arr = {7, 4, 1, 3, 2, 0, 9, -3, -99};
        new QuickSort().sort(arr, 0, arr.length - 1);
    }
}


