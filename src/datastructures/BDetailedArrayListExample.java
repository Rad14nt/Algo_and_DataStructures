package datastructures;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Arrays;

public class BDetailedArrayListExample {

    public static void main(String[] args) {
        // -------------------------------------------------------------------------------------
        // WHAT IS AN ARRAYLIST?
        // -------------------------------------------------------------------------------------
        // An ArrayList in Java is a resizable array that can grow as needed.
        // Unlike a standard array (which has a fixed size), an ArrayList can automatically
        // adjust its size when elements are added or removed.
        //
        // Advantages of using an ArrayList:
        // 1. Dynamic sizing: You don't need to know the number of elements in advance.
        // 2. Built-in methods for common operations (e.g., add, remove, get, contains).
        // 3. Supports generics, so you can have type-safe lists.
        // 4. Easy to iterate over with loops, enhanced for-loops, or lambda expressions.
        // -------------------------------------------------------------------------------------

        // -------------------------------------------------------------------------------------
        // EASY TOPIC: BASIC USAGE OF ARRAYLIST
        // -------------------------------------------------------------------------------------

        // Create an ArrayList to store Strings.
        ArrayList<String> fruits = new ArrayList<>();

        // 1. Adding Elements:
        // The add() method appends the specified element to the end of this list.
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        // Print the ArrayList. Expected output: [Apple, Banana, Cherry]
        System.out.println("ArrayList after adding elements: " + fruits);

        // 2. Inserting an Element at a Specific Index:
        // Use add(index, element) to insert an element at a specific position.
        // Here, "Orange" is inserted at index 1.
        fruits.add(1, "Orange");
        // Expected output: [Apple, Orange, Banana, Cherry]
        System.out.println("ArrayList after inserting 'Orange' at index 1: " + fruits);

        // 3. Accessing Elements:
        // Use get(index) to access an element at a specific index.
        String firstFruit = fruits.get(0); // Should be "Apple"
        System.out.println("First element (index 0): " + firstFruit);

        // 4. Iterating Over the ArrayList:
        // Using an enhanced for-loop to print each element.
        System.out.println("Iterating over the ArrayList:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // 5. Removing Elements:
        // Remove by value: removes the first occurrence of "Banana".
        fruits.remove("Banana");
        // Expected output: [Apple, Orange, Cherry]
        System.out.println("ArrayList after removing 'Banana': " + fruits);

        // Remove by index: removes the element at index 0.
        String removedFruit = fruits.remove(0);
        // "Apple" is removed. Expected output: [Orange, Cherry]
        System.out.println("Removed element: " + removedFruit);
        System.out.println("ArrayList after removing element at index 0: " + fruits);

        // 6. Checking the Size of the ArrayList:
        // The size() method returns the number of elements in the ArrayList.
        int size = fruits.size();
        System.out.println("Size of ArrayList: " + size);

        // 7. Checking for an Element:
        // The contains() method checks whether the list contains a specific element.
        boolean hasCherry = fruits.contains("Cherry");
        System.out.println("Does ArrayList contain 'Cherry'? " + hasCherry);

        // -------------------------------------------------------------------------------------
        // ADVANCED TOPICS: MORE ARRAYLIST OPERATIONS
        // -------------------------------------------------------------------------------------

        // 8. Sorting the ArrayList:
        // Collections.sort() can sort an ArrayList that contains elements implementing Comparable.
        // Let's add a few more elements to demonstrate sorting.
        fruits.add("Apple");  // Adding duplicate to see sorting behavior.
        fruits.add("Mango");
        // Before sorting, the list might be: [Orange, Cherry, Apple, Mango]
        Collections.sort(fruits);
        // After sorting (alphabetical order): [Apple, Cherry, Mango, Orange]
        System.out.println("Sorted ArrayList: " + fruits);

        // 9. Converting the ArrayList to an Array:
        // The toArray() method converts the ArrayList into an array.
        // We pass a zero-length array of the desired type to get a typed array back.
        String[] fruitsArray = fruits.toArray(new String[0]);
        System.out.println("ArrayList converted to array: " + Arrays.toString(fruitsArray));

        // 10. Iterating with Lambda Expressions (Java 8+):
        // The forEach() method combined with a lambda expression can iterate over the ArrayList.
        System.out.println("Iterating using lambda expressions:");
        fruits.forEach(fruit -> System.out.println(fruit));

        // Alternatively, using method reference for a more concise syntax.
        System.out.println("Iterating using method references:");
        fruits.forEach(System.out::println);

        // 11. Clearing the ArrayList:
        // The clear() method removes all elements from the ArrayList.
        fruits.clear();
        System.out.println("ArrayList after clearing: " + fruits);
    }
}
