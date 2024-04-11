package two_demension_array;

import java.util.Scanner;

class Q2566 {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int[][] arr1 = new int[9][9];

        for (var i = 0; i < 9; i++) {
            for (var j = 0; j < 9; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }

        int a = 0, b = 0;
        int max = 0;


        for (var k = 0; k < 9; k++) {
            for (int j = 0; j < 9; j++) {
                if (arr1[k][j] > arr1[a][b]) {
                    max = arr1[k][j];
                    a = k;
                    b = j;
                }
            }
        }

        System.out.println(max);
        System.out.println((a+1) + " " + (b+1));
    }
}
