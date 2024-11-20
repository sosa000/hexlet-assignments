package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
// BEGIN
import static org.junit.jupiter.api.Assertions.assertEquals;
import static exercise.Utils.deserialize;
import static exercise.Utils.readFile;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // BEGIN
    @Test
    public void testFileKV() {
        KeyValueStorage storage = new FileKV(filepath.toString(), Map.of("key", "value"));

        assertEquals("value", storage.get("key", "default"));
        assertEquals("defaultBLEAT", storage.get("huy", "defaultBLEAT"));
        assertEquals(Map.of("key", "value"), deserialize(readFile(filepath.toString())));
    }
    // END
}
