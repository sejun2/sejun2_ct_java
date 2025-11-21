import java.util.*;

class Solution {
    List<String> list = new ArrayList<String>();
    
    int len = 0;
    
    public String[] solution(String[][] tickets) {
       boolean[] visited = new boolean[tickets.length+1]; 
        StringBuilder sb = new StringBuilder();
        
        len = tickets.length * 3;
        
        
       for(int i = 0; i< tickets.length;i++){
           if(tickets[i][0].equals("ICN")){
        	dfs(tickets, visited, sb, i);
           }
       }
        
       
      String s = list.get(0);
        
        for(int i =0;i<list.size();i++){
           if(s.compareTo(list.get(i)) > 0) {
               s = list.get(i);
           }
        }
       
        
        String[] ans = new String[tickets.length + 1];
        
       	int k; 
        int j;
        
        for(int i =0; i<s.length();i++)   {
            k = 0;
            j = 0;
            while(k + 3 <= s.length()){
                ans[j++] = s.substring(k, k+3);
                k=k+3;
            }
            
        }
        
        return ans;
    }
    
    void dfs(String[][] tickets, boolean[] visited, StringBuilder sb, int index){
        if(visited[index]){
            return;
        }
           
        visited[index] = true;
        sb.append(tickets[index][0]);
        
        String dest = tickets[index][1];
        boolean foundNext = false;
        
        for(int i = 0; i < tickets.length; i++){
            if(tickets[i][0].equals(dest) && !visited[i]){
                foundNext = true;
                dfs(tickets, visited, sb, i);
            }
        }
        
        if(!foundNext) {
            if(sb.toString().length() == len){
                sb.append(tickets[index][1]);
                list.add(sb.toString());
                sb.delete(sb.toString().length()-3, sb.toString().length());
            }
        }
        
        sb.delete(sb.toString().length()-3, sb.toString().length());
        visited[index] = false;
    }
    
    int canGo(String dest, String[][] tickets ,boolean[] visited){
       for(int i =0;i<tickets.length;i++) {
           if(tickets[i][0].equals(dest) && !visited[i]){
               return i;
           }
       }
        
        return -1;
    }
}
