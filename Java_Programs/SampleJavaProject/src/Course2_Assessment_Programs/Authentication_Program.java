package Course2_Assessment_Programs;

import java.util.LinkedList;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class Authentication_Program {
    private LinkedList<User> userList;

    public Authentication_Program() {
        userList = new LinkedList<>();
    }

    public void register(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username already taken. Please choose another.   ");
                return;
            }
        }
        userList.add(new User(username, password));
        System.out.println("User registered successfully.");
    }

    public boolean login(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
    	Authentication_Program authSystem = new Authentication_Program();
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter a username: ");
                    String regUsername = scanner.nextLine();

                    System.out.print("Enter a password: ");
                    String regPassword = scanner.nextLine();

                    authSystem.register(regUsername, regPassword);
                    break;

                case 2:
                    System.out.print("Enter your username: ");
                    String loginUsername = scanner.nextLine();

                    System.out.print("Enter your password: ");
                    String loginPassword = scanner.nextLine();

                    if (authSystem.login(loginUsername, loginPassword)) {
                        System.out.println("Login successful.");
                        loggedIn = true;
                    } else {
                        System.out.println("Login failed. Try again.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    loggedIn = true;
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
