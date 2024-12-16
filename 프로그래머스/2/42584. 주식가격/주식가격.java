class Solution {
    public int[] solution(int[] prices) {
        Node[] nodeArr = new Node[prices.length];
        
        // 노드 배열 초기화
        for(int i = 0; i < prices.length; i++){
           nodeArr[i] = new Node(prices[i], 0, false);
        }
        
        // 각 시점마다 뒤의 가격들과 비교
        for(int i = 0; i < prices.length; i++){
            int count = 0;
            // 현재 시점 이후의 가격들만 확인
            for(int j = i + 1; j < prices.length; j++){
                count++;
                if(prices[i] > prices[j]){
                    break;
                }
            }
            nodeArr[i].count = count;
        }
        
        int[] answer = new int[prices.length];
        for(int i = 0; i < nodeArr.length; i++){
            answer[i] = nodeArr[i].count;
        }
        
        return answer;
    }
}

class Node {
    int price;
    int count;
    boolean flag;
    
    public Node(int p, int c, boolean f){
        this.price = p;
        this.count = c;
        this.flag = f;
    }
}