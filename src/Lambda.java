import java.util.Arrays;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Abby", "Edward", "Alfred", "Nathan", "Vicky", "Tim", "Bruce", "Ben", "John", "Doe", "Jane", "Alex", "Anne", "Alfonse");

        //List of all names
        System.out.println("name list: " + names);
        //printing the names list in uppercase, this does not change the original names array list.
        System.out.println("\nnames in uppercase: ");
        names.forEach(s -> System.out.println(s.toUpperCase()));
        //printing the first letter of each name.
        System.out.println("\nFirst letter of each name : ");
        names.forEach(s -> System.out.println(s.charAt(0)));
        //Modifying elements of the names list
        System.out.println("\nAdding 'Benz' to each name: ");
        names.forEach(s -> System.out.println(s + " Benz"));
    }
}
