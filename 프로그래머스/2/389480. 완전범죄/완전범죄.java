import java.util.*;
import java.math.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int[][] dp = new int[info.length][m];
        
        for (int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], 9999);
        }
        
        
    	for(int i =0; i< info.length;i++) {
            int a = info[i][0];
            int b = info[i][1];
            
            for(int j = 0; j<m; j++){
                int upper;
                if(i == 0){
                    upper = 0;
                }else{
                    upper = dp[i-1][j];
                }
                
                // a 선택
                dp[i][j] = Math.min(dp[i][j], upper + a);
                
                // b 선택
                if(j + b < m){
                    int upperB;
                    
                    if(i==0){
                        upperB = 0;
                    }else{
                        upperB = dp[i-1][j];
                    }
                    dp[i][j+b] = Math.min(dp[i][j+b], upperB);
                }
            }
        }
        
        int answer =999;
        
        for(int i=0;i<m;i++){
           int k =  Math.min(answer, dp[info.length-1][i]) ;
            
            if(k < n) answer = k;
        }
        
        if(answer == 999) return -1;
        
        return answer;
    }
}