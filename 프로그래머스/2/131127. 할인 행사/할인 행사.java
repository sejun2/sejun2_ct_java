import java.util.*;

class Solution {
        Map<String, Integer> hashMap = new HashMap<>();
    Map<String, Integer> tmpHashMap = new HashMap<>();


    public int solution(String[] want, int[] number, String[] discount) {

        int answer = 0;

        for (int i = 0; i < want.length; i++) {
            hashMap.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            tmpHashMap = new HashMap<>();

            for (int j = i; j < i + 10; j++) {
                tmpHashMap.put(discount[j], tmpHashMap.getOrDefault(discount[j], 0) + 1);
            }

            // compare with origin
            for (String s : want) {
                if (hashMap.getOrDefault(s, 0) > tmpHashMap.getOrDefault(s, 0)) {
                    answer--;
                    break;
                }
            }

            answer++;
        }

        return answer;
    }

}