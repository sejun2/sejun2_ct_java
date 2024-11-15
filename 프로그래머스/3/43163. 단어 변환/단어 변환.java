import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length+1];

        ArrayList<Integer>[] graph = new ArrayList[words.length+1];

        String[] tmpWords = new String[words.length + 1];
        tmpWords[0] = begin;

        for (int i = 1; i < words.length + 1; i++) {
            tmpWords[i] = words[i - 1];
        }

        //make graph
        for (int i = 0; i < tmpWords.length; i++) {
            graph[i] = new ArrayList<Integer>();

            for (int j = 0; j < tmpWords.length; j++) {
                if (tmpWords[i].equals(tmpWords[j])) {
                    continue;
                }

                if (hasMatch(tmpWords[i], tmpWords[j])) {
                    graph[i].add(j);
                }
            }
        }
      

        return bfs(visited, 0, graph, tmpWords, target);
    }

    boolean hasMatch(String a, String b) {
        int count = 0;

        for (int i = 0; i < a.length(); i++) {
            if (b.charAt(i) != a.charAt(i)) {
                count++;
            }
        }

        return count == 1;
    }

    int bfs(boolean[] visited, int index, ArrayList<Integer>[] graph, String[] tmpWords, String answer) {
        Queue<Integer> q = new LinkedList<>();

        int[] distance = new int[tmpWords.length];

        q.add(index);

        distance[index] = 0;

        while (!q.isEmpty()) {
            int peekIndex = q.peek();

            visited[peekIndex] = true;
            q.poll();
            System.out.println(tmpWords[peekIndex]);
            if(tmpWords[peekIndex].equals(answer)){
                return distance[peekIndex];
            }

            var iterator = graph[peekIndex].iterator();

            while (iterator.hasNext()) {
                var data = iterator.next();

                if (visited[data] != true && !q.contains(data)) {
                   
                    q.add(data);
                    distance[data] = distance[peekIndex]+1;
                }
            }
        }

        return 0;
    }
}