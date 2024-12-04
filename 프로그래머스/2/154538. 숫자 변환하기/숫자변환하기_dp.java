import java.util.*;
import java.math.*;

class Solution {
    
    public int solution(int x, int y, int n) {
        int[] dp = new int[y+1];
        
       	Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[x] = 0;
        
        for(int i =x; i<=y ;i ++){
            //도달 불가
            if(i != x && dp[i] == Integer.MAX_VALUE ){
               	continue; 
            }
           
            // x+n
            if(i+n <= y ){
            dp[i+n] = dp[i+n] == Integer.MAX_VALUE ? dp[i]+1 : Math.min(dp[i]+1, dp[i+n]);
            }
            
            // x * 2
            if (i*2 <= y){
            dp[i*2] = dp[i*2] == Integer.MAX_VALUE ? dp[i] +1: Math.min(dp[i]+1, dp[i*2]);
            }
            
            // x * 3
            if (i*3 <= y){
            dp[i*3] = dp[i*3] == Integer.MAX_VALUE ? dp[i] +1: Math.min(dp[i]+1, dp[i*3]);
            }
            
        }
        
        return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
    }
}

