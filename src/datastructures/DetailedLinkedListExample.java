package datastructures;

// Define a Node class for a singly linked list.
class ListNode {
    int value;       // The data stored in the node.
    ListNode next;   // Reference to the next node in the list.

    // Constructor to create a new node with a given value.
    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

// Define a datastructures.LinkedList class that encapsulates various operations.
class LinkedList {
    ListNode head;   // Pointer to the first node in the linked list.

    // Constructor to initialize an empty linked list.
    public LinkedList() {
        this.head = null;
    }

    // -------------------------------
    // 1. Insertion Methods
    // -------------------------------

    // Insert a new node at the beginning of the list.
    public void insertAtHead(int value) {
        // Create a new node.
        ListNode newNode = new ListNode(value);
        // Point the new node's next to the current head.
        newNode.next = head;
        // Update the head to be the new node.
        head = newNode;
    }

    // Insert a new node at the end of the list.
    public void insertAtTail(int value) {
        // Create a new node.
        ListNode newNode = new ListNode(value);
        // If the list is empty, the new node becomes the head.
        if (head == null) {
            head = newNode;
            return;
        }
        // Otherwise, traverse to the end of the list.
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        // Link the last node to the new node.
        current.next = newNode;
    }

    // Insert a new node after the first occurrence of a node with the given target value.
    public boolean insertAfter(int target, int value) {
        ListNode current = head;
        // Traverse the list to find the target node.
        while (current != null) {
            if (current.value == target) {
                // Found the target; create a new node.
                ListNode newNode = new ListNode(value);
                // Insert it after the current node.
                newNode.next = current.next;
                current.next = newNode;
                return true;  // Insertion successful.
            }
            current = current.next;
        }
        return false; // Target not found.
    }

    // -------------------------------
    // 2. Deletion Method
    // -------------------------------

    // Delete the first node that contains the given value.
    public boolean delete(int value) {
        // If the list is empty, nothing to delete.
        if (head == null) {
            return false;
        }
        // If the head holds the value, update the head pointer.
        if (head.value == value) {
            head = head.next;
            return true;
        }
        // Traverse the list to find the node just before the node we want to delete.
        ListNode current = head;
        while (current.next != null) {
            if (current.next.value == value) {
                // Skip over the node to be deleted.
                current.next = current.next.next;
                return true; // Deletion successful.
            }
            current = current.next;
        }
        return false; // The value was not found in the list.
    }

    // -------------------------------
    // 3. Traversal Method
    // -------------------------------

    // Print all nodes in the linked list.
    public void printList() {
        ListNode current = head;
        // Traverse the list until the end.
        while (current != null) {
            // Print the current node's value followed by an arrow.
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        // Indicate the end of the list.
        System.out.println("null");
    }

    // -------------------------------
    // 4. Reverse the Linked List
    // -------------------------------

    // Reverse the linked list in place.
    public void reverse() {
        ListNode prev = null;          // Initially, there is no previous node.
        ListNode current = head;       // Start with the head node.
        while (current != null) {
            // Store the next node before changing the link.
            ListNode nextTemp = current.next;
            // Reverse the 'next' pointer of the current node.
            current.next = prev;
            // Move 'prev' and 'current' one step forward.
            prev = current;
            current = nextTemp;
        }
        // After the loop, 'prev' will be the new head.
        head = prev;
    }
}

// -------------------------------
// 5. Demonstration in the Main Class
// -------------------------------
public class DetailedLinkedListExample {
    public static void main(String[] args) {
        // Create an instance of datastructures.LinkedList.
        LinkedList list = new LinkedList();

        // ----- Insertion Operations -----
        // Insert nodes at the tail (end) of the list.
        list.insertAtTail(10);
        list.insertAtTail(20);
        list.insertAtTail(30);

        System.out.println("Initial list after inserting 10, 20, 30 at tail:");
        list.printList();  // Expected output: 10 -> 20 -> 30 -> null

        // Insert a node at the head (beginning) of the list.
        list.insertAtHead(5);
        System.out.println("\nAfter inserting 5 at head:");
        list.printList();  // Expected output: 5 -> 10 -> 20 -> 30 -> null

        // Insert a node (15) after the node with value 10.
        boolean inserted = list.insertAfter(10, 15);
        if (inserted) {
            System.out.println("\nAfter inserting 15 after 10:");
            list.printList();  // Expected output: 5 -> 10 -> 15 -> 20 -> 30 -> null
        } else {
            System.out.println("\nValue 10 not found in the list. Insertion failed.");
        }

        // ----- Deletion Operation -----
        // Delete the node with value 20.
        boolean deleted = list.delete(20);
        if (deleted) {
            System.out.println("\nAfter deleting the node with value 20:");
            list.printList();  // Expected output: 5 -> 10 -> 15 -> 30 -> null
        } else {
            System.out.println("\nValue 20 not found in the list. Deletion failed.");
        }

        // ----- Reverse the Linked List -----
        System.out.println("\nReversing the linked list:");
        list.reverse();
        list.printList();  // Expected output (reversed list): 30 -> 15 -> 10 -> 5 -> null

        // You can reverse again to restore original order if needed.
        System.out.println("\nReversing the list again to restore original order:");
        list.reverse();
        list.printList();  // Expected output: 5 -> 10 -> 15 -> 30 -> null
    }
}
