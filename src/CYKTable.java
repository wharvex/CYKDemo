import java.util.ArrayList;
import java.util.HashSet;
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

    public int getInputLen() {
        return inputString.size();
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

    public void addNonBottomRow(int rowNumber) {
        IntStream.rangeClosed(rowNumber, inputString.size()).forEach(j -> {
            var diff = rowNumber - 1;
            var i = j - diff;
            var idxPairs = Helper.getIJPairsForComparison(i, j);
            var varPairs = idxPairs.stream().map(pairPair -> {
                var f = getEntry(pairPair.getLeftPair().getI(), pairPair.getLeftPair().getJ());
                var g = getEntry(pairPair.getRightPair().getI(), pairPair.getRightPair().getJ());
                // Product operation.
                return f.cartesianProduct(g);
            }).reduce(new HashSet<>(), (a, b) -> {
                // Union operation.
                a.addAll(b);
                return a;
            });

            var entry = new CYKTableEntry(i, j);
            varPairs.forEach(tv -> entry.getVariables().addAll(grammar.getProductionHeadsFromBody(tv)));
            addEntry(entry);
        });
    }

    public boolean getAnswer() {
        var lastEntry = getEntries().getLast();
        if (!(lastEntry.getI() == 1 && lastEntry.getJ() == getInputLen()))
            throw new IllegalStateException("Table in an invalid state for calling `getAnswer`.");
        return lastEntry.containsS();
    }
}
