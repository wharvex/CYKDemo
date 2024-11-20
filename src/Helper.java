import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Helper {
    public static String readFromFile(String fileName) throws IOException {
        var fileDir = System.getProperty("user.dir");
        System.out.println("Looking for " + fileName + " in " + fileDir + "...");
        var fr = new FileReader(fileName);

        // 'Try with resources' so we automatically dispose the BufferedReader.
        try (BufferedReader br = new BufferedReader(fr)) {
            var sb = new StringBuilder();
            br.lines().forEach(l -> sb.append(l).append(System.lineSeparator()));
            return sb.toString();
        }
    }
}
