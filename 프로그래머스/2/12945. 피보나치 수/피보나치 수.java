class Solution {
    int[] memo;
   
    public int solution(int n) {
    	memo = new int[n+1];
      
        fibo(n);
        
        return memo[n];
    }
    
    int fibo(int n) {
       if(n <= 1) {
           return n;
       }
        
       if(memo[n] != 0){
           return memo[n];
       }
        
        memo[n] = (fibo(n-1) + fibo(n-2)) % 1234567;
        
        return memo[n];
    }
}