import java.util.*;

class Solution {
    
    public int solution(int[] people, int limit) {
        
        List<Integer> list = new ArrayList();
        
        for(int i = 0; i < people.length; i++){
            list.add(people[i]);
        }
        
        Collections.sort(list, Comparator.reverseOrder());
       
        // 무거운
        int left = 0;
        
        // 가벼운
        int right = list.size() - 1;
        
        int answer = 0;
        
        while(left <= right){
            answer++;
            if(left == right) break;;
            
            int currentWeight = list.get(left);
            left++;
            
            if(currentWeight + list.get(right) <= limit){
                right--;
                continue;
            }
        }
        
        return answer;
    }
}