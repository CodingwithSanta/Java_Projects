import java.util.Scanner;

public class StringBufferOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();

        // Length of a string
        int lengthOfString = calculateLengthOfString(inputString);
        System.out.println("Length of the string: " + lengthOfString);

        // Reverse a string
        String reversedString = reverseString(inputString);
        System.out.println("Reversed string: " + reversedString);

        System.out.println("Enter the substring to delete:");
        String substringToDelete = scanner.nextLine();

        // Delete a substring
        String stringWithoutSubstring = deleteSubstring(inputString, substringToDelete);
        System.out.println("String after deleting '" + substringToDelete + "': " + stringWithoutSubstring);

        scanner.close();
    }

    // Method to calculate length of a string using StringBuffer
    public static int calculateLengthOfString(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        return stringBuffer.length();
    }

    // Method to reverse a string using StringBuffer
    public static String reverseString(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.reverse();
        return stringBuffer.toString();
    }

    // Method to delete a substring from a string using StringBuffer
    public static String deleteSubstring(String str, String substringToDelete) {
        StringBuffer stringBuffer = new StringBuffer(str);
        int startIndex = stringBuffer.indexOf(substringToDelete);
        if (startIndex != -1) {
            int endIndex = startIndex + substringToDelete.length();
            stringBuffer.delete(startIndex, endIndex);
        }
        return stringBuffer.toString();
    }
}