/**
 * 인접 리스트 그래프 구현
 */
package graph;

import java.util.ArrayList;

class Graph {

    final ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    Graph(int size) {
        for (int i = 0; i < size + 1; i++) {
            graph.add(new ArrayList<Node>());
        }
    }

    void putEdge(int start, int end) {
        graph.get(start).add(new Node(end));
        graph.get(end).add(new Node(start));
    }

    void putEdge(int start, int end, boolean isDirected) {
        try {
            graph.get(start).add(new Node(end));
            if (!isDirected) {
                graph.get(end).add(new Node(start));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void printGraph() {
        for (int i = 1; i < graph.size(); i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(graph.get(i).get(j).data + " ");
            }
            System.out.println();
        }
    }

    static class Node {
        int data;

        Node(int data) {
            this.data = data;
        }
    }
}

class GraphList {
    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.putEdge(1, 2, true);
        graph.putEdge(1, 3, true);
        graph.putEdge(1, 4, true);
        graph.putEdge(2, 3, true);
        graph.putEdge(4, 4, true);

        graph.printGraph();
    }
}