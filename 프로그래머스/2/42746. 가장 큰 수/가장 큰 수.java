import java.util.*;

class Solution {
    
    public String solution(int[] numbers) {
        String[] strings = new String[numbers.length]; 
        
        for(int i =0 ;i<numbers.length;i++){
            strings[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(
        strings, new Comparator<String>() {
            
            @Override
            public int compare(String a, String b){
                return -(a+b).compareTo(b+a);
            }
        }
        );
            String answer = "";
            
        for(String k : strings){
            answer += k;
        }
           if(answer.startsWith("0")) {
               return "0";
           }else{
               
            return answer;
           }
    }
    
}