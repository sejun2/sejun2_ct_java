import java.util.*;

class Solution {
    int answer = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        boolean[] visited = new boolean[n];
        
        getCombination(n, new ArrayList<Integer>(), 1, q, ans);
        
        return answer;
    }
    
    boolean checkAnswer(List<Integer> list, int[][] q, int[] ans){
       for (int i = 0 ; i< q.length ; i++) {
           int count = 0;
           for(int j= 0; j<5; j++){
               if(list.contains(q[i][j])){
                   count ++;
               }
           }
           if(count != ans[i])  return false;
       }
        
        return true;
    }
    
    void getCombination(int size, List<Integer> list, int start, int[][] q, int[] ans){
       
        if(list.size() == 5) {
            if(checkAnswer(list, q, ans)) answer++;
            return;
        }
        
        for(int i = start; i <=size; i++){
            list.add(i);
            getCombination(size, list, i+1, q, ans);
            list.remove(list.size() - 1);
        }
    }
}