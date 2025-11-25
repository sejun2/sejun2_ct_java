import java.util.*;

class Solution {
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
    public int[] solution(String[] operations) {
        for(int i= 0; i< operations.length; i++){
            if(operations[i].contains("I")){
                insertNumber(Integer.parseInt(operations[i].substring(2, operations[i].length())));
            }else if(operations[i].contains("D 1")){
                removeMax();
            }else{
                removeMin();
            }
        }
        
        if(maxPq.isEmpty()){
            return new int[]{0 ,0};
        }
        return new int[] {maxPq.peek(), minPq.peek()};
        
    }
    
    void insertNumber(int number){
       maxPq.add(number);
       minPq.add(number);
    }
    
    void removeMax(){
        Integer polled = maxPq.poll();
        if(polled != null){
            minPq.remove(polled);
        }
    }
    
    void removeMin(){
       Integer polled = minPq.poll(); 
        if(polled != null){
            maxPq.remove(polled);
        }
    }
}