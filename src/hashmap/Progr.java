package hashmap;

import java.util.*;

public class Progr {
    public static void main(String[] args) {
        Solution.solution("5525", "1255");
    }

    class Solution {
        static public String solution(String X, String Y) {
            HashMap<Character, Integer> xHashMap = new HashMap<>();
            HashMap<Character, Integer> yHashMap = new HashMap<>();
            HashMap<Character, Integer> solHashMap = new HashMap<>();

            for (var i = 0; i < X.length(); i++) {
                xHashMap.put(X.charAt(i), xHashMap.getOrDefault(X.charAt(i), 0) + 1);
            }
            for (var i = 0; i < Y.length(); i++) {
                yHashMap.put(Y.charAt(i), yHashMap.getOrDefault(Y.charAt(i), 0) + 1);
            }

            for (var i = 0; i <= 9; i++) {
                char s = Integer.toString(i).charAt(0);
                var min = Math.min(xHashMap.getOrDefault(s, 0),
                        yHashMap.getOrDefault(s, 0));

                if(min == 0) continue;

                solHashMap.put(s,
                        Math.min(xHashMap.getOrDefault(s, 0),
                                yHashMap.getOrDefault(s, 0)));
            }

            StringBuilder sb = new StringBuilder();

            for(var i=9;i >=0; i--){
                char s = Integer.toString(i).charAt(0);
                System.out.println(solHashMap.getOrDefault(s, 0));
                if(solHashMap.getOrDefault(s, 0) != 0){
                    sb.repeat(s, solHashMap.get(s));
                }
            }

            if(sb.toString().startsWith("0") || sb.isEmpty()) return "0";

            if(solHashMap.isEmpty()) return "-1";


            return sb.toString();
        }
    }
}

