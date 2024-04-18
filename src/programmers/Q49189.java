package programmers;

import java.sql.Array;
import java.util.*;

class Main3 {
    public static void main(String[] args) {
        Q49189 q = new Q49189();


        q.solution(6,
                new int[][]{
                        new int[]{3, 6},
                        new int[]{4, 3}, new int[]{3, 2}, new int[]{1, 3}, new int[]{1, 2}, new int[]{2, 4},
                        new int[]{5, 2},
                }

        );
    }
}

// 가장 먼 노드
public class Q49189 {

    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    boolean[] visited = null;
    int[] distance = new int[]{0, 0, 0, 0, 0, 0, 0};

    //[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]

    int solution(int n, int[][] edge) {
        // init visited
        visited = new boolean[n + 1];
        for (int i = 1; i < visited.length; i++) {
            visited[i] = false;
        }


        // 그래프 초기화
        for (int i = 1; i < edge.length + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 간선 추가
        for (int i = 1; i < edge.length + 1; i++) {
            System.out.println((edge[i - 1][0]) + "  ::  " + edge[i - 1][1]);
            graph.get(edge[i - 1][0]).add(edge[i - 1][1]);
            graph.get(edge[i - 1][1]).add(edge[i - 1][0]);
        }

        System.out.println(graph);

        return bfs();
    }

    int bfs() {
        Queue<Integer> queue = new LinkedList<>();

        // 시작은 1번 노드
        queue.add(1);
        visited[1] = true;


        while (!queue.isEmpty()) {
            var node = queue.poll();

            System.out.println("visit :: " + node);

            ArrayList<Integer> adjacent = graph.get(node);

            for (var i = 0; i < adjacent.size(); i++) {
                if (visited[adjacent.get(i)] == true) continue;

                queue.add(adjacent.get(i));
                visited[adjacent.get(i)] = true;
                distance[adjacent.get(i)] = distance[node] + 1;
            }
        }

        Arrays.sort(distance);

        int max = distance[distance.length - 1];
        int answer = 0;

        for (var i = 0; i < distance.length; i++) {
                if(distance[i] == max){
                    answer++;
                }
        }
        return answer;
    }


}
