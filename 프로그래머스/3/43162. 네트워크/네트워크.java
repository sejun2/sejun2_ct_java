class Solution {
    int answer = 0;

    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];

        for (var i = 0; i < n; i++) {
            if (visited[i] == false) {
                answer++;
                bfs(visited, computers, i, n);
            }
        }
        return answer;
    }

    void bfs(boolean[] visited, int[][] arr, int n, int size) {

        System.out.println(n);

        visited[n] = true;

        for (int i = 0; i < size; i++) {
            if (visited[i] == false && arr[n][i] == 1) {
                bfs(visited, arr, i, size);
            }
        }
    }
}