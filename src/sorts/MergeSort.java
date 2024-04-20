package sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 합병정렬
 * 1. 리스트의 길이가 0 또는 1 이면 정렬된 것으로 본다. 그렇지 않은 경우에는
 * 2. 정렬되지 않는 리스트를 절반으로 잘라 비슷한 크기의 두 부분 리스트로 나눈다.
 * 3. 각 부분 리스트를 재귀적으로 합병정렬을 이용해 정렬한다.
 * 4. 두 부분 리스트를 다시 하나의 정렬된 리스트로 합병한다.
 */

public class MergeSort {

    private int[] sorted;

    MergeSort(int size) {
        this.sorted = new int[size];
    }

    void sort(int list[], int left, int right) {
        if (left >= right) {
            return;
        }


        int mid = (left + right) / 2;
        sort(list, left, mid);
        sort(list, mid + 1, right);
        merge(list, left, mid, right);
    }

    void merge(int list[], int left, int mid, int right) {
        int l = left;
        int lEnd = mid;

        int rStart = mid + 1;
        int r = right;

        int sortedIndex = left;

        while (l <= lEnd && rStart <= r) {
            if (list[l] <= list[rStart]) {
                sorted[sortedIndex] = list[l];
                l++;
            } else {
                sorted[sortedIndex] = list[rStart];
                rStart++;
            }

            sortedIndex++;
        }

        if(rStart<=r)
        for (int i = rStart; i <= r; i++) {
            sorted[sortedIndex] = list[i];
            sortedIndex++;
        }

        if (l <= lEnd)
        for (int i = l; i <= lEnd; i++) {
            sorted[sortedIndex] = list[i];
            sortedIndex++;
        }


        for (int i = left; i <= right; i++) {
            list[i] = sorted[i];
        }
    }
}

class MergeSortMain {
    public static void main(String[] args) {
        int[] list = {
                6, 1, 3, 9, 4, 10, 5, 2, 8, 7,
        };

        System.out.println("Before merge sort :: " + Arrays.toString(list));

        new MergeSort(10).sort(
                list, 0, list.length - 1
        );

        System.out.println("After merge sort :: " + Arrays.toString(list));
    }
}