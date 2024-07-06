class Solution {

    int answer = 0;
    int index = 0;

    public int solution(String word) {
        dfs(word, "");

        return answer;
    }
    void dfs(String word, String text) {
        System.out.println(word + "  ::  "+text+"  ::  "+index);

        if (word.equals(text)) {
            answer = index;
            return;
        }

        index++;

        if(text.length() >=5){
            return;
        }


        dfs(word, text+"A");
        dfs(word, text+"E");
        dfs(word, text+"I");
        dfs(word, text+"O");
        dfs(word, text+"U");
    }
}