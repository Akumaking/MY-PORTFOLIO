import java.util.Scanner;

public class DecimalBinaryConverter {

    // Method to convert decimal to binary
    public static String decimalToBinary(int decimal) {
        if (decimal < 0) {
            return "Error: Negative numbers cannot be converted to binary.";
        }
        return Integer.toBinaryString(decimal);
    }

    // Method to convert binary to decimal
    public static int binaryToDecimal(String binary) {
        try {
            return Integer.parseInt(binary, 2);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid binary number.");
            return -1; // Return -1 to indicate an error
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Convert Decimal to Binary");
            System.out.println("2. Convert Binary to Decimal");
            System.out.println("3. Exit");

            System.out.print("Enter your choice (1/2/3): ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter a decimal number: ");
                String decimalInput = scanner.nextLine();
                try {
                    int decimalNumber = Integer.parseInt(decimalInput);
                    String binaryResult = decimalToBinary(decimalNumber);
                    System.out.println("Binary representation of " + decimalNumber + " is: " + binaryResult);
                } catch (NumberFormatException e) {
                    System.out.println("Error: Please enter a valid decimal number.");
                }

            } else if (choice.equals("2")) {
                System.out.print("Enter a binary number: ");
                String binaryInput = scanner.nextLine();
                int decimalResult = binaryToDecimal(binaryInput);
                if (decimalResult != -1) {
                    System.out.println("Decimal representation of " + binaryInput + " is: " + decimalResult);
                }

            } else if (choice.equals("3")) {
                System.out.println("Exiting the program. Goodbye!");
                break;

            } else {
                System.out.println("Error: Invalid choice. Please select 1, 2, or 3.");
            }
        }
        scanner.close();
    }
}