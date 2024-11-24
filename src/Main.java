import java.io.IOException;
import java.util.Hashtable;

public class Main {
    public static void main(String[] args) throws IOException {
        Hashtable Grammer = Helper.readFromFile("test.txt");

        System.out.println(Grammer);
    }


}