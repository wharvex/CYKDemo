import java.util.List;

public class CYKTable {
    private List<CYKTableEntry> entries;

    public CYKTableEntry getEntry(int i, int j) {
        return entries.stream().filter(te -> te.getI() == i && te.getJ() == j).findFirst().orElseThrow();
    }
}
