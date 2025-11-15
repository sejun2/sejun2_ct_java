import java.util.*;

class Solution {
    int answer = 0;
    Set set = new HashSet<String>();
    
    public int solution(String numbers) {
        
            boolean[] visited = new boolean[numbers.length()];
            StringBuilder sb = new StringBuilder();
       
      dfs(0, numbers, visited, sb);
      
        Iterator<String> iter = set.iterator();
        
        while(iter.hasNext()){
            boolean b = isPrime(Integer.parseInt(iter.next()));
            if(b) answer++;
        }
        
        return answer;
    }
    
    void dfs(int startIndex, String numbers, boolean[] visited,  StringBuilder sb){
        
        
        for(int i = 0; i<numbers.length();i++){
            if(sb.toString().length() == 0 && numbers.charAt(i) == '0') continue;
            
            if(visited[i]) continue;
            visited[i] = true;
            sb.append(Character.toString(numbers.charAt(i)));
            set.add(sb.toString());
            dfs(i+1, numbers, visited, sb);
            visited[i] = false;
            sb.deleteCharAt(sb.toString().length()-1);
        }
    }
    
    boolean isPrime(int n){
        if( n == 1) return false;
        
        for(int i = 2; i<= (int) Math.sqrt(n); i++){
           if(n % i == 0) return false;
        }
        
        return true;
    }
}