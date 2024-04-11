package two_demension_array;

import java.util.Arrays;
import java.util.Scanner;

public class Q2563 {
    static final int[][] arr1 = new int[100][100];

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        int count = sc.nextInt();

        int ans = 0;

        for (var i = 0; i < count; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            setArrSection(x, y);
        }

        for (var i = 0; i < 100; i++) {

            for (int j = 0; j < 100; j++) {
                ans += arr1[i][j];
            }
        }

        System.out.print(ans);
    }

    public static void setArrSection(int x, int y) {
        for (var i = x; i < x + 10; i++) {

            for (var j = y; j < y + 10; j++) {

                arr1[i][j] = 1;
            }
        }
    }
}
