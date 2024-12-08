import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
       
        HashMap<String, ArrayList<Node>> genMap = new HashMap<>();
        ArrayList<Total> totalList = new ArrayList<>();
        
        Comparator totalCom = new Comparator<Total>()
            {
                @Override
                public int compare(Total t1, Total t2){
                    return -(t1.total - t2.total);
                }
            };
        
        for(int i = 0; i<genres.length;i++){
            ArrayList<Node> list = genMap.getOrDefault(genres[i], new ArrayList<>());
           	list.add(new Node(genres[i], plays[i], i)); 
            genMap.put(genres[i], list);
        }
        
        for(String g: genMap.keySet()){
            Total t = new Total(g,0);
            for(Node n : genMap.get(g)){
              t.total = t.total + n.plays; 
            }
            
            totalList.add(t);
        }
        
        // sort genres by totalplay 
        Collections.sort(totalList, totalCom);
       
        ArrayList<Node> tmpAnswerList = new ArrayList<>();
        
        for(Total t : totalList){
           ArrayList<Node> nodeList = genMap.get(t.genres);
          
            Collections.sort(nodeList, new Comparator<Node>(){
                @Override
                public int compare(Node n1, Node n2){
                   return -(n1.plays - n2.plays);
                }
            });
            
            for(int i = 0; i <nodeList.size();i++){
                if(i >=2){
                    break;
                }
                
                tmpAnswerList.add(nodeList.get(i)); 
            }
        }
        
        int[] answer = new int[tmpAnswerList.size()];
        
        for(int i = 0; i<tmpAnswerList.size();i++){
            answer[i] = tmpAnswerList.get(i).index;
        }
        
       
        return answer;
    }
}

class Total {
    String genres;
    int total;
    
    public Total(String g, int t){
        this.genres = g;
        this.total = t;
    }
}

class Node {
    String genres;
    int plays;
    int index;
    
    public Node(String g, int p, int i){
        this.genres = g;
        this.plays = p;
        this.index = i;
    }
}