package datastructures;

import java.util.HashMap;
import java.util.Objects;

// ============================================================
// 1. Define the Custom Key Class: datastructures.Person
// ============================================================
class Person {
    String name;
    int id;

    // Constructor to initialize a datastructures.Person object.
    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Override hashCode() to produce a hash based on name and id.
    @Override
    public int hashCode() {
        // Using Objects.hash() is a convenient way to generate a hash code.
        return Objects.hash(name, id);
    }

    // Override equals() to compare datastructures.Person objects based on name and id.
    @Override
    public boolean equals(Object obj) {
        // Check if this object is compared with itself.
        if (this == obj) return true;
        // Check if obj is null or not of the same class.
        if (obj == null || getClass() != obj.getClass()) return false;
        // Cast the object to datastructures.Person and compare relevant fields.
        Person other = (Person) obj;
        return id == other.id && Objects.equals(name, other.name);
    }

    // (Optional) Override toString() for a readable string representation.
    @Override
    public String toString() {
        return "datastructures.Person{name='" + name + "', id=" + id + "}";
    }
}

// ============================================================
// 2. Using the Custom Key in a HashMap
// ============================================================
public class HDetailedCustomKeyHashMapExample {
    public static void main(String[] args) {
        // Create a HashMap with datastructures.Person objects as keys and String values.
        // Here, the value represents the occupation of the person.
        HashMap<Person, String> personMap = new HashMap<>();

        // Create two datastructures.Person objects with the same name and id.
        // Although they are distinct instances in memory, they are considered equal.
        Person p1 = new Person("Alice", 1);
        Person p2 = new Person("Alice", 1);

        // Insert a key-value pair using p1 as the key.
        personMap.put(p1, "Engineer");

        // Retrieve the value using p2 as the key.
        // Because p1.equals(p2) returns true and their hashCodes are identical,
        // the map recognizes p2 as the same key as p1.
        String occupation = personMap.get(p2);
        System.out.println("Occupation: " + occupation);  // Expected output: "Engineer"

        // ============================================================
        // 3. Iterating Over the HashMap with Custom Keys
        // ============================================================
        System.out.println("\nIterating over the personMap entries:");
        for (Person key : personMap.keySet()) {
            System.out.println("Key: " + key + ", Occupation: " + personMap.get(key));
        }
    }
}
