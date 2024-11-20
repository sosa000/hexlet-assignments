package exercise;

// BEGIN
import java.util.HashMap;
import java.util.Map;
import static exercise.Utils.serialize;
import static exercise.Utils.writeFile;

public class FileKV implements KeyValueStorage {
    private String path;
    private Map<String, String> map;

    public FileKV(String path, Map<String, String> map) {
        this.path = path;
        this.map = new HashMap<>(map);
        writeFile(this.path, serialize(this.map));
    }

    @Override
    public void set(String key, String value) {
        this.map.put(key, value);
        writeFile(this.path, serialize(this.map));
    }

    @Override
    public void unset(String key) {
        this.map.remove(key);
        writeFile(this.path, serialize(this.map));
    }

    @Override
    public String get(String key, String defaultValue) {
        return this.map.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(this.map);
    }
}
// END
