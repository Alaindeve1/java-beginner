import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    
    private static final int MAX_ATTEMPTS = 7;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        
        System.out.println("=== Welcome to the Number Guessing Game! ===");
        System.out.println("I'm thinking of a number between " + MIN_NUMBER + " and " + MAX_NUMBER);
        System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it!");
        
        while (playAgain) {
            // Generate random number
            int secretNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            int attempts = 0;
            boolean hasWon = false;
            
            System.out.println("\n--- New Game Started ---");
            System.out.println("I've picked a new number. Start guessing!");
            
            while (attempts < MAX_ATTEMPTS && !hasWon) {
                attempts++;
                int remainingAttempts = MAX_ATTEMPTS - attempts + 1;
                
                System.out.print("Attempt " + attempts + "/" + MAX_ATTEMPTS + " - Enter your guess: ");
                
                try {
                    int userGuess = scanner.nextInt();
                    
                    // Validate input range
                    if (userGuess < MIN_NUMBER || userGuess > MAX_NUMBER) {
                        System.out.println("Invalid input! Please enter a number between " + 
                                         MIN_NUMBER + " and " + MAX_NUMBER);
                        attempts--; // Don't count invalid attempts
                        continue;
                    }
                    
                    // Check the guess
                    if (userGuess == secretNumber) {
                        hasWon = true;
                        System.out.println("🎉 Congratulations! You guessed it right!");
                        System.out.println("The number was " + secretNumber);
                        System.out.println("You won in " + attempts + " attempts!");
                        
                        // Calculate score based on attempts
                        int score = ((MAX_ATTEMPTS - attempts + 1) * 100) / MAX_ATTEMPTS;
                        System.out.println("Your score: " + score + "/100");
                        
                    } else if (userGuess < secretNumber) {
                        System.out.println("Too low! Try a higher number.");
                        if (remainingAttempts > 1) {
                            System.out.println("You have " + (remainingAttempts - 1) + " attempts remaining.");
                        }
                    } else {
                        System.out.println("Too high! Try a lower number.");
                        if (remainingAttempts > 1) {
                            System.out.println("You have " + (remainingAttempts - 1) + " attempts remaining.");
                        }
                    }
                    
                } catch (Exception e) {
                    System.out.println("Invalid input! Please enter a valid integer.");
                    scanner.nextLine(); // Clear the invalid input
                    attempts--; // Don't count invalid attempts
                }
            }
            
            // Game over - check if player lost
            if (!hasWon) {
                System.out.println("\n😞 Game Over! You've used all your attempts.");
                System.out.println("The secret number was: " + secretNumber);
                System.out.println("Better luck next time!");
            }
            
            // Ask if player wants to play again
            System.out.print("\nDo you want to play again? (y/n): ");
            try {
                char choice = scanner.next().charAt(0);
                playAgain = (choice == 'y' || choice == 'Y');
            } catch (Exception e) {
                playAgain = false;
            }
        }
        
        System.out.println("\nThanks for playing the Number Guessing Game! Goodbye!");
        scanner.close();
    }
}