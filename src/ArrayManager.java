public class ArrayManager {

    private int[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayManager() {
        data = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public void insert(int value) {
        if (size == data.length) {
            resize();
        }
        data[size] = value;
        size++;
        System.out.println("Value " + value + " inserted successfully.");
    }

    public boolean delete(int value) {
        int index = search(value);
        if (index == -1) {
            System.out.println("Value " + value + " was not found.");
            return false;
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        System.out.println("Value " + value + " deleted successfully.");
        return true;
    }

    public int search(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void display() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }

        System.out.println("\nArray Elements:");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public int[] getData() {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = data[i];
        }
        return result;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        int[] newData = new int[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
