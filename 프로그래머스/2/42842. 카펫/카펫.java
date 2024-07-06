import java.util.*;

class Solution {
     public int[] solution(int brown, int yellow) {

        int[] answer = new int[2];

        int size = brown + yellow;

        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= size; i++){
            if( size % i == 0 ){
                list.add(i);
            }
        }

        System.out.println(list.toString());

        for(int i = 0; i< list.size(); i++){

            for(int j=0; j< list.size(); j++){
                if(list.get(i) <3 || list.get(j) < 3){
                    continue;
                }

                if(list.get(i) * list.get(j) == size){
                    answer[0] =  Math.max(list.get(i), list.get(j));
                    answer[1] =  Math.min(list.get(i), list.get(j));
                    
                    if((list.get(i) - 2) * (list.get(j) - 2) == yellow ){
                        return answer;
                    }
                }
            }
        }

        return answer;
    }
}