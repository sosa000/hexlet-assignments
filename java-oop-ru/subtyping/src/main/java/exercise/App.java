package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        var newMap = storage.toMap().entrySet();
        for (Entry<String, String> elem : newMap) {
            storage.unset(elem.getKey());
            storage.set(elem.getValue(), elem.getKey());
        }
    }
}
// END
