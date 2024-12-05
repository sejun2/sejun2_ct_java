import java.util.*;

class Solution {
    public int solution(int N, int number) {

        HashMap<Integer, HashSet<Integer>> dp = new HashMap<>();
      
        if(N == number) return 1;
        
        for(int i=1; i<=8; i++){
            String nString = String.valueOf(N);
            StringBuilder sb = new StringBuilder();
            
            for(int k = 0; k<i; k++){
               sb.append(nString);
            }
            
            Integer value =  Integer.parseInt(sb.toString());
            
            HashSet<Integer> set = new HashSet<Integer>();
            set.add(value);
            
            dp.put(i,set);
        }
        
        // + - * /
		
        for(int i =1;i<=8 ;i ++){
        	// i 는 N의 갯수    
            HashSet set = dp.getOrDefault(i, new HashSet<Integer>());
           
            // i 단계 조합
           	for(int j =1; j<i; j++){
                int k = i - j; 
            
                for(int a : dp.get(j)){
                    for(int b : dp.get(k)){
                        
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if(b != 0){
                        dp.get(i).add(a / b);
                        }
                    }
                }
                
                if(dp.get(i).contains(number)){
                    return i;
                }
            }
        }
        
     	return -1;  
    }
}