import java.util.*;
import java.lang.*;

class Solution {
        public int solution(int[] cards) {
        int max = 0;

        for (int i = 0; i < cards.length; i++) {
            var tmpCards = cards.clone();
            List<Integer> group1 = getGroup1(tmpCards, i);

            for(int j= 0; j<cards.length;j++){
                if(tmpCards[j] == -1) continue;
                List<Integer> group2 = getGroup1(tmpCards, j);

                max = Math.max(group1.size() * group2.size(), max);
            }
        }

        System.out.println("max :: "+max);

        return max;
    }


    List<Integer> getGroup1(int[] cards, int i) {
        //i:: selected box
        List<Integer> group1 = new ArrayList<>();

        int cardIndex = i;
        int parsedCardIndex = -1;

        group1.add(cards[cardIndex]);
        parsedCardIndex = cards[cardIndex] - 1;
        cards[cardIndex] = -1;

        while (cards[parsedCardIndex] != -1) {
            group1.add(cards[parsedCardIndex]);
            int tmp = cards[parsedCardIndex];
            cards[parsedCardIndex] = -1;
            parsedCardIndex = tmp - 1;
        }

        return group1;
    }

}