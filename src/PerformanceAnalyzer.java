package src;

import java.util.Arrays;

public class PerformanceAnalyzer {

    public static void compareSearchAlgorithms(int[] originalArray, int target) {
        if (originalArray == null || originalArray.length == 0) {
            System.out.println("No data available for performance comparison.");
            return;
        }

        long linearStart = System.nanoTime();
        int linearResult = SearchAlgorithms.linearSearch(originalArray, target);
        long linearEnd = System.nanoTime();

        long linearTime = linearEnd - linearStart;
        int linearSteps =
                SearchAlgorithms.linearSearchSteps(originalArray, target);

        int[] sortedArray = Arrays.copyOf(
            originalArray,
            originalArray.length
        );
        Arrays.sort(sortedArray);

        long binaryStart = System.nanoTime();
        int binaryResult = SearchAlgorithms.binarySearch(sortedArray, target);
        long binaryEnd = System.nanoTime();

        long binaryTime = binaryEnd - binaryStart;
        int binarySteps =
                SearchAlgorithms.binarySearchSteps(sortedArray, target);

        System.out.println();
        System.out.println("==============================================");
        System.out.println("       SEARCH PERFORMANCE COMPARISON");
        System.out.println("==============================================");

        System.out.printf(
            "%-20s %-12s %-15s%n",
            "Algorithm",
            "Steps",
            "Time (ns)"
        );

        System.out.println("----------------------------------------------");

        System.out.printf(
            "%-20s %-12d %-15d%n",
            "Linear Search",
            linearSteps,
            linearTime
        );

        System.out.printf(
            "%-20s %-12d %-15d%n",
            "Binary Search",
            binarySteps,
            binaryTime
        );

        System.out.println("----------------------------------------------");

        System.out.println(
            "Linear Search Result: " +
            (linearResult != -1 ? "Found" : "Not Found")
        );

        System.out.println(
            "Binary Search Result: " +
            (binaryResult != -1 ? "Found" : "Not Found")
        );

        System.out.println();
        System.out.println("Complexity:");
        System.out.println("Linear Search: O(n)");
        System.out.println("Binary Search: O(log n)");
    }

    public static void measureBFS(Graph graph, int startVertex) {
        if (graph == null) {
            System.out.println("Graph is not available.");
            return;
        }

        long startTime = System.nanoTime();
        graph.BFS(startVertex);
        long endTime = System.nanoTime();

        System.out.println(
            "BFS Execution Time: " +
            (endTime - startTime) +
            " ns"
        );

        System.out.println("BFS Complexity: O(V + E)");
    }

    public static void measureDFS(Graph graph, int startVertex) {
        if (graph == null) {
            System.out.println("Graph is not available.");
            return;
        }

        long startTime = System.nanoTime();
        graph.DFS(startVertex);
        long endTime = System.nanoTime();

        System.out.println(
            "DFS Execution Time: " +
            (endTime - startTime) +
            " ns"
        );

        System.out.println("DFS Complexity: O(V + E)");
    }

    public static void displayComplexityInformation() {
        System.out.println();
        System.out.println("==============================================");
        System.out.println("       ALGORITHM COMPLEXITY");
        System.out.println("==============================================");

        System.out.println("Array Search       : O(n)");
        System.out.println("Array Insert       : O(1) average");
        System.out.println("Array Delete       : O(n)");

        System.out.println("Linear Search      : O(n)");
        System.out.println("Binary Search      : O(log n)");

        System.out.println("Stack Push         : O(1)");
        System.out.println("Stack Pop          : O(1)");
        System.out.println("Stack Peek         : O(1)");

        System.out.println("Queue Enqueue      : O(1)");
        System.out.println("Queue Dequeue      : O(1)");
        System.out.println("Queue Front        : O(1)");

        System.out.println("Linked List Search : O(n)");
        System.out.println("Linked List Delete : O(n)");

        System.out.println("BFS                : O(V + E)");
        System.out.println("DFS                : O(V + E)");

        System.out.println("==============================================");
    }
}
