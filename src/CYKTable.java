import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CYKTable {
    private List<CYKTableEntry> entries;
    private List<Terminal> inputString;
    private Grammar grammar;

    public CYKTable(List<Terminal> inputString, Grammar grammar) {
        entries = new ArrayList<>();
        this.inputString = inputString;
        this.grammar = grammar;
    }

    public static List<Terminal> sampleInputString() {
        return List.of(new Terminal('b'), new Terminal('a'), new Terminal('a'), new Terminal('b'), new Terminal('a'));
    }

    public List<CYKTableEntry> getEntries() {
        return entries;
    }

    public CYKTableEntry getEntry(int i, int j) {
        return entries.stream().filter(te -> te.getI() == i && te.getJ() == j).findFirst().orElseThrow();
    }

    public void addEntry(CYKTableEntry entry) {
        entries.add(new CYKTableEntry(entry));
    }

    public void addBottomRow() {
        IntStream.range(0, inputString.size()).forEach(i -> {
            var term = inputString.get(i);
            var entry = new CYKTableEntry(i + 1, i + 1, grammar.getProductionHeadsFromBody(term));
            addEntry(entry);
        });
    }
}
