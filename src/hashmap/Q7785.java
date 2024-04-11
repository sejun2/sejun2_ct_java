package hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Q7785 {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        var hashMap = new HashMap<String, Integer>();

        int n = Integer.parseInt(sc.nextLine());

        while (n > 0) {
            var s = sc.nextLine();

            var name = s.split(" ")[0];

            if (hashMap.containsKey(name)) {
                hashMap.remove(name);
            } else {
                hashMap.put(name, 1);
            }

            n--;
        }

        ArrayList<String> list = new ArrayList<String>(hashMap.keySet());

        Collections.sort(list, Collections.reverseOrder());

        for(var item: list){
            System.out.println(item);
        }
    }
}
