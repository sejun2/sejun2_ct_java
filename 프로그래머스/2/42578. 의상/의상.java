import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
       
        int answer = 1;
        
       	for(String[] sArr : clothes) {
            ArrayList<String> list = map.getOrDefault(sArr[1], new ArrayList<String>());
            list.add(sArr[0]);
            
            map.put(sArr[1], list);
        }
    
        for(ArrayList<String> list : map.values()){
           answer = answer * (list.size()+1); 
        }
        
        return answer -1;
    }
}