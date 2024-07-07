import java.util.*;

class Solution {
     List<Integer>[] graph;

    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n + 1];

        // make tree
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        // set values
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];

            graph[v1].add(v2);
            graph[v2].add(v1);
        }


        int answer = -1;
        for (int i = 0; i < wires.length; i++) {
            count = 0;
            boolean[] visited = new boolean[n + 1];

            int v1 = wires[i][0];
            int v2 = wires[i][1];

            // remove vertex
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));

            dfs(1, visited);

            graph[v1].add(v2);
            graph[v2].add(v1);

            if (answer < 0) {
                answer = Math.abs(Math.abs(n - count) - count);
            }

            System.out.println(answer);
            answer = Math.min(answer, Math.abs(Math.abs(n-count) - count));
        }


        return answer;
    }

    int count = 0;

    int dfs(int node, boolean[] visited) {
        visited[node] = true;
        count++;

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next, visited);
            }
        }

        return count;
    }
}