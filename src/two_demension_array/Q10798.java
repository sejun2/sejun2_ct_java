package two_demension_array;

import java.util.Scanner;

class Q10798 {
    public static void main(String[] args) {
        final var sc = new Scanner(System.in);

        final var arr1 = new char[5][15];

        for (var i = 0; i < 5; i++) {
            String s = sc.nextLine();

            for (var k = 0; k < s.length(); k++) {
                arr1[i][k] = s.charAt(k);
            }
        }

        for (var i = 0; i < 15; i++) {
            for (var j = 0; j < 5; j++) {
                var res = arr1[j][i];
                if (res == '\0') continue;
                System.out.print(res);
            }
        }
    }
}
