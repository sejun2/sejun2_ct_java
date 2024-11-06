import java.util.*;

class Solution
{
    int length = 1;
    
    public int solution(String s)
    {
        for(int i =s.length()-1;i>=0;i--){
            for(int j=0;j<s.length() -i;j++){
                boolean res = checkPalindrome(s, j, j+i);
                if(res) {
                return length;
                }
            }
        }
        
        return length;
    }
    
    boolean checkPalindrome(String str, int left, int right){
       int len = right-left+1;
        
       while(left < right) {
           if(str.charAt(left) != str.charAt(right)){
               return false;
           }
           
           left++;
           right--;
       }
       	length = len; 
        
        return true;
    }
}