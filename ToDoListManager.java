import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListManager {
    private ArrayList<String> toDoList;
    private Scanner scanner;

    public ToDoListManager() {
        toDoList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("======= TO-DO LIST MANAGER =======");
            System.out.println("1. Add an item");
            System.out.println("2. Remove an item");
            System.out.println("3. View the to-do list");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    removeItem();
                    break;
                case 3:
                    viewToDoList();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }

    private void addItem() {
        System.out.print("Enter the item to add: ");
        String item = scanner.nextLine();
        toDoList.add(item);
        System.out.println("Item added to the to-do list.");
    }

    private void removeItem() {
        System.out.print("Enter the index of the item to remove: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (index >= 0 && index < toDoList.size()) {
            String item = toDoList.remove(index);
            System.out.println("Item removed from the to-do list: " + item);
        } else {
            System.out.println("Invalid index. No item removed.");
        }
    }

    private void viewToDoList() {
        if (toDoList.isEmpty()) {
            System.out.println("The to-do list is empty.");
        } else {
            System.out.println("======= TO-DO LIST =======");
            for (int i = 0; i < toDoList.size(); i++) {
                System.out.println((i + 1) + ". " + toDoList.get(i));
            }
        }
    }

    public static void main(String[] args) {
        ToDoListManager manager = new ToDoListManager();
        manager.start();
    }
}
