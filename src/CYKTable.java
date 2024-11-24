import java.util.ArrayList;
import java.util.List;

public class CYKTable {
    private List<CYKTableEntry> entries;

    public CYKTable() {
        entries = new ArrayList<>();
    }

    public CYKTableEntry getEntry(int i, int j) {
        return entries.stream().filter(te -> te.getI() == i && te.getJ() == j).findFirst().orElseThrow();
    }

    public void addEntry(CYKTableEntry entry) {
        entries.add(new CYKTableEntry(entry));
    }
}
