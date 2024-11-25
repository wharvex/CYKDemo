import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.IntStream;


public class Helper {

    public static Hashtable readFromFile(String fileName) throws IOException {

        Hashtable<Character, String> grammer = new Hashtable<>();

        char temporaryTerminal = ' ';
        char temporaryNonTerminal = ' ';

        var fileDir = System.getProperty("user.dir");
        System.out.println("Looking for " + fileName + " in " + fileDir + "...");
        var fr = new FileReader(fileName);

        // 'Try with resources' so we automatically dispose the BufferedReader.
        try (BufferedReader br = new BufferedReader(fr)) {

            var sb = new StringBuilder();
            var rightSide = new StringBuilder();
            br.lines().forEach(l -> sb.append(l.replace(" ", "")).append(System.lineSeparator()));
            char[] eachLetter = sb.toString().toCharArray();
            System.out.println(eachLetter[4]);

            for (int i = 0; i < eachLetter.length; i++) {
                temporaryNonTerminal = eachLetter[i];
                i++;
                if (eachLetter[i] == '→') {
                    i++;
                    while (eachLetter[i] != '\r') {
                        rightSide.append(eachLetter[i]);
                        i++;
                    }
                    if (eachLetter[i] == '\r') {
                        grammer.put(temporaryNonTerminal, rightSide.toString());
                        temporaryNonTerminal = ' ';
                        rightSide = new StringBuilder();
                        i++;
                    }
                }
            }
            return grammer;
        }
    }

    public static List<IJPairPair> getIJPairsForComparison(int targetI, int targetJ) {
        return IntStream.range(targetI, targetJ).mapToObj(k -> new IJPairPair(new IJPair(targetI, k), new IJPair(k + 1, targetJ))).toList();
    }
}
