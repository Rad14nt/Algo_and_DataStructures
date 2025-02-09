package datastructures;

import java.util.Deque;
import java.util.ArrayDeque;

public class EDetailedStackExample {

    public static void main(String[] args) {
        // ============================================================
        // 1. Creating a Stack using ArrayDeque
        // ============================================================
        // The Deque interface (Double-Ended Queue) provides methods for stack operations.
        Deque<Integer> stack = new ArrayDeque<>();

        // ============================================================
        // 2. Pushing Elements onto the Stack
        // ============================================================
        // 'push' adds an element to the top of the stack.
        System.out.println("Pushing elements onto the stack:");
        stack.push(10);  // Stack: [10]
        System.out.println("Pushed: 10");
        stack.push(20);  // Stack: [20, 10] -- 20 is now on top.
        System.out.println("Pushed: 20");
        stack.push(30);  // Stack: [30, 20, 10] -- 30 is now on top.
        System.out.println("Pushed: 30");

        // ============================================================
        // 3. Peeking at the Top Element
        // ============================================================
        // 'peek' returns the top element without removing it.
        System.out.println("\nPeek at the top element: " + stack.peek());  // Expected: 30

        // ============================================================
        // 4. Popping Elements from the Stack
        // ============================================================
        // 'pop' removes and returns the top element of the stack.
        System.out.println("\nPopping elements from the stack:");
        while (!stack.isEmpty()) {
            int topElement = stack.pop();  // Removes the top element.
            System.out.println("Popped: " + topElement);
        }

        // ============================================================
        // 5. Additional Stack Operations
        // ============================================================
        // Let's push some more elements.
        stack.push(40);
        stack.push(50);
        stack.push(60);  // Stack now: [60, 50, 40]

        // Check the current size of the stack.
        System.out.println("\nCurrent stack size: " + stack.size());  // Expected: 3

        // Peek at the current top element.
        System.out.println("Current top element: " + stack.peek());  // Expected: 60

        // Check if the stack contains a specific element (50 in this case).
        // Note: ArrayDeque implements the Collection interface, so we can use contains().
        boolean contains50 = stack.contains(50);
        System.out.println("Does the stack contain 50? " + contains50);  // Expected: true

        // Clear all elements from the stack.
        stack.clear();
        System.out.println("Stack cleared. Is stack empty? " + stack.isEmpty());  // Expected: true

        // ============================================================
        // 6. Practical Example: Reversing a String Using a Stack
        // ============================================================
        String input = "Stack";
        System.out.println("\nOriginal string: " + input);
        String reversed = reverseStringUsingStack(input);
        System.out.println("Reversed string: " + reversed);  // Expected: "kcatS"
    }

    /**
     * Helper method that reverses a string using a stack.
     *
     * @param s The string to be reversed.
     * @return The reversed string.
     */
    public static String reverseStringUsingStack(String s) {
        // Create a stack to hold characters.
        Deque<Character> charStack = new ArrayDeque<>();

        // Push each character of the string onto the stack.
        for (int i = 0; i < s.length(); i++) {
            charStack.push(s.charAt(i));
        }

        // Build the reversed string by popping characters from the stack.
        StringBuilder reversedBuilder = new StringBuilder();
        while (!charStack.isEmpty()) {
            // Pop returns and removes the top character.
            reversedBuilder.append(charStack.pop());
        }

        // Return the reversed string.
        return reversedBuilder.toString();
    }
}
