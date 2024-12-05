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
/**
백트랙킹을 이용하여 문제를 풀었더니 시간초과가 발생하였습니다.
모든 경우의수를 탐색하다보니 numbers 의 길이가 증가할때마다 시간복잡도가 O(n!) 기하급수적으로 늘어나게 된게 원인인 것 같습니다.
*/
