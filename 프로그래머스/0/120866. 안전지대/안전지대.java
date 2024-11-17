import java.util.*;

class Solution {
    public int solution(int[][] board) {
        // 북 동 남 서
        int[] dx = new int[]{-1,-1,0,1,1,1,0,-1};
        int[] dy = new int[]{0,1,1,1,0,-1,-1,-1};
        
        for(int i=0; i<board[0].length;i++){
            
            for(int j=0;j<board.length;j++){
              if(board[i][j] == 1){
                  
                  for(int k=0; k<dx.length; k++){
                      if(dx[k] + i <0 || dy[k] + j < 0 || dx[k]+ i > board[0].length-1 || dy[k]+j > board.length-1){
                          continue;
                      }
                     
                      if(board[i+dx[k]][j+dy[k]] != 1){
                         board[i+dx[k]][j+dy[k]] = 2;
                      }
                  }
              }     
            }
        }
       
        int answer = 0;
        
        for(int i=0; i<board[0].length;i++){
            
            for(int j=0;j<board.length;j++){
                if(board[i][j] == 0){
                    answer ++;
                }
                
            }
        }
        return answer;
        
    }
}