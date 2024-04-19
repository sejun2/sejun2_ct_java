package two_demension_array;

import java.util.Arrays;

public class BubbleSort {

    void sort(int[] arr){
       for(int i = 0;i<arr.length-1;i++) {

           for(int j= 0; j<arr.length-1-i;j++){
               if(arr[j] > arr[j+1] ){
                   int tmp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = tmp;
               }
           }
       }
    }
}

class BubbleSortMain {
    public static void main(String[] args) {
        var arr = new int[] {
                92,1,4,2,55,3,7,22,45,2,5,6,9
        };

        System.out.println("Before bubble sort :: " + Arrays.toString(arr));
        new BubbleSort().sort(arr);

        System.out.println("After bubble sort :: " + Arrays.toString(arr));
    }
}
