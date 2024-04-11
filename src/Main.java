import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr1 = new int[n][m];
        int[][] arr2 = new int[n][m];
        int[][] res = new int[n][m];

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < n; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < n; j++) {
                arr2[i][j] = sc.nextInt();
            }
        }


        for (var i = 0; i < n; i++) {
            for (var j = 0; j < m; j++) {
                res[i][j] = arr1[i][j] + arr2[i][j];

                System.out.print(res[i][j] + " ");
            }

            System.out.println();
        }


    }
}