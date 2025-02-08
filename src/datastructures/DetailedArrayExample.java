package datastructures;

import java.util.Arrays;

public class DetailedArrayExample {

    public static void main(String[] args) {
        // ============================================================
        // 1. Declaration & Initialization of a 1D Array
        // ============================================================

        // There are two common ways to declare and initialize an array.

        // Method 1: Declare with a fixed size, then assign values.
        int[] numbers = new int[5]; // Creates an integer array of length 5 (default values are 0).
        numbers[0] = 10;  // Assign value 10 to the first element (index 0)
        numbers[1] = 20;  // Assign value 20 to the second element (index 1)
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;  // Assign value 50 to the fifth element (index 4)

        // Method 2: Declare and initialize in one line using an array literal.
        int[] moreNumbers = { 10, 20, 30, 40, 50 };

        // ============================================================
        // 2. Accessing and Iterating Through an Array
        // ============================================================

        // Accessing elements by index:
        System.out.println("First element: " + numbers[0]); // prints 10
        System.out.println("Last element: " + numbers[numbers.length - 1]); // prints 50

        // Iterating with a traditional for loop:
        System.out.println("\nIterating using a traditional for loop:");
        for (int i = 0; i < numbers.length; i++) {
            // Print the index and its corresponding value.
            System.out.println("Index " + i + ": " + numbers[i]);
        }

        // Iterating with an enhanced for loop (for-each loop):
        System.out.println("\nIterating using an enhanced for loop:");
        for (int num : numbers) {
            // For each element 'num' in the array, print the value.
            System.out.println("Value: " + num);
        }

        // ============================================================
        // 3. Searching in an Array (Linear Search)
        // ============================================================

        // Linear search: checking each element until we find the target.
        int target = 30;
        int foundIndex = linearSearch(numbers, target);
        if (foundIndex != -1) {
            System.out.println("\nLinear Search: Found target " + target + " at index " + foundIndex);
        } else {
            System.out.println("\nLinear Search: Target " + target + " not found in the array.");
        }

        // ============================================================
        // 4. Reversing an Array In-Place
        // ============================================================

        // Print the original array
        System.out.println("\nOriginal array: " + Arrays.toString(numbers));
        // Reverse the array
        reverseArray(numbers);
        // Print the reversed array
        System.out.println("Reversed array: " + Arrays.toString(numbers));
        // Reverse again to restore original order (optional)
        reverseArray(numbers);

        // ============================================================
        // 5. Sorting an Array
        // ============================================================

        // Create an unsorted array:
        int[] unsorted = { 40, 10, 50, 20, 30 };
        System.out.println("\nUnsorted array: " + Arrays.toString(unsorted));
        // Use Java's built-in sort (Dual-Pivot Quicksort for primitives)
        Arrays.sort(unsorted);
        System.out.println("Sorted array: " + Arrays.toString(unsorted));

        // ============================================================
        // 6. Binary Search on a Sorted Array
        // ============================================================

        // Java's Arrays.binarySearch() can be used on sorted arrays.
        int searchTarget = 20;
        int binarySearchIndex = Arrays.binarySearch(unsorted, searchTarget);
        if (binarySearchIndex >= 0) {
            System.out.println("\nBinary Search: Found " + searchTarget + " at index " + binarySearchIndex);
        } else {
            System.out.println("\nBinary Search: " + searchTarget + " not found in the array.");
        }

        // ============================================================
        // 7. Multi-Dimensional Arrays (2D Arrays)
        // ============================================================

        // A 2D array (matrix) is essentially an array of arrays.
        int[][] matrix = {
                {1, 2, 3},   // Row 0
                {4, 5, 6},   // Row 1
                {7, 8, 9}    // Row 2
        };

        System.out.println("\n2D Array (Matrix):");
        // Nested loops to iterate over a 2D array.
        for (int i = 0; i < matrix.length; i++) { // matrix.length gives the number of rows.
            for (int j = 0; j < matrix[i].length; j++) { // matrix[i].length gives the number of columns in row i.
                System.out.print(matrix[i][j] + " "); // Print each element in the row followed by a space.
            }
            System.out.println(); // New line after each row.
        }

        // ============================================================
        // 8. Common Pitfalls: Array Index Out Of Bounds
        // ============================================================

        // Remember: Array indices start at 0 and go up to length-1.
        // Uncommenting the next line will throw an ArrayIndexOutOfBoundsException.
        // System.out.println(numbers[5]);  // Error: index 5 does not exist in an array of length 5.
    }

    // ============================================================
    // Helper Method: Linear Search
    // ============================================================
    // Returns the index of 'target' in array 'arr' if found; otherwise returns -1.
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) { // Check if the current element matches the target.
                return i; // Return the current index if found.
            }
        }
        return -1; // If target is not found, return -1.
    }

    // ============================================================
    // Helper Method: Reverse an Array In-Place
    // ============================================================
    // This method swaps elements from the beginning and end until the entire array is reversed.
    public static void reverseArray(int[] arr) {
        int left = 0;                  // Start pointer at the beginning of the array.
        int right = arr.length - 1;      // Start pointer at the end of the array.

        // Loop until the two pointers meet or cross.
        while (left < right) {
            // Swap the elements at indices 'left' and 'right'.
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // Move the pointers closer to the center.
            left++;
            right--;
        }
    }
}
