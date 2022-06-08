package dataStructures.strings;

public class playingAroundwithstr {
    public static void main(String[] args) {
//        char check = 'b' + 'a';
//        char ch = (char) 100000;
//        System.out.println(ch);
//        System.out.println(check);
//        String s1 = "saurabh";
//        String s2 = "b";
//        System.out.println(s2 == s1);
//        s1.concat("ka");
//        System.out.println(s2 == s1);
//        System.out.println(s2);
        String s3 = "java";
        s3.concat(" rules");
        //4 System.out.println(s1.indexOf(s2));

        // Yes, s1 still refers to "java"
        System.out.println("s3 refers to " + s3);
    }
}
// Java program to demonstrate difference between
// String, StringBuilder and StringBuffer

// Main class
class GFG {

    // Method 1
    // Concatenates to String
    public static void concat1(String s1) {
        s1 = s1 + "forgeeks";
    }

    // Method 2
    // Concatenates to StringBuilder
    public static void concat2(StringBuilder s2) {
        s2.append("forgeeks");
    }

    // Method 3
    // Concatenates to StringBuffer
    public static void concat3(StringBuffer s3) {
        s3.append("forgeeks");
    }

    // Method 4
    // Main driver method
    public static void main(String[] args) {
        // Custom input string
        // String 1
        String s1 = "Geeks";

        // Calling above defined method
        concat1(s1);

        // s1 is not changed
        System.out.println("String: " + s1);

        // String 1
        StringBuilder s2 = new StringBuilder("Geeks");

        // Calling above defined method
        concat2(s2);

        // s2 is changed
        System.out.println("StringBuilder: " + s2);

        // String 3
        StringBuffer s3 = new StringBuffer("Geeks");

        // Calling above defined method
        concat3(s3);

        // s3 is changed
        System.out.println("StringBuffer: " + s3);
    }
}


