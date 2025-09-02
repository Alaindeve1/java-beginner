import java.util.Scanner;

public class BasicCalculator {
    
    // Method for addition
    public static double add(double num1, double num2) {
        return num1 + num2;
    }
    
    // Method for subtraction
    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }
    
    // Method for multiplication
    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }
    
    // Method for division with edge case handling
    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Error: Division by zero is not allowed!");
        }
        return num1 / num2;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;
        
        System.out.println("=== Welcome to Basic Calculator ===");
        
        while (continueCalculating) {
            try {
                // Get first number
                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();
                
                // Get operation
                System.out.print("Enter operation (+, -, *, /): ");
                char operation = scanner.next().charAt(0);
                
                // Get second number
                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();
                
                double result = 0;
                boolean validOperation = true;
                
                // Perform calculation based on operation
                switch (operation) {
                    case '+':
                        result = add(num1, num2);
                        break;
                    case '-':
                        result = subtract(num1, num2);
                        break;
                    case '*':
                        result = multiply(num1, num2);
                        break;
                    case '/':
                        result = divide(num1, num2);
                        break;
                    default:
                        System.out.println("Error: Invalid operation! Please use +, -, *, or /");
                        validOperation = false;
                }
                
                // Display result if operation was valid
                if (validOperation) {
                    System.out.printf("Result: %.2f %c %.2f = %.2f%n", num1, operation, num2, result);
                }
                
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: Invalid input! Please enter valid numbers.");
                scanner.nextLine(); // Clear the invalid input
            }
            
            // Ask if user wants to continue
            System.out.print("Do you want to perform another calculation? (y/n): ");
            char choice = scanner.next().charAt(0);
            continueCalculating = (choice == 'y' || choice == 'Y');
        }
        
        System.out.println("Thank you for using Basic Calculator!");
        scanner.close();
    }
}