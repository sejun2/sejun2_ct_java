import java.util.*;

public class Q2559{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int count =  sc.nextInt();
        int interval = sc.nextInt();

        int[] arr = new int[count];

        for(int i=0;i<count;i++){
            arr[i] = sc.nextInt();
        }

        int[] subArr = new int[count+1];

        for(int i=1; i < count+1; i++){
            subArr[i] = subArr[i-1] + arr[i-1];
        }

        int max = subArr[interval] - subArr[0];

        for(int i = interval; i<count+1;i++){
            max = Math.max(max, subArr[i] - subArr[i-interval]);
        }

        System.out.print(max);

    }
}
