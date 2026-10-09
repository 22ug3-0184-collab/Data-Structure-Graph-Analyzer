package src;

/**
 * Queue.java
 * Member 3 — Queue Implementation
 *
 * Implements Queue operations:
 *   - Enqueue
 *   - Dequeue
 *   - Peek / Front
 *   - Display
 *
 * Queue follows FIFO:
 * First In, First Out
 */
public class Queue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;

    private static final int DEFAULT_CAPACITY = 100;

    // ---------- CONSTRUCTOR ----------
    public Queue() {
        queue = new int[DEFAULT_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Constructor with custom capacity
    public Queue(int capacity) {

        if (capacity <= 0) {
            capacity = DEFAULT_CAPACITY;
        }

        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // ---------- ENQUEUE ----------
    public boolean enqueue(int value) {

        if (isFull()) {
            System.out.println(">> Error: Queue is full. Cannot enqueue " + value);
            return false;
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        size++;

        System.out.println(">> Enqueued " + value + " into the queue.");
        return true;
    }

    // ---------- DEQUEUE ----------
    public int dequeue() {

        if (isEmpty()) {
            System.out.println(">> Error: Queue is empty. Cannot dequeue.");
            return -1;
        }

        int value = queue[front];

        front = (front + 1) % queue.length;
        size--;

        System.out.println(">> Dequeued " + value + " from the queue.");
        return value;
    }

    // ---------- PEEK / FRONT ----------
    public int peek() {

        if (isEmpty()) {
            System.out.println(">> Error: Queue is empty. Nothing to peek.");
            return -1;
        }

        System.out.println(">> Front element: " + queue[front]);
        return queue[front];
    }

    // ---------- DISPLAY ----------
    public void display() {

        if (isEmpty()) {
            System.out.println(">> Queue is empty.");
            return;
        }

        System.out.println(">> Queue elements (Front to Rear):");

        for (int i = 0; i < size; i++) {
            int index = (front + i) % queue.length;
            System.out.println("   " + queue[index]);
        }
    }

    // ---------- CHECK EMPTY ----------
    public boolean isEmpty() {
        return size == 0;
    }

    // ---------- CHECK FULL ----------
    public boolean isFull() {
        return size == queue.length;
    }

    // ---------- SIZE ----------
    public int size() {
        return size;
    }

    // ---------- CLEAR ----------
    public void clear() {
        front = 0;
        rear = -1;
        size = 0;

        System.out.println(">> Queue cleared.");
    }
}