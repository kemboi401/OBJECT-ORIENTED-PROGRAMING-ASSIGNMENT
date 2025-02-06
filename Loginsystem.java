import java.io.Console;

public class Loginsystem {
    public static void main(String[] args) {
        // Define the correct username and password
        String correctUsername = "user";
        String correctPassword = "pass";

        // Create a console object to read password securely
        Console console = System.console();

        // Check if console is available
        if (console == null) {
            System.out.println("No console available. Please run this program in a terminal.");
            return;
        }

        // Allow the user 3 attempts to log in
        for (int attempts = 0; attempts < 3; attempts++) {
            // Prompt for username
            String username = console.readLine("Enter username: ");

            // Prompt for password and mask input
            char[] passwordArray = console.readPassword("Enter password: ");
            String password = new String(passwordArray);

            // Check if the entered username and password are correct
            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                System.out.println("Login successful!");
                return; // Exit the program on successful login
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }

        // If the user fails to log in after 3 attempts
        System.out.println("Too many failed attempts. Access denied.");
    }
}