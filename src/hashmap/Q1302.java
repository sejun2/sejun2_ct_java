package hashmap;

import java.util.*;

public class Q1302 {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        var hashMap = new HashMap<String, Integer>();

        var n = Integer.parseInt(sc.nextLine());

        int maxCount = 0;

        while (n > 0) {
            var s = sc.nextLine();

            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
            if (hashMap.get(s) > maxCount) {
                maxCount = hashMap.get(s);
            }

            n--;
        }

        ArrayList list = new ArrayList<String>();

        for (var item : hashMap.keySet()) {
            if (hashMap.get(item) == maxCount) {
                list.add(item);
            }
        }

        Collections.sort(list);

        System.out.println(list.get(0));
    }
}
