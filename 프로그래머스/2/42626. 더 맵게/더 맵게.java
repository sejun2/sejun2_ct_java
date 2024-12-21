import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;
       	
        PriorityQueue<Integer> pq = new PriorityQueue<>();
       
        for(int s : scoville){
            pq.add(s);
        }
        
        while(pq.peek() < K){
            if(pq.size() <2){
                return -1;
            }
            
           	int f = pq.poll(); 
            int s = pq.poll();
            
           	int mix = mix(f, s);
            pq.add(mix);
            
            count++;
        }
        
        return count;
    }
    
    int mix(int f, int s){
       	return f + (s * 2);
    }
}