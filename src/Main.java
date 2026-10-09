import java.util.Scanner;

public class Main {

static ArrayManager arrayManager = new ArrayManager();
static SearchAlgorithms searchAlgorithms = new SearchAlgorithms();
static Stack stack = new Stack();
static Queue queue = new Queue();
static LinkedList linkedList = new LinkedList();
static Graph graph = new Graph();    
static PerformanceAnalyzer performanceAnalyzer = new PerformanceAnalyzer();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {

            displayMainMenu();

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    System.out.println("Array Operations selected.");
                    break;

                case 2:
                    System.out.println("Stack Operations selected.");
                    break;

                case 3:
                    System.out.println("Queue Operations selected.");
                    break;

                case 4:
                    System.out.println("Linked List Operations selected.");
                    break;

                case 5:
                    System.out.println("Searching Operations selected.");
                    break;

                case 6:
                    System.out.println("Graph Operations selected.");
                    break;

                case 7:
                    System.out.println("Performance Comparison selected.");
                    break;

                case 8:
                    System.out.println("Display All Results selected.");
                    break;

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

    static void displayMainMenu() {

        System.out.println();
        System.out.println("==================================================");
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

    static int readInt(String message) {

        while (true) {

            System.out.print(message);

            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }

            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
    }

}