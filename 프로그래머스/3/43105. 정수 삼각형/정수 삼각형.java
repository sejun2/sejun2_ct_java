import java.util.*;
import java.math.*;

class Solution {
    static int[][] dp;
    
    public int solution(int[][] triangle) {
        int x = triangle.length;
        int y = triangle[triangle.length-1].length;
       
        dp = new int[triangle.length][triangle[triangle.length-1].length];
   
        
        dp[0][0] = triangle[0][0];
        
        for(int h = 0; h < x; h++){
            
            for(int k = 0; k< triangle[h].length; k++){
                if(h+1 >= x) break;
                
                int a=0;
                int b=0;
                
                if(dp[h+1][k] != 0 ){
                    a = dp[h+1][k];
                }
                
                if(dp[h+1][k+1] != 0){
                    b = dp[h+1][k+1];
                }
                
                dp[h+1][k] = Math.max(dp[h][k] + triangle[h+1][k], a);
                dp[h+1][k+1] = Math.max(dp[h][k] + triangle[h+1][k+1],b);
            }
        }

        int answer = -1;
        
        for(int i =0; i< dp[x-1].length;i++){
           answer = Math.max(answer, dp[x-1][i]); 
        }
        
        return answer;
    }
}