import java.util.Random;
public class RandomNumberRange {
    public static void main(String[] args) {
        // Define the lower and upper limits
        int lowerLimit = 1;
        int upperLimit = 100;

        // Create an instance of Random class
        Random random = new Random();

        // Generate a random number within the given range
        int randomNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;

        // Print the generated number
        System.out.println("Generated random number: " + randomNumber);

        // Check the range of the generated number and print a message accordingly
        if (randomNumber < 50) {
            System.out.println("The number is less than 50.");
        } else if (randomNumber >= 50 && randomNumber <= 75) {
            System.out.println("The number is between 50 and 75 (inclusive).");
        } else {
            System.out.println("The number is greater than 75.");
        }
    }
}