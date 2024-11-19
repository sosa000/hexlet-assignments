package exercise;

import java.util.ArrayList;
import java.util.List;


// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int n) {
        if (apartments.isEmpty()) {
            return new ArrayList<>();
        }

        return apartments.stream()
                .sorted(Home::compareTo)
                .map(Home::toString)
                .toList()
                .subList(0, n);
    }
}
// END
