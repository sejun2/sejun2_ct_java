import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static boolean[][] graph;
    static int n, v;

    public static void main(String[] args) throws IOException {

        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        v = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        graph = new boolean[n + 1][n + 1];

        for (int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(1);

        int answer = 0;

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) answer++;
        }

        // 시작 지점은 제외해야하기 때문에 answer - 1
        bw.write(String.valueOf(answer - 1));

        br.close();
        bw.close();
    }

    static void dfs(int index) {
        visited[index] = true;

        for (int i = 1; i < n + 1; i++) {
            if (visited[i] == true) continue;

            if (graph[index][i] == true) {
                dfs(i);
            }
        }
    }
}
