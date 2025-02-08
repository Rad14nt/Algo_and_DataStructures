package datastructures;

public class DetailedStringExample {

    public static void main(String[] args) {
        // ============================================================
        // 1. Declaration & Initialization
        // ============================================================

        // Declare and initialize a string literal.
        String greeting = "Hello, World!";
        // Note: Strings in Java are immutable, so any operation that appears to change
        // the string will actually create a new String object.

        // ============================================================
        // 2. Basic Information and Access
        // ============================================================

        // Print the original string.
        System.out.println("Original string: " + greeting);

        // Get the length of the string.
        int length = greeting.length();
        System.out.println("Length: " + length); // prints the number of characters in the string

        // Access a specific character using charAt(index).
        char firstChar = greeting.charAt(0);  // 'H'
        char lastChar = greeting.charAt(greeting.length() - 1);  // '!'
        System.out.println("First character: " + firstChar);
        System.out.println("Last character: " + lastChar);

        // ============================================================
        // 3. Substring and Slicing
        // ============================================================

        // Extract a substring from index 0 to 5 (excluding index 5): "Hello"
        String hello = greeting.substring(0, 5);
        System.out.println("Substring (0,5): " + hello);

        // Extract a substring from a given index to the end.
        String world = greeting.substring(7);
        System.out.println("Substring (from index 7): " + world); // Expected: "World!"

        // ============================================================
        // 4. Case Conversion and Trimming
        // ============================================================

        // Convert the string to uppercase.
        String shout = greeting.toUpperCase();
        System.out.println("Uppercase: " + shout);

        // Convert the string to lowercase.
        String whisper = greeting.toLowerCase();
        System.out.println("Lowercase: " + whisper);

        // Trimming: Remove leading and trailing whitespace.
        String padded = "   Lots of space!   ";
        String trimmed = padded.trim();
        System.out.println("Before trim: '" + padded + "'");
        System.out.println("After trim: '" + trimmed + "'");

        // ============================================================
        // 5. Searching and Checking Content
        // ============================================================

        // Check if the string contains a specific substring.
        boolean containsWorld = greeting.contains("World");
        System.out.println("Contains 'World': " + containsWorld);

        // Check the starting and ending of the string.
        boolean startsWithHello = greeting.startsWith("Hello");
        boolean endsWithExclamation = greeting.endsWith("!");
        System.out.println("Starts with 'Hello': " + startsWithHello);
        System.out.println("Ends with '!': " + endsWithExclamation);

        // Find the index of a substring.
        int indexOfComma = greeting.indexOf(",");  // returns the index of the first comma
        System.out.println("Index of comma: " + indexOfComma);

        // Find the last occurrence of a character.
        int lastIndexOfl = greeting.lastIndexOf('l');  // returns the last index where 'l' appears
        System.out.println("Last index of 'l': " + lastIndexOfl);

        // ============================================================
        // 6. Replacing and Splitting
        // ============================================================

        // Replace characters or substrings.
        // Replace "World" with "Java" in the greeting.
        String replaced = greeting.replace("World", "Java");
        System.out.println("Replaced string: " + replaced);

        // Splitting the string into an array of substrings based on a delimiter.
        // Here, split the greeting by spaces.
        String[] words = greeting.split(" ");
        System.out.println("Splitting the greeting by spaces:");
        for (String word : words) {
            System.out.println(word);
        }

        // ============================================================
        // 7. Concatenation and Building Strings
        // ============================================================

        // Concatenation using the '+' operator.
        String part1 = "Hello";
        String part2 = "Java";
        String combined = part1 + ", " + part2 + "!";
        System.out.println("Concatenated string: " + combined);

        // Using the concat() method.
        String concatenated = part1.concat(", ").concat(part2).concat("!");
        System.out.println("Concatenated using concat(): " + concatenated);

        // When building strings in loops, use StringBuilder for efficiency.
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            sb.append("Line ").append(i).append("\n");
        }
        String multiLine = sb.toString();
        System.out.println("Multi-line string built with StringBuilder:\n" + multiLine);

        // ============================================================
        // 8. Converting to and from Char Arrays
        // ============================================================

        // Convert a string to a char array.
        char[] charArray = greeting.toCharArray();
        System.out.println("Characters in the greeting:");
        for (char c : charArray) {
            System.out.print(c + " ");
        }
        System.out.println(); // new line

        // Build a string from a char array.
        char[] letters = { 'J', 'a', 'v', 'a' };
        String language = new String(letters);
        System.out.println("String built from char array: " + language);

        // ============================================================
        // 9. Immutability of Strings
        // ============================================================

        // Demonstrate that strings are immutable.
        String original = "Immutable";
        // Attempt to change the string (this doesn't modify the original string)
        String modified = original.replace("Immutable", "Mutable");
        System.out.println("Original string: " + original); // remains "Immutable"
        System.out.println("Modified string: " + modified); // prints "Mutable"
    }
}
