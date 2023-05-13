import java.util.Scanner;

public class Shell {
    private FileSystem root;   // The root directory of the emulated file system
    private FileSystem current; // The current directory the user is in

    public Shell() {
        root = new FileSystem("/"); // Initialize the root directory with the name "/"
        current = root; // Set the current directory to the root directory
    }

    public void start() {
        Scanner scanner = new Scanner(System.in); // Scanner to read user input from the command line
        String command;

        while (true) { // Main loop to keep the shell running
            System.out.print(current.getName() + " $ "); // Display the prompt with the current directory name
            command = scanner.nextLine(); // Read user input

            String[] args = command.split(" "); // Split input by spaces to separate the command and its arguments

            // Process the commands entered by the user
            switch (args[0]) {
                case "pwd":
                    System.out.println(current.getName());
                    break;
                case "ls":
                    current.ls(); // List the contents of the current directory
                    break;
                case "mkdir":
                    if (args.length > 1) {
                        current.add(args[1]); // Create a new directory with the given name
                    } else {
                        System.out.println("mkdir: missing operand"); // Error message for missing directory name
                    }
                    break;
                case "cd":
                    if (args.length > 1) {
                        FileSystem newDir = current.get(args[1]); // Get the directory with the given name
                        if (newDir != null) {
                            current = newDir; // Change the current directory to the new directory
                        } else {
                            System.out.println("cd: no such directory: " + args[1]); // Error message for nonexistent directory
                        }
                    } else {
                        System.out.println("cd: missing operand"); // Error message for missing directory name
                    }
                    break;
                case "exit":
                    System.exit(0); // Exit the shell
                    break;
                default:
                    System.out.println("Unknown command: " + args[0]); // Error message for unknown command
            }
        }
    }
}