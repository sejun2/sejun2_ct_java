
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class AAA {
    public static void main(String[] args) {
        LinkedList<Integer>[] graph = new LinkedList[7];
        boolean[] visited = new boolean[7];

        for (var i = 0; i < 7; i++) {
            graph[i] = new LinkedList<>();
        }

        graph[0].add(1);
        graph[0].add(2);
        graph[0].add(3);
        graph[1].add(6);
        graph[1].add(0);
        graph[2].add(6);
        graph[2].add(5);
        graph[2].add(4);

        System.out.print("dfsStack\n");
        dfsStack(0, graph, new boolean[7]);
        System.out.print("dfs\n");
        dfs(0, graph, new boolean[7]);
        System.out.print("bfs\n");
        bfs(0, graph, new boolean[7]);
    }

    static void dfs(int v, LinkedList<Integer>[] graph, boolean[] visited) {
        visited[v] = true;
        System.out.println(v + " 방문");

        Iterator<Integer> iterator = graph[v].iterator();

        while (iterator.hasNext()) {
            int a = iterator.next();

            if (visited[a] != true) {
                dfs(a, graph, visited);
            }
        }
    }

    static void dfsStack(int v, LinkedList<Integer>[] graph, boolean[] visited){
        Stack<Integer> stack = new Stack<Integer>();

        stack.add(v);
        System.out.println(v + " 방문");

        while(!stack.isEmpty()){
            var element = stack.peek();
            visited[element] = true;
            var iter = graph[element].iterator();

            boolean hasVisitFlag = false;

            while(iter.hasNext()){
                var data = iter.next();
                if(!stack.contains(data) && !visited[data]){
                    stack.add(data);
                    System.out.println(data + " 방문");
                    hasVisitFlag = true;
                    break;
                }
            }

            if(!hasVisitFlag){
                stack.pop();
            }
        }
    }

    static void bfs(int v, LinkedList<Integer>[] graph, boolean[] visited) {
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(v);
        visited[v] = true;
        System.out.println(v + " 방문");

        while (!q.isEmpty()) {
            var res = q.poll();

            var iterator = graph[res].iterator();
            while (iterator.hasNext()){
                var data = iterator.next();
                if(!visited[data]){
                    q.add(data);
                    visited[data] = true;
                    System.out.println(data + " 방문");
                }
            }
        }
    }
}
