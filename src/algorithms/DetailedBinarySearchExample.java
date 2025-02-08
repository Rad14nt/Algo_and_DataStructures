package algorithms;
/**
 * DetailedBinarySearchExample demonstrates how Binary Search works.
 *
 * WHAT IS BINARY SEARCH?
 * -----------------------
 * Binary search is an efficient algorithm for finding an item in a sorted array.
 * It repeatedly divides the search interval in half until the target is found or
 * the search space becomes empty. Because it halves the search space each time,
 * its time complexity is O(log n), making it very efficient on large arrays.
 *
 * IMPORTANT:
 * - The array must be sorted (usually in ascending order) for binary search to work.
 * - Binary search is much faster than linear search for large datasets.
 *
 * HOW BINARY SEARCH WORKS:
 * ------------------------
 * 1. Set two pointers: 'left' (start of the array) and 'right' (end of the array).
 * 2. Calculate the middle index: mid = left + (right - left) / 2.
 *    (This formula prevents overflow compared to (left + right) / 2.)
 * 3. Compare the element at the middle index with the target:
 *    - If the middle element equals the target, return the index.
 *    - If the middle element is less than the target, continue searching in the right half.
 *    - If the middle element is greater than the target, continue searching in the left half.
 * 4. Repeat the process until the target is found or the search space is empty.
 * 5. If the target is not found, return -1.
 */
public class DetailedBinarySearchExample {

    /**
     * Performs binary search on a sorted array.
     *
     * @param arr    A sorted array of integers (in ascending order).
     * @param target The value to search for.
     * @return The index of the target if found; otherwise, -1.
     */
    public static int binarySearch(int[] arr, int target) {
        // 'left' pointer starts at the beginning of the array (index 0)
        int left = 0;
        // 'right' pointer starts at the end of the array (last index)
        int right = arr.length - 1;

        // Continue the loop as long as there is a valid search space.
        while (left <= right) {
            // Calculate the middle index of the current search interval.
            // Using 'left + (right - left) / 2' avoids potential integer overflow.
            int mid = left + (right - left) / 2;

            // Check if the middle element is equal to the target.
            if (arr[mid] == target) {
                return mid;  // Target found; return its index.
            }
            // If the target is greater than the middle element,
            // ignore the left half by updating 'left' to 'mid + 1'.
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            // Otherwise, if the target is less than the middle element,
            // ignore the right half by updating 'right' to 'mid - 1'.
            else {
                right = mid - 1;
            }
        }
        // If we exit the loop, the target is not in the array.
        return -1;
    }

    public static void main(String[] args) {
        // -------------------------------------------------------------------------------------
        // EASY TOPIC: Using Binary Search on a Sorted Array
        // -------------------------------------------------------------------------------------
        // Create a sorted array of integers. Binary search requires the array to be sorted.
        int[] sortedNumbers = {1, 3, 5, 7, 9, 11};

        // Define the target value we want to search for.
        int target = 7;

        // Call the binarySearch method to find the target in the sorted array.
        int index = binarySearch(sortedNumbers, target);

        // -------------------------------------------------------------------------------------
        // ADVANCED NOTES:
        // -------------------------------------------------------------------------------------
        // - Binary search runs in O(log n) time, which means it is very efficient for large arrays.
        // - It is a fundamental algorithm used in many LeetCode problems where fast search is needed.
        // - Understanding the edge cases (e.g., when the target is not present) is crucial.
        // - Variations of binary search can be used to find the first or last occurrence of a duplicate
        //   element, or to find the insertion point for a new element.
        // -------------------------------------------------------------------------------------

        // Print the result of the binary search.
        if (index != -1) {
            System.out.println("Index of " + target + ": " + index);
        } else {
            System.out.println(target + " was not found in the array.");
        }
    }
}
