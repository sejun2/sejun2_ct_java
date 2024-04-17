package graph;

import java.util.LinkedList;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        DfsGraph graph = new DfsGraph(9);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 2);
        graph.addEdge(4, 3);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 8);

        graph.dfs();
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

}
