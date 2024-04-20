import java.util.*;

class Solution {
     boolean solution(String s){
        Stack stack = new Stack<Character>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
               stack.push(s.charAt(i));
            }else{
                if(stack.empty()){
                    return false;
                }
                

                stack.pop();
            }
        }

        return stack.empty();
    }
}