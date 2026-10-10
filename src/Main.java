import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    private static final ArrayManager arrayManager = new ArrayManager();
    private static final Stack stack = new Stack();
    private static final Queue queue = new Queue();
    private static final LinkedList linkedList = new LinkedList();
    private static final Graph graph = new Graph();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            displayMainMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1: arrayMenu(); break;
                case 2: stackMenu(); break;
                case 3: queueMenu(); break;
                case 4: linkedListMenu(); break;
                case 5: searchMenu(); break;
                case 6: graphMenu(); break;
                case 7: performanceMenu(); break;
                case 8: displayAllResults(); break;
                case 9:
                    running = false;
                    System.out.println("Thank you for using the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-9.");
            }
        }
        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("\n==================================================");
        System.out.println("       DATA STRUCTURE & GRAPH ANALYZER");
        System.out.println("==================================================");
        System.out.println("1. Array Operations");
        System.out.println("2. Stack Operations");
        System.out.println("3. Queue Operations");
        System.out.println("4. Linked List Operations");
        System.out.println("5. Searching Operations");
        System.out.println("6. Graph Operations");
        System.out.println("7. Performance Comparison");
        System.out.println("8. Display All Results");
        System.out.println("9. Exit");
        System.out.println("==================================================");
    }

    private static void arrayMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- ARRAY OPERATIONS ---");
            System.out.println("1. Insert  2. Delete  3. Search  4. Display  0. Back");
            int choice = readInt("Choice: ");
            switch (choice) {
                case 1: arrayManager.insert(readInt("Value to insert: ")); break;
                case 2: arrayManager.delete(readInt("Value to delete: ")); break;
                case 3:
                    int target = readInt("Value to search: ");
                    int index = arrayManager.search(target);
                    System.out.println(index >= 0 ? "Found at index " + index : "Value not found.");
                    break;
                case 4: arrayManager.display(); break;
                case 0: back = true; break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private static void stackMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- STACK OPERATIONS (LIFO) ---");
            System.out.println("1. Push  2. Pop  3. Peek  4. Display  0. Back");
            int choice = readInt("Choice: ");
            switch (choice) {
                case 1: stack.push(readInt("Value to push: ")); break;
                case 2: stack.pop(); break;
                case 3:
                    if (stack.isEmpty()) System.out.println("Stack is empty.");
                    else System.out.println("Top value: " + stack.peek());
                    break;
                case 4: stack.display(); break;
                case 0: back = true; break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private static void queueMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- QUEUE OPERATIONS (FIFO) ---");
            System.out.println("1. Enqueue  2. Dequeue  3. Front  4. Display  0. Back");
            int choice = readInt("Choice: ");
            switch (choice) {
                case 1: queue.enqueue(readInt("Value to enqueue: ")); break;
                case 2: queue.dequeue(); break;
                case 3:
                    if (queue.isEmpty()) System.out.println("Queue is empty.");
                    else System.out.println("Front value: " + queue.front());
                    break;
                case 4: queue.display(); break;
                case 0: back = true; break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private static void linkedListMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- LINKED LIST OPERATIONS ---");
            System.out.println("1. Insert  2. Delete  3. Search  4. Display  0. Back");
            int choice = readInt("Choice: ");
            switch (choice) {
                case 1: linkedList.insert(readInt("Value to insert: ")); break;
                case 2: linkedList.delete(readInt("Value to delete: ")); break;
                case 3:
                    int target = readInt("Value to search: ");
                    System.out.println(linkedList.search(target) ? "Value found." : "Value not found.");
                    break;
                case 4: linkedList.display(); break;
                case 0: back = true; break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private static void searchMenu() {
        int[] data = arrayManager.getData();
        if (data.length == 0) {
            System.out.println("Array is empty. Insert some values first using Array Operations.");
            return;
        }
        int target = readInt("Enter target value: ");
        SearchAlgorithms.displayLinearSearch(data, target);
        SearchAlgorithms.displayBinarySearch(data, target);
    }

    private static void graphMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- GRAPH OPERATIONS (UNDIRECTED GRAPH) ---");
            System.out.println("1. Add vertex  2. Add edge  3. Display graph");
            System.out.println("4. BFS  5. DFS  6. Graph summary  0. Back");
            int choice = readInt("Choice: ");
            switch (choice) {
                case 1: graph.addVertex(readInt("Vertex value: ")); break;
                case 2:
                    int first = readInt("First vertex: ");
                    int second = readInt("Second vertex: ");
                    graph.addEdge(first, second);
                    break;
                case 3: graph.displayGraph(); break;
                case 4: graph.BFS(readInt("Starting vertex for BFS: ")); break;
                case 5: graph.DFS(readInt("Starting vertex for DFS: ")); break;
                case 6:
                    System.out.println("Vertices: " + graph.getVertexCount());
                    System.out.println("Edges: " + graph.getEdgeCount());
                    break;
                case 0: back = true; break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private static void performanceMenu() {
        int[] data = arrayManager.getData();
        if (data.length > 0) {
            int target = readInt("Target value for search comparison: ");
            PerformanceAnalyzer.compareSearchAlgorithms(data, target);
        } else {
            System.out.println("Insert array values first to compare search algorithms.");
        }
        if (graph.getVertexCount() > 0) {
            int start = readInt("Starting vertex for BFS/DFS timing: ");
            PerformanceAnalyzer.measureBFS(graph, start);
            PerformanceAnalyzer.measureDFS(graph, start);
        } else {
            System.out.println("Add graph vertices first to measure BFS/DFS.");
        }
        PerformanceAnalyzer.displayComplexityInformation();
    }

    private static void displayAllResults() {
        System.out.println("\n========== CURRENT DATA STRUCTURE CONTENTS ==========");
        System.out.println("\nArray:");
        arrayManager.display();
        System.out.println("\nStack:");
        stack.display();
        System.out.println("\nQueue:");
        queue.display();
        System.out.println("\nLinked list:");
        linkedList.display();
        System.out.println("\nGraph:");
        graph.displayGraph();
        System.out.println("\nAlgorithm complexity reference:");
        PerformanceAnalyzer.displayComplexityInformation();
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
            System.out.println("Invalid input. Please enter a whole number.");
            scanner.next();
        }
    }
}
