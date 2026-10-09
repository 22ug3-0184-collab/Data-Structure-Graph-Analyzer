package src;

public class Stack {

    private int[] stack;
    private int top;
    private static final int DEFAULT_CAPACITY = 10;

    public Stack() {
        stack = new int[DEFAULT_CAPACITY];
        top = -1;
    }

    public void push(int value) {
        if (top == stack.length - 1) {
            resize();
        }

        stack[++top] = value;
        System.out.println("Value " + value + " pushed onto the stack.");
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        }

        int value = stack[top--];
        System.out.println("Value " + value + " popped from the stack.");
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to peek.");
            return -1;
        }
        return stack[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("\nStack elements:");
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    private void resize() {
        int[] newStack = new int[stack.length * 2];
        for (int i = 0; i <= top; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }
}
