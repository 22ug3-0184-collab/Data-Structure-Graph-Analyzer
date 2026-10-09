package src;

public class LinkedList {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void insert(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        size++;
        System.out.println("Value " + value + " inserted into linked list.");
    }

    public boolean delete(int value) {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return false;
        }

        if (head.data == value) {
            head = head.next;
            size--;
            System.out.println("Value " + value + " deleted.");
            return true;
        }

        Node current = head;

        while (current.next != null) {
            if (current.next.data == value) {
                current.next = current.next.next;
                size--;
                System.out.println("Value " + value + " deleted.");
                return true;
            }
            current = current.next;
        }

        System.out.println("Value " + value + " not found.");
        return false;
    }

    public boolean search(int value) {
        Node current = head;

        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void display() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }

        System.out.println("\nLinked List:");
        Node current = head;

        while (current != null) {
            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println(" -> NULL");
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }
}
