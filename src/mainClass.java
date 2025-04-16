import com.sun.xml.internal.ws.util.StringUtils;
import javafx.util.Pair;
import sun.net.www.http.HttpClient;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class mainClass {
    public static void main(String[] args) throws Exception {
        mainClass o = new mainClass();
        o.temp();
    }

    private void temp() throws IOException {
        Path folderPath = Paths.get("C:\\Users\\puazhixian\\Downloads\\sql"); // <-- change this
        String keyword = "bank_account";

        Files.walk(folderPath)
                .filter(Files::isRegularFile)
                .forEach(file -> {
                    try {
                        List<String> lines = Files.readAllLines(file);
                        for (int i = 0; i < lines.size(); i++) {
                            String line = lines.get(i);
                            if (line.toLowerCase().contains(keyword)) {
                                System.out.printf("Match found in file: %s (line %d)\n", file.getFileName(), i + 1);
                                System.out.println("Line: " + line);
                            }
                        }
                    } catch (IOException e) {
                        System.err.println("Error reading file: " + file);
                        e.printStackTrace();
                    }
                });
    }
}