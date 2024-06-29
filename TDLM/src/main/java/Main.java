import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create User");
            System.out.println("2. Add Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    createUser(name);
                    break;
                case 2:
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    addTask(userName, description);
                    break;
                case 3:
                    System.out.print("Enter user name: ");
                    String userNameForCompletion = scanner.nextLine();
                    System.out.print("Enter task description to mark as completed: ");
                    String taskToComplete = scanner.nextLine();
                    markTaskAsCompleted(userNameForCompletion, taskToComplete);
                    break;
                case 4:
                    System.out.print("Enter user name: ");
                    String userNameToView = scanner.nextLine();
                    viewTasks(userNameToView);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void createUser(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                System.out.println("User already exists.");
                return;
            }
        }
        users.add(new User(name));
        System.out.println("User created: " + name);
    }

    private static void addTask(String userName, String description) {
        User user = findUser(userName);
        if (user != null) {
            user.addTask(description);
            System.out.println("Task added to " + userName);
        } else {
            System.out.println("User not found.");
        }
    }

    private static void markTaskAsCompleted(String userName, String description) {
        User user = findUser(userName);
        if (user != null) {
            user.markTaskAsCompleted(description);
        } else {
            System.out.println("User not found.");
        }
    }

    private static void viewTasks(String userName) {
        User user = findUser(userName);
        if (user != null) {
            user.printTasks();
        } else {
            System.out.println("User not found.");
        }
    }

    private static User findUser(String userName) {
        for (User user : users) {
            if (user.getName().equals(userName)) {
                return user;
            }
        }
        return null;
    }
}
