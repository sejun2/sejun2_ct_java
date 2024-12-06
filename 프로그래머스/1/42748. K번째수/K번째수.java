import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0;i<commands.length;i++){
            int res = process(array, commands[i]);
            answer[i] = res;
        }
        
        return answer;
    }
    
    int process(int[] arr, int[] command){
        int[] tmp = Arrays.copyOfRange(arr, command[0]-1, command[1]);
        
        Arrays.sort(tmp);
        
        return tmp[command[2]-1];
    }
}