import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        List<Node> nodeList = new ArrayList<Node>();
       
        int start =0;
        int end = 0;
        
        int sum = sequence[0];
        
        while(end < sequence.length){
            
            if(sum < k){
                end++;
                if(end < sequence.length){
                	sum += sequence[end];
                }else{
                    break;
                }
            }
            
            if(sum > k){
                sum -= sequence[start++];
                if(start >= sequence.length || start >end){
                    break;
                }
            }
            
          if(sum == k){
              nodeList.add(new Node(start, end));
              end ++;
              if(end < sequence.length){
              sum += sequence[end];
              }
              continue;
          }
        }
        
        Collections.sort(nodeList);
        
        return new int[]{nodeList.get(0).start, nodeList.get(0).end};
    }
    
    class Node implements Comparable<Node> {
        int start;
        int end;
        int length;
        
        Node(int start, int end){
            this.start = start;
            this.end = end;
            this.length = start-end;
        }
        
        @Override
        public int compareTo(Node node){
            if(node.length > length){
               return 1; 
            }else if(node.length < length){
                return -1;
            }
            
            return 0;
        }
    }
}