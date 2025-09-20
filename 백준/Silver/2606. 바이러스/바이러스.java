import java.io.*;
import java.util.StringTokenizer;

public class Main {
     public static void main(String[] args) throws IOException {
        // 1. DFS
        DFS.solution();

        // 2. BFS
    }

    static class DFS {

        static void solution() throws IOException {
            boolean[][] graph;
            boolean[] visited;

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n, v;

            n = Integer.parseInt(br.readLine());
            v = Integer.parseInt(br.readLine());

            visited = new boolean[n + 1];

            // 그래프 초기화
            // 1부터 시작하므로 n+1
            graph = new boolean[n + 1][n + 1];
            for (int i = 0; i < v; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x][y] = true;
                graph[y][x] = true;
            }

            dfs(1, graph, visited, n);

            int answer = 0;

            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) answer++;
            }

            // 시작 노드는 제외하므로 answer - 1
            bw.write(String.valueOf(answer - 1));

            br.close();
            bw.close();
        }

        static void dfs(int index, boolean[][] graph, boolean[] visited, int n) {
            visited[index] = true;

            for (int i = 1; i <= n; i++) {
                if (visited[i] == true) continue;

                if (graph[index][i] == true) {
                    dfs(i, graph, visited, n);
                }
            }
        }
    }
}