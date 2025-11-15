import java.util.*;

class Solution {
    int[][] dp;
    
    public int solution(int m, int n, int[][] puddles) {
       dp = new int[n+1][m+1];
        
        for(int i = 0; i <puddles.length;i++){
            int x = puddles[i][1];
            int y = puddles[i][0];
           
            dp[x][y] = -1;
        }
        
        for(int i = 1; i<=n; i++){
            for(int j =1; j<=m;j++){
                if(i == 1 && j ==1){
                    dp[1][1] = 1;
                    continue;
                }
                
                if(dp[i][j] == -1) continue;
                
                int a=0;
                int b = 0;
                if (dp[i-1][j] != -1){
                    a = dp[i-1][j];
                }
                if(dp[i][j-1] != -1){
                    b = dp[i][j-1];
                }
                
                dp[i][j] = (a + b) % 1000000007;
            }
        }
        
        return dp[n][m];
        
    }
}