package src;

/**
 * Stack.java
 * Member 3 — Stack Implementation
 *
 * Implements Stack operations:
 *   - Push
 *   - Pop
 *   - Peek
 *   - Display
 *
 * Stack follows LIFO:
 * Last In, First Out
 */
public class Stack {

    private int[] stack;
    private int top;
    private static final int DEFAULT_CAPACITY = 100;

    // ---------- CONSTRUCTOR ----------
    public Stack() {
        stack = new int[DEFAULT_CAPACITY];
        top = -1;
    }

    // Constructor with custom capacity
    public Stack(int capacity) {
        if (capacity <= 0) {
            capacity = DEFAULT_CAPACITY;
        }

        stack = new int[capacity];
        top = -1;
    }

    // ---------- PUSH ----------
    public boolean push(int value) {

        if (top >= stack.length - 1) {
            System.out.println(">> Error: Stack is full. Cannot push " + value);
            return false;
        }

        top++;
        stack[top] = value;

        System.out.println(">> Pushed " + value + " onto the stack.");
        return true;
    }

    // ---------- POP ----------
    public int pop() {

        if (isEmpty()) {
            System.out.println(">> Error: Stack is empty. Cannot pop.");
            return -1;
        }

        int value = stack[top];
        top--;

        System.out.println(">> Popped " + value + " from the stack.");
        return value;
    }

    // ---------- PEEK ----------
    public int peek() {

        if (isEmpty()) {
            System.out.println(">> Error: Stack is empty. Nothing to peek.");
            return -1;
        }

        System.out.println(">> Top element: " + stack[top]);
        return stack[top];
    }

    // ---------- DISPLAY ----------
    public void display() {

        if (isEmpty()) {
            System.out.println(">> Stack is empty.");
            return;
        }

        System.out.println(">> Stack elements (Top to Bottom):");

        for (int i = top; i >= 0; i--) {
            System.out.println("   " + stack[i]);
        }
    }

    // ---------- CHECK EMPTY ----------
    public boolean isEmpty() {
        return top == -1;
    }

    // ---------- CHECK FULL ----------
    public boolean isFull() {
        return top == stack.length - 1;
    }

    // ---------- SIZE ----------
    public int size() {
        return top + 1;
    }

    // ---------- CLEAR ----------
    public void clear() {
        top = -1;
        System.out.println(">> Stack cleared.");
    }
}