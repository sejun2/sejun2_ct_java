import java.util.*;

class Solution {
    public String solution(String s) {
    
       	StringBuilder answer = new StringBuilder();
       
       	int flag = 1;
    
        for(int i=0;i<s.length();i++){
           char c = s.charAt(i);
           
           if(c == ' '){
               answer.append(" ");
               flag = 1;
               continue;
           }
            
           if(flag % 2 == 1)  {
               if(c >= 'a'){
              answer.append(Character.toString((char)(c-32))); 
               }else{
              answer.append(Character.toString((char)(c))); 
               }
           }else{
               if(c < 'a'){
              answer.append(Character.toString((char)c+32));
               }else{
              answer.append(Character.toString((char)c));
               }
           }
              flag++;
        }
        
        return answer.toString();
    }
}