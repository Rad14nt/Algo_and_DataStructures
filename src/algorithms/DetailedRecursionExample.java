package algorithms;
/**
 * DetailedRecursionExample demonstrates the concept of recursion in Java.
 *
 * WHAT IS RECURSION?
 * ------------------
 * Recursion is a programming technique where a function (or method) calls itself to solve smaller instances of the same problem.
 * This approach is often used in:
 *   - Tree traversals
 *   - Backtracking (e.g., generating permutations or solving puzzles)
 *   - Divide-and-conquer algorithms (e.g., merge sort, quick sort)
 *
 * The key to recursion is to define:
 *   1. A base case: The condition under which the recursion stops.
 *   2. A recursive case: The part of the function where it calls itself with a smaller or simpler input.
 *
 * EXAMPLES INCLUDED:
 *   1. Factorial Calculation
 *   2. Fibonacci Sequence Calculation
 *
 * ADVANCED NOTES:
 * - While recursion can make code simpler and more intuitive, it may lead to performance issues if not used carefully.
 * - Some recursive solutions (like the naive Fibonacci implementation) have exponential time complexity.
 *   Techniques such as memoization (caching intermediate results) or iterative solutions can often optimize these cases.
 */
public class DetailedRecursionExample {

    /**
     * Calculates the factorial of a given number using recursion.
     *
     * FACTORIAL DEFINITION:
     *   n! = n * (n - 1) * (n - 2) * ... * 1
     * Base case: 0! = 1 and 1! = 1
     * Recursive case: n! = n * factorial(n - 1)
     *
     * Time Complexity: O(n)
     *
     * @param n the number for which to compute the factorial
     * @return the factorial of n
     */
    public static int factorial(int n) {
        // Base case: if n is 0 or 1, return 1 because 0! = 1! = 1.
        if (n <= 1) {
            return 1;
        }
        // Recursive case: Multiply n by the factorial of (n-1)
        return n * factorial(n - 1);
    }

    /**
     * Calculates the nth Fibonacci number using recursion.
     *
     * FIBONACCI DEFINITION:
     *   - fibonacci(0) = 0
     *   - fibonacci(1) = 1
     *   - For n >= 2, fibonacci(n) = fibonacci(n - 1) + fibonacci(n - 2)
     *
     * This implementation is simple but has exponential time complexity (O(2^n)) because it recalculates many subproblems.
     * ADVANCED: For large n, consider using memoization to cache results or use an iterative approach.
     *
     * @param n the index (n) in the Fibonacci sequence to compute
     * @return the nth Fibonacci number
     */
    public static int fibonacci(int n) {
        // Base cases: return n if n is 0 or 1.
        if (n <= 1) {
            return n;  // fibonacci(0) = 0, fibonacci(1) = 1
        }
        // Recursive case: Sum of the two preceding Fibonacci numbers.
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        // -------------------------------------------------------------------------------------
        // EXAMPLE 1: FACTORIAL USING RECURSION
        // -------------------------------------------------------------------------------------
        // Let's calculate the factorial of 5.
        // The expected result is: 5! = 5 * 4 * 3 * 2 * 1 = 120.
        int number = 5;
        int factResult = factorial(number);
        System.out.println("Factorial of " + number + " is: " + factResult);
        // Output should be: "Factorial of 5 is: 120"

        // -------------------------------------------------------------------------------------
        // EXAMPLE 2: FIBONACCI USING RECURSION
        // -------------------------------------------------------------------------------------
        // Let's compute the 6th Fibonacci number.
        // The Fibonacci sequence is: 0, 1, 1, 2, 3, 5, 8, ...
        // Therefore, fibonacci(6) should return 8.
        int fibNumber = 6;
        int fibResult = fibonacci(fibNumber);
        System.out.println("Fibonacci(" + fibNumber + ") is: " + fibResult);
        // Output should be: "Fibonacci(6) is: 8"

        // -------------------------------------------------------------------------------------
        // ADVANCED NOTES:
        // -------------------------------------------------------------------------------------
        // 1. The recursive Fibonacci implementation above is simple but inefficient.
        //    It has exponential time complexity (O(2^n)) because it makes redundant calculations.
        //    For instance, fibonacci(5) is calculated multiple times when computing fibonacci(7).
        //    To improve performance, you can use memoization (caching computed results) or convert the solution to an iterative approach.
        //
        // 2. Recursion is widely used in problems like tree traversals (pre-order, in-order, post-order) and backtracking,
        //    which often appear in technical interviews.
        //
        // 3. Always ensure you have a well-defined base case in your recursive functions to prevent infinite recursion,
        //    which can lead to a stack overflow error.
    }
}
