package hashmap;

import java.util.*;

public class Q1620 {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        int a, b;

        a = sc.nextInt();
        b = sc.nextInt();

        var hashMap = new HashMap<String, Integer>();
        var hashMap2 = new HashMap<Integer, String>();

        for (var i = 0; i < a; i++) {
            String s = sc.next();

            hashMap.put(s, i + 1);
            hashMap2.put(i + 1, s);
        }
        sc.nextLine();

        for (var j = 0; j < b; j++) {
            String s = sc.nextLine();

            if (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') {
                System.out.println(hashMap.get(s));
            } else {
                System.out.println(hashMap2.get(Integer.parseInt(s)));
            }

        }
    }
}