import java.util.Scanner;

public class Radix_Conversion {

    // Method to convert a number from base 10 to the specified base
    public static String convertToBase(int num, int base) {
        if (num == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            int remainder = num % base;
            if (remainder < 10) {
                result.append(remainder);
            } else {
                result.append((char) ('A' + (remainder - 10))); // Convert to A-F for bases > 10
            }
            num /= base;
        }
        return result.reverse().toString(); // Reverse the result to get the correct order
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Ask for the origin number system
            System.out.print("Enter the origin number system (2-16) or 'STOP' to exit: ");
            String originBaseInput = scanner.nextLine();

            if (originBaseInput.equalsIgnoreCase("STOP")) {
                System.out.println("Exiting the program.");
                break;
            }

            // Validate the origin base
            int originBase;
            try {
                originBase = Integer.parseInt(originBaseInput);
                if (originBase < 2 || originBase > 16) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer between 2 and 16.");
                continue;
            }

            // Ask for the number in the specified base
            System.out.print("Enter the number in base " + originBase + ": ");
            String number = scanner.nextLine();

            // Convert the number to base 10
            int decimalNumber;
            try {
                decimalNumber = Integer.parseInt(number, originBase);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number for the specified base. Please try again.");
                continue;
            }

            // Convert the decimal number to all bases from 2 to 16
            System.out.println("Conversions for " + number + " (base " + originBase + "):");
            for (int base = 2; base <= 16; base++) {
                String convertedNumber = convertToBase(decimalNumber, base);
                System.out.println("Base " + base + ": " + convertedNumber);
            }
        }

        scanner.close();
    }
}