public class LinkedList {

    // Node class
    private class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // Insert a new value at the end
    public void insert(String data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Delete a value
    public boolean delete(String data) {

        if (head == null) {
            return false;
        }

        // If the first node contains the value
        if (head.data.equals(data)) {
            head = head.next;
            return true;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Search for a value
    public boolean search(String data) {

        Node current = head;

        while (current != null) {

            if (current.data.equals(data)) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Display all values
    public void display() {

        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }

          Node current = head;

        System.out.print("Linked List: ");

        while (current != null) {

            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }
}