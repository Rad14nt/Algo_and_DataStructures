package datastructures;

import java.util.LinkedList;
import java.util.Queue;

// ============================================================
// 1. Define the datastructures.TreeNode class.
// ============================================================

/**
 * A datastructures.TreeNode represents a node in a binary tree.
 * Each node contains an integer value and references to its left and right children.
 */
class TreeNode {
    int value;         // The data stored in this node.
    TreeNode left;     // Reference to the left child node.
    TreeNode right;    // Reference to the right child node.

    /**
     * Constructor to create a new tree node with a given value.
     * Left and right children are initialized as null.
     *
     * @param value The integer value to store in this node.
     */
    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

// ============================================================
// 2. Define the BinaryTree operations.
// ============================================================

public class IDetailedBinaryTreeExample {

    /**
     * In-order traversal: Traverse the left subtree, visit the node, then traverse the right subtree.
     * For binary search trees, this prints the values in ascending order.
     *
     * @param node The current node in the traversal.
     */
    public static void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);                 // Traverse left subtree.
            System.out.print(node.value + " "); // Visit (print) current node.
            inOrder(node.right);                // Traverse right subtree.
        }
    }

    /**
     * Pre-order traversal: Visit the node, traverse the left subtree, then traverse the right subtree.
     *
     * @param node The current node in the traversal.
     */
    public static void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " "); // Visit current node.
            preOrder(node.left);                // Traverse left subtree.
            preOrder(node.right);               // Traverse right subtree.
        }
    }

    /**
     * Post-order traversal: Traverse the left subtree, traverse the right subtree, then visit the node.
     *
     * @param node The current node in the traversal.
     */
    public static void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);               // Traverse left subtree.
            postOrder(node.right);              // Traverse right subtree.
            System.out.print(node.value + " "); // Visit current node.
        }
    }

    /**
     * Level-order traversal (Breadth-first traversal): Visit nodes level by level using a queue.
     *
     * @param root The root node of the binary tree.
     */
    public static void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        // Create a queue to hold nodes for processing.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // Start with the root node.

        // Process nodes until the queue is empty.
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll(); // Retrieve and remove the head of the queue.
            System.out.print(current.value + " "); // Print the current node's value.

            // Enqueue the left child if it exists.
            if (current.left != null) {
                queue.offer(current.left);
            }
            // Enqueue the right child if it exists.
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    // ============================================================
    // 3. Demonstration in the main() Method.
    // ============================================================

    public static void main(String[] args) {
        // Build a simple binary tree:
        //
        //         10
        //        /  \
        //       5    15
        //      / \
        //     2   7
        //
        // Create the root node.
        TreeNode root = new TreeNode(10);
        // Build the left subtree.
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        // Build the right subtree.
        root.right = new TreeNode(15);

        // ============================================================
        // 4. Perform Various Traversals.
        // ============================================================

        // In-order Traversal: Expected output for the tree is: 2 5 7 10 15
        System.out.print("In-order Traversal: ");
        inOrder(root);
        System.out.println(); // New line for clarity.

        // Pre-order Traversal: Expected output: 10 5 2 7 15
        System.out.print("Pre-order Traversal: ");
        preOrder(root);
        System.out.println();

        // Post-order Traversal: Expected output: 2 7 5 15 10
        System.out.print("Post-order Traversal: ");
        postOrder(root);
        System.out.println();

        // Level-order Traversal: Expected output: 10 5 15 2 7
        System.out.print("Level-order Traversal: ");
        levelOrder(root);
        System.out.println();
    }
}
