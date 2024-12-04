import java.util.*;

class Solution {
    
    public int solution(int x, int y, int n) {
        HashMap<Integer, Integer> store = new HashMap<Integer, Integer>();
        
        Queue<Integer> q = new LinkedList();
      
        int depth = 0;
        // +n, *2, *3
       
        q.add(x);
        store.put(x, depth);
        
        while(!q.isEmpty()){
			Integer polled = q.poll();
      
            int currentDepth = store.get(polled);
            
            if(polled > y) continue;
            
            if(polled == y) return currentDepth;
           
            if(store.getOrDefault(polled + n, -1) == -1){
            q.add(polled + n);
            store.put(polled+n, currentDepth+1);
            }
            
            if(store.getOrDefault(polled * 2, -1) == -1 ){
            q.add(polled *2);
            store.put(polled*2, currentDepth+1);
            }
            
            if(store.getOrDefault(polled * 3, -1) == -1){
            q.add(polled *3);
            store.put(polled*3, currentDepth+1);
            }
        }
        
        return -1;
        
    }
}

