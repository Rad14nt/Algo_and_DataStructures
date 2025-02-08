package datastructures;

import java.util.Queue;
import java.util.LinkedList;

public class DetailedQueueExample {

    public static void main(String[] args) {
        // ============================================================
        // 1. Creating a Queue using datastructures.LinkedList
        // ============================================================
        // The Queue interface represents a First-In-First-Out (FIFO) data structure.
        // datastructures.LinkedList is one of the standard implementations of Queue in Java.
        Queue<Integer> queue = new LinkedList<>();

        // ============================================================
        // 2. Enqueuing Elements (Adding to the Queue)
        // ============================================================
        // 'offer()' adds an element to the tail (end) of the queue.
        System.out.println("Enqueuing elements:");
        queue.offer(10);  // Queue now: [10]
        System.out.println("Offered: 10");
        queue.offer(20);  // Queue now: [10, 20]
        System.out.println("Offered: 20");
        queue.offer(30);  // Queue now: [10, 20, 30]
        System.out.println("Offered: 30");

        // ============================================================
        // 3. Peeking at the Front Element
        // ============================================================
        // 'peek()' retrieves, but does not remove, the head of the queue.
        System.out.println("\nFront element using peek(): " + queue.peek());  // Expected: 10

        // ============================================================
        // 4. Checking the Size of the Queue
        // ============================================================
        // size() returns the number of elements in the queue.
        System.out.println("Queue size: " + queue.size());  // Expected: 3

        // ============================================================
        // 5. Iterating Over the Queue
        // ============================================================
        // You can iterate over the queue using a for-each loop.
        // Note: Iteration does not remove elements from the queue.
        System.out.println("\nIterating over queue elements:");
        for (Integer element : queue) {
            System.out.println("Element: " + element);
        }

        // ============================================================
        // 6. Dequeuing Elements (Removing from the Queue)
        // ============================================================
        // 'poll()' retrieves and removes the head of the queue.
        System.out.println("\nDequeuing elements:");
        while (!queue.isEmpty()) {
            int dequeuedElement = queue.poll();
            System.out.println("Dequeued: " + dequeuedElement);
            // Optionally, print the state of the queue after each removal.
            System.out.println("Current queue: " + queue);
        }

        // ============================================================
        // 7. Additional Queue Operations
        // ============================================================
        // Re-enqueue some elements.
        queue.offer(40);
        queue.offer(50);
        System.out.println("\nNew queue after enqueuing 40 and 50: " + queue);

        // Check if the queue contains a specific element.
        boolean contains50 = queue.contains(50);
        System.out.println("Does the queue contain 50? " + contains50);

        // Clear the queue of all elements.
        queue.clear();
        System.out.println("Queue cleared. Is the queue empty? " + queue.isEmpty());

        // ============================================================
        // 8. Practical Note: BFS and Other Uses of a Queue
        // ============================================================
        // Queues are not only used for buffering but are essential in breadth-first search (BFS)
        // where you traverse graph levels one by one.
        // In BFS, you typically enqueue neighbor nodes and dequeue the next node to visit.
        // (A BFS example is beyond the scope of this basic queue demonstration.)
    }
}
