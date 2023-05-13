import java.util.HashMap;
import java.util.Map;

public class FileSystem {
    private Map<String, FileSystem> children = new HashMap<>(); // A map to store child directories
    private String name; // The name of the directory represented by this FileSystem object

    public FileSystem(String name) {
        this.name = name; // Set the name of the directory
    }

    public String getName() {
        return name; // Return the name of the directory
    }

    public FileSystem get(String name) {
        return children.get(name); // Get a child directory by name, or return null if it doesn't exist
    }

    public void add(String name) {
        children.put(name, new FileSystem(name)); // Add a new child directory with the given name
    }

    public void ls() {
        children.keySet().forEach(System.out::println); // List the names of all child directories
    }
}