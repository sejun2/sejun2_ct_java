package hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Q10816 {
    public static void main(String[] args) throws IOException {
        final var br = new BufferedReader(new InputStreamReader(System.in));

        final var n = Integer.parseInt(br.readLine());

        final var hashMap = new HashMap<String, Integer>();

        final var st = new StringTokenizer(br.readLine());

        for (var i = 0; i < n; i++) {
            var token = st.nextToken();

            hashMap.put(token, hashMap.getOrDefault(token, 0) + 1);
        }

        final var n2 = Integer.parseInt(br.readLine());

        final var st2 = new StringTokenizer(br.readLine());

        int[] arr2 = new int[100];

        var arr = new ArrayList<Integer>();

        Collections.max(arr);
        StringBuilder sb = new StringBuilder();

        for (var i = 0; i < n2; i++) {

            final var token = st2.nextToken();

            sb.append(hashMap.getOrDefault(token, 0)).append(" ");
        }

        System.out.println(sb.toString());

    }
}

class Solution {
    public int solution(int k, int m, int[] score) {
var hashMap=new HashMap<>();
String a = "23123123";
        List<Integer> scoreList = new ArrayList<>();

        for(var item: score){
            scoreList.add(item);
        }

        Collections.sort(scoreList, Collections.reverseOrder());

        //k 점수. 1 <= p <= k
        //m 상자에 담을 사과 개수

        //1. 상자개수
//        int count = sortedScore.size() /  m;
        int count = score.length /  m;

        int answer = 0;


        for(int i =0; i<count; i++){
            List<Integer> sub = scoreList.subList(m * i, m * i + m);

            System.out.println(sub.toString());

            int min = Collections.min(sub);

            int res = min * m;

            answer = answer + res;
        }

        return answer;
    }
}

class TEST {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3, 4, new int[]{1, 2, 3,1,2,3,1}));
    }
}