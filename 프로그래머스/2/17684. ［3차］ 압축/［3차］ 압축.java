import java.util.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<Integer, String> hashMap = new HashMap<Integer,String>();
       
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        String preDefinedLib = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int currentLastIndex = 26;
        
        String tmpMsg = msg;
        
        for(int i=0;i<preDefinedLib.length();i++){
            hashMap.put(i+1, preDefinedLib.substring(i, i+1));
        }
        
        while(tmpMsg.length() >0) {
            String target = tmpMsg.substring(0,1);
            int maxLen = tmpMsg.length();
            
            int index = findLongestWordIndex(hashMap, target, maxLen,tmpMsg);
            
            answer.add(index);
            
            String longestWord = hashMap.get(index);
            
             tmpMsg = tmpMsg.substring(longestWord.length(), tmpMsg.length());
            
            if(tmpMsg.length() >0){
                hashMap.put(++currentLastIndex, longestWord+tmpMsg.substring(0,1));
            }
        }
       
        int[] answerArr = new int[answer.size()];
        
        for(int i=0;i<answer.size();i++){
            answerArr[i] = answer.get(i);
        }
        
        return answerArr;
    }
    
    int findLongestWordIndex(HashMap<Integer, String> hashMap, String s, int maxLen, String tmpMsg){
       Iterator iterator = hashMap.keySet().iterator(); 
        
      	int maxKey = -1; 
        String maxString = "";
        
       while(iterator.hasNext()){
          int key = (int) iterator.next();
           String value = hashMap.getOrDefault(key, "");
          if(value.startsWith(s)){
			 if(tmpMsg.startsWith(value)){
                 if(maxString.length() < value.length()){
                     maxString = value;
                     maxKey = key;
                 }
             }
          } 
       }
        
        return maxKey;
    }
}