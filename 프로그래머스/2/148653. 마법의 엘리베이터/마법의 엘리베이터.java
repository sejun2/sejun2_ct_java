class Solution {
    public int solution(int storey) {
        int count = 0;
        
        while(storey > 0){
            var rest = storey%10;
            storey /= 10;
        
            if(rest >5){
                count += 10-rest;
                storey += 1; 
            }else if(rest <5){
                count += rest;
            }else {
                if(storey% 10 >=5){
                    count += rest;
                     storey += 1;
                }else{
                    count += 10-rest;
                   
                }
            }
        }
        
        System.out.println(count);
        
        return count;
        
    }
}