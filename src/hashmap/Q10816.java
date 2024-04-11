package hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q10816 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        var n = Integer.parseInt(br.readLine());

        var hashMap = new HashMap<String, Integer>();

        var st = new StringTokenizer(br.readLine());

        for (var i = 0; i < n; i++) {
            var token = st.nextToken();

            hashMap.put(token, hashMap.getOrDefault(token, 0) + 1);
        }

        var n2 = Integer.parseInt(br.readLine());

        var st2 = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (var i = 0; i < n2; i++) {

            var token = st2.nextToken();

            sb.append(hashMap.getOrDefault(token, 0)).append(" ");
        }

        System.out.println(sb.toString());

    }
}
