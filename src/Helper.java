import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
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

    public static Grammar newReadFromFile(String fileName) throws IOException {
        var ret = new Grammar();
        var fileDir = System.getProperty("user.dir");
        System.out.println("Loading grammar from " + fileName + " in " + fileDir + "...");
        var fr = new FileReader(fileName);

        // 'Try with resources' so we automatically dispose the BufferedReader.
        try (BufferedReader br = new BufferedReader(fr)) {
            br.lines().forEach(l -> {
                var headAndBody = l.split("=");
                if (headAndBody.length != 2) {
                    System.out.println("Each production should have exactly one `=` symbol.");
                    System.exit(1);
                }
                var headStr = headAndBody[0].trim();
                var head = new Variable(headStr.charAt(0));
                var bodyStr = headAndBody[1].trim();
                var bodyPartsStr = bodyStr.split("\\|");
                Arrays.stream(bodyPartsStr).forEach(bps -> {
                    ret.addProduction(head, getBodyFromStr(bps));
                });
            });
            System.out.println("Grammar loaded successfully.");
            return ret;
        }
    }

    public static IProductionBody getBodyFromStr(String rawStr) {
        var str = rawStr.trim();
        if (str.equals("epsilon"))
            return new Epsilon();
        else if (str.length() == 2 && Character.isUpperCase(str.charAt(0)) && Character.isUpperCase(str.charAt(1)))
            return new TwoVariables(new Variable(str.charAt(0)), new Variable(str.charAt(1)));
        else if (str.length() == 1 && Character.isLowerCase(str.charAt(0)))
            return new Terminal(str.charAt(0));
        else
            throw new IllegalStateException("Found invalid body in grammar: `" + str + "`. Exiting...");
    }

    public static List<Terminal> getTermListFromStr(String str) {
        return str.chars().mapToObj(c -> new Terminal((char) c)).toList();
    }
}
