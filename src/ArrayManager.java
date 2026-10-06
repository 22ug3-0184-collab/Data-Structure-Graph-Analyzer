package src;

import java.util.Arrays;

/**
 * ArrayManager.java
 * Developer 1 — Array + Searching
 *
 * Handles all Array operations:
 *   - Insert
 *   - Delete
 *   - Search (basic)
 *   - Display
 */
public class ArrayManager {

    private int[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 100;

    public ArrayManager() {
        this.array = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public ArrayManager(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }

    // ---------- INSERT ----------
    public boolean insert(int value) {
        if (size >= array.length) {
            System.out.println(">> Error: Array is full. Cannot insert " + value);
            return false;
        }
        array[size] = value;
        size++;
        System.out.println(">> Inserted " + value + " at index " + (size - 1));
        return true;
    }

    // ---------- DELETE ----------
    public boolean delete(int value) {
        int index = indexOf(value);
        if (index == -1) {
            System.out.println(">> Error: Value " + value + " not found.");
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        System.out.println(">> Deleted " + value + " from index " + index);
        return true;
    }

    // ---------- SEARCH (basic) ----------
    public int search(int value) {
        int index = indexOf(value);
        if (index != -1) {
            System.out.println(">> Found " + value + " at index " + index);
        } else {
            System.out.println(">> " + value + " not found in array.");
        }
        return index;
    }

    private int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) return i;
        }
        return -1;
    }

    // ---------- DISPLAY ----------
    public void display() {
        if (size == 0) {
            System.out.println(">> Array is empty.");
            return;
        }
        System.out.print(">> Array [" + size + " elements]: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println();
    }

    // ---------- HELPERS ----------
    public int getSize() { return size; }
    public boolean isEmpty() { return size == 0; }

    public int[] toArray() {
        return Arrays.copyOf(array, size);
    }

    public void clear() {
        size = 0;
        System.out.println(">> Array cleared.");
    }
}