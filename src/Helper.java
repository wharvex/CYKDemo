import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Helper {
    public static String readFromFile(String fileName) throws IOException {
        var g = System.getProperty("user.dir");
        System.out.println(g);
        var f = new FileReader(fileName);
        try (BufferedReader br = new BufferedReader(f)) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            return everything;
        }
    }
}
