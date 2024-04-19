package sorts;

import java.util.Arrays;

public class InsertionSort {
    void sort(int[] arr) {
        //1. 앞에는 정렬되어있고,
        //2. 정렬되어있지 않은 뒤에서 하나 뽑아서 앞에 정렬된쪽에 넣어주는것.

        for (int i = 1; i < arr.length; i++) {
            int target = arr[i];

            int j;

            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > target) {
                    arr[j + 1] = arr[j];
                    System.out.println(Arrays.toString(arr));
                } else {
                    break;
                }
            }

            arr[j + 1] = target;

        }
    }
}

class InsertionSortMain {
    public static void main(String[] args) {
        var arr = new int[]{
                92, 1, 4, 2, 55, 3, 7, 22, 45, 2, 5, 6, 9
        };

        System.out.println("Before insertion sort :: " + Arrays.toString(arr));

        new InsertionSort().sort(arr);

        System.out.println("After insertion sort :: " + Arrays.toString(arr));
    }
}
