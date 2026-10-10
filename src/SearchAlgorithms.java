import java.util.Arrays;


public class SearchAlgorithms {

    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Array must be sorted.
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (array[middle] == target) {
                return middle;
            }

            if (array[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static int linearSearchSteps(int[] array, int target) {
        int steps = 0;

        for (int value : array) {
            steps++;
            if (value == target) {
                return steps;
            }
        }
        return steps;
    }

    public static int binarySearchSteps(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int steps = 0;

        while (left <= right) {
            steps++;
            int middle = left + (right - left) / 2;

            if (array[middle] == target) {
                return steps;
            }

            if (array[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return steps;
    }

    public static void displayLinearSearch(int[] array, int target) {
        int steps = linearSearchSteps(array, target);
        int index = linearSearch(array, target);

        System.out.println("\nLinear Search:");
        System.out.println("Target: " + target);

        if (index != -1) {
            System.out.println("Found at index: " + index);
        } else {
            System.out.println("Value not found.");
        }

        System.out.println("Steps: " + steps);
    }

    public static void displayBinarySearch(int[] array, int target) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray);

        int steps = binarySearchSteps(sortedArray, target);
        int index = binarySearch(sortedArray, target);

        System.out.println("\nSorted data used for Binary Search:");
        for (int value : sortedArray) {
            System.out.print(value + " ");
        }
        System.out.println();

        System.out.println("Binary Search:");
        System.out.println("Target: " + target);

        if (index != -1) {
            System.out.println("Found at sorted index: " + index);
        } else {
            System.out.println("Value not found.");
        }

        System.out.println("Steps: " + steps);
    }
}
