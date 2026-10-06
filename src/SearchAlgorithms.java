package src;

import java.util.Arrays;

/**
 * SearchAlgorithms.java
 * Developer 1 — Array + Searching
 *
 * Implements:
 *   - Linear Search   -> O(n)
 *   - Binary Search   -> O(log n)  (requires sorted array)
 *
 * Each search returns a result object containing:
 *   - found index
 *   - number of steps (operations)
 *   - execution time (nanoseconds)
 *
 * This supports the Performance Comparison module.
 */
public class SearchAlgorithms {

    // ---------- LINEAR SEARCH ----------
    public static SearchResult linearSearch(int[] arr, int target) {
        long start = System.nanoTime();
        int steps = 0;
        int foundIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            steps++;
            if (arr[i] == target) {
                foundIndex = i;
                break;
            }
        }

        long timeNs = System.nanoTime() - start;
        return new SearchResult("Linear Search", target, foundIndex, steps, timeNs);
    }

    // ---------- BINARY SEARCH ----------
    public static SearchResult binarySearch(int[] arr, int target) {
        // Binary search requires a sorted array — copy + sort
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        long start = System.nanoTime();
        int steps = 0;
        int low = 0, high = sorted.length - 1;
        int foundIndex = -1;

        while (low <= high) {
            steps++;
            int mid = low + (high - low) / 2;
            if (sorted[mid] == target) {
                foundIndex = mid;
                break;
            } else if (sorted[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        long timeNs = System.nanoTime() - start;
        return new SearchResult("Binary Search", target, foundIndex, steps, timeNs);
    }

    // ---------- COMPARISON ----------
    public static void compare(int[] arr, int target) {
        if (arr.length == 0) {
            System.out.println(">> Array is empty. Nothing to search.");
            return;
        }

        System.out.println("\n===== SEARCHING PERFORMANCE COMPARISON =====");
        System.out.println("Target value: " + target);
        System.out.println("Array size  : " + arr.length);
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-18s %-14s %-10s %-15s%n",
                "Algorithm", "Found?", "Steps", "Time (ns)");
        System.out.println("------------------------------------------------------------");

        SearchResult linear = linearSearch(arr, target);
        SearchResult binary = binarySearch(arr, target);

        printRow(linear);
        printRow(binary);

        System.out.println("------------------------------------------------------------");
        System.out.println("Note: Binary Search requires a sorted array.");
        System.out.println("Complexity -> Linear: O(n)   |   Binary: O(log n)");
        System.out.println("============================================\n");
    }

    private static void printRow(SearchResult r) {
        String found = (r.foundIndex >= 0) ? "Yes (idx " + r.foundIndex + ")" : "No";
        System.out.printf("%-18s %-14s %-10d %-15d%n",
                r.algorithm, found, r.steps, r.timeNs);
    }

    // ---------- RESULT CLASS ----------
    public static class SearchResult {
        public final String algorithm;
        public final int target;
        public final int foundIndex;
        public final int steps;
        public final long timeNs;

        public SearchResult(String algorithm, int target,
                            int foundIndex, int steps, long timeNs) {
            this.algorithm = algorithm;
            this.target = target;
            this.foundIndex = foundIndex;
            this.steps = steps;
            this.timeNs = timeNs;
        }
    }
}