package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        System.out.println("DFS");
        DfsGraph graph1 = new DfsGraph(9);

        graph1.addEdge(0, 1);
        graph1.addEdge(1, 2);
        graph1.addEdge(1, 3);
        graph1.addEdge(2, 4);
        graph1.addEdge(3, 4);
        graph1.addEdge(3, 5);
        graph1.addEdge(5, 6);
        graph1.addEdge(5, 7);
        graph1.addEdge(6, 8);

        graph1.dfs();

        System.out.println("DFS Recursive");
        DfsGraph graph2 = new DfsGraph(9);

        graph2.addEdge(0, 1);
        graph2.addEdge(1, 2);
        graph2.addEdge(1, 3);
        graph2.addEdge(2, 4);
        graph2.addEdge(3, 4);
        graph2.addEdge(3, 5);
        graph2.addEdge(5, 6);
        graph2.addEdge(5, 7);
        graph2.addEdge(6, 8);

        graph2.dfsRecursive();

        DfsGraph graph3 = new DfsGraph(9);

        graph3.addEdge(0, 1);
        graph3.addEdge(1, 2);
        graph3.addEdge(1, 3);
        graph3.addEdge(2, 4);
        graph3.addEdge(3, 4);
        graph3.addEdge(3, 5);
        graph3.addEdge(5, 6);
        graph3.addEdge(5, 7);
        graph3.addEdge(6, 8);

        System.out.println("BFS");
        graph3.bfs();
    }
}

class DfsGraph {

    Node[] nodes;

    class Node {
        int data;
        LinkedList<Node> adjacent;
        boolean isVisited;

        Node(int data) {
            this.data = data;
            this.adjacent = new LinkedList();
            this.isVisited = false;
        }
    }

    DfsGraph(int size) {
        nodes = new Node[size];

        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node node1 = nodes[i1];
        Node node2 = nodes[i2];

        if (!node1.adjacent.contains(node2)) {
            node1.adjacent.add(node2);
        }
        if (!node2.adjacent.contains(node1)) {
            node2.adjacent.add(node1);
        }
    }

    void dfs() {
        dfs(0);
    }

    void dfsRecursive() {
        dfsRecursive(nodes[0]);
    }

    void dfsRecursive(Node node) {
        node.isVisited = true;
        System.out.println(node.data);


        for (int i = 0; i < node.adjacent.size(); i++) {
            if (node.adjacent.get(i).isVisited || node.adjacent.get(i).adjacent.isEmpty()) continue;

            dfsRecursive(node.adjacent.get(i));
        }
    }

    void dfs(int index) {
        Node root = nodes[index];

        Stack<Node> stack = new Stack<Node>();

        stack.push(root);
        root.isVisited = true;

        while (!stack.isEmpty()) {
            Node n = stack.pop();
            System.out.println("Node :: " + n.data);

            for (int i = 0; i < n.adjacent.size(); i++) {
                if (n.adjacent.get(i).isVisited) continue;

                n.adjacent.get(i).isVisited = true;
                stack.push(n.adjacent.get(i));
            }
        }
    }

    void bfs() {
        bfs(0);
    }

    void bfs(int index) {
        Queue<Node> queue = new LinkedList<>();

        Node root = nodes[index];

        queue.add(root);
        root.isVisited = true;

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            System.out.println(n.data);

            for (int i = 0; i < n.adjacent.size(); i++) {
                if (n.adjacent.get(i).isVisited) continue;

                n.adjacent.get(i).isVisited = true;

                queue.add(n.adjacent.get(i));
            }
        }
    }

}
