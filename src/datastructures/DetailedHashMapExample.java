package datastructures;

import java.util.HashMap;

public class DetailedHashMapExample {
    public static void main(String[] args) {
        // ============================================================
        // 1. Creating a HashMap
        // ============================================================
        // We create a HashMap that maps String keys to Integer values.
        // HashMap provides average O(1) time for insertion, deletion, and lookup.
        HashMap<String, Integer> map = new HashMap<>();

        // ============================================================
        // 2. Inserting Key-Value Pairs
        // ============================================================
        // The put() method inserts a key-value pair into the map.
        map.put("apple", 2);
        map.put("banana", 5);
        // You can also update an existing key's value by using put() again.
        map.put("apple", 3); // "apple" now maps to 3 instead of 2.

        // ============================================================
        // 3. Retrieving Values
        // ============================================================
        // The get() method retrieves the value associated with the given key.
        Integer appleValue = map.get("apple");  // Should return 3.
        System.out.println("Value for 'apple': " + appleValue);

        // ============================================================
        // 4. Checking for Keys or Values
        // ============================================================
        // containsKey() checks if a given key exists in the map.
        if (map.containsKey("banana")) {
            System.out.println("Map contains key 'banana'");
        }

        // containsValue() checks if a given value exists in the map.
        if (map.containsValue(5)) {
            System.out.println("Map contains the value 5");
        }

        // ============================================================
        // 5. Iterating Over the HashMap
        // ============================================================
        // Iterate over keys using keySet() and then retrieve the corresponding value.
        System.out.println("\nIterating over key-value pairs:");
        for (String key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        // Alternatively, you can iterate over the entry set.
        System.out.println("\nIterating using entrySet():");
        for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // ============================================================
        // 6. Removing a Key-Value Pair
        // ============================================================
        // The remove() method deletes the key (and its associated value) from the map.
        map.remove("banana");
        System.out.println("\nAfter removing 'banana': " + map);

        // ============================================================
        // 7. Clearing the Map
        // ============================================================
        // clear() removes all key-value pairs.
        map.clear();
        System.out.println("After clearing, is map empty? " + map.isEmpty());
    }
}
