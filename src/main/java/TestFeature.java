import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestFeature {
    public static List<String> customizeName(List<String> listName, Predicate<String> conditions) {
        return listName.stream().filter(conditions).collect(Collectors.toList());
    }

    public static Predicate<String> conditions() {
        return name -> name.equals("sang");
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Sang", "ABC", "sang", "sang1", "sang", "sang2", "sang", "sang3");
        List<String> filteredName = customizeName(names, conditions());
        System.out.println(filteredName.toString());
    }
}
