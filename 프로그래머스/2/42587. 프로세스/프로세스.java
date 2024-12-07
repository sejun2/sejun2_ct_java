import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Node> q = new LinkedList<Node>();
       
        for(int i = 0;i<priorities.length;i++){
            Node n = new Node(priorities[i], i == location);
            q.add(n);
        }
       
        int count = 0;
        
        while(!q.isEmpty()){
            Node polled = q.poll();
            
           	boolean flag = false;
       		
            for(Node data: q){
                if(data.priority > polled.priority){
                    q.add(polled);
                    flag = true;
                    break;
                }
            }
           
           if(!flag) {
               if(polled.isTarget){
                   return priorities.length - q.size() ;
               }
           }
        }
        
        return 0;
    }
}

class Node {
    int priority;
    boolean isTarget;
    
    Node(int p, boolean t){
        this.priority = p;
        this.isTarget = t;
    }
}