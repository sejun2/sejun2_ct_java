import java.util.*;

class Solution {
      public String[] solution(String[] files) {

        // 문자 / 숫자 / 아무값, null가능


            Arrays.sort(files, (a,b) -> {
                int[] aIndexs = processString(a);
                int[] bIndexs = processString(b);

                int headCompare = compareHead(a.substring(0,aIndexs[0]+1), b.substring(0,bIndexs[0]+1));
                if(headCompare != 0){
                    return headCompare;
                }

                int numberCompare = compareNumber(a.substring(aIndexs[0]+1, aIndexs[1]+1), b.substring(bIndexs[0]+1, bIndexs[1]+1));
                if(numberCompare != 0){
                    return numberCompare;
                }
                
                return 0;
            });
        return files;
    }

    int compareHead(String a, String b) {
        String pa = a.toLowerCase();
        String pb = b.toLowerCase();

        return pa.compareTo(pb);
    }

    int compareNumber(String a, String b){
        int pa = Integer.parseInt(a);
        int pb = Integer.parseInt(b);

        return pa - pb;
    }

    int[] processString(String s){
        int headEndIndex =0;
        int numberEndIndex = 0;

        // find headEndIndex
        for(int i= 0;i<s.length();i++){
            if(isNumber(s.charAt(i))) {
                headEndIndex = i -1;
                break;
            }
        }

        // find numberEndIndex
        for(int i=headEndIndex+1; i<s.length();i++){
             if(i == s.length()-1){
                numberEndIndex = s.length()-1;
                break;
            }
            
            if(!isNumber(s.charAt(i))){
                numberEndIndex = i -1;
                break;
            }
        }

        return new int[]{headEndIndex, numberEndIndex};
    }



    boolean isNumber(char c){
        return c >= '0' && c<= '9';
    }
}