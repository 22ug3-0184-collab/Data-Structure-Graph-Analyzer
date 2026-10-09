import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {

    // Adjacency list representation
    private Map<String, ArrayList<String>> graph;

    // Constructor
    public Graph() {
        graph = new HashMap<>();
    }

    // Add a vertex
    public void addVertex(String vertex) {

        if (!graph.containsKey(vertex)) {
            graph.put(vertex, new ArrayList<>());
            System.out.println("Vertex added: " + vertex);
        } else {
            System.out.println("Vertex already exists: " + vertex);
        }
    }

    // Add an edge between two vertices
    public void addEdge(String source, String destination) {

        if (!graph.containsKey(source)) {
            System.out.println("Source vertex does not exist.");
            return;
        }

        if (!graph.containsKey(destination)) {
            System.out.println("Destination vertex does not exist.");
            return;
        }

        if (!graph.get(source).contains(destination)) {
            graph.get(source).add(destination);
        }

        if (!graph.get(destination).contains(source)) {
            graph.get(destination).add(source);
        }

        System.out.println("Edge added: " + source + " <-> " + destination);
    }

    // Display the graph
    public void displayGraph() {

        if (graph.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }

        System.out.println("\nGraph:");

        for (String vertex : graph.keySet()) {

            System.out.print(vertex + " -> ");

            ArrayList<String> connections = graph.get(vertex);

            for (String connection : connections) {
                System.out.print(connection + " ");
            }

            System.out.println();
        }
    }

    // Breadth First Search
    public void bfs(String startVertex) {

        if (!graph.containsKey(startVertex)) {
            System.out.println("Starting vertex does not exist.");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.add(startVertex);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {

            String current = queue.poll();

            System.out.print(current + " ");

            for (String neighbour : graph.get(current)) {

                if (!visited.contains(neighbour)) {

                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }

        System.out.println();
    }

    // Depth First Search
    public void dfs(String startVertex) {

        if (!graph.containsKey(startVertex)) {
            System.out.println("Starting vertex does not exist.");
            return;
        }

        Set<String> visited = new HashSet<>();

        System.out.print("DFS Traversal: ");

        dfsRecursive(startVertex, visited);

        System.out.println();
    }

    // Recursive method for DFS
    private void dfsRecursive(String vertex, Set<String> visited) {

        visited.add(vertex);

        System.out.print(vertex + " ");

        for (String neighbour : graph.get(vertex)) {

            if (!visited.contains(neighbour)) {
                dfsRecursive(neighbour, visited);
            }
        }
    }
}
