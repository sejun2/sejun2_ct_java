import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
           int res = n%3;
           
            if(res == 0){
                sb.append("4");
            }
            if(res == 1){
                sb.append("1");
            }
            if(res == 2){
                sb.append("2");
            }
        	if(res == 0)    {
                n = n/3 -1;
            }else{
                
           n = n/3;
            }
        }
        
        return sb.reverse().toString();
        
        
    }
}