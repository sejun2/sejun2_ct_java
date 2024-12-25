import java.util.*;

class Solution {
        StringBuilder sb = new StringBuilder();
    int index = 0;
    int end;
    int count;
    public String solution(String number, int k) {
        count = 0;
        
            end = number.length() - (number.length() - k) + count;
        while(index <= end){
            if(sb.length() >= number.length() - k){
                return sb.toString();
            }
            end = number.length() - (number.length() - k) + count;
            
            getMax(number, index, end);
        }
        
        if(index < number.length()){
        sb.append(number.substring(index, number.length()));
        }
        
        return sb.toString();
    }
    
    void getMax(String number, int start, int end){
        int max = -1;
        
        for(int i = start; i<=end; i++){
            if(number.charAt(i) - '0' > max){
                index = i+1;
                max = number.charAt(i) - '0';
            }
        }
        
        sb.append(Integer.toString(max));
        count++;
    }
}