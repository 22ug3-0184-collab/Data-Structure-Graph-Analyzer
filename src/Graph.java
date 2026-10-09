package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {

    private Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        if (adjacencyList.containsKey(vertex)) {
            System.out.println("Vertex " + vertex + " already exists.");
            return;
        }

        adjacencyList.put(vertex, new ArrayList<>());
        System.out.println("Vertex " + vertex + " added successfully.");
    }

    public void addEdge(int vertex1, int vertex2) {
        if (!adjacencyList.containsKey(vertex1)) {
            System.out.println("Vertex " + vertex1 + " does not exist.");
            return;
        }

        if (!adjacencyList.containsKey(vertex2)) {
            System.out.println("Vertex " + vertex2 + " does not exist.");
            return;
        }

        if (adjacencyList.get(vertex1).contains(vertex2)) {
            System.out.println("Edge already exists.");
            return;
        }

        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);

        System.out.println(
            "Edge added between " + vertex1 + " and " + vertex2 + "."
        );
    }

    public void displayGraph() {
        if (adjacencyList.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }

        System.out.println("\nGraph:");

        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");

            for (int neighbour : entry.getValue()) {
                System.out.print(neighbour + " ");
            }

            System.out.println();
        }
    }

    public void BFS(int startVertex) {
        if (!adjacencyList.containsKey(startVertex)) {
            System.out.println("Starting vertex does not exist.");
            return;
        }

        Set<Integer> visited = new HashSet<>();
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();

        queue.add(startVertex);
        visited.add(startVertex);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbour : adjacencyList.get(current)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }

        System.out.println();
    }

    public void DFS(int startVertex) {
        if (!adjacencyList.containsKey(startVertex)) {
            System.out.println("Starting vertex does not exist.");
            return;
        }

        Set<Integer> visited = new HashSet<>();

        System.out.print("DFS Traversal: ");
        dfsRecursive(startVertex, visited);
        System.out.println();
    }

    private void dfsRecursive(int vertex, Set<Integer> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");

        for (int neighbour : adjacencyList.get(vertex)) {
            if (!visited.contains(neighbour)) {
                dfsRecursive(neighbour, visited);
            }
        }
    }

    public boolean containsVertex(int vertex) {
        return adjacencyList.containsKey(vertex);
    }

    public int getVertexCount() {
        return adjacencyList.size();
    }

    public int getEdgeCount() {
        int total = 0;

        for (List<Integer> neighbours : adjacencyList.values()) {
            total += neighbours.size();
        }

        return total / 2;
    }
}
