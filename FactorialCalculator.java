import java.util.Scanner;

public class FactorialCalculator {
    
    /**
     * Recursive method to calculate factorial of a number
     * @param n The number to calculate factorial for
     * @return The factorial of n
     */
    public static long calculateFactorial(int n) {
        // Edge case: factorial of 0 is 1
        if (n == 0) {
            return 1;
        }
        
        // Edge case: factorial of negative numbers is undefined
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers!");
        }
        
        // Base case: factorial of 1 is 1
        if (n == 1) {
            return 1;
        }
        
        // Recursive case: n! = n * (n-1)!
        return n * calculateFactorial(n - 1);
    }
    
    /**
     * Alternative iterative method for comparison
     * @param n The number to calculate factorial for
     * @return The factorial of n
     */
    public static long calculateFactorialIterative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers!");
        }
        
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    /**
     * Method to display the step-by-step calculation
     * @param n The number to show steps for
     */
    public static void displayFactorialSteps(int n) {
        if (n < 0) {
            System.out.println("Cannot show steps for negative numbers.");
            return;
        }
        
        System.out.print(n + "! = ");
        if (n == 0) {
            System.out.println("1 (by definition)");
            return;
        }
        
        for (int i = n; i > 1; i--) {
            System.out.print(i + " × ");
        }
        System.out.println("1 = " + calculateFactorial(n));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;
        
        System.out.println("=== Factorial Calculator using Recursion ===");
        System.out.println("Note: Factorial is only defined for non-negative integers");
        
        while (continueCalculating) {
            try {
                System.out.print("\nEnter a number to calculate its factorial: ");
                int number = scanner.nextInt();
                
                // Calculate factorial using recursion
                long result = calculateFactorial(number);
                
                System.out.println("\n--- Results ---");
                System.out.println("Number: " + number);
                System.out.println("Factorial (using recursion): " + result);
                
                // Show step-by-step calculation
                System.out.println("\nStep-by-step calculation:");
                displayFactorialSteps(number);
                
                // Compare with iterative method
                long iterativeResult = calculateFactorialIterative(number);
                System.out.println("Factorial (using iteration): " + iterativeResult);
                System.out.println("Both methods match: " + (result == iterativeResult));
                
                // Show some interesting facts
                if (number <= 10) {
                    System.out.println("\n--- Fun Facts ---");
                    System.out.println("• " + number + "! has " + String.valueOf(result).length() + " digits");
                    if (number > 0) {
                        System.out.println("• " + number + "! ÷ " + (number-1) + "! = " + number);
                    }
                }
                
                // Warning for large numbers
                if (number > 20) {
                    System.out.println("\n⚠️  Warning: Large factorials may cause overflow!");
                    System.out.println("Consider using BigInteger for numbers > 20");
                }
                
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again with a non-negative integer.");
            } catch (StackOverflowError e) {
                System.out.println("Error: Number too large for recursive calculation!");
                System.out.println("Stack overflow occurred. Try a smaller number.");
            } catch (Exception e) {
                System.out.println("Error: Invalid input! Please enter a valid integer.");
                scanner.nextLine(); // Clear the invalid input
            }
            
            // Ask if user wants to continue
            System.out.print("\nDo you want to calculate another factorial? (y/n): ");
            try {
                char choice = scanner.next().charAt(0);
                continueCalculating = (choice == 'y' || choice == 'Y');
            } catch (Exception e) {
                continueCalculating = false;
            }
        }
        
        System.out.println("\nThanks for using the Factorial Calculator!");
        scanner.close();
    }
}