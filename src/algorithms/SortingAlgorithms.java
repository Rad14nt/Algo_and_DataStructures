package algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingAlgorithms {

    // ========================================================================================
    // WHAT IS SORTING?
    // ========================================================================================
    // Sorting is the process of arranging data in a specific order (usually ascending or descending).
    // For example, imagine you have a pile of unsorted playing cards and you want to arrange them
    // in order from the lowest value to the highest value. Sorting is essential because:
    // 1. It makes search operations faster (e.g., binary search requires sorted data).
    // 2. It helps organize data for ranking, comparison, or further processing.
    // 3. Many algorithms require or perform more efficiently when the data is sorted.
    // ========================================================================================

    // ----------------------------------------------------------------------------------------
    // EASY TOPIC: Basic Sorting Using Java's Built-In Methods
    // ----------------------------------------------------------------------------------------

    /**
     * Demonstrates sorting an array of primitives (integers) using Java's built-in Arrays.sort().
     * Java uses highly optimized algorithms (like Dual-Pivot Quicksort) for primitive arrays.
     */
    public static void builtInSortExample() {
        // Create an unsorted array of integers.
        int[] numbers = {50, 20, 40, 10, 30};

        // Print the original array.
        System.out.println("Original array: " + Arrays.toString(numbers));

        // Sort the array in ascending order.
        Arrays.sort(numbers);

        // Print the sorted array.
        System.out.println("Sorted array (using Arrays.sort): " + Arrays.toString(numbers));
    }

    // ----------------------------------------------------------------------------------------
    // ADVANCED TOPICS: Manual Sorting Algorithm Implementations
    // ----------------------------------------------------------------------------------------

    /**
     * Bubble Sort: A simple, but inefficient (O(n^2)) sorting algorithm.
     * It repeatedly swaps adjacent elements if they are in the wrong order.
     *
     * @param arr The array of integers to be sorted.
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // Loop over the array n-1 times.
        for (int i = 0; i < n - 1; i++) {
            // For each iteration, compare adjacent elements.
            for (int j = 0; j < n - i - 1; j++) {
                // If the current element is greater than the next, swap them.
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Insertion Sort: A simple algorithm that builds the sorted array one item at a time.
     * It is efficient for nearly sorted data and has a time complexity of O(n^2) in the worst case.
     *
     * @param arr The array of integers to be sorted.
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        // Start from the second element.
        for (int i = 1; i < n; i++) {
            int key = arr[i];  // Element to be inserted in the sorted part.
            int j = i - 1;
            // Move elements that are greater than key one position ahead.
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            // Insert the key at its correct position.
            arr[j + 1] = key;
        }
    }

    /**
     * Merge Sort: A divide-and-conquer algorithm with O(n log n) time complexity.
     * It recursively divides the array into halves, sorts each half, and merges them.
     *
     * @param arr   The array of integers to be sorted.
     * @param left  The starting index of the array segment.
     * @param right The ending index of the array segment.
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point.
            int mid = left + (right - left) / 2;
            // Recursively sort the first half.
            mergeSort(arr, left, mid);
            // Recursively sort the second half.
            mergeSort(arr, mid + 1, right);
            // Merge the two sorted halves.
            merge(arr, left, mid, right);
        }
    }

    /**
     * Helper method to merge two sorted halves of an array.
     *
     * @param arr   The array containing the two sorted halves.
     * @param left  The starting index of the first half.
     * @param mid   The ending index of the first half.
     * @param right The ending index of the second half.
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        // Sizes of two subarrays.
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays.
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data into temporary arrays.
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        // Merge the temporary arrays back into arr[left..right].
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        // Copy any remaining elements of L[].
        while (i < n1) {
            arr[k++] = L[i++];
        }
        // Copy any remaining elements of R[].
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    // ----------------------------------------------------------------------------------------
    // ADVANCED TOPICS: Custom Object Sorting (Using Comparable and Comparator)
    // ----------------------------------------------------------------------------------------

    /**
     * The Person class represents a person with a name and an age.
     * It implements Comparable to define a natural ordering based on age (ascending).
     */
    static class Person implements Comparable<Person> {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        /**
         * Defines the natural ordering for Person objects by age.
         * Returns a negative integer, zero, or a positive integer as this object's age
         * is less than, equal to, or greater than the specified object's age.
         */
        @Override
        public int compareTo(Person other) {
            return Integer.compare(this.age, other.age);
        }

        // Override toString() for easier readability when printing Person objects.
        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }

    /**
     * Demonstrates sorting an array of custom Person objects.
     * First, it sorts using natural ordering (by age) via the Comparable interface.
     * Then, it sorts using a custom Comparator to order by name.
     */
    public static void customObjectSortingExample() {
        // Create an array of Person objects.
        Person[] people = {
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35)
        };

        System.out.println("\nBefore sorting (natural order by age): " + Arrays.toString(people));

        // Sort using natural order defined by the compareTo() method (by age).
        Arrays.sort(people);
        System.out.println("After sorting (natural order by age): " + Arrays.toString(people));

        // Sort using a custom Comparator to sort by name (alphabetical order).
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.name.compareTo(p2.name);
            }
        });
        System.out.println("After sorting by name (custom order): " + Arrays.toString(people));

        // Sort using a lambda expression to sort by name in descending order.
        Arrays.sort(people, (p1, p2) -> p2.name.compareTo(p1.name));
        System.out.println("After sorting by name descending (custom order using lambda): " + Arrays.toString(people));
    }

    // ----------------------------------------------------------------------------------------
    // MAIN METHOD: Demonstrate All Sorting Examples
    // ----------------------------------------------------------------------------------------

    public static void main(String[] args) {
        // -------------------------------------------------------------------------------------
        // EASY TOPIC: Built-In Sorting Example
        // -------------------------------------------------------------------------------------
        builtInSortExample();

        // -------------------------------------------------------------------------------------
        // ADVANCED TOPIC: Manual Sorting Algorithms
        // -------------------------------------------------------------------------------------
        // Bubble Sort Example:
        int[] arrayForBubble = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("\nOriginal array for Bubble Sort: " + Arrays.toString(arrayForBubble));
        bubbleSort(arrayForBubble);
        System.out.println("Sorted array using Bubble Sort: " + Arrays.toString(arrayForBubble));

        // Insertion Sort Example:
        int[] arrayForInsertion = {12, 11, 13, 5, 6};
        System.out.println("\nOriginal array for Insertion Sort: " + Arrays.toString(arrayForInsertion));
        insertionSort(arrayForInsertion);
        System.out.println("Sorted array using Insertion Sort: " + Arrays.toString(arrayForInsertion));

        // Merge Sort Example:
        int[] arrayForMerge = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("\nOriginal array for Merge Sort: " + Arrays.toString(arrayForMerge));
        mergeSort(arrayForMerge, 0, arrayForMerge.length - 1);
        System.out.println("Sorted array using Merge Sort: " + Arrays.toString(arrayForMerge));

        // -------------------------------------------------------------------------------------
        // ADVANCED TOPIC: Custom Object Sorting (Comparable and Comparator)
        // -------------------------------------------------------------------------------------
        customObjectSortingExample();

        // -------------------------------------------------------------------------------------
        // ADVANCED NOTES:
        // -------------------------------------------------------------------------------------
        // a. Java’s Built-In Sorting Algorithms:
        //    - For primitives, Java uses Dual-Pivot Quicksort with an average time complexity of O(n log n).
        //    - For objects, Java uses TimSort (a hybrid of merge sort and insertion sort) with O(n log n) time.
        // b. Custom Sorting:
        //    - Implement Comparable<T> for a natural order (e.g., sorting Person objects by age).
        //    - Use Comparator<T> for alternate sort orders (e.g., sorting by name).
        // c. Role in Algorithmic Problems:
        //    - Sorting is often the first step in solving problems such as merging intervals, removing duplicates,
        //      or performing efficient searches.
        //    - Knowing various sorting techniques and their time complexities helps you choose the right approach
        //      in coding interviews.
    }
}
