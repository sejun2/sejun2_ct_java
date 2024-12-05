class Solution {
    String max = "0";
    
    public String solution(int[] numbers) {
        dfs(numbers, new boolean[numbers.length+1], new StringBuilder());
        
        return max;
    }
    
    void dfs(int[] numbers, boolean[] visited, StringBuilder current){
   		    
        if(max.compareTo(current.toString()) <0 ) {
            max = current.toString();
        }
        
        for(int i = 0; i< numbers.length; i++){
            if(visited[i]) continue;
            
            visited[i] = true;
            dfs(numbers, visited, current.append(String.valueOf(numbers[i])));
            visited[i] = false;
            current.setLength(current.length() - String.valueOf(numbers[i]).length());
        }
    }
    
}
