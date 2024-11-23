import java.util.ArrayList;
import java.util.List;

public class CYKTableEntry {
    private final int i;
    private final int j;
    private final List<Variable> variables;

    public CYKTableEntry(int i, int j) {
        this.i = i;
        this.j = j;
        this.variables = new ArrayList<>();
    }
}
