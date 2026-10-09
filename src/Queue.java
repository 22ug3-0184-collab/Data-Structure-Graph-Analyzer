<<<<<<< Updated upstream
=======
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

>>>>>>> Stashed changes
public class Queue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public Queue() {
        queue = new int[DEFAULT_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value) {
        if (size == queue.length) {
            resize();
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        size++;

        System.out.println("Value " + value + " added to the queue.");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }

        int value = queue[front];
        front = (front + 1) % queue.length;
        size--;

        System.out.println("Value " + value + " removed from the queue.");
        return value;
    }

    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to display.");
            return -1;
        }
        return queue[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("\nQueue elements:");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % queue.length;
            System.out.print(queue[index] + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize() {
        int[] newQueue = new int[queue.length * 2];

        for (int i = 0; i < size; i++) {
            int index = (front + i) % queue.length;
            newQueue[i] = queue[index];
        }

        queue = newQueue;
        front = 0;
        rear = size - 1;
    }
}
